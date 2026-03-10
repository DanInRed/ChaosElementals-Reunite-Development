package game.character.stats;


public class ManaPoints {
    private double currentMana;
    private double maxMana;
    private double regenRate;

    public ManaPoints() {
        this.maxMana = 150.0; // Default starting Mana
        this.currentMana = 150.0; // MANA adjusted from 300 to 150
        this.regenRate = 10;
    }

    public ManaPoints(double maxMana, double regenRate) { // for special cases currently not utilized
        this.maxMana = maxMana;
        this.currentMana = maxMana;
        this.regenRate = regenRate; //mana regen per round 
    }

    public void manaCost(double amount) {
        this.currentMana = Math.max(this.currentMana - amount, 0); // current mana will never drop below zero
    }

    public void regenerate(){ //utilizes default mana regen set inside constructor
        this.currentMana = Math.min(this.currentMana + this.regenRate, this.maxMana);
    }
    public void regenerate(double amount) {// for special cases currently not utilized
        this.currentMana = Math.min(this.currentMana + amount, this.maxMana); //Math.min keeps currentMana less than or equal to maxMana
    }

    public double getCurrentMana() { return currentMana; }
    public double getMaxMana() { return maxMana; }
    public double getRegenRate() { return regenRate;}    
}