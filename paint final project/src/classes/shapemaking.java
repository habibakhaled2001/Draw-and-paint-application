/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;

/**
 *
 * @author B-One
 */
public class shapemaking {
    public shape CreateShape(int x,int x1,int y1,int x2,int y2,int x3,int y3,Color current) {
        if(x==0)
        {
            return new line(x1,y1,x2,y2,current);
        }
        else if (x==1) {
            return new rectangle(x1,y1,x2,y2,current);}
        else if(x==2)
        {
            return new square(x1,y1,x2,y2,current);
            
        }
        else if(x==3)
        {
            return new triangle(x1,y1,x2,y2,x3,y3,current);
        }
        else if(x==4)
        {
            return new circle(x1,y1,x2,y2,current);
        }
         else {
            return null;
        }
    }
}
