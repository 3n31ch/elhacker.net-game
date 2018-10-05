/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FJG.components;

import FJG.states.GameStates;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */
public abstract class GameEngine implements Runnable {
    
    
    protected GameFrame gameFrame;
    protected GamePanel gamePanel;
    
    protected int expectedFps = 60;
    protected BufferedImage bufferedImage;
    protected Graphics2D graphics;
    
    protected GameStates gameStates;
    
    public GameEngine() {
        this.gameFrame = new GameFrame();
        this.gamePanel = gameFrame.getGamePanel();
        bufferedImage = new BufferedImage(this.gamePanel.getPreferredSize().width,
                this.gamePanel.getPreferredSize().height,
                BufferedImage.TYPE_INT_ARGB);
        this.gameStates = new GameStates();
        this.initialize();
        new Thread(this).start();
        this.gameFrame.setVisible(true);
    }
    
    protected abstract void initialize();
    
    protected void update() {
        gameStates.update();
    }
    protected void draw() {
        gameStates.draw(graphics);
    }
    

    @Override
    public void run() {
        long start;        
        long elapsed;       
        long wait;
        while(true) {
            start = System.nanoTime();  /* Tomamos tiempo de inicio */
            this.update();
            graphics = bufferedImage.createGraphics();
            this.draw();
            graphics.dispose();
            this.gamePanel.repaint(bufferedImage);
            //GameListener.clear();
            
            elapsed = System.nanoTime(); /* Tomamos tiempo de fin */
            wait = 1000/expectedFps - (elapsed-start)/1000000; /* Utilizamos formula de FPS */
            wait = (wait < 0)? 0 : wait;  /* Prevenimos posibles errores */
            try {
                Thread.sleep(wait);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
