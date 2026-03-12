
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.types;

/**
 *
 * @author Dash
 */

public enum ElementType {
    // 0 to 7 matching your Star Polygon positions
    FIRE(0),      
    ICE(1),  
    PLANT(2),       
    ROCK(3),      
    ELECTRIC(4),      
    WATER(5),     
    WIND(6),     
    METAL(7);

    private final int index;

    // Constructor for the Enum
    ElementType(int index) {
        this.index = index;
    }

    // Getter to retrieve the index for math
    public int getIndex() {
        return index;
    }
    
    //unused helper methods
    /*
    // HELPER: Dynamic Pathing
    public String getIconPath() {
        return "/game/resources/icons/" + this.name() + ".png";
    }

    // HELPER: UI Formatting
    public String getFormattedName() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
    */
}