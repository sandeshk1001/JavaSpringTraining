package hibernateBasic.Homework_4.JavaTask02_28fab.Q10;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int id;
    @Column(name = "store_name")
    private String name;
    @Column(name = "store_address")
    private String address;

    @OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE)
    private Set<Product> products= new HashSet<>();

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Store() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
