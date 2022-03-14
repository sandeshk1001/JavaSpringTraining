package hibernateBasic;

public class Car {
    private int id;
    private String name;
    private int speed;

    public Car(String name, int speed) {
        //this.id = id;
        this.name = name;
        this.speed = speed;
    }

    Car(){

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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
