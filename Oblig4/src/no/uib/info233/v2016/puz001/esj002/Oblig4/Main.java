package no.uib.info233.v2016.puz001.esj002.Oblig4;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created 19/04/16.
 */
public class Main {

    private static ConnectionHandling ch = new ConnectionHandling();
    private static Gui gui = new Gui();


    public static void main(String[] args){
        ConnectionHandling ch = new ConnectionHandling();
        Gui g = new Gui();

        g.getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch.insertRecordIntoDbUserTable(
                        g.getGradeChooser().getSelectedItem().toString(),
                        g.getLocationText().getText());
            }
        });

        g.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.closeWindow();
            }
        });
    }
}
