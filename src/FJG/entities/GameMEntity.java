/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FJG.entities;

import FJG.utilities.GameMath;
import FJG.utilities.Hitbox;
import java.awt.geom.Point2D;

/**
 *
 * @author Nacho
 */
public abstract class GameMEntity extends GameEntity {
    protected float speed;
    protected float angle;

    public GameMEntity(Entities entities, Hitbox hitbox, float speed) {
        super(entities, hitbox);
        this.speed = speed;
        this.angle = 0;
    }
    
    public void Move(float angle) {
        this.hitbox.move(angle, speed);
    }

    public void Move(Point2D.Float vector) {
        this.angle = GameMath.VectorToAngle(vector);
        this.hitbox.move(vector, speed);
    }

    
}
