package no.uib.info233.v2016.puz001.esj002.Oblig4.Main;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.DataStores;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames.Gui;

/**
 * Created 19/04/16.
 */
public class Main {

    public static void main(String[] args){
        Gui g = new Gui();
        DataStores ds = new DataStores();
        ConnectionHandling ch = new ConnectionHandling(ds, g);

        Controls controls = new Controls(g, ch, ds);
        ch.listCourses();

        g.getModel().addTableModelListener(new TableControls(ch, g, ds));
        g.getPp().getModel().addTableModelListener(new TableControls(ch, g, ds));
        g.getPp().getStudentModel().addTableModelListener(new TableControls(ch, g, ds));
        controls.controlActions();
    }
}
