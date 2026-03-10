package game.character.stats;


public class ManaPoints {
    private double currentMana;
    private double maxMana;

    public ManaPoints() {
        this.maxMana = 150.0; // Default starting Mana
        this.currentMana = 150.0; // MANA adjusted from 300 to 200
    }

    public ManaPoints(double maxMana) {
        this.maxMana = maxMana;
        this.currentMana = maxMana;
    }

    public void manaCost(double amount) {
        this.currentMana -= amount;
        if (this.currentMana < 0) {
            this.currentMana = 0;
        }else if(this.currentMana > maxMana){
            this.currentMana = maxMana;
        }
    }

    public double getCurrentMana() { return currentMana; }
    public double getMaxMana() { return maxMana; }
    
}