package app.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookService {
    public List<Book> book = new ArrayList<>();

    public void loadBooks() {
        Book b1 = new Book();
        b1.id =11111;
        b1.studentId=12345;
        b1.bookName ="Romeo and Juliet";
        b1.createdAt = "1887";

        Book b2 = new Book();
        b2.id =11112;
        b2.studentId=12345;
        b2.bookName ="The greate Gastby";
        b2.createdAt = "1975";

        Book b3 = new Book();
        b3.id =11113;
        b3.studentId=54321;
        b3.bookName ="The Hollywood";
        b3.createdAt = "1991";

        book.add(b1);
        book.add(b2);
        book.add(b3);

    }
    public void showBooks(){
        System.out.println("===Book List===");
        for(int i=0;i<book.size();i++){
            Book b = book.get(i);
            System.out.println(b.descriptionBook());
            System.out.println("-------");
        }
    }
    //todo:Get books by student id
    public List<Book> getBookByStudentid (int studentId){
        List<Book> books = new ArrayList<>();
        for(int i=0;i<book.size();i++){
            Book b = book.get(i);
            if(b.studentId==studentId){
                books.add(b);
            }
        }
        return  books;
    }


    public Book getBookById(int id){

        for(int i=0;i<book.size();i++){
             if(this.book.get(i).id==id){
                 return book.get(i);
             }
        }
        return null;
    }

    public Book addBook(Book b){
        b.id = generateId();
        book.add(b);

        return b;
    }

    public  int generateId(){

        Random rand = new Random();

        int id=rand.nextInt(99999)+1;

        if(this.getBookById(id) == null){

            id=rand.nextInt(99999)+1;
        }

        return id;

    }


    //todo:functie getBookByName
    public Book getBookByName(String name){
        for(int i=0;i<book.size();i++){
            Book b = book.get(i);
            if(b.bookName.equals(name)){
                return b;
            }

        }
        return null ;
    }


}

