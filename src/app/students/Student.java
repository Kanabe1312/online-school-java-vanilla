package app.students;

public class Student {
    public int id;
    public String firstname;
    public String lastname;
    public String email;
    public String age;
    public String password;

    public String descriptionStudent(){
        String s = "";
        s += "Student id is :"+ id +"\n";
        s += "First name is :"+ firstname +"\n";
        s += "Last name is :"+ lastname +"\n";
        s += "Email is :"+ email +"\n";
        s += "Age is :"+ age +"\n";
        s += "Password is :"+ password +"\n";
        return s;
    }

}
