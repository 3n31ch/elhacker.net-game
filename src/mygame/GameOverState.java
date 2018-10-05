/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import FJG.listeners.GameListener;
import FJG.listeners.KeyboardState;
import FJG.states.GameState;
import FJG.states.GameStates;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static mygame.PlayState.SCORE;

/**
 *
 * @author Nacho
 */
public class GameOverState extends GameState {

    private Image background;
    private Font font;
    
    public GameOverState(GameStates gameStates) {
        super(gameStates, "GAMEOVER");
    }

    @Override
    public void initialize() {
        this.background = new ImageIcon(this.getClass().getResource("/resources/images/game-over.png")).getImage();        
        
    }

    @Override
    public void update() {
         KeyboardState ks = GameListener.getKeyboardState();
        if(ks.getKeyBooleanState(KeyEvent.VK_ENTER)) {
            PlayState.SCORE = 0;
            
            this.gameStates.changeCurrentGameState("PLAY");
        } 
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawImage(background, 0, 0, null);
        graphics.setColor(Color.WHITE);
        Font font = new Font("Manaspace", Font.BOLD, 72);
        graphics.setFont(font);
        FontMetrics metrics = graphics.getFontMetrics(font);
        graphics.drawString(PlayState.SCORE+"", 640/2 - metrics.stringWidth(PlayState.SCORE+"")/2, 250);
        
        graphics.setColor(Color.YELLOW);
        font = new Font("Manaspace", Font.BOLD, 16);
        graphics.setFont(font);
        metrics = graphics.getFontMetrics(font);
        graphics.drawString("[PRECIONA ENTER PARA JUGAR]", 640/2 - metrics.stringWidth("[PRECIONA ENTER PARA JUGAR]")/2, 350);
    }
    
}
