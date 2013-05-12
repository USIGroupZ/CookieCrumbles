/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CCFinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 *
 * @author alexm
 */
public class CCBouncer {
    
    private CCVector wallCoord;
    private Shape ccBouncerShape;
    
    public CCBouncer(double x, double y, double direction, double length){
        wallCoord = new CCVector(new CartesianCoordinate(x, y), 
                new PolarCoordinate(direction, length));
    }
    
    public CCVector getWallCoord(){
        return wallCoord;
    }
    
    public Shape getWallShape(){
        return ccBouncerShape;
    }
    
    public void draw(Graphics gr){
        Graphics2D g = (Graphics2D) gr;
        double initX = wallCoord.getX();
        double initY = wallCoord.getY();
        double direction = wallCoord.getAzimuth();
        double length = wallCoord.getLength();
        double endX = (length * Math.cos(direction)) + initX;
        double endY = (length * Math.sin(direction)) + initY;
        g.setPaint(Color.BLACK);
        Shape wall = new Line2D.Double(initX, initY, endX, endY);
        ccBouncerShape = wall;
        g.draw(ccBouncerShape);               
    }
    
    public CCVector calculateReflection(CCVector particlePosition){        
        CCVector reflected = particlePosition;
        double partDir = particlePosition.getAzimuth();
        double azimuth = 2*wallCoord.getAzimuth() - partDir;
        reflected.setAzi(azimuth); 
        return reflected;        
    }
}
    
//    public CCVector calculateReflection(CCVector particlePosition, CCVector velocity){
//        double normalDir = wallCoord.getAzimuth() + Math.PI/2;
//        CCVector normal = new CCVector (new CartesianCoordinate(particlePosition.getX(),
//                particlePosition.getY()), new PolarCoordinate(normalDir, 10));
//        double twoTimesvDotN = 2 *(particlePosition.dotProduct(normal));
//        CCVector scaled = normal.scale(twoTimesvDotN);
//        CCVector reflection =  scaled.subtract(velocity);
//        return reflection;
//    }
//    
//}
