
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 9, 2026
 */
package game.battle.simulator.dialogues;

import game.types.ElementType;

/**
 *
 * @author Dash
 */
public class BattleDialogues {
    public static String getWittyRemark(ElementType type, boolean playerWon) {
        if (playerWon) {
        return switch (type) {
            case FIRE -> "The heat was on, but you played it cool!";
            case ICE -> "Cool Story... too bad you're on thin ice now. Consider yourself defrosted :p";
            case PLANT -> "Oh no you poor thing, Uprooted!";
            case ROCK -> "You were a boulder, but I was the Jack Hammer.";
            case ELECTRIC -> "The riff guy got Amped!";
            case WATER -> "You soaked up the win and left them high and dry!";
            case WIND -> "Is that it? The 'legendary gale' was barely a light breeze.";
            case METAL -> "You really Headbanged that victory home!";
            default -> "Victory is yours! They never stood a chance.";
        };
        } else {
        return switch (type) {
            case FIRE -> "You just got third-degree burned. Ouch.";
            case ICE -> "Is this frostbite? into the chill grave you go.";
            case PLANT -> "Yikes, post apocaliptic vegetation it is.";
            case ROCK -> "Wait What? the golem launched a surprise attack? \nNo fair!";
            case ELECTRIC -> "Oh well.. thunderstruck it is.";
            case WATER -> "Don't worry, the salt water will preserve your pride. \nYour 'wave' was the most pathetic thing I saw all day.";
            case WIND -> "You got blown away like a leaf in a storm.";
            case METAL -> "Oops... poser detected!";
            default -> "Better luck next time, trainee!";
        };
    }
    }
}
