package ex2_1.Student;
import ex2_1.Student.Student;
import java.util.Scanner;
public class Main {
    public static void getList(String[] list, String faculty){
        for (Student s: list){
            if(s.getFaculty().equals(faculty)){
                System.out.println(s);
            }
        }

    }
    public static void Main(String[] args){
        Scanner sc = new Scanner(System.in);
        Student spisok[] = {
                new Student (1, "Ivanov", "Ivan", "MM", "KM",  1, "0506745638","abc 8"),
                new Student (2, "Ivanova", "Ivannna", "MM", "KM", 2, "789056478","abc 9"),
                new Student (3, "Petrov", "Petro", "MM", "KM",3, "231456780","abc 10"),
        };
        String faculty = sc.next();
        getList(spisok, faculty);
        sc.close();
    }

}
