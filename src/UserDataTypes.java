import java.util.Scanner;

public class UserDataTypes {

    public static void main(String[] args) {
        // User Input In Java
        // User input refers to data entered by the user while the program is running.
        // Java provides the Scanner class to handle input from the keyboard.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        String name = scanner.nextLine();
        //integer
        System.out.println(("Enter Your Age"));
        int age = scanner.nextInt();
         //double
        System.out.println("What is GPA: ");
        double gpa = scanner.nextDouble();
        //boolean
        System.out.println("Are You a Student? (True/False)");
        boolean isStudent = scanner.nextBoolean();
        //output statements
        System.out.println("Hello : " + (name));
        System.out.println("You Are : " + (age) + " Years Old");
        System.out.println("Your GPA is: " + (gpa));
        System.out.println("Student: " + isStudent);

        if (isStudent){
            System.out.println("You are enrolled!");
        }
        else {
            System.out.println("Kindly Enroll!");
        }


        scanner.close();

    }
}
