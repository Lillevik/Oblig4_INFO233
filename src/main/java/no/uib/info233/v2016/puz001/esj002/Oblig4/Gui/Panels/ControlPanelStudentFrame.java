package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

/**
 * This is the controller class where all the actions listeners
 * are placed and initialized.
 * @author puz001, esj002
 */
public class ControlPanelStudentFrame extends JPanel {

    //Panels
    private final JPanel coursePanel = new JPanel(new GridBagLayout());
    private final JPanel buttonsPanel = new JPanel(new GridBagLayout());
    private final JPanel loggedInPanel = new JPanel(new GridBagLayout());


    //Labels
    private final JLabel nameLabel = new JLabel("Name : ");
    private final JLabel loggedInAs = new JLabel("Not logged in: ");
    private final JLabel results = new JLabel("Found students");
    private final JLabel addStudentInfo = new JLabel("Add selected students -> ");


    //TextFields
    private final JTextField nameField = new JTextField();


    //JButtons
    private final JButton searchButton = new JButton("Search");
    private final JButton addStudentsButton = new JButton("Add");


    /**
     * This is the constructor for the ControlPanel.
     * It runs the placeComponents methods.
     */
    public ControlPanelStudentFrame(){
        setupComponents();
        placeComponentsCoursePanel();
        placeComponentsButtonPanel();
        placeComponentsLoggedInPanel();
        this.setLayout(new BorderLayout(2, 2));
        this.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Add students")));
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
        coursePanel.add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        coursePanel.add(nameField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        coursePanel.add(searchButton, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        coursePanel.add(results, gc);
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
        buttonsPanel.add(addStudentInfo, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        buttonsPanel.add(addStudentsButton, gc);

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
        this.nameField.setPreferredSize(new Dimension(150, 24));

        coursePanel.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Students")));
        buttonsPanel.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Buttons")));
        loggedInPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    /**
     * This is a getter for the searchButton field
     * @return - The JButton value from the searchButton field
     */
    public JButton getSearchButton() {
        return searchButton;
    }

    /**
     * This is a getter for the loggedInAa field
     * @return - The JLabel value from the loggedInAs field
     */
    public JLabel getLoggedInAs() {
        return loggedInAs;
    }

    /**
     * This is a getter for the nameField field
     * @return - The JTextField value from the nameField field
     */
    public JTextField getNameField() {
        return nameField;
    }

    /**
     * This is a getter for the results field
     * @return - The JLabel value from the results field
     */
    public JLabel getResults() {
        return results;
    }

    /**
     * This is a getter for the addStudentsButton field
     * @return - The JButton value from the addStudentsButton field
     */
    public JButton getAddStudentsButton() {
        return addStudentsButton;
    }
}
