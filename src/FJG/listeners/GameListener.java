/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FJG.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import java.awt.event.

/**
 *
 * @author Nacho
 */
public class GameListener implements KeyListener, MouseMotionListener, MouseListener {

    private static GameListener GAME_LISTENER = new GameListener();
    private static KeyboardState KEYBOARD_STATE = new KeyboardState();
    private static MouseState MOUSE_STATE = new MouseState();
    
    
    public static KeyboardState getKeyboardState() {
        return GameListener.KEYBOARD_STATE;
    }
    
    public static MouseState getMouseState() {
        return GameListener.MOUSE_STATE;
    }
    
    public static void clear(){
        GameListener.KEYBOARD_STATE.clear();
    }
    
    public static GameListener getListener() {
        return GAME_LISTENER;
    }
   
    @Override        
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        GameListener.KEYBOARD_STATE.press(ke.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        GameListener.KEYBOARD_STATE.released(ke.getKeyCode());
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        MOUSE_STATE.setMousePosition(me.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        MOUSE_STATE.setMousePosition(me.getPoint());
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        GameListener.MOUSE_STATE.press(me.getButton());
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        GameListener.MOUSE_STATE.released(me.getButton());
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
