package Assigments.HibernateTask.JavaTask02_28fab.Q7;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class ProductIncri {
    @Id
    @GeneratedValue(generator = "custum-generater")
    @GenericGenerator(name = "custum-generater" ,strategy = "Homework_4.JavaTask02_28fab.Q7.ProductSequenceId")
    private int id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "price")
    private Double price;

    public ProductIncri(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public ProductIncri() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
