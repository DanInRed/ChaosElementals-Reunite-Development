
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.character.holder;

import game.types.*;
import game.character.stats.*;
import game.elements.*;

public class CharacterHolder {
    private final Element element;
    private AttackType attackType; // this attackType will change multiple times
    private final BaseDamage baseDamage;
    private final HealthPoints hp;

    public CharacterHolder(Element element){
        this.element = element;
        this.baseDamage = new BaseDamage();
        this.hp = new HealthPoints();
    }
    
    // 2nd constructor receives AttackType
    public CharacterHolder(Element element, AttackType attackType) {
        this.element = element;
        this.attackType = attackType;
        // Automatically set to your specified defaults
        this.baseDamage = new BaseDamage(); 
        this.hp = new HealthPoints();
    }

    // Getters so the DamageCalculator can see them
    public ElementType getElementType() { return element.getType(); }
    public AttackType getAttackType(){ return attackType;}
    public BaseDamage getStats() { return baseDamage; }
    public HealthPoints getHP() { return this.hp; }
    public String getName(){return element.getName(); }
    
    // Shortcut for the battle loop
    public boolean isAlive() {
        return !hp.isFainted();
    }
    
    public void takeDamage(double amount) {
    this.hp.takeDamage(amount); // Calls the method inside HealthPoints.java
    }
    
    public double getCurrentHealth(){
        return this.hp.getCurrentHP();
    }
    
    //only AttackType requires a setter for it needs to be updated every Turn!!!
    public void setAttackType(AttackType attackType){
        this.attackType = attackType;
    }
}