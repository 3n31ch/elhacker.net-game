/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.entities;

import FJG.entities.Entities;
import FJG.listeners.GameListener;
import FJG.entities.GameMEntity;
import FJG.listeners.KeyboardState;
import FJG.listeners.MouseState;
import FJG.utilities.GameMath;
import FJG.utilities.Hitbox;
import FJG.utilities.ResourceManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mygame.PlayState;
import mygame.Program;
import sun.awt.image.ToolkitImage;

/**
 *
 * @author Nacho
 */
public class Player extends GameMEntity {

    private String name = Program.USER.getName();
    private Color color = Program.USER.getColor();
    
    
    private long shootDelay = Program.USER.getShootDelay();
    private int attack = Program.USER.getAttack();
    private int maxLife = Program.USER.getLife();
    private int life = Program.USER.getLife();
    private float shootSpeed = Program.USER.getShootSpeed();

    private long lastShoot = 0;
    
    
    public Player(Entities entities) {
        super(entities, new Hitbox(312f, 242f, 16f, 16f) , Program.USER.getSpeed());
        this.code = "PLAYER";
        this.setSprite();
        if(Program.USER.getId().equals("elektrohcker-u436313")) {
            System.out.println("Entre");
            this.name = "pitoloko";
        }
        //pitoloko
        
        
    }
    
    private void setSprite() {
        switch (Program.USER.getId()) {
            case "hason-u545796":
                ResourceManager.addImage("HASON", ResourceManager.IMAGE_PATH + "hason.png");
                this.sprite = ResourceManager.getImage("HASON");
                break;
            case "elbrujo-u1":
                ResourceManager.addImage("EL-BRUJO", ResourceManager.IMAGE_PATH + "el-brujo.png");
                this.sprite = ResourceManager.getImage("EL-BRUJO");
                break;
            case "nebire-u570294":
                this.sprite = new ImageIcon(this.getClass().getResource("/resources/images/alien.png")).getImage();
                break;
            case "badstupidmonkey-u298195":
                this.sprite = new ImageIcon(this.getClass().getResource("/resources/images/drvy.png")).getImage();
                break;
            case "whk-u148268":
                this.sprite = new ImageIcon(this.getClass().getResource("/resources/images/whk.png")).getImage();
                break;
            case "elektrohcker-u436313":
                this.sprite = new ImageIcon(this.getClass().getResource("/resources/images/elektro.png")).getImage();
                break;
            case "mcksysargentina-u360345":
                this.sprite = new ImageIcon(this.getClass().getResource("/resources/images/mcksys.png")).getImage();
                break;
            case "nacho-u537557":
                ResourceManager.addImage("GM", ResourceManager.IMAGE_PATH + "gm.png");
                this.sprite = ResourceManager.getImage("GM");;
                break;
            case "engelx-u318120":
                this.sprite = new ImageIcon(this.getClass().getResource("/resources/images/engel-lex.png")).getImage();
                break;
            default:
                this.sprite = new ImageIcon(this.getClass().getResource("/resources/images/player.png")).getImage();
                break;
        }
    }

    @Override
    public void update() {
        KeyboardState ks = GameListener.getKeyboardState();
        MouseState ms = GameListener.getMouseState();
        
        float y = 0;
        float x = 0;
        if(ks.getKeyBooleanState(KeyEvent.VK_W)) {
            
            y = -1;
        } else if(ks.getKeyBooleanState(KeyEvent.VK_S)) {
            y = 1;
        }
        if(ks.getKeyBooleanState(KeyEvent.VK_A)) {
            if(y>0) y = 0.7f;
            if(y<0) y = -0.7f;
            if(y != 0 && y != 1 && y != -1) x = -0.7f;
            else x = -1;
        } else if (ks.getKeyBooleanState(KeyEvent.VK_D)) {
            if(y>0) y = 0.7f;
            if(y<0) y = -0.7f;
            if(y != 0 && y != 1 && y != -1) x = 0.7f;
            else x = 1;
        }
        
        if(ms.getButtonBooleanState(MouseEvent.BUTTON1)) {
            float shootAngle = GameMath.getAngleBetweenTwoPoints(this.hitbox.getCenter(), ms.getFloatMousePosition());
            this.shoot(shootAngle);
        }
        
        this.hitbox.move(new Point2D.Float(x, -y), speed);
        if(this.hitbox.x < 0 ) this.hitbox.x = 0;
        else if(this.hitbox.x > 624 ) this.hitbox.x = 624;
        
        if(this.hitbox.y < 0 ) this.hitbox.y = 0;
        else if(this.hitbox.y > 464 ) this.hitbox.y = 464;
    }
    
    private void shoot(float shootAngle) {
        if(lastShoot + shootDelay  <= System.currentTimeMillis()) {
            lastShoot = System.currentTimeMillis();
            this.entities.add(new Bullet(this.entities, shootSpeed, this.hitbox.getCenter(), attack, shootAngle));
        }
        
    }

    @Override
    public void draw(Graphics2D graphics) {
        this.drawName(graphics);
        this.drawLife(graphics);
        
        int rx = 0;
        int ry = 0;
        if(Program.USER.getId().equals("elektrohcker-u436313")) {
            rx = -3;
            ry = -2;
        }
        
        if(Program.USER.getId().equals("nacho-u537557")) {
            rx = 0;
            ry = -4;
        }
        
        if(Program.USER.getId().equals("mcksysargentina-u360345")) {
            rx = -7;
            ry = -2;
        }
        
        graphics.drawImage(colorImage(((ToolkitImage) sprite).getBufferedImage()), (int)this.hitbox.x + rx, (int)this.hitbox.y - ry, null);
    }
    
    
    private BufferedImage colorImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        WritableRaster raster = image.getRaster();
        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                if(pixels[0] == 0 && pixels[1] == 0 && pixels[2] == 0) {
                    pixels[0] = color.getRed();
                    pixels[1] = color.getGreen();
                    pixels[2] = color.getBlue();
                }
                
                raster.setPixel(xx, yy, pixels);
            }
        }
        return image;
    }
    
    private void drawName(Graphics2D graphics) {
        graphics.setColor(Color.WHITE);
        Font font = new Font("Manaspace", Font.BOLD, 12);
        graphics.setFont(font);
        FontMetrics metrics = graphics.getFontMetrics(font);
        graphics.drawString(this.name, (int)this.hitbox.getCenter().x - metrics.stringWidth(this.name)/2, (int)this.hitbox.y - 14);
    }
    
    private void drawLife(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect((int)this.hitbox.x - 8,(int)this.hitbox.y - 8 , 32, 4);
        int p = (int)(32*((float)life/(float)maxLife));
        //System.out.println("p" +  p);
        graphics.setColor(Color.GREEN);
        if(p <= 16) graphics.setColor(Color.YELLOW);
        if(p <= 8) graphics.setColor(Color.RED);
        
        
        
        graphics.fillRect((int)this.hitbox.x - 8,(int)this.hitbox.y - 8 , p, 4);
    }
    
    public void receiveAttack(int a) {
        life-=a;
        if(life <= 0) {
            PlayState.GAME_STATES.changeCurrentGameState("GAMEOVER");
            //JOptionPane.showMessageDialog(null, "GAME OVER");
            //System.exit(0);
        }
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public int getLife() {
        return life;
    }

    public float getShootSpeed() {
        return shootSpeed;
    }
    
    
    public float getSpeed() {
        return this.speed;
    }
    
    public float getShootDelay() {
        return this.shootDelay;
    }
    
}
