package BasicJava;

public class Circle {
    private double radius;

    Circle(double _radius){
        radius=_radius;
    }
    public double getArea(){
        return Math.PI;
    }
    public double getCurcumference(){
        return 0;
    }
    private double getDiameter(){
        return radius*2;
    }
}
