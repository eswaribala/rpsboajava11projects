package demo;

import java.util.ArrayList;
import java.util.List;

public class StudentHelper {

    public static List<Student> getStudents() {

        Student student1 = Student.builder().id(1).name("Jaya").build();
        Student student2 = Student.builder().id(2).name("Rahul").build();
        Student student3 = Student.builder().id(3).name("Megha").build();
        Student student4 = Student.builder().id(4).name("Tapas").build();
        Student student5 = Student.builder().id(5).name("Raghav").build();


        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        return studentList;
    }
}
