package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created 18.04.2016.
 */
public class Gui extends JFrame {


    //These are the fields of the IssuePanel class.
    private static final long serialVersionUID = 4161520540703687836L;
    private LayoutManager layout = new BorderLayout(1, 1);

    //Labels
    private JLabel descriptionLabel = new JLabel("Description:");
    private JLabel courseNameLabel = new JLabel("Course:");
    private JLabel professorLabel = new JLabel("Professor:");
    private JLabel loggedInLabel = new JLabel("Not logged in");

    //TextFields
    private JTextField courseNameField = new JTextField();
    private JTextField descriptionField = new JTextField();
    private JTextField professorField = new JTextField();

    //Buttons
    private JButton createButton = new JButton("Create");
    private JButton backButton = new JButton("Cancel");
    private JButton listCourses = new JButton("Update");
    private JButton partButton = new JButton(("New part"));

    //Arrays for comboboxes
    private String[] grades = {"A", "B", "C", "D", "E", "F"};

    //Panels
    private JPanel controls = new JPanel(new GridBagLayout());
    private JPanel spine = new JPanel(layout);
    private LoginPanel lp = new LoginPanel();
    private RegisterPanel rp = new RegisterPanel();
    private TablePanel tp;
    private ControlPanel cp = new ControlPanel();



    //Models and tables
    private TableModel model = new TableModel();
    private JTable table = new JTable(model);
    private JScrollPane tablePane;

    //Strings
    private String currentUser;

    //Menu
    private JMenuBar menuBar = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenuItem logout = new JMenuItem("Logout");




    public Gui(){
        super("Course planner");
        tableRows();
        tablePane = new JScrollPane(table);
        tp = new TablePanel(tablePane);
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

    public void setupComponents(){
        courseNameField.setPreferredSize(new Dimension(150, 24));
        descriptionField.setPreferredSize(new Dimension(150, 24));
        professorField.setPreferredSize(new Dimension(150, 24));

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
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Description");
        model.addColumn("Admin");
    }

    /**
     * This is a getter for the field locationText
     * which is used to get location of an issue.
     * @return the locationText
     */
    public JTextField getLocationText() {
        return courseNameField;
    }


    /**
     * This is the button that creates the issue
     * and returns the user to the main window.
     * @return the createButton
     */
    public JButton getCreateButton() {
        return createButton;
    }

    /**
     * @return the backButton
     */
    public JButton getBackButton() {
        return backButton;
    }

    public JTextField getCourseNameField() {
        return courseNameField;
    }

    public JTextField getDescriptionField(){
        return this.descriptionField;
    }

    public JTextField getProfessorField() {
        return professorField;
    }

    public void closeWindow(){
        System.exit(0);
    }

    public TableModel getModel() {
        return model;
    }

    public JButton getListCourses() {
        return listCourses;
    }

    public JButton getPartButton() {
        return partButton;
    }

    public LoginPanel getLp() {
        return lp;
    }

    public JPanel getSpine() {
        return spine;
    }

    public RegisterPanel getRp() {
        return rp;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
    public ControlPanel getCp() {
        return cp;
    }

    public JMenuItem getLogout() {
        return logout;
    }
}
