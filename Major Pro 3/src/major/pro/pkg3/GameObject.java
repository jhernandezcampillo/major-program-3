/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package major.pro.pkg3;

/**
 *
 * @author Judith
 */
public abstract class GameObject {
    private double direction;
    private double speed;
    private double parentWidth;
    private double parentHeight;
    
    public GameObject(){
        direction = 0.0;
        speed = 0.0;
        parentWidth =0.0;
        parentHeight = 0.0;
    }
    public GameObject(double dir, double speed, double pWidth, double pHeight){
        direction = dir;
        this.speed = speed;
        parentWidth = pWidth;
        parentHeight = pHeight;
    }

    /**
     * @return the direction
     */
    public double getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(double direction) {
        this.direction = direction;
    }

    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * @return the parentWidth
     */
    public double getParentWidth() {
        return parentWidth;
    }

    /**
     * @param parentWidth the parentWidth to set
     */
    public void setParentWidth(double parentWidth) {
        this.parentWidth = parentWidth;
    }

    /**
     * @return the parentHeight
     */
    public double getParentHeight() {
        return parentHeight;
    }

    /**
     * @param parentHeight the parentHeight to set
     */
    public void setParentHeight(double parentHeight) {
        this.parentHeight = parentHeight;
    }
    
}
