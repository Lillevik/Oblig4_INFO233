package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

/**
 * This is the controller class where all the actions listeners
 * are placed and initialized.
 * @author marius
 */
public class ControlPanel extends JPanel {

    //Panels
    private JPanel coursePanel = new JPanel(new GridBagLayout());
    private JPanel buttonsPanel = new JPanel(new GridBagLayout());
    private JPanel loggedInPanel = new JPanel(new GridBagLayout());

    //Labels
    private JLabel titleLabel = new JLabel("Title: ");
    private JLabel descriptionLabel = new JLabel("Description: ");
    private JLabel loggedInAs = new JLabel("Not logged in: ");


    //TextFields
    private JTextField titleField = new JTextField();
    private JTextField descriptionField = new JTextField();

    //JButtons
    private JButton addCourseButton = new JButton("Add course");
    private JButton updateButton = new JButton("Update table");
    private JButton addPartsButton = new JButton("Add course parts");


    /**
     * This is the constructor for the ControlPanel.
     * It runs the placeComponents methods.
     */
    public ControlPanel(){
        setupComponents();
        placeComponentsCoursePanel();
        placeComponentsButtonPanel();
        placeComponentsLoggedInPanel();
        this.setLayout(new BorderLayout(2, 2));
        this.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Add course")));
        this.add(coursePanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.CENTER);
        this.add(loggedInPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    /**
     * This method places ans positions the components
     * in the CoursePanel using GridBagLayout
     */
    public void placeComponentsCoursePanel(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;

        gc.gridx = 0;
        gc.gridy = 0;
        coursePanel.add(titleLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        coursePanel.add(titleField, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        coursePanel.add(descriptionLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        coursePanel.add(descriptionField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        coursePanel.add(addCourseButton, gc);
    }

    /**
     * This method places ans positions the components
     * in the ButtonPanel using GridBagLayout
     */
    public void placeComponentsButtonPanel(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;

        gc.gridx = 0;
        gc.gridy = 0;
        buttonsPanel.add(updateButton, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        buttonsPanel.add(addPartsButton, gc);
    }

    /**
     * This method places ans positions the components
     * in the LoggedInPanel using GridBagLayout
     */
    public void placeComponentsLoggedInPanel(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;

        gc.gridx = 0;
        gc.gridy = 0;
        loggedInPanel.add(loggedInAs, gc);
    }

    /**
     * This method sets up some components size
     * and adds a border to the 3 different panels.
     */
    public void setupComponents(){
        this.titleField.setPreferredSize(new Dimension(150, 24));
        this.descriptionField.setPreferredSize(new Dimension(150, 24));

        coursePanel.setBorder(BorderFactory.createTitledBorder(new TitledBorder("New Course")));
        buttonsPanel.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Buttons")));
        loggedInPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    }


    public JLabel getLoggedInAs() {
        return loggedInAs;
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public JTextField getDescriptionField() {
        return descriptionField;
    }

    public JButton getAddCourseButton() {
        return addCourseButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getAddPartsButton() {
        return addPartsButton;
    }
}
