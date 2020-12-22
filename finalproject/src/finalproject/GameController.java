package finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.control.Alert.AlertType; 

import java.util.*;

public class GameController {

    @FXML
    private ListView adventureLog;

    @FXML
    private Label playerStrength;

    @FXML
    private Label enemyStrength;

    @FXML
    private Label playerDex;

    @FXML
    private Label enemyDex;

    @FXML
    private Label playerInt;

    @FXML
    private Label enemyInt;

    @FXML
    private Label playerHealth;

    @FXML
    private Rectangle playerHealthBarInner;

    @FXML
    private Rectangle playerHealthBarOuter;

    @FXML
    private Label enemyHealth;

    @FXML
    private Label enemyHealthDenominator;

    @FXML
    private Rectangle enemyHealthBarInner;

    @FXML
    private Rectangle enemyHealthBarOuter;

    @FXML
    private Button north;

    @FXML
    private Button east;

    @FXML
    private Button south;

    @FXML
    private Button west;

    @FXML
    private Button fight;

    @FXML
    private Button sleep;

    @FXML
    private Button search;

    @FXML
    private Label totalAnimalBucks;

    @FXML
    private Label playerName;

    @FXML
    private Label enemyName;

    private Player playerCharacter;

    //Two sets of parallel arrays mapping characters to their list of viable moves
    private List<String> playerCharacters = new ArrayList<>();
    private List<List<String>> playerCharacterMoves = new ArrayList<>();

    private List<String> enemyCharacters = new ArrayList<>();
    private List<List<String>> enemyCharacterMoves = new ArrayList<>();

    private Random rng;

    //Game State Flags
    private Enemy enemyPresent;

    private String currentWallDirection;

    private boolean currentRoomSearched;


    public void initialize() {
        this.rng = new Random();
        adventureLog.getItems().add("Adventure Log");
        initializeCharacters();

        String playerCharacters[] = {"Weeds", "Flamey", "Wetsy"};

        ChoiceDialog d = new ChoiceDialog(playerCharacters[0], playerCharacters);
        d.setHeaderText(
            "Welcome to the World of Fighting Animals™! You can have your very own Fighting Animal to Raise and Use!\n" + 
            "You have three options for your Fighting Animal™ to carry you through this Adventure:\n" + 
            "Weeds: The Grass-Type Fighting Animal™ who loves to play in the grass and spit out poison gas!\n" + 
            "Flamey: The Fire-Type Fighting Animal™ who will set your heart ablaze!\n" + 
            "Wetsy: The Water-Type Fighting Animal™ who splishes and splashes!"
        );
        d.showAndWait();
        String animalType = d.getSelectedItem().toString();

        TextInputDialog namer = new TextInputDialog();
        namer.setHeaderText("Please give a Name to your Fighting Animal so they know that they are loved!");
        namer.showAndWait();
        String animalName = namer.getEditor().getText();
        
        int choice = 0;
        switch(animalType) {
            case "Weeds":
                choice = 2;
                break;
            case "Flamey":
                choice = 0;
                break;
            case "Wetsy":
            default:
                choice = 1;
                break;
        }

        this.playerCharacter = new Player(animalName, playerCharacterMoves.get(choice));
        this.playerName.setText(this.playerCharacter.getName() + " Stats:");
        this.playerHealth.setText("20");
        this.playerStrength.setText(Integer.toString(this.playerCharacter.getStrength()));
        this.playerDex.setText(Integer.toString(this.playerCharacter.getDexterity()));
        this.playerInt.setText(Integer.toString(this.playerCharacter.getIntelligence()));
        this.changeWhereWallIs();
    }

    private void changeWhereWallIs() {
        List<String> directions = Arrays.asList("north", "south", "east", "west");
        this.currentWallDirection = directions.get(rng.nextInt(directions.size()));
    }

