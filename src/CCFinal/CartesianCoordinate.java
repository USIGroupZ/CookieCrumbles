/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CCFinal;

/**
 *
 * @author alexm
 */
public class CartesianCoordinate {
    
    private double x;
    private double y;

    public CartesianCoordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
