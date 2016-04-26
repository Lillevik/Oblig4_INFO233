package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.DataStores;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

/**
 * This is the controller class where all the actions listeners
 * are placed and initialized.
 * @author marius
 */
public class ControlPanelStudentFrame extends JPanel {

    //Panels
    private JPanel coursePanel = new JPanel(new GridBagLayout());
    private JPanel buttonsPanel = new JPanel(new GridBagLayout());
    private JPanel loggedInPanel = new JPanel(new GridBagLayout());

    //Labels
    private JLabel nameLabel = new JLabel("Name : ");
    private JLabel loggedInAs = new JLabel("Not logged in: ");
    private JLabel results = new JLabel("Found students");
    private JLabel addStudentInfo = new JLabel("Add selected students -> ");


    //TextFields
    private JTextField nameField = new JTextField();

    //JButtons
    private JButton searchButton = new JButton("Search");
    private JButton addStudentsButton = new JButton("Add");




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
    public void placeComponentsCoursePanel(){
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
    public void placeComponentsButtonPanel(){
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
        this.nameField.setPreferredSize(new Dimension(150, 24));

        coursePanel.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Students")));
        buttonsPanel.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Buttons")));
        loggedInPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JLabel getLoggedInAs() {
        return loggedInAs;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JLabel getResults() {
        return results;
    }

    public JButton getAddStudentsButton() {
        return addStudentsButton;
    }
}
