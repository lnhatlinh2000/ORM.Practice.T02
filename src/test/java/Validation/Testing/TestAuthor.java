package Validation.Testing;

import Validation.ValidatorTesting;
import fa.orm.pratice.dao.AuthorDAO;
import fa.orm.pratice.entities.Author;
import fa.orm.pratice.entities.AuthorId;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestAuthor {

    private AuthorDAO authorDAO = new AuthorDAO();
    private ValidatorTesting validatorTesting = new ValidatorTesting();

    @Test
    void getAllAuthor() {
        List<Author> authors = authorDAO.getAll("Author");
        Assert.assertEquals(2, authors.size());
        Author author = authors.get(0);
        Assert.assertEquals("Can Tho", author.getAuthorId().getAddress());
        Assert.assertEquals("Kha", author.getAuthorId().getName());
        Assert.assertEquals("Ninh Kieu - Can Tho", author.getUrl());
    }

//    @Test
//    void getAllAuthor() {
//        List<Author> authors = authorDAO.getAll("Author");
//        Assert.assertEquals(2, authors.size());
//        Author author = authors.get(0);
//        Assert.assertEquals("Can Tho", author.getAddress());
//        Assert.assertEquals("Kha", author.getName());
//        Assert.assertEquals("Ninh Kieu - Can Tho", author.getUrl());
//    }

    @Test
    void testSaveAuthorEmbeddeId() {
        AuthorId authorId = new AuthorId("Kha", "BacLieu");
        Author author = new Author();
        author.setAuthorId(authorId);
        author.setUrl("xxxxxxxxxx");

        if (validatorTesting.testHibernateValidator(author)) {
            Assert.assertNotNull(authorDAO.save(author));
        }
    }

//    @Test
//    void testSaveAuthor() {
//        Author author = new Author();
//        author.setAddress("SocTrang");
//        author.setName("Dao Hoang Khang");
//        author.setUrl("xxxxxxxxxx");
//
//        if (validatorTesting.testHibernateValidator(author)) {
//            Assert.assertNotNull(authorDAO.save(author));
//        }
//    }
//
//    @Test
//    void testUpdateAuthor() {
//        AuthorId authorId = new AuthorId("Dao Hoang Khang", "SocTrang");
//        Author author = authorDAO.findById(Author.class, authorId);
//        authorId.setAddress("SocTrangUpdate");
//        author.setAuthorId(authorId);
//
//        System.out.println(authorDAO.update(author));
//
//    }

    //    @Test
//    void testFindById() {
//        AuthorId authorId = new AuthorId("Dao Hoang Khang", "SocTrang");
//        Author author = authorDAO.findById(Author.class, authorId);
//
//        Assert.assertEquals("SocTrang", author.getAddress());
//        Assert.assertEquals("Dao Hoang Khang", author.getName());
//        Assert.assertEquals("xxxxxxxxxx", author.getUrl());
//    }
//
    @Test
    void testDelete() {
        AuthorId authorId = new AuthorId("Linh", "HCM");
        Author author = authorDAO.findById(Author.class, authorId);
//        System.out.println(author.toString());
        Assert.assertTrue(authorDAO.delete(author));
    }
}
