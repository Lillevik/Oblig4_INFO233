package Tests;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.DataStores;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames.Gui;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by on 11.05.16.
 * This is a test class for projects tests
 */
public class ConnectionHandlingTest {

    ConnectionHandling ch;
    DataStores ds;
    Gui g;
    public void setUp(){
        g = new Gui();
        g.setVisible(false);
        ds = new DataStores(g);
        ch = new ConnectionHandling(ds ,g);
    }


    @Test
    public void testChangeStringGrade(){
        String grade = "A";
        double exepcted = 1;
        double result = ch.changeStringGrade(grade);

        assertEquals(exepcted, result, 0);
    }

    @Test
    public void testChangeDoubleGrade(){
        double grade = 1;
        String expected = "A";
        String actual = ch.changeDoubleGrade(grade);

        assertSame(expected, actual);

    }
}