/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FJG.entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author Nacho
 */
public class Entities {
    
    private ArrayList<GameEntity> addBuffer = new ArrayList<>();
    private ArrayList<GameEntity> removeBuffer = new ArrayList<>();
    
    private ArrayList<GameEntity> entities = new ArrayList<>();
        
    public void add(GameEntity entity) {
        this.addBuffer.add(entity);
    }
    
    public void remove(GameEntity entity) {
        this.removeBuffer.add(entity);
    }
    public void update() {
        preUpdate();
        for(GameEntity entity : entities) entity.update();
        postUpdate();
    }
    
    public void draw(Graphics2D graphics) {
        for(GameEntity entity : entities) entity.draw(graphics);
    }
    
    private void preUpdate() {
        for(GameEntity entity : addBuffer) entities.add(entity);
        addBuffer.clear();
    }
    
    private void postUpdate() {
        for(GameEntity entity : removeBuffer) entities.remove(entity);
        removeBuffer.clear();
    }
    
    public ArrayList<GameEntity> getEntities() {
        return entities;
    }
    
    public GameEntity getEntityById(int id) {
        for (GameEntity entity : entities) {
            if(entity.getId() == id) return entity;
        }
        return null;
    }
    
    
    public GameEntity getFirstEntityByCode(String code) {
        for (GameEntity entity : entities) {
            if(entity.getCode().equals(code)) return entity;
        }
        return null;
    }
    
    
    public Entities getEntitiesByCode(String code) {
        Entities gameEntities = new Entities();
        for (GameEntity entity : entities) {
            if(entity.getCode().equals(code)) gameEntities.add(entity);
        }
        return gameEntities;
    }
     
    public Entities getEntitiesByPoint(Point2D.Float point) {
        Entities gameEntities = new Entities();
        for (GameEntity entity : entities) {
            if(entity.getHitbox().contains(point)) gameEntities.add(entity);
        }
        return gameEntities;
    }
    
    public Entities getEntitiesByIntersection(Rectangle2D.Float rectangle) {
        Entities gameEntities = new Entities();
        for (GameEntity entity : entities) {
            if(entity.getHitbox().intersects(rectangle)) gameEntities.add(entity);
        }
        return gameEntities;
    }
    
    public GameEntity getFirstGameEntity() {
        return this.entities.get(0);
    }
    
    public Entities getGameEntities(int[] ids, String[] codes, Point2D.Float[] points, Rectangle2D.Float[] intersections, Rectangle2D.Float[] contains) {
        Entities gameEntities = new Entities();
        boolean boolId, boolCode, boolPoint, boolIntersection, boolContain;
        for (GameEntity entity : entities) {
            /* ID */
            if(ids == null) boolId = true;
            else {
                boolId = false;
                for (int id : ids) {
                    if(entity.id == id) boolId = true;
                    break;
                }
            }
            
            /* CODE */
            if(codes == null) boolCode = true;
            else {
                boolCode = false;
                for (String code : codes) {
                    if(entity.code.equals(code)) boolCode = true;
                    break;
                }
            }
            
            /* POINT */
            if(points == null) boolPoint = true;
            else {
                boolPoint = false;
                for (Point2D.Float point : points) {
                    if(entity.getHitbox().contains(point)) boolPoint = true;
                    break;
                }
            }
            
            /* INTERSECTION */
            if(intersections == null) boolIntersection = true;
            else {
                boolIntersection = false;
                for (Rectangle2D.Float intersection : intersections) {
                    if(entity.getHitbox().intersects(intersection)) boolIntersection = true;
                    break;
                }
            }
            
            
            /* CONTAINS */
            if(contains == null) boolContain = true;
            else {
                boolContain = false;
                for (Rectangle2D.Float contain : contains) {
                    if(entity.getHitbox().contains(contain)) boolContain = true;
                    break;
                }
            }
            
            if(boolId && boolCode && boolPoint && boolIntersection && boolContain) gameEntities.add(entity);
        
        }
        return gameEntities;
    }
    
    

}
