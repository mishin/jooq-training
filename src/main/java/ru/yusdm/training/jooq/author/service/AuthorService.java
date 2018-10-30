package ru.yusdm.training.jooq.author.service;

import ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JAuthor;
import ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook;

import java.util.List;

public interface AuthorService {

    List<JAuthor> getAllAuthors();

    JAuthor insert(JAuthor author);

    void update(JAuthor author);

    void deleteById(long id);

    void deleteAll();

    JAuthor findById(long id);

    List<JBook> getAuthorBooks(long authorId);

}
