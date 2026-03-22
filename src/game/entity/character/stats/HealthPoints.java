
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.entity.character.stats;



public class HealthPoints {
    private double currentHP;
    private double maxHP;

    public HealthPoints() {
        this.maxHP = 500.0; // Default starting HP
        this.currentHP = 500.0;
    }

    public HealthPoints(double maxHP) {
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    // This is the core connection method
    public void takeDamage(double amount) {
        this.currentHP -= amount;
        if (this.currentHP < 0) {
            this.currentHP = 0;
        }
    }

    public void setCurrentHP(double amount) {this.currentHP = amount; }
    
    public double getCurrentHP() { return currentHP; }
    public double getMaxHP() { return maxHP; }
    public boolean isFainted() { return currentHP <= 0; }
    
    
}
