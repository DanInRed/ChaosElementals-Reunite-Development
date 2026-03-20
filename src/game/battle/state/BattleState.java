    
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 20, 2026
 */
package game.battle.state;

import game.character.holder.CharacterHolder;

/**
 * The "Model" of the battle. 
 * This class holds the current data/status of the fight.
 */

public class BattleState {
    private CharacterHolder player;
    private CharacterHolder enemy;
    
    private int turnCount;
    private boolean isPlayerTurn;
    private boolean battleOver;

    public BattleState(CharacterHolder player, CharacterHolder enemy) {
        this.player = player;
        this.enemy = enemy;
        this.turnCount = 1;
        this.isPlayerTurn = true; // Player usually goes first
        this.battleOver = false;
    }

    // --- GETTERS ---
    public CharacterHolder getPlayer() { return player; }
    public CharacterHolder getEnemy() { return enemy; }
    public int getTurnCount() { return turnCount; }
    public boolean isPlayerTurn() { return isPlayerTurn; }
    public boolean isBattleOver() { return battleOver; }

    // --- SETTERS / LOGIC ---
    public void nextTurn() {
        this.turnCount++;
        this.isPlayerTurn = !isPlayerTurn;
    }

    public void setBattleOver(boolean battleOver) {
        this.battleOver = battleOver;
    }
    
    /**
     * Resets the state for a new match if needed.
     */
    public void reset(CharacterHolder newPlayer, CharacterHolder newEnemy) {
        this.player = newPlayer;
        this.enemy = newEnemy;
        this.turnCount = 1;
        this.isPlayerTurn = true;
        this.battleOver = false;
    }
}
