package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Models.ModelFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Eirik on 04.05.2016.
 */
public class StudentGradesPanel extends JFrame{

    private static final long serialVersionUID = 4161520540703687836L;
    private LayoutManager layout = new BorderLayout(1, 1);
    private String[] grades = {"A", "B", "C", "D", "E", "F"};

    private JPanel controls = new JPanel(new GridBagLayout());
    private JPanel spine = new JPanel(layout);

    private JTextField studentName = new JTextField();

    private JLabel nameLabel = new JLabel("Student name");
    private JLabel header = new JLabel("View and add students here.");
    private JLabel desc = new JLabel("Syntax: 'Firstname Lastname'. " + "\n");

    private JButton addStudent = new JButton("Add student");
    private JButton exit = new JButton("Back");

    private DefaultTableModel model = ModelFactory.getStudentGradeModel();
    private JTable table = new JTable(model);
    private JScrollPane tablePane;
    private TablePanel tp;

    /**
     * The constructor initiates all the components
     * and makes it visible.
     */
    public StudentGradesPanel(){

        tableRows();
        tablePane = new JScrollPane(table);
        tp = new TablePanel(tablePane);
        setPreferredSize(new Dimension(1000, 1000));
        this.setLayout(layout);
        setupComponents();
        this.add(controls, BorderLayout.WEST);
        this.add(tp, BorderLayout.CENTER);
        setVisible(true);

    }

    /**
     * This is the method that sets up and add all the
     * components to the panel.
     * @param panel
     */
    private void placeComponentsGridBag(JPanel panel) {

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LINE_START;

        studentName.setPreferredSize(new Dimension(150, 20));

        gc.gridx = 0;
        gc.gridy = 2;
        panel.add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        panel.add(studentName, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        panel.add(addStudent, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        panel.add(exit, gc);

    }

    /**
     * The setupComponents sets the specified components
     * and lets the constructor get ahold of them with less code.
     */
    public void setupComponents(){

        placeComponentsGridBag(controls);
    }

    /**
     * This method clears the model and readds the rows
     * and columns again.
     * It was primarily made to reduce code duplication
     * by reusing some code where possible.
     */
    public void tableRows(){

        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Course");
        model.addColumn("Grade");
    }

    public JButton getExit() {
        return exit;
    }

    public JButton getAddStudent() {
        return addStudent;
    }

    public JTextField getStudentName() {
        return studentName;
    }

    public JLabel getHeader() {
        return header;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}


