// The main class where the program starts
public class Main {
    public static void main(String[] args) {

        // To run your code: Press Shift + F10 or click the Run button (top-right in IntelliJ IDEA)

        // The difference between print() and println():
        // - print() prints text on the same line.
        // - println() prints text on a new line each time it's called.
        // - Adding "\n" creates a blank line between text.

        // Printing three lines of text
        System.out.println("My Best Car Model. Mercedes Benz G-Wagon\n"); // Prints on a new line
        System.out.println("It costs a lot of Dollars\n"); // Another line
        System.out.println("I'll buy it in 2026"); // Prints on a new line

        //Assignment Write a code that prints three line statements, Your favourite music anything


        //A variable is a container that stores data in Java.
        //Each variable has a type that defines what kind of data it can hold.
        //Primitive and Non-Primitive(Reference variables)
        //Primitive(Stores Simple Values)
        //Non-Primitive(Stores Complex Objects)
        // Syntax: dataType variableName = value;


        //int age;
        //System.out.println(age);
        //if you run this you will get an error since you haven't initialized
        //the value of age

        //1. Integer Data Types

        int age = 26;
        int year = 2025;
        int month = 3;
        int temp = 42;
        int height = 21;

        System.out.println(age);
        System.out.println(year);
        System.out.println(month);
        System.out.println(temp);
        System.out.println(height);

        //You can output a variable within a string of texts as well

        System.out.println("The temperature is "  + (temp) + " Degrees Celsius");
        System.out.println("We are in March The " + (month) + "rd month of the year");
        System.out.println("My Height is " + (height) + "cm");

        //2. Double Data Types
        //A double is a primitive data type in Java
        // used to store decimal numbers (floating-point values)

        //double variableName = value;

        // Declaring double variables

        double temperature = 13.5;
        double gpa = 68.5;
        double price = 200.00;
        double weight = 68;
        double pi = 3.1432567;

        System.out.println(temperature);
        System.out.println(gpa);
        System.out.println(price);

        System.out.println("The Temperature is: " + (temperature) + " Degrees Celsius");
        System.out.println("The Price of KFC is: " + (price) + "Ksh");
        System.out.println("The Weight of the Girl is: " + (weight) + "Kgs");
        System.out.println("Pi = " + (pi));


        //📝 Task:
        // Write a Java program that declares five double variables
        // related to real-life scenarios. Then, print their values with appropriate labels.


        //3. Character Data Types
        //The char data type is a primitive type in Java
        // stores a single character (letter, number, or symbol).
        // It uses single quotes (' ') to store the character.

        //char variableName = 'A';
        //Declaring char variables


        char grade = 'A';
        char symbol = '@';
        char currency = '$';
        char initial = 'R';


        System.out.println(grade);
        System.out.println(symbol);
        System.out.println(currency);
        System.out.println(initial);


        // Printing the char values
        System.out.println("Grade: " + grade);
        System.out.println("Initial: " + initial);
        System.out.println("Currency Symbol: " + currency);
        System.out.println("Special Character: " + symbol);

        //3.Boolean data types
        //The boolean data type is a primitive type in Java that stores only two values:
        //
        //true (✅ Yes, enabled, active, etc.)
        //false (❌ No, disabled, inactive, etc.)
        //Boolean Data Types Is True or False

        // Declaring boolean variables

        boolean isJavaFun = true;
        boolean isRaining = false;
        boolean isStudent = true;
        boolean isLoggedIn = false;


        System.out.println("Is Java Fun: " +(isJavaFun));
        System.out.println("Is it Raining: " + (isRaining));
        System.out.println("Is He a Student: " + (isStudent));

        if(!isRaining){
            System.out.println("Yes : We are Going For A Trip");
        }
        else {
            System.out.println("No : One is Going To The Trip");
        }


        if(!isJavaFun){
            System.out.println("The Lesson Will Continue");
        }
        else {
            System.out.println("Alas! : The Lesson is Postponed");
        }

        if(!isLoggedIn){
            System.out.println("Welcome, Ridge!");
        }
        else{
            System.out.println("Please Log In!");
        }

        // Assignment - Declare five boolean variables to represent real-life conditions:



    }
}



