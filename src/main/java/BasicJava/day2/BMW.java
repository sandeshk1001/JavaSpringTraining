package BasicJava.day2;

public class BMW implements Car{
    double price;
    String color;
    String model;
    BMW(double _price,String _color,String _model){
        price=_price;
        color=_color;
        model=_model;
    }
    @Override
    public String getColour() {
        return color;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getModel() {
        return model;
    }
}
