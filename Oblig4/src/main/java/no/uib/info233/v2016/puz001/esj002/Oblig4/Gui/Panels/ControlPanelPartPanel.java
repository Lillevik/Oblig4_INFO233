package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by goat on 23.04.16.
 * @author puz001, esj002
 */
public class ControlPanelPartPanel extends JPanel{


    //Panels
    private final JPanel coursePanel = new JPanel(new GridBagLayout());
    private final JPanel updatingPanel = new JPanel(new BorderLayout(1, 1));
    private final JPanel loggedInPanel = new JPanel(new GridBagLayout());
    private final JPanel updatePartPanel = new JPanel(new GridBagLayout());
    private final JPanel buttonPanel = new JPanel(new GridBagLayout());


    //Labels
    private final JLabel titleLabel = new JLabel("Part name: ");
    private final JLabel weightLabel = new JLabel("Weight: ");
    private final JLabel loggedInAs = new JLabel("Not logged in: ");
    private final JLabel currentWeight = new JLabel("Total weight: ");
    private final JLabel spaceLabel = new JLabel("");
    private final JLabel updateWeightLabel = new JLabel("Weight: ");


    //TextFields
    private final JTextField titleField = new JTextField();
    private final JTextField weightField = new JTextField();
    private final JTextField updateWeightField = new JTextField();


    //JButtons
    private final JButton addCourseButton = new JButton("Add part");
    private final JButton addStudentButton = new JButton("Add students");
    private final JButton backButton = new JButton("Back");
    private final JButton updatePart = new JButton("Update");


    //Arrays
    private final ArrayList<String> percentage = new ArrayList<String>(){};

    //J Combo box
    private final JComboBox weight;


    /**
     * This is the constructor for the ControlPanelPartPanel class
     * which initializes components and places them in the panel.
     */
    public ControlPanelPartPanel(){
        fillWeigthList();
        //noinspection unchecked
        weight = new JComboBox(percentage.toArray());
        setupComponents();
        placeComponentsCoursePanel();
        placeComponentsUpdatingPanel();
        placeComponentsButtonPanel();
        placeComponentsLoggedInPanel();
        this.setLayout(new BorderLayout(2, 2));
        this.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Add part")));
        this.add(coursePanel, BorderLayout.NORTH);
        this.add(updatingPanel, BorderLayout.CENTER);
        this.add(loggedInPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    /**
     * This method places the components of the coursePanel panel
     * into the coursePanel panel field.
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
        coursePanel.add(weightLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        coursePanel.add(weight,gc);

        gc.gridx = 0;
        gc.gridy = 2;
        coursePanel.add(addCourseButton, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        coursePanel.add(spaceLabel, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        coursePanel.add(currentWeight, gc);
    }

    /**
     * This method places the components of the updatingPanel panel
     * into the updatingPanel panel field.
     */
    private void placeComponentsUpdatingPanel(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;

        gc.gridx = 0;
        gc.gridy = 1;
        updatePartPanel.add(updateWeightLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        updatePartPanel.add(updateWeightField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        updatePartPanel.add(updatePart, gc);

        updatePartPanel.setBorder(BorderFactory.createTitledBorder("Update part"));

        updatingPanel.add(this.updatePartPanel, BorderLayout.NORTH);
        updatingPanel.add(this.buttonPanel, BorderLayout.CENTER);
    }

    /**
     * This method places the components in the loggedInPanel panel
     * and adds them to the panel.
     */
    private void placeComponentsLoggedInPanel(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;

        gc.gridx = 0;
        gc.gridy = 0;
        loggedInPanel.add(loggedInAs, gc);
    }

    /**
     * This method places the components of the buttonPanel
     * and adds them to the panel.
     */
    private void placeComponentsButtonPanel(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;

        gc.gridx = 0;
        gc.gridy = 0;
        buttonPanel.add(addStudentButton, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        buttonPanel.add(backButton, gc);

        buttonPanel.setBorder(BorderFactory.createTitledBorder("Buttons"));


    }

    /**
     * This method setsUpCertain components by customising
     * size and so on.
     */
    private void setupComponents(){
        this.titleField.setPreferredSize(new Dimension(150, 24));
        this.weightField.setPreferredSize(new Dimension(150, 24));
        this.weight.setPreferredSize(new Dimension(150, 24));
        this.updateWeightField.setPreferredSize(new Dimension(150, 24));

        coursePanel.setBorder(BorderFactory.createTitledBorder(new TitledBorder("New Part")));
        updatingPanel.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Updating")));
        loggedInPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    /**
     * This method adds all the numbers from 20 - 100 to
     * the ArrayList percentage which is used in the JComboBox
     */
    private void fillWeigthList(){
        for(int i = 20; i  < 101; i++){
            percentage.add(i + "%");
        }
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
     * This is a getter for the addCourseButton field
     * @return - The JButton value from the addCourseButton field
     */
    public JButton getAddPartButton() {
        return addCourseButton;
    }

    /**
     * This is a getter for addStudentButton field
     * @return - The JButton value from the addStudentButton field
     */
    public JButton getAddStudentButton() {
        return addStudentButton;
    }

    /**
     * This is a getter for the weight field
     * @return - The JComboBox value from the weight field
     */
    public JComboBox getWeight() {
        return weight;
    }

    /**
     * This is a getter for the currentWeight field
     * @return - The JLabel value from the currentWeight field
     */
    public JLabel getCurrentWeight() {
        return currentWeight;
    }

    /**
     * This is a getter for the backButton field
     * @return - The JButton value from the backButton field
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * This is a getter for the updateWeightField field
     * @return - The JTextField value from the updateWeightField field
     */
    public JTextField getUpdateWeightField() {
        return updateWeightField;
    }

    /**
     * This is a getter for the updatePart field
     * @return - The JButton value from the updatePart field
     */
    public JButton getUpdatePart() {
        return updatePart;
    }
}
