/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FJG.components;

import FJG.listeners.GameListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class GamePanel extends JPanel {
    
    private final static int WIDTH = 640;
    private final static int HEIGHT = 480;
    private BufferedImage frame;
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(GameListener.getListener());
        this.addMouseListener(GameListener.getListener());
        this.addMouseMotionListener(GameListener.getListener());
    }
    
    public void repaint(BufferedImage frame) {
        this.frame = frame;
        this.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(frame, 0, 0, this);
    }
}
