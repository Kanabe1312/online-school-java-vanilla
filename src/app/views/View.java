package app.views;

import app.books.Book;
import app.books.BookService;
import app.course.Course;
import app.course.CourseService;
import app.enrolment.Enrolment;
import app.enrolment.EnrolmentService;
import app.schedule.Schedule;
import app.schedule.ScheduleService;
import app.students.Student;
import app.students.StudentService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    public BookService bookService= new  BookService();
    public StudentService studentService = new  StudentService();
    public ScheduleService scheduleService = new ScheduleService();
    public CourseService courseService = new  CourseService();
    public EnrolmentService enrolmentService = new  EnrolmentService();
    public Student  logat=null;



    //todo:logare student;
    //todo:Afisare carti student
    Scanner sc = new Scanner(System.in);

    public void meniu(){
        System.out.println("1-Login");
        System.out.println("2-Show books");
        System.out.println("3-Add book");
        System.out.println("4-Show schedule");
        System.out.println("5-Add schedule");
        System.out.println("6-Show my enrolments");
        System.out.println("7-Add enrolment");



    }
    public void play(){
        studentService.loadStudents();
        bookService.loadBooks();
        scheduleService.loadSchedules();
        enrolmentService.loadEnrolments();
        courseService.loadCourses();




        while(true){
            meniu();
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:login();
                break;
                case 2:showBooks();
                break;
                case 3:addBook();
                break;
                case 4: showSchedule();
                break;
                case 5: addSchedule();
                break;
                case 6 : showMyEnrolments();
                break;
                case 7 : enrollStudentToCourse();
                break;

            }
        }
    }

    public void login(){
        System.out.println("Enter your Email:");
        String email = sc.nextLine();
        Student s = studentService.getStudentByEmail(email);

        if(s==null){
            System.out.println("Invalid Email");
            return;
        }
        System.out.println("Enter your Password:");
        String password = sc.nextLine();

        if(s.password.equals(password)){
            System.out.println("Login Successful");
            this.logat=s;
        }
        else{
            System.out.println("Invalid Password");
        }
    }
    public void showBooks() {
        if(logat == null){
            System.out.println("Please Login");
            return;
        }
        List<Book> books = bookService.getBookByStudentid(logat.id);
        System.out.println("===Your Books ===");
        for(int i=0;i<books.size();i++){
            Book b = books.get(i);
            System.out.println(b.descriptionBook());
            System.out.println("--------");
        }

    }
    public void addBook() {
        if(logat == null){
            System.out.println("Please Login");
            return;
        }
        Book b = new Book();


        b.studentId = logat.id;

        System.out.println("Enter Book name: ");
        b.bookName = sc.nextLine();
        if(bookService.getBookByName(b.bookName)!=null){
            System.out.println("Book already exists");

        }else{
            System.out.println("Enter created year: ");
            b.createdAt = sc.nextLine();

            this.bookService.addBook(b);

            System.out.println("Book added "+b.id);
        }


    }
    public void showSchedule(){
        if(logat == null){
            System.out.println("Please Login!");
            return;
        }

        List<Schedule> list = scheduleService.getScheduleByStudentId(logat.id);

        if(list.size() == 0){
            System.out.println("No schedule found!");
            return;
        }
        System.out.println("=== Your Schedule ===");
        for(Schedule s : list){
            System.out.println(s.descriptionSchedule());
            System.out.println("------------");

        }

    }

    public void addSchedule(){
        if(logat == null){
            System.out.println("Please Login!");
            return;
        }

        Schedule sched = new Schedule();
        sched.studentId = logat.id;

        System.out.println("Enter subject:");
        sched.subject = sc.nextLine();

        System.out.println("Enter day:");
        sched.day = sc.nextLine();

        System.out.println("Enter duration (ex: 10:00 - 12:00):");
        sched.duration = sc.nextLine();

        scheduleService.addSchedule(sched);
        System.out.println("Schedule added with ID: " + sched.id);
    }

    public void showMyEnrolments(){
        if(logat == null){
            System.out.println("Please Login!");
            return;
        }
        List<Integer> list = enrolmentService.getEnrolmentsByStudentId(logat.id);
        List<Course> courses= courseService.getCoursesByIds(list);
        if(list.size() == 0){
            System.out.println("No my enrolments found!");
            return;
        }
        for(int i=0;i<courses.size();i++){
            System.out.println(courses.get(i).name);
        }
        System.out.println("=== Your Enrolments ===");


    }

    public void enrollStudentToCourse(){
        if (logat == null){
            System.out.println("Please Login!");
            return;
        }
        System.out.println("Enter course ID to enrol:");
        int courseId = Integer.parseInt(sc.nextLine());
        this.enrolmentService.enrolStudentToCourse(logat.id,courseId);
    }



}
