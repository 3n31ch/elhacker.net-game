/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FJG.listeners;

import java.util.ArrayList;

/**
 *
 * @author Nacho
 */
public class KeyboardState {
    
    public static final int PRESSED = 1;
    public static final int RELEASED = 0;
    
    private final ArrayList<Integer> keysPressed = new ArrayList<>();
    
    public void press(int code) {
        if(!keysPressed.contains(code))  keysPressed.add(code);
    }
    
    public void released(int code) {
        keysPressed.remove(new Integer(code) );
    }

    
    public int getKeyState(int code) {
        if(keysPressed.contains(code)) return KeyboardState.PRESSED;
        else return KeyboardState.RELEASED;
    }
    
    
    public boolean getKeyBooleanState(int code) {
        return keysPressed.contains(code);
    }
    
    
    public void clear() {
        keysPressed.clear();
    }
    
}
