package ch.usi.inf.sa2.CookieCrumbles;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class CookieCrumblesMain extends JFrame {
    

    private static final Logger LOG = Logger.getLogger("Viewport");
    private static final DecimalFormat DF = (DecimalFormat) DecimalFormat.getInstance();
    private AffineTransform originalTransform;
    private Point2D initPos;
    private int  posX;
    private int posY;
    

    public CookieCrumblesMain() {
        System.setProperty("sun.java2d.opengl","True");
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        translation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        zoom = new javax.swing.JTextField();
        viewport = new ch.usi.inf.sa2.CookieCrumbles.Viewport();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        doubleJSlider1 = new ch.usi.inf.sa2.CookieCrumbles.doubleJSlider();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        doubleJSlider2 = new ch.usi.inf.sa2.CookieCrumbles.doubleJSlider();
        jLabel6 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Translation:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        translation.setEditable(false);
        translation.setText("0, 0");
        translation.setName(""); // NOI18N
        getContentPane().add(translation, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 224, -1));

        jLabel2.setText("Zoom:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 456, -1, -1));

        zoom.setEditable(false);
        zoom.setText("1");
        getContentPane().add(zoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 450, 208, -1));

        viewport.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                viewportMouseWheelMoved(evt);
            }
        });
        viewport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                viewportMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewportMouseClicked(evt);
            }
        });
        viewport.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                viewportMouseDragged(evt);
            }
        });
        viewport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(viewport, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 807, 438));

        jButton1.setText("Sim1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, -1, -1));

        jButton5.setText("Sim2");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, -1, -1));

        jButton6.setText("CLS");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 450, -1, -1));

        doubleJSlider1.setDoubleMaximum(359.0);
        doubleJSlider1.setDoubleValue(0.0);
        doubleJSlider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                doubleJSlider1MouseDragged(evt);
            }
        });
        getContentPane().add(doubleJSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, -1, -1));

        jLabel3.setText("0.0");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 40, -1));

        jLabel4.setText("Direction");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        jLabel5.setText("Spread");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, -1, -1));

        doubleJSlider2.setDoubleValue(0.0);
        doubleJSlider2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                doubleJSlider2MouseDragged(evt);
            }
        });
        getContentPane().add(doubleJSlider2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, -1, -1));

        jLabel6.setText("0.0");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, -1, 20));

        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(1);
        jSlider1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jSlider1MouseDragged(evt);
            }
        });
        getContentPane().add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 490, 130, -1));

        jLabel7.setText("Density");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 500, -1, -1));

        jLabel8.setText("1");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 500, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewportMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewportMouseDragged
        try {
            Point2D currentPos = originalTransform.inverseTransform(evt.getPoint(), null);
            double x1 = currentPos.getX();
            double y1 = currentPos.getY();
            double x2 = initPos.getX();
            double y2 = initPos.getY();
            double transform_x = x1 - x2;
            double transform_y = y1 - y2;
            initPos = currentPos;
            viewport.getTransform().translate(transform_x, transform_y);
            viewport.repaint();
            int print_x = (int) viewport.getTransform().getTranslateX();
            int print_y = (int) viewport.getTransform().getTranslateY();
            translation.setText("" + print_x + "," + print_y);
            
//            ArrayList emitterList = viewport.getEmitterList();
//            for ( int i = 0; i < emitterList.size(); i++){
//                ParticleEmitter emitter = (ParticleEmitter) emitterList.get(i);
//                Rectangle boundingBox = emitter.getBoundingBox();
//                
//                if (boundingBox.contains(x2 , y2 )){
//                    System.out.println("Mouse over emitter");
//                    double originalX = emitter.getOriginX();
//                    double originalY = emitter.getOriginY();
//                    double hix = evt.getX();
//                    double hiy = evt.getY();
//                    repaint();
//                    double updatedX = originalX + hix - posX;
//                    double updatedY = originalY + hiy - posY;
//                    
//                   
//                    Rectangle updatedPos = new Rectangle((int) updatedX, (int) updatedY, 35, 35);
//                    emitter.setBoundingBox(updatedPos);
//                    
//                    
//                    emitter.setOriginX( updatedX);
//                    emitter.setOriginY( updatedY);
//                    posX = (int) updatedX ;
//                    posY = (int) updatedY;
//                    repaint();
                    
                    
                
        } catch (NoninvertibleTransformException ex) {
            Logger.getLogger(CookieCrumblesMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewportMouseDragged

    private void viewportMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewportMousePressed
        try {
            initPos = viewport.getTransform().inverseTransform(evt.getPoint(), null);
            originalTransform = (AffineTransform) viewport.getTransform().clone();
            posX = evt.getX();
            posY = evt.getY();
            
            
                
                
                
            }
         catch (NoninvertibleTransformException ex) {
            Logger.getLogger(CookieCrumblesMain.class.getName()).log(Level.SEVERE, null, ex);
        
         }
    }//GEN-LAST:event_viewportMousePressed

    private void viewportMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_viewportMouseWheelMoved
        try {
            double scalefactor = Math.pow(2, -evt.getPreciseWheelRotation() / 10);
            Point2D mouse = viewport.getTransform().inverseTransform(evt.getPoint(), null);
            double x1 = mouse.getX();
            double y1 = mouse.getY();
            viewport.getTransform().translate(x1, y1);
            viewport.getTransform().scale(scalefactor, scalefactor);
            viewport.getTransform().translate(-x1, -y1);
            viewport.repaint();
            double print_scale = viewport.getTransform().getScaleY();
            zoom.setText("" + DF.format(print_scale));
            

        } catch (NoninvertibleTransformException ex) {
            Logger.getLogger(CookieCrumblesMain.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_viewportMouseWheelMoved

    private void viewportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewportMouseClicked
        DoubleManipulator da = new DoubleManipulator();
        da.setDefaultCloseOperation(da.DISPOSE_ON_CLOSE);
        if (SwingUtilities.isRightMouseButton(evt)) {
            int x = evt.getX();
            int y = evt.getY();
            System.out.println(x);
            System.out.println(y);

            da.setVisible(true);
            da.setLocation(x, y);
        } else {
            da.setVisible(false);
        }

    }//GEN-LAST:event_viewportMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        viewport.clearEverything();
        viewport.Simulation1();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        viewport.clearEverything();
        viewport.Simulation2();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        viewport.clearEverything();
    }//GEN-LAST:event_jButton6MouseClicked

    private void doubleJSlider1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doubleJSlider1MouseDragged
        doubleJSlider1.setDoubleMinimum(0d);
        doubleJSlider1.setDoubleMaximum(360d);
        double value = doubleJSlider1.getValue()/100;
        jLabel3.setText(""+value);
        double valueRad = Math.toRadians(value);
        ArrayList emitterList = viewport.getEmitterList();
        ArrayList emitterListBF = viewport.getEmitterListBH();
        if (!emitterList.isEmpty()){
           ParticleEmitter emitter = (ParticleEmitter) emitterList.get(0);
           emitter.setDirection(valueRad);
        }
//        if (!emitterListBF.isEmpty()){
//            ParticleEmitterBH emitter = (ParticleEmitterBH) emitterListBF.get(0);
//            emitter.setDirection(valueRad);
//        }
        
    }//GEN-LAST:event_doubleJSlider1MouseDragged

    private void doubleJSlider2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doubleJSlider2MouseDragged
        doubleJSlider2.setDoubleMinimum(0d);
        doubleJSlider2.setDoubleMaximum(360d);
        double value = doubleJSlider2.getValue()/100;
        jLabel6.setText(""+value);
        double valueRad = Math.toRadians(value);
        ArrayList emitterList = viewport.getEmitterList();
        ArrayList emitterListBF = viewport.getEmitterListBH();
         if (!emitterList.isEmpty()){
           ParticleEmitter emitter = (ParticleEmitter) emitterList.get(0);
           emitter.setSpread(valueRad);
        }
