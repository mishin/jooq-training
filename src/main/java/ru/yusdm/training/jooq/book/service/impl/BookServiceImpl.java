package ru.yusdm.training.jooq.book.service.impl;

import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yusdm.training.jooq.book.service.BookService;
import ru.yusdm.training.jooq.jooqgenerated.tables.daos.JBookDao;
import ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook;

import static ru.yusdm.training.jooq.common.business.configs.DatabaseConfigs.JOOQ_DEFAULT_CONFIGURATION;
import static ru.yusdm.training.jooq.common.business.configs.DatabaseConfigs.TRANSACTION_MANAGER;

@Service
@Transactional(TRANSACTION_MANAGER)
public class BookServiceImpl implements BookService {

    private final DefaultDSLContext dsl;
    private final JBookDao bookDao;

    public BookServiceImpl(@Qualifier(JOOQ_DEFAULT_CONFIGURATION) DefaultConfiguration jooqConfig) {
        this.bookDao = new JBookDao(jooqConfig);
        dsl = new DefaultDSLContext(jooqConfig);
    }

    @Override
    public JBook insert(JBook book) {
        bookDao.insert(book);
        return book;
    }
}
