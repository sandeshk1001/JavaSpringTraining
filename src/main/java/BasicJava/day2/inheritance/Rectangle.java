package BasicJava.day2.inheritance;

public class Rectangle extends Shape{
    private double length;
    private double breadth;

    public Rectangle(){

    }

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    public Rectangle(String _color, boolean _filled, double _length, double _breadth) {
        super(_color, _filled);
        this.length = _length;
        this.breadth = _breadth;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getBreadth() {
        return breadth;
    }

    public void setBreadth(double breadth) {
        this.breadth = breadth;
    }



    public double getArea(){
        return length*breadth;
    }
}
