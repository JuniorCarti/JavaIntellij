import java.util.Scanner;

public class ArithmeticOperators {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.println("Enter second number: ");
        double num2 = scanner.nextDouble();

        //performing the operations
        double sum = num1 + num2;
        double difference = num1 - num2;
        double multiply = num1 * num2;
        double modulus = num1 % num2;
        double division = num1 / num2;

        scanner.nextLine();

        System.out.println("\nResults");
        System.out.println(num1 + "+" + num2 + "=" + sum);
        scanner.nextLine();
        System.out.println(num1 + "-" + num2 + "=" + difference);
        scanner.nextLine();
        System.out.println(num1 + "*" + num2 + "=" + multiply);
        scanner.nextLine();
        System.out.println(num1 + "%" + num2 + "=" + modulus);
        scanner.nextLine();
        System.out.println(num1 + "/" + num2 + "=" + division);


        scanner.close();

    }
}
