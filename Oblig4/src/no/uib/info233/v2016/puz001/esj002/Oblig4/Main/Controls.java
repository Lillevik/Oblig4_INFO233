package no.uib.info233.v2016.puz001.esj002.Oblig4.Main;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.Course;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.Student;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.DataStores;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames.ConfirmationFrame;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames.Gui;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by goat on 21.04.16.
 */
public class Controls {

    private Gui g;
    private ConnectionHandling ch;
    private DataStores ds;

    /**
     * The constructor of the Controls class.
     * @param g
     * @param ch
     * @param ds
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
    }

    /**
     * This method adds a new Course if a course with
     * the same name does not allready exist.
     */
    public void createCourse() {

        g.getCp().getAddCourseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch.insertNewCourse(
                        g.getCp().getDescriptionField().getText(),
                        g.getCp().getTitleField().getText());
                ch.listCourses();
            }
        });
    }

    /**
     * This method fills the JTable in the spinePanel in gui
     * with all the courses from the database
     */
    public void listCourses() {

        g.getCp().getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch.listCourses();

            }
        });
    }

    /**
     * This method authenticates the login towards the server
     * and changes the panel if the login is correct.
     */
    public void login() {
        g.getLp().getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Working");
                ch.authenticateLogin(g.getLp().getUserField().getText(),
                        g.getLp().getPasswordField().getText());

            }
        });

    }

    /**
     * This method simply switches to the register panel.
     */
    public void changeToRegisterPanel(){
        g.getLp().getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setContentPane(g.getRp());
                g.pack();
            }
        });
    }

    /**
     * This is the button that checks the server if a user
     * allready exists and adds a new Employee if it doesnt exist.
     */
    public void registerNewUser(){
        g.getRp().getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch.insertNewEmployee(g.getRp().getUserField().getText(),
                                     g.getRp().getFullNameField().getText(),
                                     g.getRp().getPasswordField().getText());


                g.setContentPane(g.getLp());
                g.pack();
            }
        });
    }

    /**
     * This is an actionListener for the JMenuItem Logout which
     * simply sends the user back to the login panel.
     */
    public void switchUser(){
        g.getLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.getPp().setVisible(false);
                g.setContentPane(g.getLp());
                g.pack();
            }
        });
    }

    /**
     * This is just a cancel button that returns the user to the
     * login panel from the registration panel.
     */
    public void cancelRegistration(){
        g.getRp().getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setContentPane(g.getLp());
                g.pack();
            }
        });
    }

    /**
     * This is a button that opens the addPart frame if a course is
     * selected. The frame is then opened and prsents the current selected
     * course from the course list.
     */
    public void switchToPartFrame(){
        g.getCp().getAddPartsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = g.getTable().getSelectedRow();

                if(selectedRow == -1) {
                    System.out.println("Please select a course to add part evaluation for.");
                } else if(selectedRow != -1) {
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
            }
        });
    }

    /**
     * This method adds a new CoursePart if the weight all
     * together is less than 100%.
     */
    public void addNewPart(){
        g.getPp().getCp().getAddPartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = g.getPp().getCp().getTitleField().getText();
                int weight = Integer.parseInt(g.getPp().getCp().getWeigth()
                        .getSelectedItem().toString().replaceAll("%", ""));

                ch.fetchCourseParts(ds.getCourse().getName());
                ch.insertNewPart(name, weight);
                ds.addPartsToList();


            }
        });
    }

    public void listPartEvaluationGrades(){
        g.getPp().getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = g.getPp().getTable().getSelectedRow();

                String title = g.getPp().getTable().getValueAt(selectedRow, 2).toString();
                String weight = g.getPp().getTable().getValueAt(selectedRow, 3).toString();

                ds.getCourse().setCurrentPartId(Integer.parseInt(g.getPp().getModel().getValueAt(selectedRow, 0).toString()));

                g.getPp().getCp().getUpdateWeightField().setText(weight);
                ch.fetchStudentPart(Integer.parseInt(g.getPp().getTable().getValueAt(selectedRow, 0).toString()));
            }

            });
        }

    public void backButtonPartPanel(){
        g.getPp().getCp().getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setContentPane(g.getSpine());
                g.pack();
            }
        });
    }

    public void addStudents(){
        g.getPp().getCp().getAddStudentButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.getPp().getCp().getAddStudentButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
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
                    }
                });
            }
        });
    }

    public void addStudentsToCourse(){
        g.getAsf().getCp().getAddStudentsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.getAsf().getTable().setRowSelectionInterval(0, 0);
                ch.addStudentsToCourse();
            }
        });
    }

    public void studentSearch(){

        g.getAsf().getCp().getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Student> students = new ArrayList<Student>();
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
            }
        });
    }

    public void updatePartCourseWeight(){
        g.getPp().getCp().getUpdatePart().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int weight = Integer.parseInt(g.getPp().getCp().getUpdateWeightField().getText());
                int id = Integer.parseInt(g.getPp().getTable().getValueAt(g.getPp().getTable().getSelectedRow(), 0).toString());
                int previousWeight = Integer.parseInt(g.getPp().getTable().getValueAt(g.getPp().getTable().getSelectedRow(), 3).toString());

                ch.fetchCourseParts(ds.getCourse().getName());
                ds.addPartsToList();
                ch.updatePart("Part", "Part_weight", weight, "part_id", id, previousWeight);
                ch.fetchCourseParts(ds.getCourse().getName());
            }
        });


    }

    public void deleteCourse(){
        g.getCp().getDeleteCourseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        new ConfirmationFrame(ch, g);
            }
        });
    }



}

