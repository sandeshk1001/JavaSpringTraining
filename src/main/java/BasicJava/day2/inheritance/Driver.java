package BasicJava.day2.inheritance;

public class Driver {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10,20);
        System.out.println(rectangle.getArea()+" "+rectangle.getColor());
        rectangle.setColor("red");
        rectangle.setFilled(true);
        System.out.println(rectangle.toString());
        rectangle.setBreadth(10);
        System.out.println(rectangle.getArea());
    }
}
