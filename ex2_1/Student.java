package ex2_1.Student;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Student {
    @Override
    public String toString(){
        return "Student [id="+id", surname="+surname")";
    }
    public Integer getId() {
        return id;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setIg(Integer id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Student(Integer id, String surname, String name, String group, String faculty,
                   Integer course, String phone, String address, Date birth){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.group = group;
        this.faculty = faculty;
        this.course = course;
        this.phone = phone;
        this.address = address;
        this.birth = birth;
    }

    public void input(Scanner sc){
        this.id = sc.nextInt();
        this.surname = surname.nextLine();
        this.name = name.next();
        this.group = group.next();
        this.faculty = faculty.next();
        this.course = course.nextInt();
        this.phone = phone.next();
        this.address = address.next();
        try {
            this.birth = new SimpleDateFormat("dd/mm/yyyy").;
        }
        catch(ParseException e){
            e.printStackTrace();
        }
    }


    @SuppressWarnings("deprecation")
    public int getYear(){
        return birth.getYear();
    }
    private Integer id;
    private String surname;
    private String name;
    private String group;
    private String faculty;
    private Integer course;
    private String phone;
    private String address;
    private Date birth;

}
