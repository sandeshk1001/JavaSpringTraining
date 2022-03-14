package hibernateBasic.Homework_4.JavaTask02_28fab.Q9;

import jakarta.persistence.*;

@Entity
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private int id;
    @Column(name = "cat_name")
    private String catName;
    @Column(name = "cat_weight")
    private Double catWeight;
    @Column(name = "cat_age")
    private int catAge;

    public Cat() {
    }

    public Cat(String catName, Double catWeight, int catAge) {
        this.catName = catName;
        this.catWeight = catWeight;
        this.catAge = catAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Double getCatWeight() {
        return catWeight;
    }

    public void setCatWeight(Double catWeight) {
        this.catWeight = catWeight;
    }

    public int getCatAge() {
        return catAge;
    }

    public void setCatAge(int catAge) {
        this.catAge = catAge;
    }

    @Override
    public String toString() {
        return "\nCat{" +
                "id=" + id +
                ", catName='" + catName + '\'' +
                ", catWeight=" + catWeight +
                ", catAge=" + catAge +
                '}';
    }
}
