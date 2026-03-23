
/*
 *  Project: ChaosElementalsGridExperiment
 *  Author: Dash 
 *  Date: Mar 22, 2026
 */
package game.core.main;

import game.entity.Player;
import game.tiles.TileManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
   // SCREEN SETTINGS
    public final int originalTileSize = 16; // 16x16 tile
    public final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48x48 tile
    public final int maxScreenCol = 26; 
    public final int maxScreenRow = 15; 
    public final int screenWidth = tileSize * maxScreenCol; // 1248px
    public final int screenHeight = tileSize * maxScreenRow; // 720px
    
    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int maxWorldWidth = tileSize * maxWorldCol;
    public final int maxWorldHeight = tileSize * maxWorldRow;
    
    // FPS
    int FPS = 60;
    
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this, keyH);
    
    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    /*
    @Override // this is for the Runnable implementation in Thread gameThread;
    public void run(){  // The GameLoop
        
        double drawInterval = 1000000000/FPS; // 60 fps per second (1 billion nanoSeconds)
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while(gameThread != null){
            
            
            
            // 1. Update: update information such as character positions
            update();
            // 2. DRAW: draw the screen with the updated information
            repaint(); //calling the painComponent
            //
            
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000; //divide by 1 million to turn nanoSeconds into milliseconds
                
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                
                Thread.sleep((long) remainingTime);
                
                nextDrawTime += drawInterval;
                
            } catch (InterruptedException ex) {
                System.getLogger(GamePanel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }
    */
    @Override
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        while(gameThread != null){
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            
            lastTime = currentTime;
            
            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;    
            }
            
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
        
    }
    
    public void update(){
        // moved to Player.java
        player.update(); // Player walk animation
        tileM.update(); // Tiles animation
    }   
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);
        player.draw(g2);
        
        g2.dispose();
    }
    
}
