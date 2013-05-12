/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CCFinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 *
 * @author alexm
 */
public class CCParticle {
    private CCVector position;
    private CCVector velocity;
    private double emitterOriginX;
    private double emitterOriginY;
    private int lifetime;
    private CCVector positionInit;
    private Shape particleRect;
    
    
    
    public CCParticle(double x, double y, double posDir, 
            double posLen, double speed, int lifetime){
    emitterOriginX = x;
    emitterOriginY = y;
    position = new CCVector(new CartesianCoordinate(x, y), 
            new PolarCoordinate(posDir, posLen));
    velocity = new CCVector (new CartesianCoordinate(0, 0), 
            new PolarCoordinate(0, speed));
    this.lifetime = lifetime;
    positionInit = position;
       
}
    
    public Shape getParticleShape(){
        return particleRect;
    }
    
    public void setParticleShape(Shape newShape){
        particleRect = newShape;
    }
    
    public double getOriginX(){
        return emitterOriginX;
    }
    
    public double getOriginY(){
        return emitterOriginY;
    }
    
    public void setOriginX(double x){
        emitterOriginX = x;
    }
    
    public void setOriginY(double y){
        emitterOriginY = y ;
    }
    
    
public void draw(final Graphics gr){
    Graphics2D g = (Graphics2D) gr;
    g.setPaint(Color.BLACK);
    Shape particleRectLocal = new Rectangle.Double(emitterOriginX +position.getX(), 
            emitterOriginY + position.getY(), 5,5);
    g.draw(particleRectLocal);
    particleRect = particleRectLocal;
    
}  

public void moveParticle(){
    CCVector newPos = velocity.move(position, 1);
    position = newPos;
}

public CCVector getPositionVector(){
    return position;
}

public CCVector getInitVector(){
    return positionInit;
}

public void setInitAzi(double azi){
    positionInit.setAzi(azi);
}

public void setPositionVector (CCVector newPos){
    position = newPos;
}

public CCVector getVelocity(){
    return velocity;
}

public void setVelocity(CCVector vel){
    velocity = vel;
}
    
}
