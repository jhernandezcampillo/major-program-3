/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegame;

import javafx.geometry.Rectangle2D;

/**
 *
 * @author Judith
 */
public class Projectile extends GameObject {
    public Projectile(CmdCenter cc){
        super(cc.getParentHeight(), cc.getParentWidth());
        this.setShowObj(new Rectangle2D(145,353,5,18));
        this.setViewport(this.getShowObj());
        
        this.setWidth(5 * 1.5);
        this.setHeight(18 * 1.5);
        
        this.setScaleX(1.5);
        this.setScaleY(1.5);
        
        this.setX(cc.getX());
        this.setY(cc.getY());
        
        this.setDirection(this.getValue("NORTH"));
        this.setSpeed(8);
    }
    @Override
    public void move(){
        double newY= this.getY()+ getSpeed()* Math.sin(Math.toRadians(getDirection()));
        this.setY(newY);
    }
    
}
