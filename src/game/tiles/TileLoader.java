
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 28, 2026
 */
package game.tiles;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

public class TileLoader implements TileIDs{

    // Helper to load a single image
    private static BufferedImage loadImage(String fileName) {
        try {
            return ImageIO.read(TileLoader.class.getResourceAsStream("/game/resources/tiles/" + fileName));
        } catch (IOException e) {
            System.out.println("Error loading: " + fileName);
            return null;
        }
    }

    public static void loadOverworldTiles(Tile[] tile) {
        // 1. Load the sheets once
        BufferedImage grassSheet = loadImage("grass.png");
        BufferedImage pathSheet  = loadImage("path.png");
        BufferedImage waterSheet = loadImage("water.png");
        BufferedImage treeSheet  = loadImage("tree.png");
        BufferedImage bush1Sheet = loadImage("bush1.png");
        BufferedImage bush2Sheet = loadImage("bush2.png");

        // 2. Use setup to assign them to the array
        // --- Walkable (0-9) ---
        setup(GRASS_A, tile, grassSheet, 0, 0, false);
        setup(GRASS_B, tile, grassSheet, 0, 1, false);
        setup(PATH_A, tile, pathSheet, 0, 0, false);
        setup(PATH_B, tile, pathSheet, 0, 1, false);
        setup(HINT_PATH, tile, "hintpath", false);
        setup(SAND_FLOOR, tile, "sand", false);
        setup(COBBLE_FLOOR, tile, "cobblefloor", false);

        // --- Water (10-19) ---
        setup(WATER_A, tile, waterSheet, 0, 0, true);
        setup(WATER_B, tile, waterSheet, 0, 1, true);

        // --- Environment (30-39) ---
        setup(TREE_A, tile, treeSheet, 0, 0, true);
        setup(TREE_B, tile, treeSheet, 0, 1, true);
        setup(BUSH1_A, tile, bush1Sheet, 0, 0, true);
        setup(BUSH1_B, tile, bush1Sheet, 0, 1, true);
        setup(BUSH2_A, tile, bush2Sheet, 0, 0, true);
        setup(BUSH2_B, tile, bush2Sheet, 0, 1, true);

        // --- Walls/Cave (40-50) ---
        setup(WALL_CONCRETE, tile, "concretewall", true);
        setup(WALL_CAVE, tile, "cavewall", true);
        setup(CAVE_ENTRANCE, tile, "caveentrance", false);
    }

    // SETUP: For single files
    public static void setup(int index, Tile[] tile, String imageName, boolean collision) {
        tile[index] = new Tile();
        tile[index].image = loadImage(imageName + ".png");
        tile[index].collision = collision;
    }

    // SETUP: For sheets
    public static void setup(int index, Tile[] tile, BufferedImage sheet, int col, int row, boolean collision) {
        tile[index] = new Tile();
        tile[index].image = sheet.getSubimage(col * 16, row * 16, 16, 16);
        tile[index].collision = collision;
    }

    public static void parseMapFile(String path, int[][] mapData, int maxCol, int maxRow) {
        try {
            InputStream is = TileLoader.class.getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for (int row = 0; row < maxRow; row++) {
                String line = br.readLine();
                String[] numbers = line.split("\\s+");
                for (int col = 0; col < maxCol; col++) {
                    mapData[col][row] = Integer.parseInt(numbers[col]);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}