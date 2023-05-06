package Assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StudentStream {
    private int id;
    private String name;
    private int problemsSolved;
    private int grade;

    public StudentStream(int id, String name, int problemsSolved, int grade) {
        this.id = id;
        this.name = name;
        this.problemsSolved = problemsSolved;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProblemsSolved() {
        return problemsSolved;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public static void main(String[] args) {
        // create list of students
        List<StudentStream> students = new ArrayList<>();
        students.add(new StudentStream(1, "Alice", 10, 80));
        students.add(new StudentStream(2, "Bob", 8, 90));
        students.add(new StudentStream(3, "Charlie", 12, 75));
        students.add(new StudentStream(4, "Dave", 9, 85));
        students.add(new StudentStream(5, "Eve", 15, 70));
        students.add(new StudentStream(6, "Frank", 7, 95));

        // filter students based on no of problem solved
        List<StudentStream> filteredStudents = ((Object) ((Stream<StudentStream>) students.stream()
                .filter(s -> s.getProblemsSolved() >= 10)
                .peek(s -> s.setGrade(s.getGrade() + 10))
                .sorted(Comparator.comparing(StudentStream::getGrade).reversed()
                        .thenComparing(StudentStream::getProblemsSolved).reversed()))
                .limit(5))
                .toList();

        // print top 5 students by grade and no of problems solved
        System.out.println("Top 5 students by grade and no of problems solved:");
        filteredStudents.forEach(s -> System.out.println("ID: " + s.getId() +
                ", Name: " + s.getName() + ", Problems Solved: " + s.getProblemsSolved() +
                ", Grade: " + s.getGrade()));
    }
}
