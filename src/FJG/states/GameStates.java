/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FJG.states;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Nacho
 */
public class GameStates {
    
    private final ArrayList<GameState> gameStates = new ArrayList<>();
    private GameState currentGameState;
    
    private boolean changeState = false;
    private String newState;
    
    public GameState getStateById(int id) {
        for(GameState gameState : gameStates) if(gameState.getId() == id) return gameState;
        return null;
    }
    
    public GameState getStateByCode(String code) {
        for(GameState gameState : gameStates) if(gameState.getCode().equals(code)) return gameState;
        return null;
    }
    
    public void add(GameState gameState) {
        this.gameStates.add(gameState);
    }
    
    public void setCurrentGameState(int id) {
         currentGameState = this.getStateById(id);
         currentGameState.initialize();
    }
    
    public void setCurrentGameState(String code) {
         currentGameState = this.getStateByCode(code);
         currentGameState.initialize();
    }
    
    public void changeCurrentGameState(String code) {
        this.changeState = true;
        this.newState = code;
    }
    
    public GameState getCurrentState() {
        return currentGameState;
    }
    
    public void update() {
        if(changeState) {
            this.setCurrentGameState(newState);
            changeState = false;
        }
        currentGameState.update();
    }
    public void draw(Graphics2D graphics) {
        currentGameState.draw(graphics);
    }
}
