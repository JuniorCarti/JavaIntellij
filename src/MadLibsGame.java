import java.awt.*;
import java.util.Scanner;

public class MadLibsGame {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Asking for the user input
        System.out.print("Enter a name:");
        String name = scanner.nextLine();

        System.out.print("Enter a place:");
        String place = scanner.nextLine();

        System.out.print("Enter an adjective:");
        String adjective = scanner.nextLine();

        System.out.print("Enter a past tense verb:");
        String verb = scanner.nextLine();

        System.out.print("Enter a plural noun:");
        String pluralNoun = scanner.nextLine();

        System.out.print("Enter an animal:");
        String animal = scanner.nextLine();

        System.out.print("Enter your favourite food:");
        String food = scanner.nextLine();

        System.out.print("Enter a number:");
        int number = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter a silly word:");
        String sillyWord = scanner.nextLine();


        // Creating the Mad Libs story
        System.out.println("\n--- Here is your Mad Libs Story! ---\n");
        System.out.println("Once upon a time, " + name + " went to " + place + ".");
        System.out.println("It was a " + adjective + " day, and " + name + " decided to " + verb + ".");
        System.out.println("Along the way, they saw " + number + " " + pluralNoun + " and a " + animal + " eating " + food + ".");
        System.out.println("Suddenly, a mysterious voice shouted '" + sillyWord + "!' and everything changed forever...");
        System.out.println("\nThe End. 😂");


        scanner.close();
    }
}
