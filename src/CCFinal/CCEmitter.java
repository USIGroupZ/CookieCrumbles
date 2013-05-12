/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CCFinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author alexm
 */
public class CCEmitter {
    
    private double originX;
    private double originY; 
    private Shape CCEmitterShape;
    private ArrayList particleList;
    
    
    public CCEmitter(double x, double y){
        originX = x;
        originY = y;
        particleList = new ArrayList();
               
    }
    
   public void draw(final Graphics gr){
    Graphics2D g = (Graphics2D) gr;
    g.setPaint(Color.RED);
    Shape emitterCircle = new Ellipse2D.Double(originX-13, originY-13, 30, 30);
    CCEmitterShape = emitterCircle;
    g.fill(emitterCircle);
}  
   
   public double directionSetter(){
      Random rand = new Random();
      double direction = Math.PI*2;
      double spread = Math.PI;
      double randomNum = direction + (spread  - direction) * rand.nextDouble();
      return randomNum;
   }
   
   public void generateParticles(){
       for ( int i = 0; i < 2; i++){  
           CCParticle particle = new CCParticle(originX, originY, directionSetter(), 0, 1, 30);
           particleList.add(particle);
       }
   }
   
   public ArrayList getParticleList(){
       return particleList;
   }
}
