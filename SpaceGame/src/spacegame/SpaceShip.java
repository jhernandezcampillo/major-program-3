/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegame;

import java.util.Random;
import javafx.geometry.Rectangle2D;

/**
 *
 * @author Judith
 */
public class SpaceShip extends Invader{
    private Random random;
    
    
    public SpaceShip(GamePane gamePane){
        super(gamePane);
        random = new Random();
        
        
        this.setShowObj(new Rectangle2D(170,178,41,21));
        this.setViewport(this.getShowObj());
        this.setScaleX(1.5);
        this.setScaleY(1.5);  
        this.setWidth(41*1.5);
        this.setHeight(21*1.5);
        this.setY(0);
        this.setSpeed(2);
    }
    public void side(){
        int num = random.nextInt(2);
        
        if(num == 0){
            this.setX(-100);
            this.setDirection(this.getValue("EAST"));
        }
        else{
            this.setX(this.getParentWidth()+100);
            this.setDirection(this.getValue("WEST"));
        }
    }
    @Override
    public void move(){
        double newX = this.getX()+ getSpeed()* Math.cos(Math.toRadians(getDirection()));
        this.setX(newX);
    }
    public void setRandomPointValue(){
        int[] nums = {100,200,300};
        int val = random.nextInt(3);
        this.setPointValue(nums[val]);
    }
}
