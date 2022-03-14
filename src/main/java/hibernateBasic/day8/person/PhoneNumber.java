package hibernateBasic.day8.person;

public class PhoneNumber {
    private int phoneId;
    private String phoneNumber;
    private String serviceProvider;

    public PhoneNumber(int phoneId, String phoneNumber, String serviceProvider) {
        this.phoneId = phoneId;
        this.phoneNumber = phoneNumber;
        this.serviceProvider = serviceProvider;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

}
