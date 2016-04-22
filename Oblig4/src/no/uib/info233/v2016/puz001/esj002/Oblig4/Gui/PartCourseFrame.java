package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by goat on 21.04.16.
 */
public class PartCourseFrame extends JFrame {
    //Layouts
    private LayoutManager layout = new BorderLayout(3, 3);
    private LayoutManager gridBag = new GridBagLayout();

    //Panels
    private JPanel north = new JPanel(gridBag);
    private JPanel center = new JPanel(gridBag);

    //Labels
    private JLabel partNameLabel = new JLabel("Title: ");
    private JLabel weigthLabel = new JLabel("Weigth: ");
    private JLabel partTitleLabel = new JLabel("Part evaluation");

    //Buttons
    private JButton button = new JButton("Button");

    //ComboBoxes
    private ArrayList weigth = new ArrayList<String>();
    private JComboBox chooseWeigth;

    //TextFields
    private JTextField nameField = new JTextField();



    public PartCourseFrame(){
        fillWeigthList();
        chooseWeigth = new JComboBox(weigth.toArray());
        setPreferredSize(new Dimension(600, 600));
        setLayout(layout);
        setupCmponents();
        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        setVisible(true);
        pack();

    }

    public void setupCmponents(){
        north.setPreferredSize(new Dimension(100, 100));
        center.setPreferredSize(new Dimension(100, 100));
        chooseWeigth.setPreferredSize(new Dimension(150, 20));
        nameField.setPreferredSize(new Dimension(150, 24));

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;

        //Center Panel
        gc.gridx = 0;
        gc.gridx = 0;
        center.add(partNameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        center.add(nameField, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        center.add(weigthLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        center.add(chooseWeigth, gc);

        //North Panel
        gc.gridx = 0;
        gc.gridy = 0;
        north.add(partTitleLabel, gc);
    }


    public void fillWeigthList(){
        for(int i = 20; i  < 101; i++){
            weigth.add(i + "%");
        }
    }


}
