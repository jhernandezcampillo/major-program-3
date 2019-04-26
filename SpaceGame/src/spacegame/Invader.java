/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegame;

/**
 *
 * @author Judith
 */
public abstract class Invader extends GameObject{
    private int pointValue;
    
    public Invader(GamePane gp){
        super(gp.getPrefHeight(), gp.getPrefWidth());
    }

    /**
     * @return the pointValue
     */
    public int getPointValue() {
        return pointValue;
    }

    /**
     * @param pointValue the pointValue to set
     */
    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }
    
}
