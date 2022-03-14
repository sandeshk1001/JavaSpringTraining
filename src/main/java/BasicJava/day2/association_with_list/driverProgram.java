package BasicJava.day2.association_with_list;

public class driverProgram {
    public static void main(String[] args) {
//        Course course = new Course(new Student[]{}, new Faculty());
        Student student1 = new Student("name-1");
        Student student2 = new Student("name-2");
        Student student3 = new Student("name-3");
        Student student4 = new Student("name-4");
        Student student5 = new Student("name-5");
        Student student6 = new Student("name-6");
        Course course = new Course();

        course.addStudent(student1);
        course.addStudent(student2);
        course.addStudent(student3);
        course.addStudent(student4);
        course.addStudent(student5);
        course.addStudent(student6);
        System.out.println("Students enrolled in course-1");
        course.print();

        Course course2 = new Course();
        course2.addStudent(student1);
        Student student7 = new Student("name-7");
        course2.addStudent(student7);

        System.out.println("Students enrolled in cours-2");
        course2.print();
        // course.addStudent

    }
}
