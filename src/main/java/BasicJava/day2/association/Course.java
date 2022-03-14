package BasicJava.day2.association;

public class Course {
    private Student[] students;
    private Faculty faculty;
    private int index;

    Course() {
        index = 0;
        students = new Student[5];
    }

    public void addStudent(Student student) {
        int size = students.length;
        // students[0]...students[99]
        if (index >= size) {
            int newSize = 2 * size;
            Student[] newStudents = new Student[newSize];
            for (int i = 0; i < size; i++)
                newStudents[i] = students[i];
            newStudents[index] = student;
            index++;
            students = newStudents;
        } else {
            students[index] = student;
            index++;
        }
    }

    public void editStudent(int index){

    }

    // setters
    public void setFaculty(Faculty _faculty) {
        faculty = _faculty;
    }
    // getter
    public Faculty getFaculty() {
        return faculty;
    }

    public void print() {
        System.out.println("List of all students int the course");
        for (int i = 0; i < index; i++)
            System.out.println(students[i].getName());
    }
}