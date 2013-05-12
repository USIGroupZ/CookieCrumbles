package CCFinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.Timer;

public class Viewport extends JComponent implements ActionListener {

  private static final long serialVersionUID = 1345623525L;
  private AffineTransform transform = new AffineTransform();
  private ArrayList ccEmitterList;
  private ArrayList ccBouncerList;
  private Timer ticker;
  
  

  public Viewport() {
    initComponents();
    ticker = new Timer(10, this);
    transform.setToIdentity();
    ccEmitterList = new ArrayList ();
    ccBouncerList = new ArrayList();
    ticker.start();
    ticker.setInitialDelay(0);
    
  }
  
  public void addCCEmitter(){
      CCEmitter emitter = new CCEmitter(90, 600);
      ccEmitterList.add(emitter);
  }
  
  public void addCCBouncer(){
      CCBouncer bouncer = new CCBouncer(0, 0, Math.PI, 700);
      CCBouncer bouncer2 = new CCBouncer(0, 200, Math.PI, 900);
      CCBouncer bouncer3 = new CCBouncer(-300, -400, Math.PI/2, 900);
      CCBouncer bouncer4 = new CCBouncer(-200, -700, Math.PI/2, 900);
      ccBouncerList.add(bouncer);
      ccBouncerList.add(bouncer2);
      ccBouncerList.add(bouncer3);
      ccBouncerList.add(bouncer4);
  }
  
  
      
  

  @Override
  public void paint(final Graphics gr) {
    final Graphics2D g = (Graphics2D) gr;
    g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.setPaint(Color.WHITE);
    g.fillRect(0, 0, getWidth(), getHeight());
    final AffineTransform at = g.getTransform();
    g.transform(transform);
    
    /////// MAIN CALCULATION LOOP HERE
    if (!ccEmitterList.isEmpty()){
        for (int i = 0; i < ccEmitterList.size(); i++){
            CCEmitter emitter = (CCEmitter) ccEmitterList.get(i);
            emitter.draw(g);
            emitter.generateParticles();
            ArrayList particleList = emitter.getParticleList();
            ///CALCULATING PARTICLES 
            for (int j = 0; j < particleList.size(); j++){
                //System.out.println(particleList.size());
                CCParticle particle = (CCParticle) particleList.get(j);
                particle.moveParticle();
                particle.setInitAzi(particle.getPositionVector().getAzimuth());
                particle.draw(g);
                Shape particleShape = particle.getParticleShape();
                Rectangle2D particleRectangle = particleShape.getBounds2D();
                
                
                // =====================================                
                //// CHECKING FOR COLLISIONS WITH WALLS
                //// SKIP IF THERE ARE NO WALLS 
                // =====================================
                if (!ccBouncerList.isEmpty()){          
                    for (int b = 0; b < ccBouncerList.size(); b++){
                        CCBouncer bouncer = (CCBouncer) ccBouncerList.get(b);
                        bouncer.draw(g);
                        Shape bouncerShape = bouncer.getWallShape();
                        //// ACTUALLY CHECKING FOR COLLISIONS NOW :D
                        if (bouncerShape.intersects(particleRectangle)){
                            double newOriginX = particle.getPositionVector().getX() +particle.getOriginX();
                            double newOriginY = particle.getPositionVector().getY() +particle.getOriginY();
                            particle.setOriginX(newOriginX);
                            particle.setOriginY(newOriginY);
                            CCVector particleVector = particle.getInitVector();
                            CCVector particleVelocity = particle.getVelocity();
                            CCVector reflected = bouncer.calculateReflection(particleVector);                            
                            //System.out.println("" + particlePosition.getY()+","+reflected.getY());
                            particle.setPositionVector(reflected);
                            particle.moveParticle();
                        }                        
                    }                   
                }
                
            }
            
        }
    }
    
    
    
    
    
    
    g.setTransform(at);
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

  public AffineTransform getTransform() {
    return transform;
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
  
  
  
}
