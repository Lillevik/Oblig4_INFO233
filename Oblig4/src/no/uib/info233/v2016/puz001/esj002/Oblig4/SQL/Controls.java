package no.uib.info233.v2016.puz001.esj002.Oblig4.SQL;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.StudentTableHandeling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Gui;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.PartCourseFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esj002 && Puz001
 * Created 21.04.16.
 *
 * The Controls class is a class for all action events
 * and listeners. It takes buttons from all GUI related
 * classes and connects them with a method.
 * The methods and buttons are then initiated in the Main class.
 *
 */
public class Controls {

    private Gui g;
    private ConnectionHandling ch;
    private StudentTableHandeling sth;


    public Controls(Gui g, ConnectionHandling ch, StudentTableHandeling sth){
        this.g = g;
        this.ch = ch;
        this.sth = sth;
    }

    /**
     * This method initioates all the possible methods in this class.
     */
    public void controlActions(){

        createCourse();
        listCourses();
        cancelButton();
        listStudents();
        addStudents();
        exitStudentFrame();
        addNewPart();
        login();
        changeToRegisterPanel();
        registerNewUser();
        switchUser();
    }


    /**
     * This method lets the user add new courses
     * to the 'Course' table in the database.
     * The user HAS to input name and desc, but the ADMIN row is auto
     * implemented by who is logged inn.
     */
    public void createCourse() {
        g.getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch.insertRecordIntoDbUserTable(
                        g.getDescriptionField().getText(),
                        g.getCourseNameField().getText(),
                        g.getProfessorField().getText());
                ch.listCourses(g);
            }
        });
    }

    /**
     * This button is for exiting the program.
     */
    public void cancelButton() {
        g.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.closeWindow();
            }
        });
    }

    /**
     * This method lets the user update the 'Course' table from the database.
     *
     */
    public void listCourses() {
        g.getListCourses().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch.listCourses(g);
            }
        });
    }


    /**
     * This method sends the user to a new panel where
     * the table is altered to show the 'Student' table from the database.
     * Here the user can view and add new students to the table.
     * The user can return to the original pane.
     */
    public void listStudents() {
        g.getListStudents().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setContentPane(g.getSf());
                sth.listStudents(g.getSf());
                g.pack();
            }
        });
    }

    /**
     * This method lets the user add students to the 'Student'
     * table in the database. The user only inputs name since
     * the ID is auto implemented in the table.
     * After adding it refills the table so that the new
     * Student(s) is shown.
     */
    public void addStudents(){
        g.getSf().getAddStudent().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sth.insertRecordIntoDbUserTable(
                            g.getSf().getStudentName().getText());
                sth.listStudents(g.getSf());

            }
        });
    }

    /**
     * This method makes the "Back" button in the StudentFrame return the user
     * to the original pane and fills the table accordingly.
     */
    public void exitStudentFrame(){
        g.getSf().getExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setContentPane(g.getSpine());
                g.pack();
                ch.listCourses(g);
            }
        });
    }

    public void addNewPart() {
        g.getPartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PartCourseFrame();
            }
        });


    }

    public void login() {
        g.getLp().getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch.authenticateLogin(g.getLp().getUserField().getText(),
                        g.getLp().getPasswordField().getText(),
                        g);

            }
        });

    }

    public void changeToRegisterPanel(){
        g.getLp().getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setContentPane(g.getRp());
                g.pack();
            }
        });
    }

    public void registerNewUser(){
        g.getRp().getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch.insertNewEmployee(g.getRp().getUserField().getText(),
                                     g.getRp().getPasswordField().getText());
                g.setContentPane(g.getLp());
                g.pack();
            }
        });
    }

    public void switchUser(){
        g.getSwitchUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setContentPane(g.getLp());
            }
        });
    }
}
