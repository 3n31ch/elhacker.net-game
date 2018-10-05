/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FJG.listeners;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author Nacho
 */
public class MouseState {
    public static final int PRESSED = 1;
    public static final int RELEASED = 0;
    
    private Point mousePosition = new Point(0,0);
    
    private final ArrayList<Integer> keysPressed = new ArrayList<>();
    
    
    public void setMousePosition(Point mousePosition) {
        this.mousePosition = mousePosition;
    }
    
    public Point getMousePosition() {
        return mousePosition;
    }
    
    public Point2D.Float getFloatMousePosition() {
        return new Point2D.Float(mousePosition.x,mousePosition.y);
    }
    
    public void press(int code) {
        if(!keysPressed.contains(code))  keysPressed.add(code);
    }
    
    public void released(int code) {
        keysPressed.remove(new Integer(code) );
    }
    
    public int getButtonState(int code) {
        if(keysPressed.contains(code)) return KeyboardState.PRESSED;
        else return KeyboardState.RELEASED;
    }
    
    public boolean getButtonBooleanState(int code) {
        return keysPressed.contains(code);
    }
    
    public void clear() {
        keysPressed.clear();
    }
}