package mygame;


import FJG.entities.Entities;
import FJG.entities.GameEntity;
import FJG.states.GameState;
import FJG.states.GameStates;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import mygame.entities.enemies.Enemy;
import mygame.entities.Player;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class PlayState extends GameState {

    
    public static GameStates GAME_STATES;
    
    public static int SCORE = 0;
    
    
    private ArrayList<GameEntity> bufferEntities;
    private Entities entities;
    private Image background;
    private long lastEnemy = System.currentTimeMillis();
    private long enemyDelay = 5000;
    
    /*
        this.player.getLife() + "/" + this.player.getMaxLife(),
          this.player.getAttack() + "",
          this.player.getSpeed() + "",
          this.player.getShootSpeed() + "",
          this.player.getShootDelay() + ""
    */
    private Image icons[] = new Image[] {
        new ImageIcon(this.getClass().getResource("/resources/images/health-icon.png")).getImage(),
        new ImageIcon(this.getClass().getResource("/resources/images/attack-icon.png")).getImage(),
        new ImageIcon(this.getClass().getResource("/resources/images/speed-icon.png")).getImage(),
        new ImageIcon(this.getClass().getResource("/resources/images/shoot-speed-icon.png")).getImage(),
        new ImageIcon(this.getClass().getResource("/resources/images/shoot-delay-icon.png")).getImage()
    };
    
    
    private Image bitcoin = new ImageIcon(this.getClass().getResource("/resources/images/bitcoin.png")).getImage();
    
    private Image front;
    private Player player;
    
    
    
    public PlayState(GameStates gameStates) {
        super(gameStates, "PLAY");
        
    }
    
    @Override
    public void initialize() {
        enemyDelay = 5000;
        GAME_STATES = this.gameStates;
        this.bufferEntities = new ArrayList<>();
        this.entities = new Entities();
        this.player = new Player(entities);
        this.entities.add(this.player);
        
        if(Program.USER.getId().equals("elbrujo-u1") || Program.USER.getId().equals("engelx-u318120") || Program.USER.getId().equals("elektrohcker-u436313")) {
            this.background = new ImageIcon(this.getClass().getResource("/resources/images/background-elhacker.png")).getImage();
        } else if(Program.USER.getId().equals("hason-u545796")) {
            this.background = new ImageIcon(this.getClass().getResource("/resources/images/background-hason.png")).getImage();
        } else {
            this.background = new ImageIcon(this.getClass().getResource("/resources/images/background.png")).getImage();
        }
        if(Program.USER.getId().equals("randomize-u42216")) {
            this.front = new ImageIcon(this.getClass().getResource("/resources/images/troll.png")).getImage();
        }
        if(Program.USER.getId().equals("hason-u545796")) {
            this.front = new ImageIcon(this.getClass().getResource("/resources/images/smoke.png")).getImage();
        }
    }

    @Override
    public void update() {
        
        if(lastEnemy + enemyDelay < System.currentTimeMillis()) {
            System.out.println(lastEnemy + "+" + enemyDelay + "<" + System.currentTimeMillis());
            
            lastEnemy = System.currentTimeMillis();
            enemyDelay = (int)(enemyDelay*0.95);
            addEnemy();
        }
        entities.update();
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.BLUE);
        graphics.drawImage(background, 0, 0, null);
        entities.draw(graphics);
        bufferEntityToEntities();
        if(Program.USER.getId().equals("randomize-u42216") || Program.USER.getId().equals("hason-u545796")) {
            graphics.drawImage(front, 0, 0, null);
        }
        drawScore(graphics);
        drawStats(graphics);
    }
    
    public void addEntity(GameEntity gameEntity) {
        bufferEntities.add(gameEntity);
    }
    
    private void bufferEntityToEntities() {
        for(GameEntity e : bufferEntities) {
            entities.add(e);
        }
        bufferEntities.clear();
    }
    
    private void drawScore(Graphics2D graphics) {
        graphics.setColor(Color.WHITE);
        Font font = new Font("Manaspace", Font.BOLD, 32);
        graphics.setFont(font);
        graphics.drawImage(bitcoin, 10, 13, null);
        graphics.drawString(SCORE+"", 50, 40);
    }
    
    
    private void drawStats(Graphics2D graphics) {
        graphics.setColor(Color.WHITE);
        Font font = new Font("Manaspace", Font.BOLD, 12);
        graphics.setFont(font);
        
        String[] stats = new String[]{
          this.player.getLife() + "/" + this.player.getMaxLife(),
          this.player.getAttack() + "",
          this.player.getSpeed() + "",
          this.player.getShootSpeed() + "",
          this.player.getShootDelay() + ""
        };
        
        for (int i = 0; i < 5; i++) {
            
            graphics.drawImage(icons[i], 20, 70 + i*20 - 15, null);
            graphics.drawString(stats[i], 40, 70 + i*20);
        };
    }
    
    
    
    private void addEnemy() {
        Random random = new Random();
        int x = random.nextInt(640);
        int y = random.nextInt(480);
        int o = random.nextInt(4); // 0-3
        if(o == 0) x = 0;
        else if(o == 1) x = 640;
        else if(o == 2) y = 0;
        else if(o == 3) y = 480;
        this.entities.add(Enemy.getRandomEnemy(entities, new Point2D.Float(x-16,y-16)));
    }

    
    
}
