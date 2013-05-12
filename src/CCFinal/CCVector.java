/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CCFinal;


public class CCVector {
  


    private CartesianCoordinate i;
    private PolarCoordinate j;

    

    public CCVector(CartesianCoordinate i, PolarCoordinate j) {
        this.i = i;
        this.j = j;
    }

    public CCVector add(final CCVector other) {
        if (j == null) {
            // adding two vectors here
            CartesianCoordinate k = new CartesianCoordinate(0, 0);
            double x = i.getX();
            double y = i.getY();
            double y2 = other.i.getY();
            double x2 = other.i.getX();
            double x3 = x2 + x;
            double y3 = y2 + y;
            k.setX(x3);
            k.setY(y3);

            // Calulating polar coords
            PolarCoordinate h = new PolarCoordinate(0, 0);
            double power = 2;
            double x_power = Math.pow(x3, power);
            double y_power = Math.pow(y3, power);
            double length = Math.sqrt(x_power + y_power);
            double azimuth = Math.atan2(y3, x3);
            azimuth = Math.toDegrees(azimuth);
            h.setAzimuth(azimuth);
            h.setLength(length);

            //generating return value 
            CCVector result = new CCVector(k, h);
            return result;
        } else {
            // Finding Cartesian coords of vector 1 
            double az1 = j.getAzimuth();
            az1 = Math.toRadians(az1);
            double len1 = j.getLength();
            double x1 = len1 * Math.cos(az1);
            double y1 = len1 * Math.sin(az1);

            //finding Cart Coords of vector 2
            double az2 = other.j.getAzimuth();
            az2 = Math.toRadians(az2);
            double len2 = other.j.getLength();
            double x2 = len2 * Math.cos(az2);
            double y2 = len2 * Math.sin(az2);

            //Adding coords as usual 
            double x3 = x2 + x1;
            double y3 = y2 + y1;

            //Back to polar coords 
            double power = 2;
            double x_power = Math.pow(x3, power);
            double y_power = Math.pow(y3, power);
            double length = Math.sqrt(x_power + y_power);
            double azimuth = Math.atan2(y3, x3);
            azimuth = Math.toDegrees(azimuth);

            //Returning values 
            CartesianCoordinate k = new CartesianCoordinate(0, 0);
            k.setX(x3);
            k.setY(y3);
            PolarCoordinate h = new PolarCoordinate(0, 0);
            h.setAzimuth(azimuth);
            h.setLength(length);
            CCVector result = new CCVector(k, h);
            return result;
        }
    }
    
    
    //// TO REMOVE LATER
    public double getAzimuthFromGivenCartesian(double x, double y) {
        double azimuthC = Math.atan2(y, x);
        azimuthC = Math.toDegrees(azimuthC);
        //System.out.println(azimuth);
        return azimuthC;
    }

    public CCVector subtract(final CCVector other) {
       double x1 = i.getX();
       double y1 = i.getY();
       double x2 = other.i.getX();
       double y2 = other.i.getY();
       double subX = x1-x2;
       double subY = y1-y2;
       double length = Math.sqrt((subX * subX) + (subY * subY));
       double direction = Math.atan2(subY, subX);
       //System.out.println(direction);
       CCVector result = new CCVector(new CartesianCoordinate(subX, subY), 
               new PolarCoordinate(direction, length));
       return result;

    }

    public double dotProduct(final CCVector other) {
        double x1 = i.getX();
        double y1 = i.getY();
        double x2 = other.i.getX();
        double y2 = other.i.getY();
        double dotProduct = (x1 * y1) + (x2 * y2);
        return dotProduct;
    }

    public CCVector scale(final double scaleFactor) {
        double scaledX = scaleFactor* i.getX();
        double scaledY = scaleFactor* i.getY();
        double length = Math.sqrt((scaledX * scaledX) + (scaledY * scaledY));
        double direction = Math.atan2(scaledX, scaledY);
        System.out.println(direction);
        CCVector result = new CCVector(new CartesianCoordinate(scaledX, scaledY), 
               new PolarCoordinate(direction, length));
        return result;
    }
    
    public double getAzimuth(){
        return j.getAzimuth();
    }
    
    public void setLength(double len){
        j.setLength(len);
    }


    public double getX() {
        return i.getX();

    }

    public double getY() {
        return i.getY();
    }

    public void setCoord(double x, double y) {
        i.setX(x);
        i.setY(y);
    }
    
    public void setAzi(double azi){
        j.setAzimuth(azi);
    }

    public double getLength() {
        if (j == null) {
            double x = i.getX();
            double y = i.getY();
            double power = 2;
            double x_power = Math.pow(x, power);
            double y_power = Math.pow(y, power);
            double length = Math.sqrt(x_power + y_power);
            return length;
        } else {
            double length = j.getLength();
            return length;
        }
    }

   ////REWRITE NORMALIZE METHOD 

    public CCVector move(CCVector originalPosition, double travelTime) {
        double velocity = j.getLength();
        double originalPos = originalPosition.j.getLength();
        //System.out.println("Vector" + originalPos);
        double finalpos = velocity * travelTime + originalPos;
        double direction = originalPosition.j.getAzimuth();
        double x2 = finalpos * Math.cos(direction);
        double y2 = finalpos * Math.sin(direction);
        double azimuth = Math.atan2(y2, x2);
        //azimuth = Math.toDegrees(azimuth);

        PolarCoordinate h = new PolarCoordinate(azimuth, finalpos);
        CartesianCoordinate m = new CartesianCoordinate(x2, y2);
        CCVector result = new CCVector(m, h);
        return result;

    }
}
//    public CCVector move(CCVector originalPosition, double travelTime) {
//        double CCVector = j.getLength();
////        if (CCVector> 0){
//            //CCVector = CCVector - 5.5;
//            //System.out.println(CCVector);
//            double originalPos = originalPosition.j.getLength();
//            //originalPos = originalPos-3;
//            double finalpos = CCVector * travelTime + originalPos;
//            finalpos = finalpos - 1;
//            double direction = originalPosition.j.getAzimuth();
//            direction = direction + 0.02;
//            double x2 = finalpos * Math.cos(direction);
//            x2 = x2 - 1;
//            double y2 = finalpos * Math.sin(direction);
//            y2 = y2 -1;
//            //direction = direction - 1;
//            //finalpos = finalpos - 5;
//            PolarCoordinate h = new PolarCoordinate(direction, finalpos);
//            CartesianCoordinate m = new CartesianCoordinate(x2, y2);
//            CCVector result = new CCVector(m, h);
//            return result;
//    }
//}

    


