package hibernateBasic.day10.associationWithAnotation;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer id;
    @Column(name = "person_name")
    private String name;
    @OneToMany(mappedBy = "person",cascade = CascadeType.REMOVE)
    private Set<PhoneNumber> phoneNumbers= new HashSet<>();

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
