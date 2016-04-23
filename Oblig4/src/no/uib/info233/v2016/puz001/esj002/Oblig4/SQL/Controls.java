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

    public Controls(Gui g, ConnectionHandling ch) {
        this.g = g;
        this.ch = ch;
    }

    public void controlActions() {
        createCourse();
        listCourses();
        addNewPart();
        login();
        changeToRegisterPanel();
        registerNewUser();
        switchUser();
        cancelRegistration();
    }


    public void createCourse() {

        g.getCp().getAddCourseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch.insertRecordIntoDbUserTable(
                        g.getCp().getDescriptionField().getText(),
                        g.getCp().getTitleField().getText(),
                        g);
                ch.listCourses(g);
            }
        });
    }

    public void listCourses() {

        g.getCp().getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        g.getLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setContentPane(g.getLp());
                g.pack();
            }
        });
    }

    public void cancelRegistration(){
        g.getRp().getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setContentPane(g.getLp());
                g.pack();
            }
        });
    }
}
