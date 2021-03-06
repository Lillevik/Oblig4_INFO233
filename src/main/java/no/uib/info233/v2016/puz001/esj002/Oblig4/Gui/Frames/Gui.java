package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames;

import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Models.ModelFactory;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created 18.04.2016.
 * @author puz001, esj002
 */
public class Gui extends JFrame {

    //These are the fields of the IssuePanel class.
    private static final long serialVersionUID = 4161520540703687836L;
    private final LayoutManager layout = new BorderLayout(1, 1);

    //TextFields
    private final JTextField courseNameField = new JTextField();
    private final JTextField descriptionField = new JTextField();
    private final JTextField professorField = new JTextField();

    //Panels
    private final JPanel spine = new JPanel(layout);
    private final LoginPanel lp = new LoginPanel();
    private final RegisterPanel rp = new RegisterPanel();
    private final TablePanel tp;
    private final ControlPanel cp = new ControlPanel();
    private final PartPanel pp = new PartPanel();
    private final StudentGradesPanel sgp = new StudentGradesPanel();
    private final CourseGradesPanel cgp = new CourseGradesPanel();


    //Models and tables
    private final DefaultTableModel model = ModelFactory.createCourseModel();
    private final JTable table = new JTable(model);
    private final JScrollPane tablePane;

    //Menu
    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu file = new JMenu("File");
    private final JMenuItem logout = new JMenuItem("Logout");

    //Frames
    private final AddStudentsFrame asf = new AddStudentsFrame();


    /**
     * This is the constructor for the Gui class
     * which is the class that basicly presents
     * entire program.
     */
    public Gui(){
        super("Course planner");
        tableRows();
        tablePane = new JScrollPane(table);
        tp = new TablePanel(tablePane);
        //noinspection MagicConstant
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 650));
        setResizable(true);
        this.setLayout(layout);
        setupComponents();
        spine.add(cp, BorderLayout.WEST);
        spine.add(tp, BorderLayout.CENTER);
        setContentPane(lp);
        pack();
        setVisible(true);
    }

    /**
     * This method sets up the size of some of the components
     * and adds a menubar to the frame.
     */
    private void setupComponents(){
        courseNameField.setPreferredSize(new Dimension(150, 24));
        descriptionField.setPreferredSize(new Dimension(150, 24));
        professorField.setPreferredSize(new Dimension(150, 24));

        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Course ID");
        model.addColumn("Title");
        model.addColumn("Description");
        model.addColumn("Professor");

        this.setJMenuBar(menuBar);

        this.menuBar.add(file);
        file.add(logout);
    }
    /**
     * This method clears the model and readds the rows
     * and columns again.
     * It was primarily made to reduce code duplication
     * by reusing some code where possible.
     */
    public void tableRows(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
    }

    /**
     * This is a getter for the model field
     * @return - The DefaultTableModel value from the model field
     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**
     * This is a getter for the lp field
     * @return - The LoginPanel value from the lp field
     */
    public LoginPanel getLp() {
        return lp;
    }

    /**
     * This is a getter for the spine field
     * @return - The JPanel from the spine field
     */
    public JPanel getSpine() {
        return spine;
    }

    /**
     * This is a getter for the rp field
     * @return - The RegisterPanel from the rp field
     */
    public RegisterPanel getRp() {
        return rp;
    }

    /**
     * This is a getter for the cp field
     * @return - The ControlPaneø
     */
    public ControlPanel getCp() {
        return cp;
    }

    /**
     * This is a getter for the logout field
     * @return - The JMenuItem value from the logout field
     */
    public JMenuItem getLogout() {
        return logout;
    }

    /**
     * This is a getter for the pp field
     * @return - The PartPanel from the pp field
     */
    public PartPanel getPp() {
        return pp;
    }

    /**
     * This is a getter for the table field
     * @return - The JTable from the table field
     */
    public JTable getTable() {
        return table;
    }

    /**
     * This is a getter for the asf field
     * @return - The AddStudentFrame from the asf field
     */
    public AddStudentsFrame getAsf() {
        return asf;
    }

    /**
     * Getter for the studentGradesPanel.
     * used for displaying and adding students.
     * @return StudentsGradesPanel
     */
    public StudentGradesPanel getSgp() {
        return sgp;
    }

    /**
     * getter for hte courseGradesPanel class.
     * The class displays final grades.
     * @return CourseGradesPanel
     */
    public CourseGradesPanel getCgp() {
        return cgp;
    }
}
