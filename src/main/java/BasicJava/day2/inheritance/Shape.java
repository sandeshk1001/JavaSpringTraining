package BasicJava.day2.inheritance;

import java.util.Date;

/*
to define new classes from existing classes.
 */
public class Shape {
    private String color;
    private boolean filled;
    private Date createdDate;

    Shape() {
        createdDate = new Date();
    }

    Shape(String _color, boolean _filled) {
        createdDate = new Date();
        color = _color;
        filled = _filled;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "created on " + createdDate + " , color = " + color + " , filled = " + filled;
    }
}
