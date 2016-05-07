package no.uib.info233.v2016.puz001.esj002.Oblig4.Main;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.DataStores;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames.Gui;

/**
 * Created 19/04/16.
 */
public class Main {

    /**
     * This is the main method which combines the classes and instantiates
     * them together in order to communicate and run methods.
     * @param args - String Array
     */
    public static void main(String[] args){
        Gui g = new Gui();
        DataStores ds = new DataStores(g);
        ConnectionHandling ch = new ConnectionHandling(ds, g);

        Controls controls = new Controls(g, ch, ds);
        ch.listCourses();


        TableControls tc = new TableControls(ch, ds);
        g.getModel().addTableModelListener(tc);
        g.getPp().getModel().addTableModelListener(tc);
        g.getPp().getStudentModel().addTableModelListener(tc);
        controls.controlActions();
    }
}
