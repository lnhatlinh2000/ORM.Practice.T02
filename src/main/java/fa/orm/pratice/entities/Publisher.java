package fa.orm.pratice.entities;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @Column(name = "publisher_name", nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String address;

    @Pattern(regexp = "(0)+([0-9]{9})\\b", message = "IllegalArgumentException")
    @Column(nullable = false)
    private String phone;

    @NotNull
    @Column(nullable = false, length = 10)
    private int url;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher")
    private Set<Book> books;

    public Publisher() {

    }

    public Publisher(String name, String address, String phone, int url) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
