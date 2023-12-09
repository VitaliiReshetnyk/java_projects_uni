package ex5_11;
/**
 * 6theme
 * exercise5_11
 * @author Vitalii Reshetnyk
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Student {
    String firstName;
    String lastName;
    String className;
    Map<String, Integer> grades;

    public Student(String firstName, String lastName, String className) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.className = className;
        this.grades = new HashMap<>();
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public boolean hasGradeBelow4() {
        return grades.values().stream().anyMatch(grade -> grade < 4);
    }

    public int getAverageGrade() {
        return (int) grades.values().stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public String toString() {
        return lastName + " " + firstName + ", " + className;
    }
}

public class ex5_11 {

    public static void main(String[] args) {
        List<Student> students = readStudentDataFromFile("C:\\Projects\\javaproject\\src\\students");

        // a) determination of the number of students who do not have grades below 4
        int countStudentsWithoutFailingGrades = countStudentsWithoutFailingGrades(students);
        System.out.println("Number of students without failing grades: " + countStudentsWithoutFailingGrades);

        // b) building a file that contains information about the best students
        writeBestStudentsToFile("best_students.txt", students);

        // c) printing information about students who have at least one arbitrary grade
        printStudentsWithAnyGrade(students);
    }

    // Procedure a
    public static int countStudentsWithoutFailingGrades(List<Student> students) {
        return (int) students.stream().filter(student -> !student.hasGradeBelow4()).count();
    }

    // Procedure b
    public static void writeBestStudentsToFile(String filename, List<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            students.stream()
                    .filter(student -> student.getAverageGrade() >= 4)
                    .forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Procedure c
    public static void printStudentsWithAnyGrade(List<Student> students) {
        students.stream()
                .filter(student -> !student.grades.isEmpty())
                .forEach(student -> {
                    System.out.println("Student: " + student);
                    System.out.println("Subjects with grades:");
                    student.grades.forEach((subject, grade) ->
                            System.out.println(subject + ": " + grade));
                    System.out.println("------");
                });
    }

    // Utility method to read student data from a file
    public static List<Student> readStudentDataFromFile(String filename) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String firstName = parts[0].trim();
                String lastName = parts[1].trim();
                String className = parts[2].trim();
                Student student = new Student(firstName, lastName, className);

                // Read grades if available
                if (parts.length > 3) {
                    String[] gradeParts = parts[3].split(":");
                    String subject = gradeParts[0].trim();
                    int grade = Integer.parseInt(gradeParts[1].trim());
                    student.addGrade(subject, grade);
                }

                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}

