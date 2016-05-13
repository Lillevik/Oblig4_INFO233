package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import javax.swing.*;
import java.awt.*;

/**
 * This is the panel which is placed in the center of the
 * spine frame in gui. It contains the JTable and a CustomOutputStream.
 * Created by mariuslillevik on 10.03.16.
 * @author puz001, esj002
 */
public class TablePanelPF extends JPanel {


    /**
     * This is the constructor of the TablePanel class
     * which initialized the components the the program.
     * @param partPane - The pane to  use for parts info
     * @param studentPane - The student pane to use for students grades
     */
    public TablePanelPF(JScrollPane partPane, JScrollPane studentPane){
        setLayout(new BorderLayout(1, 1));
        add(partPane, BorderLayout.CENTER);
        add(studentPane, BorderLayout.SOUTH);
    }
}