    private void initializeCharacters() {
        final String flamey = "Flamey";
        final List<String> flameyMoves = Arrays.asList("Set on Fire", "Turbo Blaze!", "Smoke in your Eyes", "11th Degree Burn");

        final String wetsy = "Wetsy";
        final List<String> wetsyMoves = Arrays.asList("Drown and Suffocate", "Wet Attack!", "Make Soggy", "Soaked Socks");
        
        final String weeds = "Weeds";
        final List<String> weedsMoves = Arrays.asList("Poisonous Attack", "Tripping over Vines", "Thorns!", "Leaf Throw");

        playerCharacters.add(flamey);
        playerCharacterMoves.add(flameyMoves);

        playerCharacters.add(wetsy);
        playerCharacterMoves.add(wetsyMoves);

        playerCharacters.add(weeds);
        playerCharacterMoves.add(weedsMoves);


        enemyCharacters.add(flamey);
        enemyCharacterMoves.add(flameyMoves);

        enemyCharacters.add(wetsy);
        enemyCharacterMoves.add(wetsyMoves);

        enemyCharacters.add(weeds);
        enemyCharacterMoves.add(weedsMoves);

        enemyCharacters.add("Rolly Polly");
        enemyCharacterMoves.add(Arrays.asList("Bug Crawl", "Invasive Species", "Creepy Crawly", "Chronic Deadly Poison Attack"));

        enemyCharacters.add("Twinkle Sparkle Unicorn Star");
        enemyCharacterMoves.add(Arrays.asList("Fairy Dust in your Eyes", "Kissing and Hugging", "Alaka-swooper-doop", "Cooties"));

        enemyCharacters.add("The Rock");
        enemyCharacterMoves.add(Arrays.asList("Stones Break Bones!", "Pebble Blast", "Tectonic Shift", "Igneous"));

        enemyCharacters.add("Darlene the Dragon");
        enemyCharacterMoves.add(Arrays.asList("Draconic Coupon Usage", "Devastating Minivan", "Flying the Boys to Soccer Practice", "Fire Breath because This Food is Too Spicy, I'm Sending this Dish Back"));
    }

    private void move(String direction) {
        if (this.enemyPresent != null) {
            //Can't move if in combat
            this.adventureLog.getItems().add("You can't move while in battle! Maybe try running away if you do't want to fight");
            return;
        }
        if (this.currentWallDirection == direction) {
            adventureLog.getItems().add("You tried to go " + direction + " but you hit a wall!");
            return;
        } else {
            this.currentRoomSearched = false;
            adventureLog.getItems().add("You went " + direction);
        }

        boolean encounter = rng.nextInt(3) == 0;
        if (encounter) {
            this.enemyPresent = generateRandomMonster();
            setEnemyText();
            adventureLog.getItems().add("You encountered a " + this.enemyPresent.getName() + "!");
        }
    }

    private void setEnemyText() {
        if (this.enemyPresent == null) {
            return;
        }

        this.enemyHealthDenominator.setText(Integer.toString(this.enemyPresent.getTotalHP()));
        this.enemyHealth.setText(Integer.toString(this.enemyPresent.getCurrentHP()));
        this.enemyStrength.setText(Integer.toString(this.enemyPresent.getStrength()));
        this.enemyDex.setText(Integer.toString(this.enemyPresent.getDexterity()));
        this.enemyInt.setText(Integer.toString(this.enemyPresent.getIntelligence()));
        this.enemyName.setText(this.enemyPresent.getName() + " Stats:");
    }

    private void clearEnemyText() {
        this.enemyHealthDenominator.setText("0");
        this.enemyHealth.setText("0");
        this.enemyStrength.setText("0");
        this.enemyDex.setText("0");
        this.enemyInt.setText("0");
        this.enemyName.setText("Just looking around. . .");
    }

    private Enemy generateRandomMonster() {
        int monsterIndex = rng.nextInt(enemyCharacters.size());
        return new Enemy(enemyCharacters.get(monsterIndex), enemyCharacterMoves.get(monsterIndex));
    }

    public void goNorth() {
        move("north");
    }
    public void goSouth() {
        move("south");
    }
    public void goEast() {
        move("east");
    }
    public void goWest() {
        move("west");
    }

    public void onSearch() {
        if (this.enemyPresent != null) {
            this.adventureLog.getItems().add("You can't search while in battle!");
            return;
        }
        if (this.currentRoomSearched) {
            this.adventureLog.getItems().add("You already searched this room! Greediness is a vice!");
            return;
        }
        this.currentRoomSearched = true;
        boolean goldFound = rng.nextInt(20) + 1 < this.playerCharacter.getIntelligence();
        if (goldFound) {
            int amtBucks = rng.nextInt(901) + 100;
            this.playerCharacter.addAnimalBucks(amtBucks);
            this.adventureLog.getItems().add(
                "Your Fighting Animal Friend's keen sense of smell resulted in monetary gain!\n" +
                "Fighting Animals and People really can live in harmony!\n" + 
                "You found " + amtBucks + " AnimalBucks"
            );
            this.totalAnimalBucks.setText(Integer.toString(this.playerCharacter.getTotalAnimalBucks()));
        } else {
            this.adventureLog.getItems().add(
                "Your Fighting Animal sniffed until its nostrils began to hurt\n" + 
                "So you begin to rub its nostrils and it is very happy and soothed!\n" + 
                "However, you did not find any AnimalBucks here"
            );
        }
    }

