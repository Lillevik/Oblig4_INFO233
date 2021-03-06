package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

/**
 * This is the controller class where all the actions listeners
 * are placed and initialized.
 * @author puz001, esj002
 */
public class ControlPanel extends JPanel {

    //Panels
    private final JPanel coursePanel = new JPanel(new GridBagLayout());
    private final JPanel buttonsPanel = new JPanel(new GridBagLayout());
    private final JPanel loggedInPanel = new JPanel(new GridBagLayout());

    //Labels
    private final JLabel titleLabel = new JLabel("Title: ");
    private final JLabel descriptionLabel = new JLabel("Description: ");
    private final JLabel loggedInAs = new JLabel("Not logged in: ");


    //TextFields
    private final JTextField titleField = new JTextField();
    private final JTextField descriptionField = new JTextField();

    //JButtons
    private final JButton addCourseButton = new JButton("Add course");
    private final JButton updateButton = new JButton("Update table");
    private final JButton addPartsButton = new JButton("Add course parts");
    private final JButton deleteCourseButton = new JButton("Delete");
    private final JButton viewStudents = new JButton("View Students");
    private final JButton courseGrades = new JButton("View Fianl Grades");


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
    private void placeComponentsCoursePanel(){
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

        gc.gridx = 1;
        gc.gridy = 2;
        coursePanel.add(deleteCourseButton, gc);
    }

    /**
     * This method places ans positions the components
     * in the ButtonPanel using GridBagLayout
     */
    private void placeComponentsButtonPanel(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;

        gc.gridx = 0;
        gc.gridy = 0;
        buttonsPanel.add(updateButton, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        buttonsPanel.add(addPartsButton, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        buttonsPanel.add(viewStudents, gc);

        gc.gridx = 0;
        gc.gridy = 6;
        buttonsPanel.add(courseGrades, gc);

    }

    /**
     * This method places ans positions the components
     * in the LoggedInPanel using GridBagLayout
     */
    private void placeComponentsLoggedInPanel(){
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
    private void setupComponents(){
        this.titleField.setPreferredSize(new Dimension(150, 24));
        this.descriptionField.setPreferredSize(new Dimension(150, 24));

        coursePanel.setBorder(BorderFactory.createTitledBorder(new TitledBorder("New Course")));
        buttonsPanel.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Buttons")));
        loggedInPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    }


    /**
     * This is a getter for the loggedInAs field
     * @return - The JLabel value from the loggedInAs field
     */
    public JLabel getLoggedInAs() {
        return loggedInAs;
    }

    /**
     * This is a getter for the titleField field
     * @return - The JTextField value from the titleField field
     */
    public JTextField getTitleField() {
        return titleField;
    }

    /**
     * This is a getter for the descriptionField field
     * @return - The JTextField value from the descriptionField field
     */
    public JTextField getDescriptionField() {
        return descriptionField;
    }

    /**
     * This is a getter for the addCourseButton field
     * @return - The JButton value from the addCourseButton field
     */
    public JButton getAddCourseButton() {
        return addCourseButton;
    }

    /**
     * This is a getter for the updateButton field
     * @return - The JButton value from the updateButton field
     */
    public JButton getUpdateButton() {
        return updateButton;
    }

    /**
     * This is a getter for the addPartsButton field
     * @return - The JButton value from the addPartsButton field
     */
    public JButton getAddPartsButton() {
        return addPartsButton;
    }

    /**
     * This is a getter for the deleteCourseButton field
     * @return - The JButton value from the deleteCourseButton field
     */
    public JButton getDeleteCourseButton() {
        return deleteCourseButton;
    }

    /**
     * This is a getter for the viewStudents field
     * @return - The JButton value from the viewStudents field
     */
    public JButton getViewStudents() {
        return viewStudents;
    }

    /**
     * This is a getter for the deleteCourseButton field
     * @return - The JButton value from the deleteCourseButton field
     */
    public JButton getCourseGrades() {
        return courseGrades;
    }
}
