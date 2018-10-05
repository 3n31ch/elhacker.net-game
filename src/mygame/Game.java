/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import FJG.components.GameEngine;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Nacho
 */
public class Game extends GameEngine {

    @Override
    protected void initialize() {
        try {
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/resources/fonts/manaspc.ttf")));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(GameOverState.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.gameStates.add(new PlayState(this.gameStates));
        this.gameStates.add(new GameOverState(this.gameStates));
        this.gameStates.setCurrentGameState("PLAY");
    }
    
    
    
}
