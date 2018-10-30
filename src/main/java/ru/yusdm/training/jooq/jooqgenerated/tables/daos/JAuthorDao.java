/*
 * This file is generated by jOOQ.
 */
package ru.yusdm.training.jooq.jooqgenerated.tables.daos;


import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import ru.yusdm.training.jooq.jooqgenerated.tables.JAuthor;
import ru.yusdm.training.jooq.jooqgenerated.tables.records.JAuthorRecord;


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
public class JAuthorDao extends DAOImpl<JAuthorRecord, ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JAuthor, Long> {

    /**
     * Create a new JAuthorDao without any configuration
     */
    public JAuthorDao() {
        super(JAuthor.AUTHOR, ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JAuthor.class);
    }

    /**
     * Create a new JAuthorDao with an attached configuration
     */
    public JAuthorDao(Configuration configuration) {
        super(JAuthor.AUTHOR, ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JAuthor.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JAuthor object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>ID IN (values)</code>
     */
    public List<ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JAuthor> fetchByJId(Long... values) {
        return fetch(JAuthor.AUTHOR.ID, values);
    }

    /**
     * Fetch a unique record that has <code>ID = value</code>
     */
    public ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JAuthor fetchOneByJId(Long value) {
        return fetchOne(JAuthor.AUTHOR.ID, value);
    }

    /**
     * Fetch records that have <code>FIRST_NAME IN (values)</code>
     */
    public List<ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JAuthor> fetchByJFirstName(String... values) {
        return fetch(JAuthor.AUTHOR.FIRST_NAME, values);
    }

    /**
     * Fetch records that have <code>MIDDLE_NAME IN (values)</code>
     */
    public List<ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JAuthor> fetchByJMiddleName(String... values) {
        return fetch(JAuthor.AUTHOR.MIDDLE_NAME, values);
    }

    /**
     * Fetch records that have <code>LAST_NAME IN (values)</code>
     */
    public List<ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JAuthor> fetchByJLastName(String... values) {
        return fetch(JAuthor.AUTHOR.LAST_NAME, values);
    }

    /**
     * Fetch records that have <code>DATE_OF_BIRTH IN (values)</code>
     */
    public List<ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JAuthor> fetchByJDateOfBirth(Timestamp... values) {
        return fetch(JAuthor.AUTHOR.DATE_OF_BIRTH, values);
    }
}
