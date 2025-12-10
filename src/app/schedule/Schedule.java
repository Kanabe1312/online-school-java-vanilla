package app.schedule;

public class Schedule {
    public int id;
    public int studentId;
    public String subject;
    public String day;
    public String duration;

    public String descriptionSchedule(){
        String s = "";
        s += "Svhedule ID: " + id + "\n";
        s += "Student ID: " + studentId + "\n";
        s += "Subject: " + subject + "\n";
        s += "Day: " + day + "\n";
        s += "Duration: " + duration + "\n";
        return s;
    }
}
