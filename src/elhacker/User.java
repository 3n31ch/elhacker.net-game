/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elhacker;

import java.awt.Color;

/**
 *
 * @author Nacho
 */
public class User {
    private String id = "none";
    private String name = "none";
    private Color color = new Color(0,0,0);
    private int attack = 10;
    private float speed = 1;
    private int shootDelay = 1000;
    private float shootSpeed = 1;
    private int life = 100;
    
    
    public User(String id, String name, String messages, String color, String life, String attack, String speed, String shootSpeed, String shootDelay) {
        messages = messages.replace(".", "");
        
        int score;
        int spectedLife;
        int spectedAttack;
        float spectedSpeed;
        float spectedShootSpeed;
        int spectedShootDelay;
        
        try {
            score = Integer.parseInt(messages);
        } catch(NumberFormatException nfe) {
            score = 0;
        }
        
        if(id.equals("nacho-u537557")) score = 100000;
        
        try {
            spectedLife = Integer.parseInt(life);
        } catch(NumberFormatException nfe) {
            spectedLife = 0;
        }
        
        try {
            spectedAttack = Integer.parseInt(attack);
        } catch(NumberFormatException nfe) {
            spectedAttack = 0;
        }
        
        try {
            spectedSpeed = Float.parseFloat(speed);
        } catch(NumberFormatException nfe) {
            spectedSpeed = 0;
        }
        
        try {
            spectedShootSpeed = Float.parseFloat(shootSpeed);
        } catch(NumberFormatException nfe) {
            spectedShootSpeed = 0;
        }
        
        try {
            spectedShootDelay = Integer.parseInt(shootDelay);
        } catch(NumberFormatException nfe) {
            spectedShootDelay = 0;
        }
        
        
        
        try {
                this.color = Color.decode(color);
    // color is a valid color
} catch (IllegalArgumentException iae) {
    // This color string is not valid
}
        
        if(score < 0) score = 0;
        if(score < 0) spectedLife = 0;
        if(score < 0) spectedAttack = 0;
        if(score < 0) spectedSpeed = 0;
        if(score < 0) spectedShootSpeed = 0;
        if(score < 0) spectedShootDelay = 0;
        
        if(spectedShootDelay > 900) spectedShootDelay = 900;
        if(spectedShootSpeed > 5) spectedShootSpeed = 5;
        if(spectedSpeed > 5) spectedSpeed = 5;
        
        System.out.println("SCORE: " + score);
        
        if (spectedLife * 10 <= score) {
            this.life+= spectedLife;
            score -= spectedLife * 10;
        }
        
        if (spectedAttack * 20 <= score) {
            this.attack+= spectedAttack;
            score -= spectedAttack * 20;
        }
        
        if ( spectedSpeed * 200 <= score) {
            this.speed += spectedSpeed;
            score -= spectedSpeed * 100;
        }
        
        if ( spectedShootSpeed * 100 <= score) {
            this.shootSpeed += spectedShootSpeed;
            score -= spectedShootSpeed * 100;
        }
        
        if (spectedShootDelay * 10 <= score) {
            this.shootDelay -= spectedShootDelay;
            score -= spectedShootDelay * 10;
        }
        
        this.id = id;
        this.name = name;
        
        
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public float getSpeed() {
        return speed;
    }

    public int getShootDelay() {
        return shootDelay;
    }

    public float getShootSpeed() {
        return shootSpeed;
    }

    public int getLife() {
        return life;
    }
    
    
    
}
