package fa.orm.pratice.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
//@IdClass(AuthorId.class)
public class Author {

    @EmbeddedId
    private AuthorId authorId;
//    @Id
//    private String name;
//    @Id
//    private String address;

    @NotBlank
    @Column(nullable = false)
    private String url;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Set<Book> books;

    public Author() {

    }

    public Author(AuthorId authorId, String url) {
        this.authorId = authorId;
        this.url = url;
    }

    public AuthorId getAuthorId() {
        return authorId;
    }

    public void setAuthorId(AuthorId authorId) {
        this.authorId = authorId;
    }
//
//        public Author(String name, String address, String url) {
//        this.name = name;
//        this.address = address;
//        this.url = url;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
