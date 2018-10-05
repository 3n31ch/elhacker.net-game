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
public class Virus extends Enemy  {

    public Virus(Entities entities, Point2D.Float position) {
        super(entities, new Hitbox((float)position.getX(), (float)position.getY(), 16f, 16f), 3f);
        this.setAttack(10);
        this.setLife(10);
        this.score = 20;
        this.code = "VIRUS";
        ResourceManager.addImage("VIRUS", ResourceManager.IMAGE_PATH + "virus.png");
        this.sprite = ResourceManager.getImage("VIRUS");
    }
    
}
