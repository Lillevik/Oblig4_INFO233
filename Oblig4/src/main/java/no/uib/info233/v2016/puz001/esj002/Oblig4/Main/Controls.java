package no.uib.info233.v2016.puz001.esj002.Oblig4.Main;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.Course;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.Student;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.DataStores;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames.Gui;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels.StudentGradesPanel;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by goat on 21.04.16.
 *
 * This class is adding actionListeners to almost all of the buttons that is
 * used withing the program itself
 *
 * @author marius
 */
public class Controls {

    private Gui g;
    private ConnectionHandling ch;
    private DataStores ds;

    /**
     * The constructor of the Controls class.
     * @param g - The Gui to be used
     * @param ch - The ConnectionHandling to be used
     * @param ds - The DataStores to be used
     */
    public Controls(Gui g, ConnectionHandling ch, DataStores ds) {
        this.g = g;
        this.ch = ch;
        this.ds = ds;
    }

    /**
     * This method initializes all the action listeners
     * when its called in the main method of the program.
     */
    public void controlActions() {
        createCourse();
        listCourses();
        switchToPartFrame();
        login();
        changeToRegisterPanel();
        registerNewUser();
        switchUser();
        cancelRegistration();
        addNewPart();
        listPartEvaluationGrades();
        backButtonPartPanel();
        addStudents();
        addStudentsToCourse();
        studentSearch();
        updatePartCourseWeight();
        deleteCourse();
        changeToStudentGradesPanel();
        backButtonStudentGradePanel();
        addStudentsToTable();

    }

    /**
     * This method adds a new Course if a course with
     * the same name does not allready exist.
     */
    public void createCourse() {

        g.getCp().getAddCourseButton().addActionListener(e -> {
            ch.insertNewCourse(
                    g.getCp().getDescriptionField().getText(),
                    g.getCp().getTitleField().getText());
            ch.listCourses();
        });
    }

    /**
     * This method fills the JTable in the spinePanel in gui
     * with all the courses from the database
     */
    public void listCourses() {

        g.getCp().getUpdateButton().addActionListener(e -> ch.listCourses());
    }

    /**
     * This method authenticates the login towards the server
     * and changes the panel if the login is correct.
     */
    public void login() {
        g.getLp().getLoginButton().addActionListener(e -> {
            //noinspection deprecation,deprecation
            ch.authenticateLogin(g.getLp().getUserField().getText(),
                    g.getLp().getPasswordField().getText());

        });

    }

    /**
     * This method simply switches to the register panel.
     */
    public void changeToRegisterPanel(){
        g.getLp().getRegisterButton().addActionListener(e -> {
            g.setContentPane(g.getRp());
            g.pack();
        });
    }

    /**
     * This is the button that checks the server if a user
     * allready exists and adds a new Employee if it doesnt exist.
     */
    public void registerNewUser(){
        g.getRp().getRegisterButton().addActionListener(e -> {
            //noinspection deprecation
            ch.insertNewEmployee(g.getRp().getUserField().getText(),
                                 g.getRp().getFullNameField().getText(),
                                 g.getRp().getPasswordField().getText());


            g.setContentPane(g.getLp());
            g.pack();
        });
    }

    /**
     * This is an actionListener for the JMenuItem Logout which
     * simply sends the user back to the login panel.
     */
    public void switchUser(){
        g.getLogout().addActionListener(e -> {
            g.getPp().setVisible(false);
            g.setContentPane(g.getLp());
            g.pack();
        });
    }

    /**
     * This is just a cancel button that returns the user to the
     * login panel from the registration panel.
     */
    public void cancelRegistration(){
        g.getRp().getCancelButton().addActionListener(e -> {
            g.setContentPane(g.getLp());
            g.pack();
        });
    }

    /**
     * This is a button that opens the addPart frame if a course is
     * selected. The frame is then opened and prsents the current selected
     * course from the course list.
     */
    public void switchToPartFrame(){
        g.getCp().getAddPartsButton().addActionListener(e -> {
            int selectedRow = g.getTable().getSelectedRow();

            if(selectedRow == -1) {
                System.out.println("Please select a course to add part evaluation for.");
            } else {
                g.getPp().setStudentTableRows();

                int courseId = Integer.parseInt(g.getTable().getValueAt(selectedRow, 0).toString());
                String courseTitle = g.getTable().getValueAt(selectedRow, 1).toString();
                String courseDescription = g.getTable().getValueAt(selectedRow, 2).toString();
                String courseProfessor = g.getTable().getValueAt(selectedRow, 3).toString();


                ds.setCourse(new Course(courseId, courseTitle, courseDescription, courseProfessor));
                g.getPp().getCp().setBorder(BorderFactory.createTitledBorder(ds.getCourse().getName()));
                ch.fetchCourseParts(ds.getCourse().getName());
                ds.addPartsToList();
                g.getPp().getCp().getLoggedInAs().setText("Logged in as: " + ds.getUser().getFullName());
                g.setContentPane(g.getPp());
                g.pack();
            }
        });
    }

    /**
     * This method adds a new CoursePart if the weight all
     * together is less than 100%.
     */
    public void addNewPart(){
        g.getPp().getCp().getAddPartButton().addActionListener(e -> {
            String name = g.getPp().getCp().getTitleField().getText();
            int weight = Integer.parseInt(g.getPp().getCp().getWeight()
                    .getSelectedItem().toString().replaceAll("%", ""));

            ch.fetchCourseParts(ds.getCourse().getName());
            ch.insertNewPart(name, weight);
            ds.addPartsToList();


        });
    }

