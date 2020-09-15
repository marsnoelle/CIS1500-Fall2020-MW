package chapter2;

import java.util.Scanner;

public class Chapter2 {

    // comments are ignored by the compiler
    public static void main(String[] args) {
        System.out.println("Happy Wednesday!");
        System.out.println("Let's learn about Java!");
        System.out.println("Programming is so much \"fun\"");
        System.out.print("Here's a print command\n");
        System.out.print("Here's another one!\n");
        
        System.out.println("Welcome to our Java shop!");
        System.out.println("1. Coffee\t\t\t$1.00");
        System.out.println("2. Espresso\t\t\t$1.50");
        System.out.println("3. Latte\t\t\t\t$4.00");
        System.out.println("  - Vanilla flavor shot\t\t$.50");
        System.out.println("  - Pumpkin\\Vanilla Spice\t$1.00");
        System.out.println("");
        String menu = "Welcome to our Java shop!\n" +
            "1. Coffee\t\t\t$1.00\n" +
            "2. Espresso\t\t\t$1.50\n" +
            "3. Latte\t\t\t\t$4.00\n" +
            "  - Vanilla flavor shot\t\t$.50\n" + 
            "  - Pumpkin\\Vanilla Spice\t$1.00\n";
        System.out.println(menu);
        
        double totalCostOfOrder = 4.50;
        
        System.out.println("Thank you for ordering, your owe: $" + totalCostOfOrder);
        
        double totalCashPaid = 10;
        
        System.out.println("Your change is: $" + (totalCashPaid - totalCostOfOrder));
        
        // order of operations - the string '7 + 7 =' is concatenated with 7
        //  and we get '7 + 7 = 7'
        //  then it is concatened with 7 again
        //  and we get '7 + 7 = 77'
        System.out.println("7 + 7 = " + 7 + 7);
        System.out.println("Oops, that's String concatention!");
        
        // ensure you use ( ) for order of operations to work
        System.out.println("7 + 7 = " + (7 + 7));
        
        int myFavoriteNumber = 42;
        
        System.out.println(myFavoriteNumber);
        
        byte singlByte = 127;
        
        // have to put an F after the number to tell Java it is a float
        float smallerNumberWithDecimal = 127.1F;
        double biggerNumbersWithMoreDecimalPlaces = 127.0000000000000001;
        
        // java is bad at floating point math, big sad!
        System.out.println(biggerNumbersWithMoreDecimalPlaces + smallerNumberWithDecimal);
        
        boolean trueOrFalseValue = true; // false
        
        // notice the single quotes
        char singleCharacterValue = 'C';
        
        String name;
        
        System.out.println("Please enter your name:");
        Scanner keyboard = new Scanner(System.in);
        name = keyboard.nextLine();
        
        System.out.println("Hello " + name + ", nice to meet you. I am the computer!");
        
        System.out.println("How many coffees did you want to buy?");
        int numberOfCoffees = keyboard.nextInt();
        // if you use a nextInt or nextDouble, the Enter key stays, use nextLine to throw it away
        keyboard.nextLine();
        
        System.out.println("How many coffees did you want to buy?");
        // anther option, get input as string and convert
        numberOfCoffees = Integer.parseInt(keyboard.nextLine());
        
        // two lines is fine, whatever you prefer
        //String numberOfCoffeesString = keyboard.nextLine();
        //numberOfCoffees = Integer.parseInt(numberOfCoffeesString);
        
        
        System.out.println("Your total cost with tax is: $" + (numberOfCoffees * 1.06));
        
        System.out.println("Is there anything else you want?");
        String additionalOrder = keyboard.nextLine();
        
        System.out.println("Here's your extra: " + additionalOrder);
        
        System.out.println("3.1 rounded up ( ceil ) : " + Math.ceil(3.1));
        
    }
    
}
