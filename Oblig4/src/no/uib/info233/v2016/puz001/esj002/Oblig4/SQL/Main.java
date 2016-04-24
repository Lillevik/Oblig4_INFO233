package no.uib.info233.v2016.puz001.esj002.Oblig4.SQL;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.DataStores;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Gui;

/**
 * Created 19/04/16.
 */
public class Main {

    public static void main(String[] args){
        Gui g = new Gui();
        DataStores ds = new DataStores();
        ConnectionHandling ch = new ConnectionHandling(ds);

        Controls controls = new Controls(g, ch, ds);
        ch.listCourses(g);
        controls.controlActions();
    }
}
