package hibernateBasic.day10.associationWithAnotation;

import jakarta.persistence.*;
@Entity
public class PhoneNumber {
    @Id
    @Column(name = "phone_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public PhoneNumber() {
    }

    @Column(name = "phone_number")
    private String phone;
    @Column(name = "provider")
    private String provider;
    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
