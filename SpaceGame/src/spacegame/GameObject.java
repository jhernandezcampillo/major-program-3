/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegame;

import java.io.FileInputStream;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Judith
 */
public abstract class GameObject extends ImageView implements Movable {

    private double direction;
    private double speed;
    private double parentWidth;
    private double parentHeight;
    private long previous;
    private Rectangle2D showObj;
    private double width;
    private double height;

    public GameObject() {
        direction = EAST;
        speed = 0.0;
        parentWidth = 0.0;
        parentHeight = 0.0;
        previous = 0;

        try {
            Image image = new Image(new FileInputStream("spritesheet.jpg"));
            this.setImage(image);
        } catch (java.io.FileNotFoundException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
    }

    public GameObject(double direction, double speed, double parentWidth, double parentHeight) {
        this();
        this.direction = direction;
        this.speed = speed;
        this.parentWidth = parentWidth;
        this.parentHeight = parentHeight;
    }

    public GameObject(double parentWidth, double parentHeight) {
        this();
        this.parentWidth = parentWidth;
        this.parentHeight = parentHeight;
    }
    public Rectangle2D surround(){
        return new Rectangle2D(this.getX(),this.getY(),this.getWidth(),this.getHeight());
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

    /**
     * @return the previous
     */
    public long getPrevious() {
        return previous;
    }

    /**
     * @param previous the previous to set
     */
    public void setPrevious(long previous) {
        this.previous = previous;
    }

    /**
     * @return the showObj
     */
    public Rectangle2D getShowObj() {
        return showObj;
    }

    /**
     * @param showObj the showObj to set
     */
    public void setShowObj(Rectangle2D viewportRect) {
        this.showObj = viewportRect;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }
    
    public int getValue(String direction) {
        if (direction == "EAST") {
            return EAST;
        } else if (direction == "WEST") {
            return WEST;
        } else if (direction == "SOUTH") {
            return SOUTH;
        } else if (direction == "NORTH") {
            return NORTH;
        }
        return -1;
    }

}
