package no.uib.info233.v2016.puz001.esj002.Oblig4.SQL;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.StudentTableHandeling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Gui;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.StudentFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by goat on 21.04.16.
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

    public void controlActions(){
        createCourse();
        listCourses();
        cancelButton();
        listStudents();
        addStudents();
        exitStudentFrame();
    }


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

    public void cancelButton() {

        g.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.closeWindow();
            }
        });
    }

    public void listCourses() {

        g.getListCourses().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch.listCourses(g);
            }
        });
    }

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
}
