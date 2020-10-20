package project2;
import java.util.Scanner; 
import java.io.*;
public class Project2 {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello and welcome to crappy adventure game! Enter CREATE to create the game, or PLAY to play the game.");
        Scanner keyboard = new Scanner(System.in);
        String gameMode = keyboard.nextLine();
        if (gameMode.toLowerCase().equals("create")) {
            createMode();
        } else if (gameMode.toLowerCase().equals("play")) {
            playMode();
        } else {
            System.out.println("Sorry that is not a valid command, please re-run the program and try again");
        }
    }

    public static void createMode() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        PrintWriter gameIntro = new PrintWriter("gameintroduction.txt");
        System.out.println("Enter an introduction and description for the game you want to create.");
        String usersIntro = keyboard.nextLine();
        gameIntro.println(usersIntro);
        gameIntro.close();
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("Enter a command such as a directional command to head somewhere, or enter Done if you're done creating commands.");
            String command = keyboard.nextLine();
            if (command.toLowerCase().equals("done")){
                keepGoing = false;
            }
            else{
                PrintWriter commandFile = new PrintWriter(command + ".txt");
                System.out.println("Does this command wound the user? Please enter Yes or No");
                String canWound = keyboard.nextLine();
                if (canWound.toLowerCase().equals("yes")) {
                    commandFile.println("WOUNDED");    
                }
                else {
                    commandFile.println("");
                }
                System.out.println("What happens when a player does that command?");
                String consequences = keyboard.nextLine();
                commandFile.println(consequences);
                commandFile.close();
            }
        }
        PrintWriter gameExit = new PrintWriter("gameescapeword.txt");
        System.out.println("Enter a command to exit the game.");
        String usersExit = keyboard.nextLine();
        gameExit.println(usersExit);
        gameExit.close();
    }

    public static void playMode() throws IOException {
        File gameIntroFile = new File("gameintroduction.txt"); 
        Scanner gameIntro = new Scanner(gameIntroFile);
        System.out.println(gameIntro.nextLine());
        gameIntro.close();

        File escapeWordFile = new File("gameescapeword.txt");
        Scanner esc = new Scanner(escapeWordFile);
        String escapeWord = esc.nextLine();
        esc.close();

        boolean keepGoing = true;

        String previousValidCommand = "";

        while (keepGoing) {
            System.out.println("Enter a command or " + escapeWord + " to quit the game");
            Scanner keyboard = new Scanner(System.in);
            String command = keyboard.nextLine();

            // First, try and find the file that matches the command the user entered
            File commandFile = new File(command + ".txt");
            if (!commandFile.exists()) {
                if (command.equalsIgnoreCase(escapeWord)) {
                    System.out.println("Thank you so 'amuch for a'playing your game!");
                    keepGoing = false;
                } else {
                    System.out.println("That is not a valid command!! Please enter something I can understand!!");
                }
            } else {
                if (command.toLowerCase().equals(previousValidCommand)) {
                    System.out.println("You cannot do the same thing twice; that would be a very boring game. Please try again.");
                } else {
                    previousValidCommand = command;
                    Scanner file = new Scanner(commandFile);
                    boolean wounded = file.nextLine().equals("WOUNDED");
                    while (wounded) {
                        System.out.println("Oh no! You have met a terrible fate and are now wounded. Please enter 'sleep' to feel a little better?");
                        String resting = keyboard.nextLine();
                        if (resting.toLowerCase().equals("sleep")) {
                            wounded = false;
                        }
                    }

                    System.out.println(file.nextLine());
                    file.close();
                }
            }
        }
    }
}
