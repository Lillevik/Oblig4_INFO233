package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by goat on 23.04.16.
 */
public class ControlPanelPartPanel extends JPanel{

    //Panels
    private JPanel coursePanel = new JPanel(new GridBagLayout());
    private JPanel buttonsPanel = new JPanel(new BorderLayout(1, 1));
    private JPanel loggedInPanel = new JPanel(new GridBagLayout());
    private JPanel updatePartPanel = new JPanel(new GridBagLayout());

    //Labels
    private JLabel titleLabel = new JLabel("Part name: ");
    private JLabel weightLabel = new JLabel("Weight: ");
    private JLabel loggedInAs = new JLabel("Not logged in: ");
    private JLabel currentWeight = new JLabel("Total weight: ");
    private JLabel spaceLabel = new JLabel("");
    private JLabel updateTitleLabel = new JLabel("Part name: ");
    private JLabel updateWeightLabel = new JLabel("Weight: ");



    //TextFields
    private JTextField titleField = new JTextField();
    private JTextField weightField = new JTextField();
    private JTextField updateTitleField = new JTextField();
    private JTextField updateWeightField = new JTextField();




    //JButtons
    private JButton addCourseButton = new JButton("Add part");
    private JButton addStudentButton = new JButton("Add students");
    private JButton backButton = new JButton("Back");
    private JButton updatePart = new JButton("Update");


    //Arrays
    private ArrayList<Integer> percentage = new ArrayList<Integer>(){};

    //Combobox
    private JComboBox weigth;




    public ControlPanelPartPanel(){
        fillWeigthList();
        weigth = new JComboBox(percentage.toArray());
        setupComponents();
        placeComponentsCoursePanel();
        placeComponentsButtonPanel();
        placeComponentsLoggedInPanel();
        this.setLayout(new BorderLayout(2, 2));
        this.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Add part")));
        this.add(coursePanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.CENTER);
        this.add(loggedInPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

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
        coursePanel.add(weightLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        coursePanel.add(weigth,gc);

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

    public void placeComponentsButtonPanel(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;

        gc.gridx = 0;
        gc.gridy = 0;
        updatePartPanel.add(updateTitleLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        updatePartPanel.add(updateTitleField, gc);

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

        buttonsPanel.add(this.updatePartPanel, BorderLayout.NORTH);
        buttonsPanel.add(addStudentButton, BorderLayout.CENTER);
        buttonsPanel.add(backButton, BorderLayout.SOUTH);



    }

    public void placeComponentsLoggedInPanel(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;

        gc.gridx = 0;
        gc.gridy = 0;
        loggedInPanel.add(loggedInAs, gc);
    }

    public void setupComponents(){
        this.titleField.setPreferredSize(new Dimension(150, 24));
        this.weightField.setPreferredSize(new Dimension(150, 24));
        this.weigth.setPreferredSize(new Dimension(150, 24));
        this.updateTitleField.setPreferredSize(new Dimension(150, 24));
        this.updateWeightField.setPreferredSize(new Dimension(150, 24));



        coursePanel.setBorder(BorderFactory.createTitledBorder(new TitledBorder("New Part")));
        buttonsPanel.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Updating")));
        loggedInPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void fillWeigthList(){
        for(int i = 20; i  < 101; i++){
            percentage.add(i);
        }
    }


    public JLabel getLoggedInAs() {
        return loggedInAs;
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public JButton getAddPartButton() {
        return addCourseButton;
    }

    public JButton getAddStudentButton() {
        return addStudentButton;
    }

    public JComboBox getWeigth() {
        return weigth;
    }

    public JLabel getCurrentWeight() {
        return currentWeight;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JTextField getUpdateTitleField() {
        return updateTitleField;
    }

    public JTextField getUpdateWeightField() {
        return updateWeightField;
    }

    public JButton getUpdatePart() {
        return updatePart;
    }
}
