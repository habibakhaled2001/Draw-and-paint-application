/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classes.circle;
import classes.line;
import classes.rectangle;
import classes.shape;
import classes.shapemaking;
import classes.square;
import classes.triangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author B-One
 */
public class board extends JPanel implements MouseListener, MouseMotionListener {
    Color current;
    int x1,x2,y1,y2,x3,y3,mode=-1,deleteIndex;
    private shape selectToResize =null,selectToMove=null,selectToCopy=null;
    boolean first =false;
    shapemaking make=new shapemaking();
    ArrayList<shape> x = new ArrayList<shape>();
    public board() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < x.size(); i++) {
           x.get(i).draw(g);
                
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
       
    
    }

    @Override
    public void mousePressed(MouseEvent e) {
         x1 = e.getX();
        y1 = e.getY();
        if (mode == 0) {
             line l=(line)make.CreateShape(0,x1,y1,x1,y1,0,0,current);
            x.add(l);
            repaint();
        }
        else if(mode==1)
        {
            rectangle r=(rectangle)make.CreateShape(1,x1,y1,x1,y1,0,0,current);
            x.add(r);
            repaint();
        }
        else if(mode==2)
        {
            square sq=(square)make.CreateShape(2,x1,y1,x1,y1,0,0,current);
            x.add(sq);
            repaint();
        }
        else if(mode==3)
        {
             triangle t=(triangle)make.CreateShape(3,x1,y1,x1,y1,x1,y1,current);
            x.add(t);
            repaint();
        }
        else if(mode==4)
        {
            circle c=(circle)make.CreateShape(4,x1,y1,x1,y1,0,0,current);
            x.add(c);
            repaint();
        }
        else if(mode==5)
        {
            for(int i=x.size()-1;i>=0;i--)
            {
                if(x.get(i).select(x1, y1))
                {
                    selectToResize=x.get(i);
                    break;
                }
            }
        }
         else if(mode==6)
        {
            for(int i=x.size()-1;i>=0;i--)
            {
                if(x.get(i).select(x1, y1))
                {
                    
                    selectToMove=x.get(i);
                    break;
                }
            }
        }
         else if(mode==7)
        {
            for(int i=x.size()-1;i>=0;i--)
            {
                if(x.get(i).select(x1, y1))
                {
                   x.remove(i);
                   break;
                }
            }
            repaint();
            
        }
        else if(mode==8)
        {
            for(int i=x.size()-1;i>=0;i--)
            {
                if(x.get(i).select(x1, y1))
                {
                    System.out.println("yes");
                    selectToCopy=x.get(i);
                    break;
                }
            }
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (mode == 0) {
            x2 = e.getX();
            y2 = e.getY();
            shape s = x.get(x.size() - 1);
            if (s instanceof line) {
                line l = (line) s;
                l.setX2(x2);
                l.setY2(y2);
            }
            repaint();
            first = false;
        } else if(mode==1)
        {
            x2=e.getX();
            y2=e.getY();
            shape s=x.get(x.size() -1);
            if(s instanceof rectangle)
            {
                rectangle r=(rectangle) s;
                r.setX2(x2);
                r.setY2(y2);
                
            }
            repaint();
            first=false;
        }
        else if(mode==2)
        {
            x2=e.getX();
            y2=e.getY();
            shape s=x.get(x.size()-1);
            if(s instanceof square)
            {
                square sq=(square) s;
                sq.setX2(x2);
                sq.setY2(y2);
            }
            repaint();
            first=false;
                    
        }
        else if(mode==3)
        {
            x2=e.getX();
            y2=e.getY();
            x3=x1;
            y3=y2;
             shape s=x.get(x.size()-1);
            if(s instanceof triangle)
            {
                triangle t=(triangle) s;
                t.setX2(x2);
                t.setY2(y2);
                t.setX3(x3);
                t.setY3(y3);
            }
            repaint();
            first=false;
        }
        else if(mode==4)
        {
            x2=e.getX();
            y2=e.getY();
            shape s=x.get(x.size()-1);
            if(s instanceof circle)
            {
                circle c=(circle) s;
                c.setX2(x2);
                c.setY2(y2);
            }
            repaint();
            first=false;
        }
        else if(mode==5)
        {
            x2=e.getX();
            y2=e.getY();
            if(selectToResize!=null)
            {
            if(selectToResize instanceof rectangle)
            {
                rectangle r=(rectangle) selectToResize;
                r.setX2(x2);
                r.setY2(y2);
                   
            }
            else if(selectToResize instanceof square)
            {
                square sq=(square) selectToResize;
                sq.setX2(x2);
                sq.setY2(y2);
                   
            }
            else if(selectToResize instanceof triangle)
            {
                
                triangle t=(triangle) selectToResize;
                t.setX2(x2);
                t.setY2(y2);
            }
            else if(selectToResize instanceof circle)
            {
                circle c=(circle) selectToResize;
                c.setX2(x2);
                c.setY2(y2);
                   
            }
            repaint();
            }
        }
        else if (mode==6)
        {
            x2=e.getX();
            y2=e.getY();
            if(selectToMove!=null)
            {
                if(selectToMove instanceof rectangle)
                {
                    rectangle r=(rectangle) selectToMove;
                    int o= Math.abs(r.getX1()-r.getX2());
                    int p=Math.abs(r.getY1()-r.getY2());
                    r= new rectangle(x2,y2,o,p,current);
                    x.add(r);
                }
                repaint();
            }
        }
        else if(mode==8)
        {
            x2=e.getX();
            y2=e.getY();
            rectangle r2=null;
            if(selectToCopy !=null)
            {
                if(selectToCopy instanceof rectangle)
                {
                    rectangle r1=(rectangle)selectToCopy; 
                    
                    try {
                         r2=(rectangle)r1.clone();
                        System.out.println(r2.getX1());
                        r2.setX1(x2);
                        r2.setY1(y2);
                        
                        
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(board.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                 
            }
            x.add(r2);
            repaint();
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
}
