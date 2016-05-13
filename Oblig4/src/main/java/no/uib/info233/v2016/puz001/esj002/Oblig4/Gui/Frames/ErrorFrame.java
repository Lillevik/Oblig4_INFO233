package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames;

import javax.swing.*;
import java.awt.*;

/** This class is a panel created to show error dialouges.
     * Indead of printing errors it will display the errors that are catched in an error box.
     */
    public class ErrorFrame extends JOptionPane {

    private JPanel spine = new JPanel();

    public ErrorFrame(){
        add(spine);
        spine.setPreferredSize(new Dimension(100, 100));
    }
}
