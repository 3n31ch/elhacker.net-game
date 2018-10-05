/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.entities.enemies;

import FJG.entities.Entities;
import FJG.utilities.Hitbox;
import FJG.utilities.ResourceManager;
import java.awt.geom.Point2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Nacho
 */
public class Android extends Enemy {
    
    public Android(Entities entities, Point2D.Float position) {
        super(entities, new Hitbox((float)position.getX(), (float)position.getY(), 16f, 16f), 0.2f);
        this.setAttack(50);
        this.setLife(100);
        this.score = 150;
        this.code = "ANDROID";
        ResourceManager.addImage("ANDROID", ResourceManager.IMAGE_PATH + "android.png");
        this.sprite = ResourceManager.getImage("ANDROID");
    }
    
}
