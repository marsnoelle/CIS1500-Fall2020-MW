package project0;
import java.util.Scanner;
public class Project0 {

    public static void main(String[] args) {
        System.out.println("Hello, this program will smooth out all of those wrinkles you've been staring at with disgust\n"
                + "in regards to your college experience! All you have to do is answer a few short questions."); 
        System.out.println("What is your name?");
        Scanner keyboard = new Scanner(System.in);
        String userName = keyboard.nextLine();
        
         System.out.println("Okay " +userName+ ", how many credits do you already have?");
        double creditsHad = keyboard.nextDouble();
        
        System.out.println( userName+ ", how many more credits do you need to complete an associate's degree?");
        double creditsNeeded = keyboard.nextDouble();
        
        System.out.println( userName+ ", how many credits do you take per semester?");
        double creditsPerSemester = keyboard.nextDouble();
        
        System.out.println( userName+ ", how much does 1 credit cost?");
        double creditCost = keyboard.nextDouble();
        
        System.out.println("Thanks " +userName+ ", your life will make sense soon. Soon everything will become clear."); //NOT ominous
        
        
        double semestersRemaining = Math.ceil(creditsNeeded/creditsPerSemester);
        
        double totalCost = creditCost * creditsNeeded;
        
        System.out.println( userName + ", according to this little program here, you will have to take " +semestersRemaining+ " more semesters and need $" +totalCost+ " \n"
                + "to finish up that associate's degree! Not too shabby! (Total cost does not include any additional fees or the cost of textbooks.)");
                
        
    }
    
}
