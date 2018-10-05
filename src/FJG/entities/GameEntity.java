/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FJG.entities;

import FJG.utilities.Hitbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Nacho
 */
public abstract class GameEntity {
    
    private static int IDENTIFICATOR = 0;

    protected Entities entities;
    protected final int id;
    protected Hitbox hitbox;
    protected Image sprite;
    protected String code = "";
    
    public GameEntity(Entities entities, Hitbox hitbox) {
        this.id = GameEntity.IDENTIFICATOR++;
        this.hitbox = hitbox;
        this.entities = entities;
        //sprite = new ImageIcon(this.getClass().getResource("/resources/images/player.png")).getImage();
    }
    
    public void setSprite(String path) {
        this.sprite = new ImageIcon(this.getClass().getResource("/resources/images/player.png")).getImage();
    }
    
    public Hitbox getHitbox() {
        return hitbox;
    }

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }
    
    public String getCode() {
        return this.code;
    }
    public abstract void update();
    public abstract void draw(Graphics2D graphics);
    
    
    public int getId() {
        return this.id;
    }
    //public abstract void update();
    /*public void draw(Graphics2D graphics) {=
        graphics.drawImage(sprite, 0, 0, null);
    }*/
    
    
}
