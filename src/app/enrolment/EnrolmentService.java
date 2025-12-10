package app.enrolment;
import app.course.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnrolmentService {

    public List<Enrolment> enrolments = new ArrayList<>();

    public void loadEnrolments() {
        Enrolment e1= new Enrolment();
        e1.studentId = 12345;
        e1.couseId = 1;
        e1.createdAt = "09:30;01.12.2025";

        Enrolment e2= new Enrolment();
        e2.studentId = 12345;
        e2.couseId = 2;
        e2.createdAt = "14:30;23.12.2025";

        Enrolment e3= new Enrolment();
        e3.studentId = 54321;
        e3.couseId = 3;
        e3.createdAt = "15:30;26.11.2025";

        enrolments.add(e1);
        enrolments.add(e2);
        enrolments.add(e3);
    }


    public List<Integer> getEnrolmentsByStudentId(int studentId) {
        List<Integer> list =new ArrayList<>();
        for (int i = 0; i<enrolments.size();i++) {
            if (enrolments.get(i).studentId == studentId) {
                Enrolment e = enrolments.get(i);
                if(e.studentId == studentId){
                    list.add(e.couseId);
                }
            }
        }
        return list;
    }

    public Enrolment getEnrolmentById(int id){


        for(int i = 0; i <enrolments.size(); i++){
            if(enrolments.get(i).id==id){
                return enrolments.get(i);
            }
        }
        return null;
    }

    public int generateId(){
        Random r = new Random();
        return r.nextInt(9999) + 1;
    }

    public Enrolment addEnrolment(Enrolment e){
        e.id = generateId();
        enrolments.add(e);
        return e;
    }

    public void enrolStudentToCourse(int studentId, int couseId){
        for(int i = 0;i<enrolments.size();i++){
          Enrolment e = enrolments.get(i);
          if(e.studentId == studentId &&  e.couseId == couseId){
              System.out.println("Student is already enrolled");
              return;
          }
      }

      Enrolment e = new Enrolment();
      e.studentId = studentId;
      e.couseId = couseId;
      e.createdAt = "09:30;01.12.2025";

      enrolments.add(e);

        System.out.println("Student" + studentId + "was enrolled at the course " + couseId);
    }
}
