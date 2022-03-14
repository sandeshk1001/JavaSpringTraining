package hibernateBasic.day8;

public class Student {
    private int id;
    private String name;
    private int rollno;
    private String university;

    public Student() {
    }

    public Student(String name, int rollno, String university) {
        this.name = name;
        this.rollno = rollno;
        this.university = university;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rollno=" + rollno +
                ", university='" + university + '\'' +
                '}'+"\n";
    }
}