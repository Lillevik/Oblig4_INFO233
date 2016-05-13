package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames;

import javax.swing.*;
import java.awt.*;

/** Created 13.05.16
 * This class is a panel created to show error dialouges.
 * Indead of printing errors it will display the errors that are catched in an error box.
 * @author puz001, esj002
 */
public class ErrorFrame extends JOptionPane {

    private JPanel spine = new JPanel();

    /**
     * Constructor for the simple frame
     * that is used to depoly the JOptionsPane
     */
    public ErrorFrame(){
        add(spine);
        spine.setPreferredSize(new Dimension(100, 100));
    }
}
