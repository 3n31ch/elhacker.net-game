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

/**
 *
 * @author Nacho
 */
public class Hacker extends Enemy  {

    public Hacker(Entities entities, Point2D.Float position) {
        super(entities, new Hitbox((float)position.getX(), (float)position.getY(), 16f, 16f), 2f);
        this.setAttack(50);
        this.setLife(50);
        this.score = 100;
        this.code = "HACKER";
        ResourceManager.addImage("HACKER", ResourceManager.IMAGE_PATH + "hacker.png");
        this.sprite = ResourceManager.getImage("HACKER");
    }
    
}
