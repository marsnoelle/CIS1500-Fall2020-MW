package finalproject;

import java.util.List;

public class Player extends Character {
    private int totalAnimalBucks;

    public Player(String name, List<String> attacks) {
        super(name, attacks);
        this.totalHP = 20;
        this.currentHP = 20;
        this.strength = rollD6(3);
        this.dexterity = rollD6(3);
        this.intelligence = rollD6(3);
        this.totalAnimalBucks = 0;
    }

    public int getTotalAnimalBucks() {
        return this.totalAnimalBucks;
    }

    public void addAnimalBucks(int amt) {
        this.totalAnimalBucks += amt;
    }

    // Rolls a d6 a specified number of times and returns the sum of the rolls
    private int rollD6(int numTimes) {
        int num = 0;
        for (int i = 0; i < numTimes; i++) {
            num += this.rng.nextInt(6) + 1;
        }
        return num;
    }
}