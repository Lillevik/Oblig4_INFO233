package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by svimanet on 22/04/16.
 */
public class StudentFrame extends JPanel {


    //These are the fields of the IssuePanel class.
    private static final long serialVersionUID = 4161520540703687836L;
    private LayoutManager layout = new BorderLayout(1, 1);
    private String[] grades = {"A", "B", "C", "D", "E", "F"};

    private JPanel controls = new JPanel(new GridBagLayout());
    private JPanel spine = new JPanel(layout);

    private JTextField studentName = new JTextField();
    private JTextField studentID = new JTextField();

    private JLabel nameLabel = new JLabel("Student name");
    private JLabel IDlabel = new JLabel("Student ID");

    private JButton addStudent = new JButton("Add student");
    private JButton exit = new JButton("Back");

    private TableModelStudent studentModel = new TableModelStudent();
    private JTable table = new JTable(studentModel);
    private JScrollPane tablePane;
    private TablePanel tp;

    public StudentFrame(){

        tableRows();
        tablePane = new JScrollPane(table);
        tp = new TablePanel(tablePane);
        setPreferredSize(new Dimension(1000, 650));
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

        studentName.setPreferredSize(new Dimension(100, 20));
        studentID.setPreferredSize(new Dimension(100, 20));

        gc.gridx = 0;
        gc.gridy = 0;
        panel.add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        panel.add(studentName, gc);


        gc.gridx = 0;
        gc.gridy = 1;
        panel.add(addStudent, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        panel.add(exit, gc);

    }

    public void exitWindow(){
        System.exit(0);
    }

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

        studentModel.setRowCount(0);
        studentModel.setColumnCount(0);
        studentModel.addColumn("ID");
        studentModel.addColumn("Name");
    }

    @Override
    public LayoutManager getLayout() {
        return layout;
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

    public JTextField getStudentID() {
        return studentID;
    }

    public TableModelStudent getStudentModel() {
        return studentModel;
    }
}
