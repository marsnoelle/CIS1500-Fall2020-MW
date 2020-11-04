package project3;

import java.util.*;

public class PowerBallSimulator {

    public static void main(String[] args) {
        double amountWon = 0.0;
        double amountSpent = 0.0;
        
        Scanner keyboard = new Scanner(System.in);
        
        List<PowerBallTicket> ticketsPurchased = new ArrayList<>();
        List<PowerBallTicket> winningTickets = new ArrayList<>();
        
        final PowerBallTicket WINNER = new PowerBallTicket();
        
        System.out.println("Welcome to Gambling! This is a healthy fun game that will improve your life!");
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("(1) Buy a ticket ($5.00)");
            System.out.println("(2) See total amount won");
            System.out.println("(3) See total amount spent");
            System.out.println("(4) See net loss");
            System.out.println("(5) See all tickets purchased");
            System.out.println("(6) See all winning tickets purchased");
            System.out.println("(7) Quit playing");
            
            int userSelection = keyboard.nextInt();
            
            switch (userSelection) {
                case 1:
                    System.out.println("Type (1) to pick your own numbers or (2) for an easy pick");
                    userSelection = keyboard.nextInt();
                    PowerBallTicket ticket;
                    if (userSelection == 1) {
                        int[] whiteNums = new int[5];
                        for (int index = 0; index < 5; index++) {
                            whiteNums[index] = getNumberInRange(1, 69, keyboard);
                        }
                        int redNumber = getNumberInRange(1,26, keyboard);
                        ticket = new PowerBallTicket(whiteNums, redNumber);
                    } else {
                        ticket = new PowerBallTicket();
                    }
                    
                    amountSpent += 5.0;
                    
                    ticketsPurchased.add(ticket);
                    double winnings = ticket.getWinnings(WINNER);
                    if (winnings > 0.0) {
                        winningTickets.add(ticket);
                        amountWon += winnings;
                        System.out.println("Congratulations! You won $" + winnings);
                        System.out.println("Isn't that great? You're sure to keep winning more money if you just buy some more tickets!!");
                    } else {
                        System.out.println("Sorry! No win this time. Better luck next time.");
                        System.out.println("Better buy another ticket, otherwise you'll be in the hole and will have lost money. You're not a loser, are you?");
                    }
                    break;
                case 2:
                    System.out.println("You have won a total of $" + amountWon);
                    break;
                case 3:
                    System.out.println("You have spent a total of $" + amountSpent);
                    System.out.println("(And that's nothing! On average, people spend at least $" + (amountSpent + 5.0) + " before they are a huge huge winner!!");
                    break;
                case 4:
                    System.out.println("You have only lost $" + (amountWon - amountSpent));
                    break;
                case 5:
                    System.out.println("Here are all of your tickets");
                    for (PowerBallTicket t : ticketsPurchased) {
                        System.out.println(t.toString());
                        System.out.println();
                    }
                    break;
                case 6:
                    System.out.println("Here are all of your winning tickets");
                    for (PowerBallTicket t : winningTickets) {
                        System.out.println(t.toString());
                        System.out.println();
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("That is not a valid option! Please try again!!");
                    
            }         
        }
    }
    
    /**
     * Gets a number in a certain range of positive integers (this may not work for negative integers)
     * Bounds are both inclusive
     */
    public static int getNumberInRange(int lowerBound, int upperBound, Scanner keyboard) {
        int toReturn = -1;
        
        do {
            System.out.println("Enter a number between " + lowerBound + " and " + upperBound + ".");
            toReturn = keyboard.nextInt();
            if (toReturn < lowerBound || toReturn > upperBound) {
                System.out.println("Wrong! Try again!");
            }
        } while (toReturn < lowerBound || toReturn > upperBound);
   
        return toReturn;
    }
    
}
    
