package app.course;

public class Course {
    public int id;
    public String name;
    public String department;

    public String descriptionCourse(){
        String s = "";
        s += "Course ID: " + id + "\n";
        s += "Name: " + name + "\n";
        s += "Department: " + department + "\n";
        return s;
    }
}