//        if (!emitterListBF.isEmpty()){
//             ParticleEmitterBH emitter = (ParticleEmitterBH) emitterListBF.get(0);
//           emitter.setSpread(valueRad);
//        }
    }//GEN-LAST:event_doubleJSlider2MouseDragged

    private void jSlider1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseDragged
        jSlider1.setMinimum(1);
        jSlider1.setMaximum(5);
        int value = jSlider1.getValue();
        jLabel8.setText(""+value);
        ArrayList emitterList = viewport.getEmitterList();
        ArrayList emitterListBF = viewport.getEmitterListBH();
         if (!emitterList.isEmpty()){
           ParticleEmitter emitter = (ParticleEmitter) emitterList.get(0);
           emitter.setDensity(value);
        }
//        if (!emitterListBF.isEmpty()){
//            ParticleEmitterBH emitter = (ParticleEmitterBH) emitterListBF.get(0);
//           emitter.setDensity(value);
//        }
                                        
        
        
    }//GEN-LAST:event_jSlider1MouseDragged

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CookieCrumblesMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CookieCrumblesMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CookieCrumblesMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CookieCrumblesMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CookieCrumblesMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ch.usi.inf.sa2.CookieCrumbles.doubleJSlider doubleJSlider1;
    private ch.usi.inf.sa2.CookieCrumbles.doubleJSlider doubleJSlider2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField translation;
    private ch.usi.inf.sa2.CookieCrumbles.Viewport viewport;
    private javax.swing.JTextField zoom;
    // End of variables declaration//GEN-END:variables
}
