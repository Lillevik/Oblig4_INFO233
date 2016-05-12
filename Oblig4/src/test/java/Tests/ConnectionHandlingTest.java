package Tests;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.DataStores;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames.Gui;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by goat on 11.05.16.
 */
public class ConnectionHandlingTest {

    @Test
    public void testChangeStringGrade() throws Exception {
        Gui g = new Gui();
        g.setVisible(false);
        DataStores ds = new DataStores(g);
        ConnectionHandling ch = new ConnectionHandling(ds ,g);
        String grade = "A";

        double exepcted = 1;
        double result = ch.changeStringGrade(grade);

        assertEquals(exepcted, result, 0);
    }

    @Test
    public void testChangeDoubleGrade() throws Exception {

    }
}