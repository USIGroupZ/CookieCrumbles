package ch.usi.inf.sa2.CookieCrumbles;
/**
 *
 * @author A.Mamyshev / R.Seyidov
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.Random;
import javax.swing.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Viewport extends JComponent implements ActionListener {

    private AffineTransform transform = new AffineTransform();
    
    
    
    private ArrayList emitterList;
    private ArrayList emitterListBH;
    private Timer timer;
    double x;
    double y;

    public Viewport() {
        
        initComponents();
        timer = new Timer(10, this);
        emitterList = new ArrayList();
        emitterListBH = new ArrayList();
        timer.start();
        timer.setInitialDelay(0);
        //repaint();
        x = 0;
        y = 0;
        transform.setToIdentity();
    }

    public void Simulation1(){
        ParticleEmitter emitter = new ParticleEmitter(-200,0, 5);
        emitterList.add(emitter);
    }
    
    public void Simulation2(){
        ParticleEmitterBH emitter = new ParticleEmitterBH(-200,0, 5);
        emitterListBH.add(emitter);
    }
        
    public ArrayList getEmitterList(){
        return emitterList;
    }
    
    public ArrayList getEmitterListBH(){
        return emitterListBH;
    }
    
    public void clearEverything(){
        if (!emitterList.isEmpty()){
            
        ParticleEmitter emitter = (ParticleEmitter) emitterList.get(0);
        emitterList.remove(emitter);
    
    }
        if (!emitterListBH.isEmpty()){
           ParticleEmitterBH emitter = (ParticleEmitterBH) emitterListBH.get(0); 
        emitterListBH.remove(emitter);
        }
    }
        
    
    
     private double originRandomizer(){
         Random rand = new Random();
         int min = -900;
         int max = 900;
         double randomNum = rand.nextInt(max - min + 1) + min;
         return randomNum;
     }
     
    @Override
        public void paint(final Graphics gr) {
        
        Graphics2D g = (Graphics2D) gr;
        super.paint(g);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setPaint(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        final AffineTransform at = g.getTransform();
        g.transform(transform);
        
        if (emitterList != null){
                
        for (int i = 0; i < emitterList.size(); i++){
            
            ParticleEmitter emitter = (ParticleEmitter) emitterList.get(i);
            g.setPaint(Color.RED);
            g.fillOval((int)emitter.getOriginX(),(int) emitter.getOriginY() , 30, 30);
            emitter.recalculate(g);
            
        }}
        
        if (emitterListBH != null){
        
        for (int j = 0; j < emitterListBH.size(); j++){
            
            ParticleEmitterBH emitter = (ParticleEmitterBH) emitterListBH.get(j);
            g.setPaint(Color.ORANGE);
            g.fillOval((int)emitter.getOriginX(),(int) emitter.getOriginY() , 30, 30);
            emitter.recalculate(g);
        }
        }
        
                
        
            
        
        
       
//        for (int i = 0; i <5; i++) {
//        final Particle myparticle = new Particle(0, 0, directionRandomizer(), lengthRandomizer(), directionRandomizer(), lengthRandomizer(), (int) lengthRandomizer());
//        particleList.add(myparticle);
//        }
        //System.out.println(particleList);
//        for (int i = 0; i < particleList.size(); i++) {
//            Particle part = (Particle) particleList.get(i);
//            int lifetime = part.getLifetime();
//            lifetime++;
//            part.setLifetime(lifetime);
//            part.setNewPosition();
//            x = part.positionGetX();
//            y = part.positionGetY();
//            //System.out.println(particleList);
//            g.fillRect((int) x, (int) y, 5, 5);
            
//            if (lifetime > 1000) {
//                particleList.remove(part);
//                part = null;
//            }
        
        g.setTransform(transform);
        g.dispose();
        
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Viewport.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }

    public double lengthRandomizer() {
        Random rand = new Random();
        double randomNum = rand.nextInt(100) + 1;
        return randomNum;
    }

    public double directionRandomizer() {
        Random rand = new Random();
//        int min = 1;
//        int max = 360;
//        double randomNum = rand.nextInt(max - min + 1) + min;
        double randomNum = rand.nextDouble()/2;
        return randomNum;

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
