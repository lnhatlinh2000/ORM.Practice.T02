package Validation.Testing;

import Validation.ValidatorTesting;
import fa.orm.pratice.dao.PublisherDAO;
import fa.orm.pratice.entities.Publisher;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;


public class TestPublisher {

    private PublisherDAO publisherDAO = new PublisherDAO();
    private ValidatorTesting validatorTesting = new ValidatorTesting();

    @Test
    void getAllPublisher() {
        List<Publisher> publisherList = publisherDAO.getAll("Publisher");
        Assert.assertEquals(2, publisherList.size());
    }

    @Test
    void testSavePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Tri thuc");
        publisher.setAddress("Vinh Long");
        publisher.setPhone("0123456789");
        publisher.setUrl(1);


        if (validatorTesting.testHibernateValidator(publisher)) {
            Assert.assertNotNull(publisherDAO.save(publisher));
        }
    }

    @Test
    void testValidatorSavePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Tri thuc");
        publisher.setAddress("Vinh Long");
        //Check mobile numbers as 10 digits start with 0
        publisher.setPhone("1234567891011");
        publisher.setUrl(1);

        Assert.assertEquals(false, validatorTesting.testHibernateValidator(publisher));
    }

    @Test
    void testUpdatePublisher() {
        Publisher publisher = publisherDAO.findById(Publisher.class, "Kimdong");
        publisher.setAddress("Vinh Long Update");
        publisher.setUrl(2);

        Assert.assertTrue(publisherDAO.update(publisher));

        Publisher publisherUpdate = publisherDAO.findById(Publisher.class, "Kimdong");

        Assert.assertEquals("Vinh Long Update", publisherUpdate.getAddress());
        Assert.assertEquals(2, publisherUpdate.getUrl());
    }

    @Test
    void testFindById() {
        Publisher publisher = publisherDAO.findById(Publisher.class, "Kimdong");

        Assert.assertEquals("0123456789", publisher.getPhone());
        Assert.assertEquals("Vinh Long Update", publisher.getAddress());
        Assert.assertEquals(2, publisher.getUrl());
    }

    @Test
    void testDeletePublisher() {
        Publisher publisher = publisherDAO.findById(Publisher.class, "Tri thuc");

        Assert.assertTrue(publisherDAO.delete(publisher));
    }
}
