package ru.yusdm.training.jooq.author.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.yusdm.training.jooq.JooqTrainingApplication;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan(basePackageClasses = {JooqTrainingApplication.class})
public class TestConfig implements ApplicationContextAware {


    @PostConstruct
    public void postConstruct(){
        System.out.println("sdsdsdsdsds");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println();
    }
}
