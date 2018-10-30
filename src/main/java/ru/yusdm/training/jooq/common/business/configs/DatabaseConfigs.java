package ru.yusdm.training.jooq.common.business.configs;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.jooq.SpringTransactionProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfigs {
    private static final String PREFIX = "custom";
    public static final String DSL_CONTEXT = PREFIX + "DSLContext";
    public static final String JOOQ_DEFAULT_CONFIGURATION = PREFIX + "JooqConfig";
    public static final String DATASOURCE_NAME = PREFIX + "DsName";
    public static final String TRANSACTION_AWARE_DS_PROXY = PREFIX + "TsAwareDsProxy";
    public static final String TRANSACTION_MANAGER = PREFIX + "TransactionManager";
    public static final String TRANSACTION_PROVIDER = PREFIX + "TransactionProvider";
    public static final String CONNECTION_PROVIDER = PREFIX + "ConnectionProvider";


    private final Environment environment;

    public DatabaseConfigs(Environment environment) {
        this.environment = environment;
    }

    @Bean(name = DATASOURCE_NAME)
    public DataSource dataSource(DataSourceProperties dataSourceProperties) {
        final HikariConfig configuration = hikariConfig();

        configuration.setJdbcUrl(dataSourceProperties.determineUrl());
        configuration.setDriverClassName(dataSourceProperties.determineDriverClassName());
        configuration.setUsername(dataSourceProperties.determineUsername());
        configuration.setPassword(dataSourceProperties.determinePassword());
        configuration.addDataSourceProperty("cachePrepStmts", true);
        configuration.addDataSourceProperty("prepStmtCacheSize", 250);
        configuration.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        configuration.addDataSourceProperty("useServerPrepStmts", true);

        return new HikariDataSource(configuration);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean(name = TRANSACTION_AWARE_DS_PROXY)
    public TransactionAwareDataSourceProxy transactionAwareDataSource(
            @Qualifier(DATASOURCE_NAME) DataSource dataSource) {
        return new TransactionAwareDataSourceProxy(dataSource);
    }

    @Bean(name = TRANSACTION_MANAGER)
    public DataSourceTransactionManager transactionManager(
            @Qualifier(DATASOURCE_NAME) DataSource dataSource
    ) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = TRANSACTION_PROVIDER)
    public SpringTransactionProvider transactionProvider(
            @Qualifier(TRANSACTION_MANAGER) DataSourceTransactionManager txManager) {
        return new SpringTransactionProvider(txManager);
    }

    @Bean(name = CONNECTION_PROVIDER)
    public DataSourceConnectionProvider connectionProvider(
            @Qualifier(TRANSACTION_AWARE_DS_PROXY) TransactionAwareDataSourceProxy transactionAwareDataSourceProxy) {
        return new DataSourceConnectionProvider(transactionAwareDataSourceProxy);
    }


    @Bean(name = DSL_CONTEXT)
    public DefaultDSLContext dsl(
            @Qualifier(JOOQ_DEFAULT_CONFIGURATION) DefaultConfiguration config
    ) {
        return new DefaultDSLContext(config);
    }

    @Bean(name = JOOQ_DEFAULT_CONFIGURATION)
    public DefaultConfiguration configuration(
            @Qualifier(CONNECTION_PROVIDER) DataSourceConnectionProvider connectionProvider,
            @Qualifier(TRANSACTION_PROVIDER) SpringTransactionProvider springTransactionProvider

    ) {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();

        String sqlDialectName = environment.getRequiredProperty("jooq.sql.dialect");
        SQLDialect dialect = SQLDialect.valueOf(sqlDialectName);
        jooqConfiguration.set(dialect);

        jooqConfiguration.setConnectionProvider(connectionProvider);
        jooqConfiguration.setTransactionProvider(springTransactionProvider);
        return jooqConfiguration;
    }


}