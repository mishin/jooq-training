/*
 * This file is generated by jOOQ.
 */
package ru.yusdm.training.jooq.jooqgenerated;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import ru.yusdm.training.jooq.jooqgenerated.tables.JAuthor;
import ru.yusdm.training.jooq.jooqgenerated.tables.JBook;
import ru.yusdm.training.jooq.jooqgenerated.tables.JBookAuthor;
import ru.yusdm.training.jooq.jooqgenerated.tables.records.JAuthorRecord;
import ru.yusdm.training.jooq.jooqgenerated.tables.records.JBookAuthorRecord;
import ru.yusdm.training.jooq.jooqgenerated.tables.records.JBookRecord;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>PUBLIC</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<JAuthorRecord, Long> IDENTITY_AUTHOR = Identities0.IDENTITY_AUTHOR;
    public static final Identity<JBookRecord, Long> IDENTITY_BOOK = Identities0.IDENTITY_BOOK;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<JAuthorRecord> PK_AUTHOR = UniqueKeys0.PK_AUTHOR;
    public static final UniqueKey<JBookRecord> PK_BOOK = UniqueKeys0.PK_BOOK;
    public static final UniqueKey<JBookAuthorRecord> PK_BOOK_AUTHOR = UniqueKeys0.PK_BOOK_AUTHOR;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<JBookAuthorRecord, JAuthorRecord> FK_AUTHOR_ID = ForeignKeys0.FK_AUTHOR_ID;
    public static final ForeignKey<JBookAuthorRecord, JBookRecord> FK_BOOK_ID = ForeignKeys0.FK_BOOK_ID;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<JAuthorRecord, Long> IDENTITY_AUTHOR = Internal.createIdentity(JAuthor.AUTHOR, JAuthor.AUTHOR.ID);
        public static Identity<JBookRecord, Long> IDENTITY_BOOK = Internal.createIdentity(JBook.BOOK, JBook.BOOK.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<JAuthorRecord> PK_AUTHOR = Internal.createUniqueKey(JAuthor.AUTHOR, "PK_AUTHOR", JAuthor.AUTHOR.ID);
        public static final UniqueKey<JBookRecord> PK_BOOK = Internal.createUniqueKey(JBook.BOOK, "PK_BOOK", JBook.BOOK.ID);
        public static final UniqueKey<JBookAuthorRecord> PK_BOOK_AUTHOR = Internal.createUniqueKey(JBookAuthor.BOOK_AUTHOR, "PK_BOOK_AUTHOR", JBookAuthor.BOOK_AUTHOR.AUTHOR_ID, JBookAuthor.BOOK_AUTHOR.BOOK_ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<JBookAuthorRecord, JAuthorRecord> FK_AUTHOR_ID = Internal.createForeignKey(ru.yusdm.training.jooq.jooqgenerated.Keys.PK_AUTHOR, JBookAuthor.BOOK_AUTHOR, "FK_AUTHOR_ID", JBookAuthor.BOOK_AUTHOR.AUTHOR_ID);
        public static final ForeignKey<JBookAuthorRecord, JBookRecord> FK_BOOK_ID = Internal.createForeignKey(ru.yusdm.training.jooq.jooqgenerated.Keys.PK_BOOK, JBookAuthor.BOOK_AUTHOR, "FK_BOOK_ID", JBookAuthor.BOOK_AUTHOR.BOOK_ID);
    }
}
