package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;


import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Models.ModelFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created 18.04.2016.
 * This class represents the parts of a course
 */
public class PartPanel extends JPanel {


    //These are the fields of the IssuePanel class.
    private static final long serialVersionUID = 4161520540703687836L;
    private LayoutManager layout = new BorderLayout(1, 1);

    //Labels

    //TextFields
    private JTextField courseNameField = new JTextField();
    private JTextField descriptionField = new JTextField();



    //Panels
    private ControlPanelPartPanel cppf = new ControlPanelPartPanel();
    private TablePanelPF tp;



    //Models and tables
    private DefaultTableModel model = ModelFactory.createPartModel();
    private DefaultTableModel studentModel = ModelFactory.createPartEvaluationModel();
    private JTable table = new JTable(model);
    private JTable studentTable = new JTable(studentModel);
    private JScrollPane tablePane;
    private JScrollPane studentPane;



    /**
     * This is the constructor of the PartPanel
     * class.
     */
    public PartPanel(){
        setStudentTableRows();
        tableRows();
        setLayout(layout);
        tablePane = new JScrollPane(table);
        studentPane = new JScrollPane(studentTable);
        tp = new TablePanelPF(tablePane, studentPane);
        this.setLayout(layout);
        setupComponents();
        this.add(cppf, BorderLayout.WEST);
        this.add(tp, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * This method sets up some components.
     */
    public void setupComponents(){
        courseNameField.setPreferredSize(new Dimension(150, 24));
        descriptionField.setPreferredSize(new Dimension(150, 24));
    }
    /**
     * This method clears the model and reads the rows
     * and columns again.
     * It was primarily made to reduce code duplication
     * by reusing some code where possible.
     */
    public void tableRows(){
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Part Id");
        model.addColumn("Course Name");
        model.addColumn("Part Name");
        model.addColumn("Weigth in %");
    }

    public void setStudentTableRows(){
        this.studentModel.setRowCount(0);
        this.studentModel.setColumnCount(0);
        this.studentModel.addColumn("Course Part ID");
        this.studentModel.addColumn("Student ID");
        this.studentModel.addColumn("Grade");
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public ControlPanelPartPanel getCp() {
        return cppf;
    }

    public DefaultTableModel getStudentModel() {
        return studentModel;
    }

    public JTable getTable() {
        return this.table;
    }

    public JTable getStudentTable() {
        return studentTable;
    }


}

