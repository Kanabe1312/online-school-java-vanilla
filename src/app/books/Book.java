package app.books;

public class Book {
    public int id;
    public int studentId;
    public String bookName;
    public String createdAt;


    public String descriptionBook(){
        String b ="";
        b += "Books id is:" + id + "\n";
        b += "Student id is:" + studentId + "\n";
        b += "Book name is:" + bookName + "\n";
        b += "Was created at: " + createdAt + "\n";
        return b;
    }
}



