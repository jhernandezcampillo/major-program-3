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
public class CmdCenter extends GameObject {

    private Projectile projectile;

    public CmdCenter(ActionPane actionPane) {
        super(actionPane.getPrefHeight(), actionPane.getPrefWidth());

        projectile = new Projectile(this);

        this.setShowObj(new Rectangle2D(220, 180, 26, 17));
        this.setWidth(26 * 1.5);
        this.setHeight(17 * 1.5);
        this.setScaleX(1.5);
        this.setScaleY(1.5);
        this.setViewport(this.getShowObj());
        this.setX(this.getParentWidth() / 2);
        this.setY(this.getParentHeight());
        this.setVisible(true);
    }

    public void move() {
        double newX = this.getX() + getSpeed() * Math.cos(Math.toRadians(getDirection()));
        this.setX(newX);
    }
    

    public void fireProjectile() {
        if(projectile.getY()<0){
            projectile.setX(this.getX());
            projectile.setY(this.getY());
            projectile.setVisible(true);
        }

    }

    /**
     * @return the projectile
     */
    public Projectile getProjectile() {
        return projectile;
    }

    /**
     * @param projectile the projectile to set
     */
    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
    }

}
