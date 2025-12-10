package app.students;


import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public List<Student> student = new ArrayList<>();

    public void loadStudents() {
        Student s1 = new Student();
        s1.id=12345;
        s1.firstname="John";
        s1.lastname="Doe";
        s1.age="19";
        s1.email="johndoe@gmail.com";
        s1.password="John123";

        Student s2 = new Student();
        s2.id=54321;
        s2.firstname="Robert";
        s2.lastname="Miller";
        s2.age="20";
        s2.email="robert2005@gmail.com";
        s2.password="Robert123";

        Student s3 = new Student();
        s3.id=654321;
        s3.firstname="Mark";
        s3.lastname="Ritz";
        s3.age="25";
        s3.email="mark2000@gmail.com";
        s3.password="Mark123";

       student.add(s1);
       student.add(s2);
       student.add(s3);

    }
    public void studentDisplay() {
        System.out.println("===Student List===");

        for(int i=0;i<student.size();i++) {
            Student s = student.get(i);
            System.out.println(s.descriptionStudent());
            System.out.println("---------");

        }
    }

    public Student getStudentByEmail(String email) {
        for(int i = 0;i<student.size();i++) {
            Student s = student.get(i);
            if(s.email.equals(email)) {
                return s;
            }
        }
        return null;
    }




}
