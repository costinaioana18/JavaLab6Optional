package sample;

import java.awt.geom.Ellipse2D;

/**
 * Ellipses shaped like rain drops
 */
public class RainDrop extends Ellipse2D.Double {
    /**
     * The method creates a rain drop shaped ellipse
     *
     * @param x0     the place where the shape is drawn
     * @param y0
     * @param radius the rain drop's size
     */
    public RainDrop(double x0, double y0, double radius) {
        super(x0 - radius / 2, y0 - radius / 2, radius, radius + 40);
    }
}
