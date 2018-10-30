package ru.yusdm.training.jooq.author.service.impl;

import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yusdm.training.jooq.author.service.AuthorService;
import ru.yusdm.training.jooq.jooqgenerated.Tables;
import ru.yusdm.training.jooq.jooqgenerated.tables.daos.JAuthorDao;
import ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JAuthor;
import ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook;

import java.util.Arrays;
import java.util.List;

import static ru.yusdm.training.jooq.common.business.configs.DatabaseConfigs.JOOQ_DEFAULT_CONFIGURATION;
import static ru.yusdm.training.jooq.common.business.configs.DatabaseConfigs.TRANSACTION_MANAGER;
import static ru.yusdm.training.jooq.jooqgenerated.tables.JAuthor.AUTHOR;
import static ru.yusdm.training.jooq.jooqgenerated.tables.JBook.BOOK;
import static ru.yusdm.training.jooq.jooqgenerated.tables.JBookAuthor.BOOK_AUTHOR;

@Service
@Transactional(TRANSACTION_MANAGER)
public class AuthorServiceImpl implements AuthorService {

    private final DefaultDSLContext dsl;
    private final JAuthorDao authorDao;

    public AuthorServiceImpl(@Qualifier(JOOQ_DEFAULT_CONFIGURATION) DefaultConfiguration jooqConfig) {
        this.authorDao = new JAuthorDao(jooqConfig);
        dsl = new DefaultDSLContext(jooqConfig);
    }

    @Override
    public List<JAuthor> getAllAuthors() {
        return authorDao.findAll();
    }

    @Override
    public JAuthor insert(JAuthor author) {
        authorDao.insert(author);
        return author;
    }

    @Override
    public void update(JAuthor author) {
        authorDao.update(author);
    }

    @Override
    public void deleteById(long id) {
        authorDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        dsl.delete(AUTHOR).execute();
    }

    @Override
    public JAuthor findById(long id) {
        return authorDao.findById(id);
    }

    @Override
    public List<JBook> getAuthorBooks(long authorId) {

        /**
         * SELECT
         * 	"PUBLIC"."BOOK"."ID",
         * 	"PUBLIC"."BOOK"."NAME",
         * 	"PUBLIC"."BOOK"."CONTENT_AS_TEXT",
         * 	"PUBLIC"."BOOK"."CONTENT_AS_PDF",
         * 	"PUBLIC"."BOOK"."PAGES_NUMBER",
         * 	"PUBLIC"."BOOK"."PUBLISH_DATE",
         * 	"PUBLIC"."BOOK_AUTHOR"."AUTHOR_ID",
         * 	"PUBLIC"."BOOK_AUTHOR"."BOOK_ID",
         * 	"PUBLIC"."AUTHOR"."ID",
         * 	"PUBLIC"."AUTHOR"."FIRST_NAME",
         * 	"PUBLIC"."AUTHOR"."MIDDLE_NAME",
         * 	"PUBLIC"."AUTHOR"."LAST_NAME",
         * 	"PUBLIC"."AUTHOR"."DATE_OF_BIRTH"
         * FROM
         * 	"PUBLIC"."BOOK"
         * JOIN "PUBLIC"."BOOK_AUTHOR" ON
         * 	"PUBLIC"."BOOK"."ID" = "PUBLIC"."BOOK_AUTHOR"."BOOK_ID"
         * JOIN "PUBLIC"."AUTHOR" ON
         * 	"PUBLIC"."BOOK_AUTHOR"."AUTHOR_ID" = "PUBLIC"."AUTHOR"."ID"
         */
        List<JBook> result = dsl.select().from(BOOK)
                .innerJoin(BOOK_AUTHOR).on(BOOK.ID.eq(BOOK_AUTHOR.BOOK_ID))
                .innerJoin(AUTHOR).on(BOOK_AUTHOR.AUTHOR_ID.eq(AUTHOR.ID))
                .fetchInto(JBook.class);


        /**
         * SELECT
         * 	"PUBLIC"."BOOK"."ID",
         * 	"PUBLIC"."BOOK"."NAME",
         * 	"PUBLIC"."BOOK"."CONTENT_AS_TEXT",
         * 	"PUBLIC"."BOOK"."CONTENT_AS_PDF",
         * 	"PUBLIC"."BOOK"."PAGES_NUMBER",
         * 	"PUBLIC"."BOOK"."PUBLISH_DATE"
         * FROM
         * 	"PUBLIC"."BOOK"
         * JOIN "PUBLIC"."BOOK_AUTHOR" ON
         * 	"PUBLIC"."BOOK"."ID" = "PUBLIC"."BOOK_AUTHOR"."BOOK_ID"
         * JOIN "PUBLIC"."AUTHOR" ON
         * 	"PUBLIC"."BOOK_AUTHOR"."AUTHOR_ID" = "PUBLIC"."AUTHOR"."ID"
         */
        dsl.select(Arrays.asList(Tables.BOOK.fields())).from(Tables.BOOK)
                .innerJoin(Tables.BOOK_AUTHOR).on(Tables.BOOK.ID.eq(Tables.BOOK_AUTHOR.BOOK_ID))
                .innerJoin(Tables.AUTHOR).on(BOOK_AUTHOR.AUTHOR_ID.eq(Tables.AUTHOR.ID))
                .fetchInto(JBook.class);


        return result;
    }
}
