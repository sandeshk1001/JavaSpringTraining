package BasicJava.day2;

public class Student {
    private int rollno;
    private String name;
    private int stdclass;
    private String fathername;
    private String address;
    private int phone;

    public Student(int rollno, String name, int stdclass, String fathername, String address, int phone) throws Exception {
        if(isvalid(rollno,name,stdclass,fathername,address,phone)){
            this.rollno = rollno;
            this.name = name;
            this.stdclass = stdclass;
            this.fathername = fathername;
            this.address = address;
            this.phone = phone;
        }

    }

    private boolean isvalid(int rollno, String name, int stdclass, String fathername, String address, int phone) throws Exception {
        if(rollno <1 && rollno>100)
            throw new Exception("Roll no Invalid Please insert correct");
        else if(stdclass <1 && stdclass >12)
            throw new Exception("Class should be between 1 to 12");
        else if(phone <10 && phone >10){
            throw new Exception("Phone number should be 10 digit");
        }
        return false;
    }
}
