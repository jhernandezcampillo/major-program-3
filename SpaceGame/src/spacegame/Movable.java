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
public interface Movable {

    public void move();
    final int EAST = 0;
    final int WEST = 180;
    final int NORTH = 270;
    final int SOUTH = 90;
        
}
