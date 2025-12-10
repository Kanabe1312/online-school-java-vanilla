package app.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScheduleService {

    public List<Schedule> schedules = new ArrayList<>();

    public void loadSchedules() {

        Schedule s1 = new Schedule();
        s1.id = 1;
        s1.studentId = 12345;
        s1.subject = "Math";
        s1.day = "Monday";
        s1.duration = "10:00 - 12:00";

        Schedule s2 = new Schedule();
        s2.id = 2;
        s2.studentId = 12345;
        s2.subject = "History";
        s2.day = "Wednesday";
        s2.duration = "14:00 - 16:00";

        Schedule s3 = new Schedule();
        s3.id = 3;
        s3.studentId = 54321;
        s3.subject = "Biology";
        s3.day = "Friday";
        s3.duration = "08:00 - 10:00";

        schedules.add(s1);
        schedules.add(s2);
        schedules.add(s3);
    }

    public List<Schedule> getScheduleByStudentId(int studentId){
        List<Schedule> list = new ArrayList<>();

        for(int i=0;i<schedules.size();i++){
            Schedule s = schedules.get(i);
            if(s.studentId == studentId){
                list.add(s);
            }
        }

        return list;
    }

    public Schedule addSchedule(Schedule sc){
        sc.id = generateId();
        schedules.add(sc);
        return sc;
    }

    private int generateId(){
        Random r = new Random();
        return r.nextInt(99999)+1;
    }


}
