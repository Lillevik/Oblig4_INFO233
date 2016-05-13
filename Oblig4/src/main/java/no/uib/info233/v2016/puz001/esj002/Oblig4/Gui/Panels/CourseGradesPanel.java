package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;


import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Models.ModelFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.border.TitledBorder;

/**
 * Created 12.05.16
 * CourseGradePanel is a gui JPanel used to display
 * the final grades for students and courses in a table.
 * @author puz001, esj002
 */
public class CourseGradesPanel extends JPanel {

    //Panels
    private final JPanel coursePanel = new JPanel(new GridBagLayout());
    private final JPanel tablePanel = new JPanel(new BorderLayout());

    //Labels
    private final JLabel titleLabel = new JLabel("Final Grades");

    //Models
    private final DefaultTableModel model = ModelFactory.createFinalGradesModel();
    private final JTable table = new JTable(model);
    private final JScrollPane tablePane = new JScrollPane(table);

    //TextFields
    private final JTextField searchField = new JTextField();

    //JButtons
    private final JButton searchButton = new JButton("Search");
    private final JButton backButton = new JButton("Back");

    /**
     * Constructor for the courseGradesPanel
     * Initiates all the methods in the class and lets
     * the class be imported to other classes.
     */
    public CourseGradesPanel(){

        tablePanel.add(tablePane);
        placeComponentsCourseGradePanel();
        tableRows();
        this.setLayout(new BorderLayout(2, 2));
        this.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Final Grades")));
        coursePanel.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Menu")));
        tablePanel.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Table")));
        this.add(coursePanel, BorderLayout.WEST);
        this.add(tablePanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    /**
     * This method places the components of the coursePanel panel
     * into the coursePanel panel field.
     */
    private void placeComponentsCourseGradePanel(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;

        gc.gridx = 0;
        gc.gridy = 0;
        coursePanel.add(titleLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        coursePanel.add(searchField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        coursePanel.add(backButton, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        coursePanel.add(searchButton, gc);

        searchField.setPreferredSize(new Dimension(100, 20));

        model.setColumnCount(0);
        model.addColumn("Course");
        model.addColumn("StudentName");
        model.addColumn("Grade");

    }

    /**
     * Sets up the table, making it ready for input
     * info and pasting it in the JTable.
     */
    public void tableRows(){
        model.setRowCount(0);

    }

    /**
     * getter for the search button. Letting
     * the user search for courses in the table
     * in the final grades panel.
     * @return searchButton
     */
    public JButton getSearchButton() {
        return searchButton;
    }

    /**
     * getter for the JButton BackButton, used to let the
     * user exit the final grades panel.
     * @return backButton
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * Getter for the JTextField used to search for courses
     * @return searchField
     */
    public JTextField getSearchField() {
        return searchField;
    }

    /**
     * getter for the table used in the panel
     * @return table
     */
    public JTable getTable() {
        return table;
    }

    /**
     * getter for the model used in the table
     * @return model
     */
    public DefaultTableModel getModel() {
        return model;
    }
}
