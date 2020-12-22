package finalproject;

import java.util.List;
import java.util.Random;

/*
    Abstract class for character; to be inherited by player character and enemy npc
*/
public abstract class Character {
    protected String name;
    protected Random rng;
    protected List<String> attacks;
    protected int totalHP;
    protected int currentHP;
    protected int strength;
    protected int dexterity;
    protected int intelligence;

    protected Character(String name, List<String> attacks) {
        this.name = name;
        this.attacks = attacks;
        this.rng = new Random();
    }

    public String fight(Character other) {
        String toReturn = this.name + " performs " + this.attacks.get(this.rng.nextInt(this.attacks.size())) + '\n';
        int accuracyCheck = rng.nextInt(20);
        if (accuracyCheck >= other.getDexterity())  {
            int damage = 1;
            if (accuracyCheck == 19) { //Critical hit! Take full strength stat of damage
                toReturn += "It's a critical hit!\n";
                damage = Math.max(1, this.getStrength());
            } else { //Normal hit! Take strength stat / 3 of damage
                toReturn += "The attack hits!\n";
                damage = Math.max(1, this.getStrength() / 3);
            }
            toReturn += other.getName() + " takes " + damage + " points of damage!\n";
            other.setCurrentHP(other.getCurrentHP() - damage);
        } else {
            toReturn += this.name + " misses their attack!\n";
        }
        if (other.isDead()) {
            toReturn += other.getName() + " has fainted and is unable to battle!\n";
        }
        return toReturn;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalHP() {
        return this.totalHP;
    }

    public void setTotalHP(int totalHP) {
        this.totalHP = totalHP;
    }

    public int getCurrentHP() {
        return this.currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public boolean isDead() {
        return this.currentHP <= 0;
    }

    public void die() {
        setCurrentHP(0);
    }
}