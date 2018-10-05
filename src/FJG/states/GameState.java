/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FJG.states;

import java.awt.Graphics2D;

/**
 *
 * @author Nacho
 */
public abstract class GameState {
    
    private static int IDENTIFICATOR;
    
    protected GameStates gameStates;
    
    protected int id;
    protected String code;
    
    public GameState(GameStates gameStates, String code) {
        this.id = IDENTIFICATOR++;
        this.code = code;
        this.gameStates = gameStates;
        this.gameStates.add(this);
    }
    
    public abstract void initialize();
    public abstract void update();
    public abstract void draw(Graphics2D graphics);


    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
    
    public GameStates getGameStates() {
        return gameStates;
    }
    
    
    
    
}
