package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Models.ModelFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created  04.05.2016.
 *
 * StudentGradesPanel is a gui JPanel class for displaying and
 * adding new students to the database in the "Student" table.
 *
 * @author puz001, esj002
 */
public class StudentGradesPanel extends JPanel{

    private final LayoutManager layout = new BorderLayout(1, 1);

    private final JPanel controls = new JPanel(new GridBagLayout());

    private final JTextField studentName = new JTextField();

    private final JLabel nameLabel = new JLabel("Student name");
    private final JLabel header = new JLabel("View and add students here.");

    private final JButton addStudent = new JButton("Add student");
    private final JButton exit = new JButton("Back");

    private final DefaultTableModel model = ModelFactory.getStudentsModel();
    private final JTable table = new JTable(model);
    private final JScrollPane tablePane;
    private final TablePanel tp;

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
    private void setupComponents(){
        placeComponentsGridBag(controls);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Course");
        model.addColumn("Grade");
    }

    /**
     * This method clears the model and readds the rows
     * and columns again.
     * It was primarily made to reduce code duplication
     * by reusing some code where possible.
     */
    public void tableRows(){
        model.setRowCount(0);
    }

    /**
     * Getter for the exit button
     * @return exit
     */
    public JButton getExit() {
        return exit;
    }

    /**
     * getter for the add students button
     * @return addStudent
     */
    public JButton getAddStudent() {
        return addStudent;
    }

    /**
     * getter for the student name button
     * @return studentName
     */
    public JTextField getStudentName() {
        return studentName;
    }

    /**
     * Getter for the header jLabel
     * @return header
     */
    public JLabel getHeader() {
        return header;
    }

    /**
     * getter for the model used in the table
     * @return model
     */
    public DefaultTableModel getModel() {
        return model;
    }
}


