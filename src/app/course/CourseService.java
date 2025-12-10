package app.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CourseService {

    public List<Course> courses = new ArrayList<>();

    public void loadCourses(){
        Course c1 = new Course();
        c1.id = 1;
        c1.name = "Algorithms";
        c1.department = "Computer Science";

        Course c2 = new Course();
        c2.id = 2;
        c2.name = "Database";
        c2.department = "Computer Science";

        Course c3 = new Course();
        c3.id = 3;
        c3.name = "Marketing";
        c3.department = "Economics";

        courses.add(c1);
        courses.add(c2);
        courses.add(c3);

    }

    public List<Course> getCoursesByIds(List<Integer> ids){
        List<Course> filteredCourses = new ArrayList<>();
        for(int i = 0; i <courses.size(); i++){
            if(ids.contains(courses.get(i).id)){
                filteredCourses.add(courses.get(i));
            }
        }
        return filteredCourses;
    }

    public int generateId(){
        Random r = new Random();
        return r.nextInt(9999) + 1;
    }

    public Course addCourse(Course c){
        c.id = generateId();
        courses.add(c);
        return c;
    }
}
