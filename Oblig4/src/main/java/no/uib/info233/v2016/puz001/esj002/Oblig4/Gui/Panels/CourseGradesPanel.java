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
public class CourseGradesPanel extends JFrame {

    //Panels
    private JPanel coursePanel = new JPanel(new GridBagLayout());

    //Labels
    private JLabel titleLabel = new JLabel("Search course:");

    //Models
    private DefaultTableModel model = ModelFactory.getFinalGradesModel();
    private JTable table = new JTable(model);
    private JScrollPane tablePane;
    private TablePanel tp;

    //TextFields
    private JTextField searchField = new JTextField();

    //JButtons
    private JButton searchButton = new JButton("Search");
    private JButton backButton = new JButton("Back");

    public CourseGradesPanel(){
        super("Final Grades");
        //this.setBorder(BorderFactory.createTitledBorder(new TitledBorder("Final Grades")));
        tablePane = new JScrollPane(table);
        tp = new TablePanel(tablePane);

        tableRows();
        placeComponentsCourseGradePanel();
        this.setLayout(new BorderLayout(2, 2));

        this.add(coursePanel, BorderLayout.WEST);
        this.add(tp, BorderLayout.CENTER);
        setVisible(true);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

    public void tableRows(){

        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Course");
        model.addColumn("StudentName");
        model.addColumn("Grade");
    }

    public static void main (String[]args){

        CourseGradesPanel c = new CourseGradesPanel();

    }
}
