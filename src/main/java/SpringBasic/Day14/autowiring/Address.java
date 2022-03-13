package SpringBasic.Day14.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Address {

    private String houseno;

    public Address() {
        houseno="house 123";
    }

    public Address(String address) {
        this.houseno = address;
    }

    public String getHouseno() {
        return houseno;
    }
}
