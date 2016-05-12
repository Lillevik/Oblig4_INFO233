package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;


import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Models.ModelFactory;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Eirik on 04.05.2016.
 */
public class CourseGradesPanel extends JPanel {

    //Panels
    private JPanel coursePanel = new JPanel(new GridBagLayout());
    private JPanel tablePanel = new JPanel(new BorderLayout());

    //Labels
    private JLabel titleLabel = new JLabel("Final Grades");

    //Models
    private DefaultTableModel model = ModelFactory.getFinalGradesModel();
    private JTable table = new JTable(model);
    private JScrollPane tablePane;

    //TextFields
    private JTextField searchField = new JTextField();

    //JButtons
    private JButton searchButton = new JButton("Search");
    private JButton backButton = new JButton("Back");

    /**
     * Constructor for the courseGradesPanel
     * Initiates all the methods in the class and lets
     * the class be imported to other classes.
     */
    public CourseGradesPanel(){

        placeTableComponents();
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
     * Sets up the JTable in a JPanel
     * making it visible
     */
    public void placeTableComponents(){
        tablePane = new JScrollPane(table);
        tablePanel.add(tablePane);
    }

    /**
     * This method places the components of the coursePanel panel
     * into the coursePanel panel field.
     */
    public void placeComponentsCourseGradePanel(){
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

    }

    /**
     * Sets up the table, making it ready for input
     * info and pasting it in the JTable.
     */
    public void tableRows(){

        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Course");
        model.addColumn("StudentName");
        model.addColumn("Grade");
    }

    /**
     * getter for the search button. Letting
     * the user search for courses in the table
     * in the final grades panel.
     * @return
     */
    public JButton getSearchButton() {
        return searchButton;
    }

    /**
     * getter for the JButton BackButton, used to let the
     * user exit the final grades panel.
     * @return
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * Getter for the JTextField used to search for courses
     * @return
     */
    public JTextField getSearchField() {
        return searchField;
    }
}
