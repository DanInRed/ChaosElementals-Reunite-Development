package game.battle.simulator;

import game.character.holder.CharacterHolder;
import game.engine.ManaCostCalculator;
import game.types.AttackType;

public class SimulateManaCost {
    //private double ManaCostCalculator.calculateManaCost(player.getAttackType());
    private int choice;
    private double manaNeeded;
    private double currentMana;

    public SimulateManaCost(int choice, CharacterHolder player, AttackType attack){
        this.choice = choice;
        this.manaNeeded = ManaCostCalculator.calculateManaCost(player, attack);
        this.currentMana = player.getCurrentMana();
    }

    //isChoiceValid needs another Clarification pls review the SimulateBattle.java
    public boolean isChoiceValid(int choice, CharacterHolder player, AttackType attack){
        boolean isValid;
        if(currentMana >= manaNeeded){
            isValid = true;
        }else{
            isValid = false;
        }
        return isValid;
    }

    public int getChoice(){ return choice; }
    public double getManaNeeded(){ return manaNeeded; }
    public double getCurrentMana(){ return currentMana;}
    
}
