import java.sql.Timestamp;

public class User {

    private Long id;
    private String name;
    private String surname;
    private String phone;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public User(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public User(Long id, String name, String surname, String phone, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "USER: " + id + "\n" + name + "\n" + surname + "\n" + phone + "\n" + createdAt + "\n" + updatedAt + "\n";
    }
}
