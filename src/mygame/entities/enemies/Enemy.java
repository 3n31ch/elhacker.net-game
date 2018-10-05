/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.entities.enemies;

import FJG.entities.Entities;
import FJG.entities.GameEntity;
import FJG.entities.GameMEntity;
import FJG.utilities.GameMath;
import FJG.utilities.Hitbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.Random;
import mygame.PlayState;
import mygame.entities.Player;

/**
 *
 * @author Nacho
 */
public class Enemy extends GameMEntity {
    
    protected int score = 10;
    protected int attack = 10;
    protected int maxLife = 100;
    protected int life = maxLife;
    
    protected void setAttack(int attack) {
        this.attack = attack;
    }
    
    protected void setLife(int life) {
        this.life = life;
        this.maxLife = life;
    }
    
    public Enemy(Entities entities, Hitbox hitbox, float speed) {
        super(entities, hitbox, speed);
    }

    @Override
    public void update() {        
        Player player = (Player)this.entities.getFirstEntityByCode("PLAYER");
        if(player != null) {
            if(this.hitbox.intersects(player.getHitbox())) {
                player.receiveAttack(attack);
                entities.remove(this);
            } else {
                float angle = GameMath.getAngleBetweenTwoPoints(this.hitbox.getCenter(), player.getHitbox().getCenter());
                this.hitbox.move(angle, speed);
            }            
        }
    }

    @Override
    public void draw(Graphics2D graphics) {
        this.drawLife(graphics);
        this.drawName(graphics);
        graphics.drawImage(sprite, (int)this.hitbox.x, (int)this.hitbox.y, null);
    }
    
    
    private void drawLife(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect((int)this.hitbox.x - 8,(int)this.hitbox.y - 8 , 32, 4);
        int p = (int)(32*((float)life/(float)maxLife));
        graphics.setColor(Color.GREEN);
        if(p <= 16) graphics.setColor(Color.YELLOW);
        if(p <= 8) graphics.setColor(Color.RED);
        graphics.fillRect((int)this.hitbox.x - 8,(int)this.hitbox.y - 8 , p, 4);
    }
    
    private void drawName(Graphics2D graphics) {
        graphics.setColor(Color.RED);
        Font font = new Font("Manaspace", Font.BOLD, 12);
        graphics.setFont(font);
        FontMetrics metrics = graphics.getFontMetrics(font);
        graphics.drawString(this.code, (int)this.hitbox.getCenter().x - metrics.stringWidth(this.code)/2, (int)this.hitbox.y - 14);
    }
    
    public void receiveAttack(int a) {
        life-=a;
        if(life <= 0) {
            PlayState.SCORE+= this.score;
            entities.remove(this);
        }
    }
    
    public static Enemy getRandomEnemy(Entities entities, Point2D.Float position) {
        Random r = new Random();
        switch(r.nextInt(5)) {
            case 0: return new Android(entities, position);
            case 1: return new Hacker(entities, position);
            case 2: return new KeyLogger(entities, position);
            case 3: return new Virus(entities, position);
            case 4: return new Worm(entities, position);
            default: return null;
        }
    }
}
