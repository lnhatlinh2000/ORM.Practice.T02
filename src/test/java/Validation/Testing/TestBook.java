package Validation.Testing;

import Validation.ValidatorTesting;
import fa.orm.pratice.dao.AuthorDAO;
import fa.orm.pratice.dao.BookDAO;
import fa.orm.pratice.dao.PublisherDAO;
import fa.orm.pratice.entities.Author;
import fa.orm.pratice.entities.AuthorId;
import fa.orm.pratice.entities.Book;
import fa.orm.pratice.entities.Publisher;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestBook {

    private BookDAO bookDAO = new BookDAO();
    private AuthorDAO authorDAO = new AuthorDAO();
    private PublisherDAO publisherDAO = new PublisherDAO();

    ValidatorTesting validatorTesting = new ValidatorTesting();

    @Test
    void testSaveBook() {
        AuthorId authorId = new AuthorId("Kha", "BacLieu");
        Author author = authorDAO.findById(Author.class, authorId);
        Publisher publisher = publisherDAO.findById(Publisher.class, "Tri Thuc");

        Book book = new Book();
        book.setIsbn("978-3-16-148410-0");
//        book.setIsbn("dasde");
        book.setPrice(120000);
        book.setYear(2020);
        book.setTitle("International Standard");
        book.setAuthor(author);
        book.setPublisher(publisher);

        if (validatorTesting.testHibernateValidator(book)) {
            Assert.assertNotNull(bookDAO.save(book));
        }
    }

    @Test
    void testValidatorSaveBook() {
        AuthorId authorId = new AuthorId("Linh", "HCM");
        Author author = authorDAO.findById(Author.class, authorId);
        Publisher publisher = publisherDAO.findById(Publisher.class, "Thanh Cong");

        Book book = new Book();
        book.setIsbn("978-3-16-148410-0");
        book.setPrice(120000);
        //check years from 1950 to the current year
        book.setYear(1949);
        book.setTitle("International Standard");
        book.setAuthor(author);
        book.setPublisher(publisher);

        Assert.assertEquals(false, validatorTesting.testHibernateValidator(book));
    }

    @Test
    void testUpdateBook() {
        AuthorId authorId = new AuthorId("Linh", "HCM");
        Author author = authorDAO.findById(Author.class, authorId);
        Publisher publisher = publisherDAO.findById(Publisher.class, "Thanh Cong");

//        authorId.setAddress("HCM-Update");
//        author.setAuthorId(authorId);

        Book book = new Book();
        book.setIsbn("978-3-16-148410-0");
        book.setPrice(120000);
        book.setYear(2020);
        book.setTitle("International Standard");
        book.setAuthor(author);
        book.setPublisher(publisher);

        System.out.println(bookDAO.update(book));
    }
}
