package fa.orm.pratice.dao;

import fa.orm.pratice.entities.Author;
import fa.orm.pratice.entities.AuthorId;
import fa.orm.pratice.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorDAO extends AbstractDAO<Author, String>{

    public Author findById(Class<Author> entity, AuthorId authorId) {
        return super.findById(entity, authorId);
    }
}
