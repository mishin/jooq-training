package ru.yusdm.training.jooq.book_author.service.impl;

import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yusdm.training.jooq.book_author.service.BookAuthorService;
import ru.yusdm.training.jooq.jooqgenerated.tables.daos.JBookAuthorDao;
import ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBookAuthor;

import static ru.yusdm.training.jooq.common.business.configs.DatabaseConfigs.JOOQ_DEFAULT_CONFIGURATION;
import static ru.yusdm.training.jooq.common.business.configs.DatabaseConfigs.TRANSACTION_MANAGER;

@Service
@Transactional(TRANSACTION_MANAGER)
public class BookAuthorServiceImpl implements BookAuthorService {

    private final DefaultDSLContext dsl;
    private final JBookAuthorDao bookAuthorDao;

    public BookAuthorServiceImpl(@Qualifier(JOOQ_DEFAULT_CONFIGURATION) DefaultConfiguration jooqConfig) {
        this.bookAuthorDao = new JBookAuthorDao(jooqConfig);
        dsl = new DefaultDSLContext(jooqConfig);
    }

    @Override
    public JBookAuthor insert(JBookAuthor bookAuthor) {
        bookAuthorDao.insert(bookAuthor);
        return bookAuthor;
    }
}
