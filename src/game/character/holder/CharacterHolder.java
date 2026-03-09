
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
    private final HealthPoints hp;  // for now these are final since it only triggers battle
    private final ManaPoints mana; // only once. This will be not final after the game loop logic is fixed

    public CharacterHolder(Element element){
        this.element = element;
        this.baseDamage = new BaseDamage();
        this.hp = new HealthPoints();
        this.mana = new ManaPoints(); // mana creation
    }
    
    // 2nd constructor receives AttackType
    public CharacterHolder(Element element, AttackType attackType) {
        this.element = element;
        this.attackType = attackType;
        // Automatically set to your specified defaults
        this.baseDamage = new BaseDamage(); 
        this.hp = new HealthPoints();
        this.mana = new ManaPoints(); // mana added
    }

    // Getters so the DamageCalculator can see them
    public ElementType getElementType() { return element.getType(); }
    public AttackType getAttackType(){ return attackType;}
    public BaseDamage getStats() { return baseDamage; }
    public HealthPoints getHP() { return this.hp; }
    public ManaPoints getMana() { return this.mana;} //retrieve mana
    public String getName(){return element.getName(); }
    
    // Shortcut for the battle loop
    public boolean isAlive() {
        return !hp.isFainted();
    }
    
    public void takeDamage(double amount) {
        this.hp.takeDamage(amount); // Calls the method inside HealthPoints.java
    }
    
    public void manaCost(double amount){
        this.mana.manaCost(amount);//TODO fix this Mana Cost Logic
    }

    public double getCurrentHealth(){
        return this.hp.getCurrentHP();
    }
    public double getCurrentMana(){
        return this.mana.getCurrentMana(); //TODO fix the battle logic where skills require mana usage
    }
    
    //only AttackType requires a setter for it needs to be updated every Turn!!!
    public void setAttackType(AttackType attackType){
        this.attackType = attackType;
    }
}