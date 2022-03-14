package hibernateBasic.day8.person;

public class Person {
    private Integer personId;
    private String personName;
    private PhoneNumber phoneNumber;

    public Person(Integer personId, String personName, PhoneNumber phoneNumber) {
        this.personId = personId;
        this.personName = personName;
        this.phoneNumber = phoneNumber;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
