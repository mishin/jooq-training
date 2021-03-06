/*
 * This file is generated by jOOQ.
 */
package ru.yusdm.training.jooq.jooqgenerated.tables.daos;


import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import ru.yusdm.training.jooq.jooqgenerated.tables.JBook;
import ru.yusdm.training.jooq.jooqgenerated.tables.records.JBookRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JBookDao extends DAOImpl<JBookRecord, ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook, Long> {

    /**
     * Create a new JBookDao without any configuration
     */
    public JBookDao() {
        super(JBook.BOOK, ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook.class);
    }

    /**
     * Create a new JBookDao with an attached configuration
     */
    public JBookDao(Configuration configuration) {
        super(JBook.BOOK, ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>ID IN (values)</code>
     */
    public List<ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook> fetchByJId(Long... values) {
        return fetch(JBook.BOOK.ID, values);
    }

    /**
     * Fetch a unique record that has <code>ID = value</code>
     */
    public ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook fetchOneByJId(Long value) {
        return fetchOne(JBook.BOOK.ID, value);
    }

    /**
     * Fetch records that have <code>NAME IN (values)</code>
     */
    public List<ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook> fetchByJName(String... values) {
        return fetch(JBook.BOOK.NAME, values);
    }

    /**
     * Fetch records that have <code>CONTENT_AS_TEXT IN (values)</code>
     */
    public List<ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook> fetchByJContentAsText(String... values) {
        return fetch(JBook.BOOK.CONTENT_AS_TEXT, values);
    }

    /**
     * Fetch records that have <code>CONTENT_AS_PDF IN (values)</code>
     */
    public List<ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook> fetchByJContentAsPdf(byte[]... values) {
        return fetch(JBook.BOOK.CONTENT_AS_PDF, values);
    }

    /**
     * Fetch records that have <code>PAGES_NUMBER IN (values)</code>
     */
    public List<ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook> fetchByJPagesNumber(Integer... values) {
        return fetch(JBook.BOOK.PAGES_NUMBER, values);
    }

    /**
     * Fetch records that have <code>PUBLISH_DATE IN (values)</code>
     */
    public List<ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook> fetchByJPublishDate(Timestamp... values) {
        return fetch(JBook.BOOK.PUBLISH_DATE, values);
    }
}
