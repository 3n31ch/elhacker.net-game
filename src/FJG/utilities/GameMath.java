/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FJG.utilities;

import java.awt.geom.Point2D;

/**
 *
 * @author Nacho
 */
public class GameMath {
    public static float VectorToAngle(Point2D.Float vector) {
        float angle = (float)Math.atan2(-vector.getY(), vector.getX());
        return angle;
    }

    public static float getAngleBetweenTwoPoints(Point2D.Float center, Point2D.Float target) {
        Point2D.Float difference = new Point2D.Float( (float)(-1 * center.getX()), (float)(-1 * center.getY()));
        target = new Point2D.Float((float)(target.getX() + difference.getX()), (float)(target.getY() + difference.getY()));
        return VectorToAngle(new Point2D.Float( (float)(1 * target.getX()), (float)(-1 * target.getY()))    );
    }
}
