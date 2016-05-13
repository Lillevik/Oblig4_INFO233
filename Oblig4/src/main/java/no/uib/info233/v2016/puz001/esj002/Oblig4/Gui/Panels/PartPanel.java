package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;


import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Models.ModelFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created 18.04.2016.
 * This class represents the parts of a course
 * @author marius
 */
public class PartPanel extends JPanel {


    //These are the fields of the IssuePanel class.
    private static final long serialVersionUID = 4161520540703687836L;

    //Labels

    //TextFields
    private JTextField courseNameField = new JTextField();
    private JTextField descriptionField = new JTextField();



    //Panels
    private ControlPanelPartPanel cppf = new ControlPanelPartPanel();
    private CourseGradesPanel cgp = new CourseGradesPanel();


    //Models and tables
    private DefaultTableModel model = ModelFactory.createPartModel();
    private DefaultTableModel studentModel = ModelFactory.createPartEvaluationModel();
    private JTable table = new JTable(model);
    private JTable studentTable = new JTable(studentModel);


    /**
     * This is the constructor of the PartPanel
     * class.
     */
    public PartPanel(){
        LayoutManager layout = new BorderLayout(1, 1);
        setLayout(layout);
        JScrollPane tablePane = new JScrollPane(table);
        JScrollPane studentPane = new JScrollPane(studentTable);
        TablePanelPF tp = new TablePanelPF(tablePane, studentPane);
        this.setLayout(layout);
        setupComponents();
        this.add(cppf, BorderLayout.WEST);
        this.add(tp, BorderLayout.CENTER);
        this.add(cgp, BorderLayout.EAST);

        setVisible(true);
    }

    /**
     * This method sets up some components.
     */
    public void setupComponents(){
        courseNameField.setPreferredSize(new Dimension(150, 24));
        descriptionField.setPreferredSize(new Dimension(150, 24));
        model.addColumn("Part Id");
        model.addColumn("Course Name");
        model.addColumn("Part Name");
        model.addColumn("Weight in %");

        studentModel.addColumn("Course Part ID");
        studentModel.addColumn("Student ID");
        studentModel.addColumn("Part Grade");

    }
    /**
     * This method clears the model and reads the rows
     * and columns again.
     * It was primarily made to reduce code duplication
     * by reusing some code where possible.
     */
    public void tableRows(){
        model.setRowCount(0);
        table.getColumnModel().getColumn(3).setCellRenderer(ModelFactory.createCellRenderer());
    }

    /**
     * This is a method for clearing the studentModel
     * to prepare it for adding new rows.
     */
    public void setStudentTableRows(){
        this.studentModel.setRowCount(0);
    }

    /**
     * This is a getter for the model field
     * @return - The DefaultTableModel value from the model field
     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**
     * This is a getter for the cppf field
     * @return - The ControlPanelPartPanel value from the cppf field
     */
    public ControlPanelPartPanel getCp() {
        return cppf;
    }

    /**
     * This is a getter for the studentModel field
     * @return - The DefaultTableModel value from the studentModel field
     */
    public DefaultTableModel getStudentModel() {
        return studentModel;
    }

    /**
     * This is a getter for the table field
     * @return - The JTable value from the table field
     */
    public JTable getTable() {
        return this.table;
    }

    /**
     * This is a getter for the studentTable field
     * @return - The JTable value from the studentTable field
     */
    public JTable getStudentTable() {
        return studentTable;
    }


}

