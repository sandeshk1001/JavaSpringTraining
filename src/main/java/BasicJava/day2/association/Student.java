package BasicJava.day2.association;

public class Student {
    private Course[] courses;
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void addCourse(Course c){

    }
}