package app.enrolment;

public class Enrolment {
    public int id;
    public int studentId;
    public int couseId;
    public String createdAt;

    public String descriptionEnrolment(){
        String s = "";
        s += "Strudent Id" + studentId + "\n";
        s += "Couse Id" + couseId + "\n";
        s += "Created At" + createdAt + "\n";
        return s;
    }
}
