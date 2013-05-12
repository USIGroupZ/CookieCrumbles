package CCFinal;

import java.awt.EventQueue;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class CookieCrumblesMain extends JFrame {

  private static final Logger LOG = Logger.getLogger("Viewport");
  private static final DecimalFormat DF = (DecimalFormat) DecimalFormat.getInstance();
  private static final long serialVersionUID = 1234234L;

  static {
    DF.setRoundingMode(RoundingMode.HALF_UP);
    DF.setMaximumFractionDigits(3);
  }
  private AffineTransform originalTransform;
  private Point2D mouseOrigin;

  public CookieCrumblesMain() {
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
        viewport = new CCFinal.Viewport();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Translation:");

        translation.setEditable(false);
        translation.setText("0, 0");
        translation.setName(""); // NOI18N

        jLabel2.setText("Zoom:");

        zoom.setEditable(false);
        zoom.setText("1");

        viewport.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                mouseWheel(evt);
            }
        });
        viewport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mouseDown(evt);
            }
        });
        viewport.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mouseDrag(evt);
            }
        });

        jButton1.setText("AddEmitter");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Add Line");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(viewport, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 617, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(6, 6, 6)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jButton2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .add(18, 18, 18)
                        .add(translation, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(6, 6, 6)
                        .add(jLabel2)
                        .add(18, 18, 18)
                        .add(zoom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(viewport, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 438, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(201, 201, 201)
                        .add(jButton1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton2)))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(translation, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(zoom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void mouseWheel(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_mouseWheel
    try {
      final double factor = Math.pow(2, -evt.getPreciseWheelRotation() / 10);
      final Point2D mouse = viewport.getTransform().inverseTransform(evt.getPoint(), null);
      viewport.getTransform().translate(mouse.getX(), mouse.getY());
      viewport.getTransform().scale(factor, factor);
      viewport.getTransform().translate(-mouse.getX(), -mouse.getY());
      viewport.repaint();
      zoom.setText(DF.format(viewport.getTransform().getScaleX()));
    } catch (NoninvertibleTransformException ex) {
      Logger.getLogger(CookieCrumblesMain.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_mouseWheel

  private void mouseDown(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseDown
    try {
      mouseOrigin = viewport.getTransform().inverseTransform(evt.getPoint(), null);
      originalTransform = (AffineTransform) viewport.getTransform().clone();
    } catch (NoninvertibleTransformException ex) {
      LOG.log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_mouseDown

  private void mouseDrag(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseDrag
    try {
      final Point2D current = originalTransform.inverseTransform(evt.getPoint(), null);
      final double tx = current.getX() - mouseOrigin.getX();
      final double ty = current.getY() - mouseOrigin.getY();
      mouseOrigin = current;
      viewport.getTransform().translate(tx, ty);
      viewport.repaint();
      translation.setText(DF.format(viewport.getTransform().getTranslateX()) + ", " + DF.format(viewport.getTransform().getTranslateY()));
    } catch (NoninvertibleTransformException ex) {
      LOG.log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_mouseDrag

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        viewport.addCCEmitter();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        viewport.addCCBouncer();
    }//GEN-LAST:event_jButton2MouseClicked

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField translation;
    private CCFinal.Viewport viewport;
    private javax.swing.JTextField zoom;
    // End of variables declaration//GEN-END:variables
}
