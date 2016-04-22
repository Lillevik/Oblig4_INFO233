package no.uib.info233.v2016.puz001.esj002.Oblig4.SQL;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Gui;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.PartCourseFrame;

/**
 * Created 19/04/16.
 */
public class Main {

    public static void main(String[] args){

        Gui g = new Gui();
        ConnectionHandling ch = new ConnectionHandling();
        Controls controls = new Controls(g, ch);

        controls.controlActions();
    }
}
