/*
 * This file is generated by jOOQ.
 */
package ru.yusdm.training.jooq.jooqgenerated;


import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;

import ru.yusdm.training.jooq.jooqgenerated.tables.JAuthor;
import ru.yusdm.training.jooq.jooqgenerated.tables.JBook;
import ru.yusdm.training.jooq.jooqgenerated.tables.JBookAuthor;


/**
 * A class modelling indexes of tables of the <code>PUBLIC</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index PRIMARY_KEY_7 = Indexes0.PRIMARY_KEY_7;
    public static final Index PRIMARY_KEY_1 = Indexes0.PRIMARY_KEY_1;
    public static final Index FK_AUTHOR_ID_INDEX_A = Indexes0.FK_AUTHOR_ID_INDEX_A;
    public static final Index FK_BOOK_ID_INDEX_A = Indexes0.FK_BOOK_ID_INDEX_A;
    public static final Index PRIMARY_KEY_A = Indexes0.PRIMARY_KEY_A;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index PRIMARY_KEY_7 = Internal.createIndex("PRIMARY_KEY_7", JAuthor.AUTHOR, new OrderField[] { JAuthor.AUTHOR.ID }, true);
        public static Index PRIMARY_KEY_1 = Internal.createIndex("PRIMARY_KEY_1", JBook.BOOK, new OrderField[] { JBook.BOOK.ID }, true);
        public static Index FK_AUTHOR_ID_INDEX_A = Internal.createIndex("FK_AUTHOR_ID_INDEX_A", JBookAuthor.BOOK_AUTHOR, new OrderField[] { JBookAuthor.BOOK_AUTHOR.AUTHOR_ID }, false);
        public static Index FK_BOOK_ID_INDEX_A = Internal.createIndex("FK_BOOK_ID_INDEX_A", JBookAuthor.BOOK_AUTHOR, new OrderField[] { JBookAuthor.BOOK_AUTHOR.BOOK_ID }, false);
        public static Index PRIMARY_KEY_A = Internal.createIndex("PRIMARY_KEY_A", JBookAuthor.BOOK_AUTHOR, new OrderField[] { JBookAuthor.BOOK_AUTHOR.AUTHOR_ID, JBookAuthor.BOOK_AUTHOR.BOOK_ID }, true);
    }
}
