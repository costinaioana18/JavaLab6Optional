package sample;

import java.awt.geom.Ellipse2D;

/**
 * simple filled circles
 */
public class Circle extends Ellipse2D.Double {
    /**
     * Creates a filled circle
     */
    public Circle(double x0, double y0, double radius) {
        super(x0 - radius / 2, y0 - radius / 2, radius, radius);
    }
}
