/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FJG.utilities;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Nacho
 */
public class Hitbox extends Rectangle2D.Float {
    
    public Hitbox(float x, float y, float w, float h) {
        super(x,y,w,h);
    }
    
    @Override
    public String toString() {
        return String.format("HITBOX(%1$.3f, %2$.3f, %3$.3f, %4$.3f)", this.x, this.y, this.width, this.height);
    }

    public void move(float angle, float speed) {
        Point2D distance = new Point2D.Float((float)(speed * Math.cos(angle)), (float)(speed * Math.sin(angle)));
        this.x += distance.getX();
        this.y += distance.getY();
    }

    public void move(Point2D vector, float speed) {
        this.x += vector.getX() * speed;
        this.y += -vector.getY() * speed;
    }
    
    public Point2D.Float getCenter() {
        return new Point2D.Float((float)this.getCenterX(), (float)this.getCenterY());
    }

}
