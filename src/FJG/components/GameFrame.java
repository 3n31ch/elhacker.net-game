/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FJG.components;

import javax.swing.JFrame;

/**
 *
 * @author Nacho
 */
public class GameFrame extends JFrame {
    
    private final GamePanel gamePanel;
    
    public GameFrame() {
        super("elhacker.net");
        gamePanel = new GamePanel();
        this.setContentPane(gamePanel);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public GamePanel getGamePanel() {
        return gamePanel;
    }
}