    public void onSleep() {
        if (this.enemyPresent != null) {
            this.adventureLog.getItems().add("You can't sleep while in battle!");
            return;
        }
        this.adventureLog.getItems().add("You tell your friend " + this.playerCharacter.getName() + " it's time to sleep now and coerce them to take a nap");
        boolean enemyAttacks = rng.nextInt(6) == 0;
        if (enemyAttacks) {
            this.enemyPresent = generateRandomMonster();
            setEnemyText();
            this.adventureLog.getItems().add("While your friend was sound asleep, a wild " + this.enemyPresent.getName() + " attacked!");
            this.adventureLog.getItems().add(
                this.enemyPresent.fight(this.playerCharacter)
            );
            
            if (this.playerCharacter.isDead()) {
                this.playerCharacter.setCurrentHP(0);
                endGame();
                return;
            }
            setHealthBars();
        }
        
        this.playerCharacter.setCurrentHP(this.playerCharacter.getTotalHP());
        setHealthBars();

        this.adventureLog.getItems().add("By forcing your friend to sleep, their wounds have vanished and they feel like they were just kissed by an angel!");
    }

    public void onFight() {
        if (this.enemyPresent == null) { // Can't fight if there's nothing to fight!
            this.adventureLog.getItems().add("That is very cruel of you asking your best friend in the whole world to attack nothing. . .\nTry kindness next time");
            return;
        }
        this.adventureLog.getItems().add(this.playerCharacter.fight(this.enemyPresent));
        if (this.playerCharacter.isDead()) {
            this.playerHealth.setText("0");
            endGame();
        } else if (this.enemyPresent.isDead()) {
            this.enemyPresent = null;
            clearEnemyText();
        } else {
            this.adventureLog.getItems().add(this.enemyPresent.fight(this.playerCharacter));
            if (this.playerCharacter.isDead()) {
                this.playerHealth.setText("0");
                endGame();
            } else if (this.enemyPresent.isDead()) {
                this.enemyPresent = null;
                clearEnemyText();
            }
        }
        
        setHealthBars();

        if (this.enemyPresent == null) {
            int amtBucks = rng.nextInt(901) + 100;
            this.playerCharacter.addAnimalBucks(amtBucks);
            this.adventureLog.getItems().add("You just defeated the enemy! You earned " + amtBucks + " AnimalBucks");
            this.totalAnimalBucks.setText(Integer.toString(this.playerCharacter.getTotalAnimalBucks()));
        }
    }

    public void setHealthBars() {
        this.playerHealth.setText(Integer.toString(this.playerCharacter.getCurrentHP()));
        
        int healthBarWidth = 108;
        this.playerHealthBarInner.setWidth(
            (int)Math.floor(((double)this.playerCharacter.getCurrentHP() / (double)this.playerCharacter.getTotalHP()) * healthBarWidth)
        );
        if (this.enemyPresent != null) {
            this.enemyHealth.setText(Integer.toString(this.enemyPresent.getCurrentHP()));
            this.enemyHealthBarInner.setWidth((int)
                Math.floor(((double)this.enemyPresent.getCurrentHP() / (double)this.enemyPresent.getTotalHP()) * healthBarWidth)
            );
        }
    }

    public void endGame() {
        Alert a = new Alert(
            AlertType.NONE, 
            "Your friend " + this.playerCharacter.getName() + " has fainted.\n" + 
            "You run out of the Fighting Animal Cave to nurse it back to health.\n" +
            "I hope they will be okay. . .\n\n" + 
            "Re-run the game to play again!",
            ButtonType.OK
        );

        a.showAndWait();

        System.exit(0);
    }

    public void onRun() {
        if (this.enemyPresent == null) { // Can't run if there's nothing to run from!
            this.adventureLog.getItems().add("What are you running from?? Your fears??");
            return;
        }
        boolean sawMe = rng.nextInt(20) + 1 < this.enemyPresent.getIntelligence();
        if (sawMe) {
            //Attack!
            this.adventureLog.getItems().add("The enemy saw you trying to run away! They attack!");
            this.enemyPresent.fight(this.playerCharacter);
            if (this.playerCharacter.isDead()) {
                endGame();
                return;
            }
            setHealthBars();
        }
        this.adventureLog.getItems().add("You got away!");
        this.enemyPresent = null;
        clearEnemyText();

    }
}