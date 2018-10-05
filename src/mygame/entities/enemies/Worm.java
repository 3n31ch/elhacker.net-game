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
public class Worm extends Enemy  {

    public Worm(Entities entities, Point2D.Float position) {
        super(entities, new Hitbox((float)position.getX(), (float)position.getY(), 16f, 16f), 0.5f);
        this.setAttack(20);
        this.setLife(50);
        this.score = 70;
        this.code = "WORM";
        ResourceManager.addImage("WORM", ResourceManager.IMAGE_PATH + "worm.png");
        this.sprite = ResourceManager.getImage("WORM");
    }
    
}
