package game.character.stats;


public class ManaPoints {
    private double currentMana;
    private double maxMana;

    public ManaPoints() {
        this.maxMana = 300.0; // Default starting Mana
        this.currentMana = 300.0;
    }

    public ManaPoints(double maxMana) {
        this.maxMana = maxMana;
        this.currentMana = maxMana;
    }

    // TODO Make the skill cost mana and make sure every skill exept normal attack cost mana
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