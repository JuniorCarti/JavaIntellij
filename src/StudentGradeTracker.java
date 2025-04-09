import java.util.Scanner;

public class StudentGradeTracker {

    // Inner class to represent a Student
    static class Student {
        String name;
        double grade;
        int attendance;

        Student(String name, double grade, int attendance) {
            this.name = name;
            this.grade = grade;
            this.attendance = attendance;
        }

        boolean hasPassed() {
            return grade >= 50 && attendance >= 75;
        }

        @Override
        public String toString() {
            return "Name: " + name + "\nGrade: " + grade + "\nAttendance: " + attendance + "%";
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // clear newline

        Student[] students = new Student[numberOfStudents];

        // Input data
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Grade (0-100): ");
            double grade = scanner.nextDouble();

            System.out.print("Attendance (%): ");
            int attendance = scanner.nextInt();
            scanner.nextLine(); // clear newline

            students[i] = new Student(name, grade, attendance);
        }

        // Output results
        System.out.println("\n--- Student Report ---");
        for (Student student : students) {
            System.out.println(student);
            System.out.println("Pass Status: " + (student.hasPassed() ? "✅ Pass" : "❌ Fail"));
            System.out.println();
        }

        scanner.close();
    }
}
