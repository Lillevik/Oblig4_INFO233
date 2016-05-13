package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import javax.swing.*;
import java.awt.*;

/**
 * This is the panel which is placed in the center of the
 * spine frame in gui. It contains the JTable and a customOutPutstream.
 * Created by mariuslillevik on 10.03.16.
 * @author puz001, esj002
 */
public class TablePanel extends JPanel {

    /**
     * This is the constructor of the TablePanel class
     * which initialized the components the the program.
     * @param pane - The pane to add to the table panel
     */
    public TablePanel(JScrollPane pane){
        setLayout(new BorderLayout(1, 1));
        add(pane, BorderLayout.CENTER);
    }
}

