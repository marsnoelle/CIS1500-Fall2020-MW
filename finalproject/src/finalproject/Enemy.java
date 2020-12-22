package finalproject;

import java.util.List;

public class Enemy extends Character {
    public Enemy(String name, List<String> attacks) {
        super(name, attacks);
        
        int statNumber = this.rng.nextInt(6) + 1;
        this.totalHP = statNumber;
        this.currentHP = statNumber;
        this.strength = statNumber * 2;
        this.dexterity = statNumber * 2;
        this.intelligence = statNumber * 2;
    }
}