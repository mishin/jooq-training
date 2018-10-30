package ru.yusdm.training.jooq.author.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.yusdm.training.jooq.author.service.AuthorService;
import ru.yusdm.training.jooq.book.service.BookService;
import ru.yusdm.training.jooq.book_author.service.BookAuthorService;
import ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JAuthor;
import ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBook;
import ru.yusdm.training.jooq.jooqgenerated.tables.pojos.JBookAuthor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static ru.yusdm.training.jooq.common.business.configs.DatabaseConfigs.TRANSACTION_MANAGER;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Transactional(TRANSACTION_MANAGER)
public class AuthorServiceImplTest {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookAuthorService bookAuthorService;

    @Test
    public void getAllAuthors() {
        authorService.getAllAuthors();
    }


    @Test
    public void save() {
        JAuthor toSave = prepareTestAuthor();
        authorService.insert(toSave);
        System.out.println();
    }

    @Test
    public void update() {
        JAuthor author = prepareTestAuthor();
        authorService.insert(author);
        author.setFirstName("NewFirstName");
        authorService.update(author);
    }

    @Test
    public void deleteById() {
        JAuthor author = prepareTestAuthor();
        authorService.insert(author);
        authorService.deleteById(author.getId());
        assertEquals(0, authorService.getAllAuthors().size());
    }

    @Test
    public void testGetAuthorBooks() {

        JAuthor author = prepareTestAuthor();
        authorService.insert(author);

        int index = 0;
        List<JBook> books = Arrays.asList(
                prepareTestBook(++index),
                prepareTestBook(++index),
                prepareTestBook(++index)
        );

       books.forEach(b -> {
            bookService.insert(b);
            bookAuthorService.insert(new JBookAuthor(author.getId(), b.getId()));
        });

        authorService.getAuthorBooks(author.getId());

    }

    private JAuthor prepareTestAuthor() {
        return new JAuthor(null, "firstName",
                "middleName",
                "lastName",
                Timestamp.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
    }

    private JBook prepareTestBook(int index) {
        return new JBook(null,
                "Name_" + index,
                "ContentAsStr_" + index,
                ("ContentAsPdf_" + index).getBytes(),
                index,
                Timestamp.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
    }
}