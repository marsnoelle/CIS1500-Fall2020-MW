
package project1;

import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) {
        while (true){
            System.out.println("Hey, champ in the making! It's time for you to start your journey to become Fighting Animals™ master.");
            System.out.println("Use the commands N for north, E for East, S for South, and W for Well Howdy. I'm just kidding. It's for West.");
            Scanner keyboard = new Scanner(System.in) ;
            System.out.println("First, let's get you a Fighting Animal™");
            System.out.println("Looks like we found one here, this animal is perfect! It's an AnimalChu! This will work just fine.");
            System.out.println("What would you like to name your AnimalChu™?");
            String animalFriend = keyboard.nextLine();
            System.out.println("Alright! If you and " + animalFriend + " are ready, it's about time I pushed you out of the nest. Fly away!");


            String helpText;
            
        
            boolean atStartingLocation = true;
            do {
                helpText = "Use the commands N for north, E for East, S for South, and W for Well Howdy. I'm just kidding. It's for West.";
                System.out.println("Where would you like to go next? Or type the word QUIT to exit the game. Or type HELP for HELP!!");
                String userCommand = keyboard.nextLine();
                if (userCommand.equalsIgnoreCase("N")){
                    System.out.println("Heading North towards the dunes");
                    atStartingLocation = true;
                    helpText = "Ahh, a trip to the vast expanse of sand. You can smell the sand in the air.\n" + 
                    "What would you like to do?\n" + 
                    "Enter 1 for showing " +animalFriend+ " the sand\n" +
                    "Enter 2 to engage in battle with a sand animal\n" +
                    "Enter 3 to count the sand\n" +
                    "Enter 4 to look under a nearby stone";
                    boolean atSand = true;
                    while (atSand) {
                        
                        System.out.println(helpText);
                        System.out.println("Or press S to go back");
                    
                        userCommand = keyboard.nextLine();
                    
                        if (userCommand.equalsIgnoreCase("S")) {
                            atSand = false;
                            atStartingLocation = true;
                        } else if (userCommand.equals("1")){
                            System.out.println(animalFriend+" seems disinterested in the sand. It wants to get into an animal fight.");
                        } else if (userCommand.equals("2")){
                            System.out.println(animalFriend+" is really chewing up that lizard!!! If my dad saw this, he would take a picture!!");
                        } else if (userCommand.equals("3")){
                            System.out.println("Counting!!!");
                            for (int i = 1; i < 101; i++){
                                System.out.println(i + " sand");
                            }
                            System.out.println("That was fun sand, but I'm done counting now.");
                        } else if (userCommand.equals("4")){
                            System.out.println("Wow! A dangerous scorpion! Hope it isn't a violent breed of scorpion...");
                            System.out.println("Oh no! While you were playing with the scorpion you and " +animalFriend+ " have been struck by a 1999 Honda Civic!");
                            boolean haveSlept = false;
                            while (!haveSlept){
                                System.out.println("You've gotta just sleep this one off. Enter C to wake up and smell the coffee once more.");
                                userCommand = keyboard.nextLine();
                                if (userCommand.equalsIgnoreCase("C")) {
                                    haveSlept = true;
                                }
                            }
                        } else { //also catches if user types HELP
                            System.out.println(helpText);
                        }
                    }

                }
                else if (userCommand.equalsIgnoreCase("E")){
                    atStartingLocation = false;
                    helpText = "Ahh, a trip to the river! You can even see it!\n" + 
                    "What would you like to do?\n" + 
                    "Enter 1 for teaching " +animalFriend+ " to fish like father and son.\n" +
                    "Enter 2 to engage in battle with a river animal, or fish\n" +
                    "Enter 3 to ask " +animalFriend+ " how many ships they think are at the bottom of the river\n" +
                    "Enter 4 to take a dip in the river";
                    System.out.println("Heading East towards the river");
                    boolean atRiver = true;
                    while (atRiver) {
                        System.out.println(helpText);
                        System.out.println("Or press W to go back");
                    
                        userCommand = keyboard.nextLine();
                    
                    
                        if (userCommand.equalsIgnoreCase("W")) {
                            atRiver = false;
                            atStartingLocation = true;
                        } else if (userCommand.equals("1")){
                            System.out.println(animalFriend+" seems unable to hold the rod. You don't mind. This is about you at the end of the day.");
                        } else if (userCommand.equals("2")){
                            System.out.println(animalFriend+" is really ~making waves~ fighting the wet animal!!! If my dad saw this, he would take a picture!! Of the animal fight!");
                        } else if (userCommand.equals("3")){
                            System.out.println("Your AnimalChu cannot speak. If it could, it would probably just say it's own name.");
                        } else if (userCommand.equals("4")){
                            System.out.println("Swimming is great! Swimming is the best! You're floating, drifting, the worries are also drifting away.");
                            System.out.println("Oh no! While you were pensively floating you and " +animalFriend+ " have been struck by a 1999 Honda Civic!");
                            boolean haveSlept = false;
                            while (!haveSlept){
                                System.out.println("You've gotta just sleep this one off. Enter C to wake up and smell the coffee once more.");
                                userCommand = keyboard.nextLine();
                                if (userCommand.equalsIgnoreCase("C")) {
                                    haveSlept = true;
                                }
                            }
                        } else { //also catches if user types HELP
                            System.out.println(helpText);
                        }
                    }
                }
                else if (userCommand.equalsIgnoreCase("W")){
                    atStartingLocation = false;
                    helpText = "Ahh, a trip to the vast expanse of local city. You can see houses from here!\n" + 
                    "What would you like to do?\n" + 
                    "Enter 1 for showing " +animalFriend+ " the train tracks everyone gets their senior pictures taken at.\n" +
                    "Enter 2 to engage in battle with a city animal\n" +
                    "Enter 3 to count the pigeons\n" +
                    "Enter 4 to look under a nearby pigeon";
                    System.out.println("Heading West towards the city");
                    boolean atCity = true;
                    while (atCity) {
                        System.out.println(helpText);
                        System.out.println("Or press E to go back");
                    
                        userCommand = keyboard.nextLine();
                    
                    
                        if (userCommand.equalsIgnoreCase("E")) {
                            atCity = false;
                            atStartingLocation = true;
                        } else if (userCommand.equals("1")){
                            System.out.println(animalFriend+" is really living for this! It's almost as if your AnimalChu wants to get a senior picture taken by your dad!");
                        } else if (userCommand.equals("2")){
                            System.out.println(animalFriend+" is not faring well against the city animals such as SKATER GUYS and SPITEFUL CROW.");
                        } else if (userCommand.equals("3")){
                            System.out.println("Counting!!!");
                            for (int i = 1; i < 101; i++){
                                System.out.println(i + " pretty bird");
                            }
                            System.out.println("That was fun pigeon, but I'm done counting now.");
                        } else if (userCommand.equals("4")){
                            System.out.println("Wow! A CD sampler! I cannot wait to listen to this in my dad's car!!!");
                            System.out.println("Oh no! While you were playing with the CD ROM you and " +animalFriend+ " have been struck by a 1999 Honda Civic!");
                            boolean haveSlept = false;
                            while (!haveSlept){
                                System.out.println("You've gotta just sleep this one off. Enter C to wake up and smell the coffee once more.");
                                userCommand = keyboard.nextLine();
                                if (userCommand.equalsIgnoreCase("C")) {
                                    haveSlept = true;
                                }
                            }
                        } else { //also catches if user types HELP
                            System.out.println(helpText);
                        }
                    }
                }
                else if (userCommand.equalsIgnoreCase("S")){
                    atStartingLocation = false;
                    helpText = "Ahh, a trip to the vast expanse of cave. You can smell the cave in the air.\n" + 
                    "What would you like to do?\n" + 
                    "Enter 1 for showing" +animalFriend+ " the interior design choices of a cavern.\n" +
                    "Enter 2 to engage in battle with a cave animal\n" +
                    "Enter 3 to count the stalagtites and stalagmites\n" +
                    "Enter 4 to mine coal";
                    System.out.println("Heading South towards the cave");
                    boolean atCave = true;
                    while (atCave) {
                        
                        
                        System.out.println(helpText);
                    
                 
                         System.out.println("Or press N to go back");
                        
                        userCommand = keyboard.nextLine();
                        if (userCommand.equalsIgnoreCase("N")) {
                            atCave = false;
                            atStartingLocation = true;
                        } else if (userCommand.equals("1")){
                            System.out.println(animalFriend+" seems to really take to the clammy atmosphere. It might be a good idea to set up camp in here.");
                        } else if (userCommand.equals("2")){
                            System.out.println(animalFriend+" is really chowing down on the cave insect!!! If my dad saw this, he would avert his eyes!!");
                        } else if (userCommand.equals("3")){
                            System.out.println("Counting!!!");
                            for (int i = 1; i < 101; i++){
                                System.out.println(i + (i % 2 == 0 ? " stalagmite" : " stalagtite"));
                            }
                            System.out.println("That was fun sticks, but I'm done counting now.");
                        } else if (userCommand.equals("4")){
                            System.out.println("Wow! Character building! Hope I don't get some sort of lung disease");
                            System.out.println("Oh no! While you were playing with the coal you and " +animalFriend+ " have been struck by a 1999 Honda Civic!");
                            boolean haveSlept = false;
                            while (!haveSlept){
                                System.out.println("You've gotta just sleep this one off. Enter C to wake up and smell the coffee once more.");
                                userCommand = keyboard.nextLine();
                                if (userCommand.equalsIgnoreCase("C")) {
                                    haveSlept = true;
                                }
                            }
                        } else { //also catches if user types HELP
                            System.out.println(helpText);
                        }
                    }
                
                } else if (userCommand.equalsIgnoreCase("quit")){
                    System.out.println("Bye bye!");
                    System.exit(0);
                } else if (userCommand.equalsIgnoreCase("help")) {
                    System.out.println(helpText);
                }
                else {
                    System.out.println("That is not a direction, try again!");
                    atStartingLocation = false;
                }
            } while(atStartingLocation);
       }
    }
    
}