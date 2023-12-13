/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author B-One
 */
public abstract class   shape  {
    private Color color;

    public shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
   public abstract void draw (Graphics g);
   public abstract boolean select (int x,int y);
 
    
    
}
