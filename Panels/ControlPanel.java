package sample;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

/**
 * The bottom part of the frame, containing Save, Load, Reset and Exist buttons
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;
    /**
     * creating the buttons
     */
    JButton saveButton = new JButton("Save");
    JButton loadButton = new JButton("Load");
    JButton resetButton = new JButton("Reset");
    JButton exitButton = new JButton("Exit");

    /**
     * The method adds all the created buttons and configures listeners for each of them
     */
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        add(saveButton);
        add(loadButton);
        add(resetButton);
        add(exitButton);

        loadButton.addActionListener(this::load);
        saveButton.addActionListener(this::save);
        resetButton.addActionListener(this::reset);
        exitButton.addActionListener(this::exit);

    }

    /**
     * The method lets us choose a file
     * The method saves the picture in the chosen file
     */
    private void save(ActionEvent e) {
        try {
            JFileChooser file = new JFileChooser();
            file.setDialogTitle("Save the image to: ");

            int returnValue = file.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File myFile = file.getSelectedFile();
                ImageIO.write(frame.canvas.image, "PNG", new File(myFile.getAbsolutePath()));
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

    /**
     * The method lets us choose a file
     * The method loads the chosen image
     */
    private void load(ActionEvent e) {
        try {
            JFileChooser file = new JFileChooser();
            file.setDialogTitle("Load an image from: ");

            int returnValue = file.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File myFile = file.getSelectedFile();
                BufferedImage image = ImageIO.read(new File(myFile.getAbsolutePath()));
                frame.canvas.graphics.drawImage(image, 0, 0, this);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }


    /**
     * The method clears the drawing area
     */
    private void reset(ActionEvent e) {
        frame.canvas.clear();
    }

    /**
     * The method closes the app
     */
    private void exit(ActionEvent e) {
        System.exit(0);
    }
}