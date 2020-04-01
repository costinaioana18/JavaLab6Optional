package sample;

import java.awt.*;

/**
 * polygons that look like a broken piece of glass
 */
public class BrokenGlass extends Polygon {
    /**
     * creates polygon that looks like a broken piece of glass
     *
     * @param radius the size
     * @param sides  the number of sides
     */
    public BrokenGlass(int x0, int y0, int radius, int sides) {
        double alpha = 2 * Math.PI / sides;
        for (int i = 0; i < sides; i++) {
            double x = x0 + radius * Math.cos(alpha * i) * i;
            double y = y0 + radius * Math.sin(alpha * i);
            this.addPoint((int) x, (int) y);
        }
    }
}