
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 29, 2026
 */
package game.tiles;

public interface TileIDs {
    // 00-09: WALKABLE
    int GRASS_A = 0;
    int GRASS_B = 1; // For animation
    int PATH_A  = 2;
    int PATH_B  = 3;
    int HINT_PATH = 4;
    int SAND_FLOOR = 5;
    int COBBLE_FLOOR = 6;

    // 10-19: LIQUIDS (Collision: True)
    int WATER_A = 10;
    int WATER_B = 11;

    // 30-39: NATURE (Collision: True)
    int TREE_A = 30;
    int TREE_B = 31;
    int BUSH1_A = 35;
    int BUSH1_B = 36;
    int BUSH2_A = 37;
    int BUSH2_B = 37;

    // 40-59: STRUCTURES & TRANSITIONS
    int WALL_CONCRETE = 40;
    int WALL_CAVE = 41;
    int CAVE_ENTRANCE = 50;
}
