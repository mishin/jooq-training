/*
 * This file is generated by jOOQ.
 */
package ru.yusdm.training.jooq.jooqgenerated;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import ru.yusdm.training.jooq.jooqgenerated.tables.JAuthor;
import ru.yusdm.training.jooq.jooqgenerated.tables.JBook;
import ru.yusdm.training.jooq.jooqgenerated.tables.JBookAuthor;


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
public class JPublic extends SchemaImpl {

    private static final long serialVersionUID = 1464595379;

    /**
     * The reference instance of <code>PUBLIC</code>
     */
    public static final JPublic PUBLIC = new JPublic();

    /**
     * The table <code>PUBLIC.AUTHOR</code>.
     */
    public final JAuthor AUTHOR = ru.yusdm.training.jooq.jooqgenerated.tables.JAuthor.AUTHOR;

    /**
     * The table <code>PUBLIC.BOOK</code>.
     */
    public final JBook BOOK = ru.yusdm.training.jooq.jooqgenerated.tables.JBook.BOOK;

    /**
     * The table <code>PUBLIC.BOOK_AUTHOR</code>.
     */
    public final JBookAuthor BOOK_AUTHOR = ru.yusdm.training.jooq.jooqgenerated.tables.JBookAuthor.BOOK_AUTHOR;

    /**
     * No further instances allowed
     */
    private JPublic() {
        super("PUBLIC", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            JAuthor.AUTHOR,
            JBook.BOOK,
            JBookAuthor.BOOK_AUTHOR);
    }
}
