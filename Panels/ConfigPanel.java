package sample;

import javax.swing.*;

/**
 * The top part of the frame, where the tool type, shape type, size, sides number and color labels are
 */
public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel typeLabel;
    JComboBox shapeType;
    JLabel sidesLabel;
    JSpinner sidesNumber;
    JLabel colorLabel;
    JComboBox shapeColor;
    JLabel sizeLabel;
    JSpinner shapeSize;
    JLabel toolLabel;
    JComboBox toolType;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * the method creates and adds all the configuration panel's components (tool type, shape type, size, color labels)
     */
    private void init() {

        /**
         * creating the tool label
         */
        toolLabel = new JLabel("Tool: ");
        String[] toolTypes = {"Painter", "Rubber"};
        toolType = new JComboBox(toolTypes);
        toolType.setSelectedIndex(0);


        /**
         *creating the type label
         */
        typeLabel = new JLabel("Type: ");
        String[] types = {"Regular", "Circle", "Rain drop", "Broken glass"};
        shapeType = new JComboBox(types);
        shapeType.setSelectedIndex(0);

        /**
         * creating the sides number label
         */
        sidesLabel = new JLabel("Sides number:  ");
        sidesNumber = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));
        sidesNumber.setValue(3); //default number of sides

        /**
         * creating the shape's size label
         */
        sizeLabel = new JLabel("Size:  ");
        shapeSize = new JSpinner(new SpinnerNumberModel(10, 10, 100, 10));
        shapeSize.setValue(20);

        /**
         * creating the shape's color label
         */
        colorLabel = new JLabel("Color: ");
        String[] colors = {"Random", "Pink", "Black", "Blue", "Purple", "Green"};
        shapeColor = new JComboBox(colors);
        shapeColor.setSelectedIndex(0);

        add(toolLabel);
        add(toolType);
        add(typeLabel);
        add(shapeType);
        add(sidesLabel);
        add(sidesNumber);
        add(colorLabel);
        add(shapeColor);
        add(sizeLabel);
        add(shapeSize);
    }

}