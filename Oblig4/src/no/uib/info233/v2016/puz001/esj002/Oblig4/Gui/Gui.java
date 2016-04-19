package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created 18.04.2016.
 */
public class Gui extends JFrame {


    //These are the fields of the IssuePanel class.
    private static final long serialVersionUID = 4161520540703687836L;
    private JLabel priority = new JLabel("Grade:");
    private JLabel locationField = new JLabel("Course:");
    private JTextField locationText = new JTextField();
    private JButton createButton = new JButton("Create");
    private JButton backButton = new JButton("Cancel");
    private String[] grades = {"A", "B", "C", "D", "E", "F"};
    private JComboBox gradeChooser = new JComboBox(grades);
    private JPanel spine = new JPanel(new BorderLayout(1, 1));

    public Gui(){
        super("Course planner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 650));
        setResizable(true);
        placeComponents(spine);
        setContentPane(spine);
        pack();
        setVisible(true);
    }




    /**
     * This is the method that sets up and add all the
     * components to the panel.
     * @param panel
     */
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);


        priority.setBounds(200, 240, 80, 25);
        panel.add(priority);

        gradeChooser.setBounds(290, 240, 160, 25);
        panel.add(gradeChooser);

        locationField.setBounds(200, 280, 80, 25);
        panel.add(locationField);

        locationText.setBounds(290, 280, 160, 25);
        panel.add(locationText);

        createButton.setBounds(275, 480, 80, 25);
        panel.add(createButton);

        backButton.setBounds(390, 480, 80, 25);
        panel.add(backButton);
    }

    /**
     * This is a getter for the field locationText
     * which is used to get location of an issue.
     * @return the locationText
     */
    public JTextField getLocationText() {
        return locationText;
    }


    /**
     * This is the button that creates the issue
     * and returns the user to the main window.
     * @return the createButton
     */
    public JButton getCreateButton() {
        return createButton;
    }

    /**
     * @return the backButton
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * @param backButton the backButton to set
     */
    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }


    public JComboBox getGradeChooser(){
        return this.gradeChooser;
    }

    public void closeWindow(){
        System.exit(0);
    }

}
