package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * The middle part of the frame, where the shapes are drawn after getting the right characteristics
 */
public class DrawingPanel extends JPanel {

    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    /**
     * sets the frame's background color and size
     */
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    /**
     * The method makes sure to call the drawShape(mouseX,mouseY) function everytime the mouse is pressed
     */
    private void init() {
        setPreferredSize(new Dimension(W, H));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    /**
     * The method gets and sets the following characteristics: tool type(Painter/ Rubber), type, size, color and sides number, and then it draws the shape/ deletes a shape
     *
     * @param x mousex --the x and y where the shape is drawn/ deleted
     * @param y mousey
     */
    private void drawShape(int x, int y) {

        /**
         * getting and setting the selected tool type (painter tool or rubber)
         */
        String tool = String.valueOf(frame.configPanel.toolType.getSelectedItem());

        /**
         * getting & setting the selected size
         */
        int shSize = (int) frame.configPanel.shapeSize.getValue();

        /**
         * getting & setting the selected nr of sides
         */
        int sides = (int) frame.configPanel.sidesNumber.getValue();

        /**
         * Getting & generating the selected color if we selected the painting tool
         */
        Color color = Color.black;
        if (tool.equals("Painter")) {
            String col = String.valueOf(frame.configPanel.shapeColor.getSelectedItem());
            if (col.equals("Pink")) color = new Color(255, 204, 255);
            if (col.equals("Black")) color = new Color(0, 0, 0);
            if (col.equals("Blue")) color = new Color(153, 204, 255);
            if (col.equals("Green")) color = new Color(0, 255, 0);
            if (col.equals("Purple")) color = new Color(178, 102, 255);
            if (col.equals("Random")) {
                Random rand = new Random();
                int R, G, B;
                R = rand.nextInt(255);
                G = rand.nextInt(255);
                B = rand.nextInt(255);
                color = new Color(R, G, B);
            }
            graphics.setColor(color);
        }
        /**
         * Getting and setting the shape type
         */
        String type = String.valueOf(frame.configPanel.shapeType.getSelectedItem());

        /**
         * drawing the actual shapes/ using the rubber if selected
         */
        if (tool.equals("Painter")) {
            if (type.equals("Regular"))
                graphics.fill(new RegularPolygon(x, y, shSize, sides));
            if (type.equals("Circle"))
                graphics.fill(new Circle(x, y, shSize));
            if (type.equals("Rain drop"))
                graphics.fill(new RainDrop(x, y, shSize));
            if (type.equals("Broken glass"))
                graphics.fill(new BrokenGlass(x, y, shSize, sides));
        } else if (tool.equals("Rubber")) {
            color = new Color(255, 255, 255);
            graphics.setColor(color);
            graphics.fill(new Circle(x, y, 50));
        }
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    /**
     * The method clears the drawing area
     */
    public void clear() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
        updateUI();
    }
}