    /**
     * This method lists all partEvaluations in the course
     * given in a parameter.
     */
    public void listPartEvaluationGrades(){
        g.getPp().getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = g.getPp().getTable().getSelectedRow();

                ds.getCourse().setCurrentPartId(Integer.parseInt(g.getPp().getModel().getValueAt(selectedRow, 0).toString()));

                ch.fetchStudentPart(Integer.parseInt(g.getPp().getTable().getValueAt(selectedRow, 0).toString()));
            }

            });
        }

    /**
     * This is an actionListener for the backButton which returns
     * the user to the previous panel
     */
    public void backButtonPartPanel(){
        g.getPp().getCp().getBackButton().addActionListener(e -> {
            g.setContentPane(g.getSpine());
            g.pack();
        });
    }

    /**
     * This is an actionListener which opens the add students frame
     * for adding students to a course of if the weight of all parts are
     * a 100% in total.
     */
    public void addStudents(){
        g.getPp().getCp().getAddStudentButton().addActionListener(e -> g.getPp().getCp().getAddStudentButton().addActionListener(e1 -> {
            if(ds.getCurrentValue() != 100){
                System.out.println("All parts need to be 100% before adding students to the course.");
            } else {
                ds.addPartsToList();
                g.getAsf().getCp().setBorder(BorderFactory.createTitledBorder
                        ("Add students to: " + ds.getCourse().getName()));
                g.getAsf().getCp().getLoggedInAs().setText("Logged in as: "+ ds.getUser().getFullName());
                ch.listStudentsNotOnCourse(ds.getCourse().getId());
                g.getAsf().setVisible(true);
            }
        }));
    }

    /**
     * This is an actionListener for the addStudentButton which adds
     * selected students from the studentsFrame to a given course.
     */
    public void addStudentsToCourse(){
        g.getAsf().getCp().getAddStudentsButton().addActionListener(e -> {
            g.getAsf().getTable().setRowSelectionInterval(0, 0);
            ch.addStudentsToCourse();
        });
    }

    /**
     * This is ac actionListener for the searchButton which searches
     * for a given user in a list.
     */
    public void studentSearch(){

        g.getAsf().getCp().getSearchButton().addActionListener(e -> {

            ArrayList<Student> students = new ArrayList<>();
            ch.listStudentsNotOnCourse(ds.getCourse().getId());
            int rows = g.getAsf().getTable().getRowCount();
            for(int i = 0; i < rows; i++){
                int studentId = Integer.parseInt(g.getAsf().getTable().getValueAt(i, 0).toString());
                String studentName = g.getAsf().getTable().getValueAt(i, 1).toString().toLowerCase();
                String searchWord = g.getAsf().getCp().getNameField().getText();
                if((studentName.toLowerCase().indexOf(searchWord)) != -1){
                    students.add(new Student(studentId, studentName));
                }
            }
            g.getAsf().tableRows();
            for(Student s : students){
                g.getAsf().getModel().addRow(new Object[]{s.getId(), s.getName()});
            }

            g.getAsf().getCp().getResults().setText("Found " + students.size() + " students.");
        });
    }

    /**
     * This is an actionListener for the updatePart button in the partPanel
     * which updates a partWeight if it will not go over 100%.
     */
    public void updatePartCourseWeight(){
        g.getPp().getCp().getUpdatePart().addActionListener(e -> {
            int weight = Integer.parseInt(g.getPp().getCp().getUpdateWeightField().getText());
            int id = Integer.parseInt(g.getPp().getTable().getValueAt(g.getPp().getTable().getSelectedRow(), 0).toString());
            int previousWeight = Integer.parseInt(g.getPp().getTable().getValueAt(g.getPp().getTable().getSelectedRow(), 3).toString());

            ch.fetchCourseParts(ds.getCourse().getName());
            ds.addPartsToList();
            ch.updatePart(weight, id, previousWeight);
            ch.fetchCourseParts(ds.getCourse().getName());
        });
    }

    /**
     * This is an actionListener for the deleteButton which will open a
     * ConfirmationPanel to confirm deletion.
     */
    public void deleteCourse(){

        g.getCp().getDeleteCourseButton().addActionListener(e ->{

            String ObjButtons[] = {"Yes","No"};
            int row = g.getTable().getSelectedRow();
            String name = g.getTable().getValueAt(row, 1).toString();
            String information = "Are you sure you want to delete the course " + name + "?" +
                    "\n This will also delete all of its part evaluations" +
                    "\n and the students taking the course.";


        int PromptResult = JOptionPane.showOptionDialog(null,information,"Online Examination System",
                JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
        if(PromptResult==JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(g.getTable().getValueAt(row, 0).toString());
            ch.deleteCourse(id, name);
        }
    });
    }

    /**
     * This method simply switches to the StudentGradesPanel.
     */
    public void changeToStudentGradesPanel(){
        g.getCp().getViewStudents().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setContentPane(g.getSgp());
                g.pack();
            }
        });
    }

    /**
     * This method takes the user back from the StudentGradePanel
     * to the main spine panel.
     */
    public void backButtonStudentGradePanel(){
        g.getSgp().getExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setContentPane(g.getSpine());
                g.pack();
            }
        });
    }

    public void addStudentsToTable(){
        g.getSgp().getAddStudent().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch.insertStudents(
                        g.getSgp().getStudentName().getText());
                ch.listStudents(g.getSgp());

            }
        });
    }

    public void calculateCourseGrades(){
        int row = g.getTable().getSelectedRow();
        int courseId = Integer.parseInt(g.getTable().getValueAt(row, 0).toString());


    }
}

