import java.util.Scanner;
public class AreaOfRectangle {
    public static  void main(String[] args) {

        //Calculate the area of a rectangle
        double width = 0;
        double length = 0;
        double area = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter width: ");
        width = scanner.nextDouble();

        System.out.println("Enter length: ");
        length = scanner.nextDouble();

        area = width * length;

        System.out.println("The Area is: " + (area) + "cm");

        scanner.close();

    }
}