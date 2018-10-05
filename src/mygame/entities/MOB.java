/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.entities;

import FJG.entities.Entities;
import FJG.entities.GameMEntity;
import FJG.utilities.Hitbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Nacho
 */
public abstract class MOB extends GameMEntity {

    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attack;
    
    public MOB(Entities entities, Point2D.Float position, float speed) {
        super(entities, new Hitbox((float)position.getX(), (float)position.getY(), 16f, 16f), speed);
        this.sprite = new ImageIcon(this.getClass().getResource("/resources/images/image-not-found.png")).getImage();
    }
    
    public void receiveAttack(int a) {
        health-=a;
        if(health <= 0) entities.remove(this);
    }
    
    @Override
    public void draw(Graphics2D graphics) {
        drawName(graphics);
        drawHealth(graphics);
        graphics.drawImage(sprite, (int)this.hitbox.x, (int)this.hitbox.y, null);
    }

    private void drawHealth(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        
        graphics.fillRect((int)this.hitbox.x - 8,(int)this.hitbox.y - 8 , 32, 4);
        int p = (int)(32*((float)health/(float)maxHealth));
        
        graphics.setColor(Color.GREEN);
        if(p <= 16) graphics.setColor(Color.YELLOW);
        if(p <= 8) graphics.setColor(Color.RED);
        
        graphics.fillRect((int)this.hitbox.x - 8,(int)this.hitbox.y - 8 , p, 4);
    }
    
    
    private void drawName(Graphics2D graphics) {
        graphics.setColor(Color.WHITE);
        Font font = new Font("Consolas", Font.BOLD, 12);
        graphics.setFont(font);
        FontMetrics metrics = graphics.getFontMetrics(font);
        graphics.drawString(this.name, (int)this.hitbox.getCenter().x - metrics.stringWidth(this.name)/2, (int)this.hitbox.y - 14);
    }
 
}
