package no.uib.info233.v2016.puz001.esj002.Oblig4.SQL;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Gui;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.PartCourseFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by goat on 21.04.16.
 */
public class Controls {

    private Gui g;
    private ConnectionHandling ch;

    public Controls(Gui g, ConnectionHandling ch){
        this.g = g;
        this.ch = ch;
    }

    public void controlActions(){
        createCourse();
        listCourses();
        cancelButton();
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

    public void addNewPart(){
        g.getPartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PartCourseFrame();
            }
        });
    }

}
