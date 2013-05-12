/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CCFinal;

/**
 *
 * @author alexm
 */
public class PolarCoordinate {
    
private double azimuth;
    private double length;

    public PolarCoordinate(double azimuth, double length) {
        this.azimuth = azimuth;
        this.length = length;

    }

    public double getAzimuth() {
        return azimuth;
    }

    public double getLength() {
        return length;
    }

    public void setAzimuth(double azimuth) {
        this.azimuth = azimuth;
    }

    public void setLength(double length) {
        this.length = length;
    }
    

    public void addAcceleration(PolarCoordinate pc) {
        pc = new PolarCoordinate(azimuth, length);
        double azim = this.azimuth + pc.azimuth;
        double leng = this.length + pc.length;
        this.azimuth = azim;
        this.length = leng;
    }

    public void addVelocity(PolarCoordinate vc) {
        vc = new PolarCoordinate(azimuth, length);
        double azim = this.azimuth + vc.azimuth;
        double leng = this.length + vc.length;
        this.azimuth = azim;
        this.length = leng;
    }
}
