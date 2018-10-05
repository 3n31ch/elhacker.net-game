/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.entities;

import mygame.entities.enemies.Enemy;
import FJG.entities.Entities;
import FJG.components.GameEngine;
import FJG.entities.GameEntity;
import FJG.entities.GameMEntity;
import FJG.utilities.GameMath;
import FJG.utilities.Hitbox;
import FJG.utilities.ResourceManager;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Nacho
 */
public class Bullet extends GameMEntity {
    
    private float angle;
    private int attack;
    
    public Bullet(Entities entities, float speed, Point2D.Float position, int attack, float angle) {
        super(entities, new Hitbox(position.x, position.y, 4f, 4f) , speed);
        this.code = "BULLET";
        this.angle = angle;
        this.attack = attack;
        ResourceManager.addImage("BULLET", ResourceManager.IMAGE_PATH + "bullet.png");
        this.sprite = ResourceManager.getImage("BULLET");
    }
    
    @Override
    public void update() {
        for(GameEntity entity : this.entities.getEntities() ) {
            if(!entity.getCode().equals("PLAYER") && !entity.getCode().equals("BULLET")) {
                if(entity.getHitbox().intersects(hitbox)) {
                    entities.remove(this);
                    ((Enemy)entity).receiveAttack(attack);
                    return;
                }
            }
        }
        
        
        this.hitbox.move(angle, speed);
    }

    @Override
    public void draw(Graphics2D graphics) {
         graphics.drawImage(sprite, (int)this.hitbox.x, (int)this.hitbox.y, null);
    }
    
}
