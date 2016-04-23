package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui;

import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

/**
 * Created 18.04.2016.
 */
public class Gui extends JFrame {



    //These are the fields of the IssuePanel class.
    private static final long serialVersionUID = 4161520540703687836L;
    private LayoutManager layout = new BorderLayout(1, 1);

    private JLabel descriptionLabel = new JLabel("Description:");
    private JLabel courseNameLabel = new JLabel("Course:");
    private JLabel professorLabel = new JLabel("Professor:");
    private JLabel loggedInLabel = new JLabel("Not logged in");

    private JTextField courseNameField = new JTextField();
    private JTextField descriptionField = new JTextField();
    private JTextField professorField = new JTextField();

    private JButton createButton = new JButton("Create");
    private JButton backButton = new JButton("Cancel");
    private JButton listStudents = new JButton("Students");
    private JButton listCourses = new JButton("Courses");
    private JButton partButton = new JButton(("New part"));
    private JButton switchUser = new JButton("Switch user");

    private String[] grades = {"A", "B", "C", "D", "E", "F"};

    private JPanel controls = new JPanel(new GridBagLayout());
    private JPanel spine = new JPanel(layout);

    private StudentFrame sf = (StudentFrame) new StudentFrame();

    private LoginPanel lp = new LoginPanel();
    private RegisterPanel rp = new RegisterPanel();

    private TableModel model = new TableModel();
    private JTable table = new JTable(model);
    private JScrollPane tablePane;
    private TablePanel tp;
    private String currentUser;



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
        spine.add(controls, BorderLayout.WEST);
        spine.add(tp, BorderLayout.CENTER);
        setContentPane(lp);

        pack();
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

        gc.gridx = 0;
        gc.gridy = 0;
        panel.add(courseNameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        panel.add(courseNameField, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        panel.add(descriptionLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        panel.add(descriptionField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        panel.add(professorLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        panel.add(professorField, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        panel.add(createButton, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        panel.add(backButton, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        gc.weighty = 10;
        panel.add(listCourses, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.weighty = 10;
        panel.add(listStudents, gc);

        gc.gridx = 2;
        gc.gridy = 4;
        panel.add(partButton, gc);

        gc.gridx = 0;
        gc.gridy = 5;
        panel.add(loggedInLabel, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        panel.add(switchUser, gc);
    }

    public void setupComponents(){
        courseNameField.setPreferredSize(new Dimension(150, 24));
        descriptionField.setPreferredSize(new Dimension(150, 24));
        professorField.setPreferredSize(new Dimension(150, 24));

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

    public JButton getListStudents() {
        return listStudents;
    }

    public StudentFrame getSf() {
        return sf;
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

    public JLabel getLoggedInLabel() {
        return loggedInLabel;
    }

    public JButton getSwitchUser() {
        return switchUser;
    }
}
