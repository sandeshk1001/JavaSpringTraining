package hibernateBasic.day8;

public class CarDetails {
    private Integer id;
    private Double speed;
    private String name;
    Float horsePower;
    Character maker;
    Boolean isHatchBack;
    Long carNumber;

    public CarDetails(Integer id, Double speed, String name, Float horsePower, Character maker, Boolean isHatchBack, Long carNumber) {
        this.id = id;
        this.speed = speed;
        this.name = name;
        this.horsePower = horsePower;
        this.maker = maker;
        this.isHatchBack = isHatchBack;
        this.carNumber = carNumber;
    }

    public CarDetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Float horsePower) {
        this.horsePower = horsePower;
    }

    public Character getMaker() {
        return maker;
    }

    public void setMaker(Character maker) {
        this.maker = maker;
    }

    public Boolean getisHatchBack() {
        return isHatchBack;
    }

    public void setisHatchBack(Boolean hatcback) {
        isHatchBack = hatcback;
    }

    public Long getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Long carNumber) {
        this.carNumber = carNumber;
    }

}
