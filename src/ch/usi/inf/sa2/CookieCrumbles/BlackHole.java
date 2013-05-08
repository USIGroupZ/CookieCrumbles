/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.usi.inf.sa2.CookieCrumbles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

/**
 *
 * @author ruslanseyidov
 */
public class BlackHole {
    double x;
    double y;
    
    public BlackHole() {
        double xb = this.x;
        double yb = this.y;
    }

    public BlackHole(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    
    public double getX(){
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setX(double sx) {
        x = sx;
    }
    
    public void setY(double sy) {
        y = sy;
    }

    public void paint(final Graphics gr) {

        Graphics2D g = (Graphics2D) gr;
        //super.

        g.setPaint(Color.WHITE);
        BlackHole BH = new BlackHole();
        g.fillOval((int)BH.getX(),(int) BH.getY(), 150, 150);
    
    }
}

