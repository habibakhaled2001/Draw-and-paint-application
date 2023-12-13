
package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author B-One
 */
public class rectangle extends shape implements Cloneable {
   private int x1,y1,x2,y2;

    
    public rectangle(int x1, int y1, int x2, int y2, Color color) {
        super(color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public rectangle(Color color) {
        super(color);
    }

    

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(g.getColor());
        if(x1<x2&&y1<y2)
        {g.drawRect(x1, y1, Math.abs(x1-x2),Math.abs(y1-y2) );}
        else if(x1>x2&&y1>y2)
        {
            g.drawRect(x2, y2, Math.abs(x1-x2), Math.abs(y1-y2));
        }
        else if(x1<x2&&y1>y2)
        {
            g.drawRect(x1, y2, Math.abs(x1-x2), Math.abs(y1-y2));
        }
        else if(x1>x2&&y1<y2)
        {
            g.drawRect(x2, y1, Math.abs(x1-x2), Math.abs(y1-y2));
   
        }
    }

    @Override
    public boolean select(int x, int y) {
        Rectangle r=null;
        if(this.x1<this.x2&&this.y1<this.y2)
        {
            r=new Rectangle (this.x1,this.y1,Math.abs(this.x1-this.x2),Math.abs(this.y1-this.y2));
        }
        else if(this.x2<this.x1&&this.y2<this.y1)
        {
         r=new Rectangle (this.x2,this.y2,Math.abs(this.x1-this.x2),Math.abs(this.y1-this.y2));   
        }
        else if(this.x1<this.x2&&this.y2<this.y1)
        {
           r= new Rectangle (this.x1,this.y2,Math.abs(this.x1-this.x2),Math.abs(this.y1-this.y2));
        }
        else if(this.x2<this.x1&&this.y1<this.y2)
        {
             r= new Rectangle (this.x2,this.y1,Math.abs(this.x1-this.x2),Math.abs(this.y1-this.y2));
        }
        if(r.contains(x,y))
        {
            return true;
        }
        else 
            return false;
    }
     @Override
    public Object clone() throws CloneNotSupportedException {
        rectangle r =(rectangle)super.clone();
       return r;
    }
    
}
