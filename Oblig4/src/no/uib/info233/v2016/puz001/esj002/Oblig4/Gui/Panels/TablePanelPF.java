package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;


import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

/**
 * This is the panel which is placed in the center of the
 * spine frame in gui. It contains the JTable and a customOutPutstream.
 * Created by mariuslillevik on 10.03.16.
 */
public class TablePanelPF extends JPanel {



    private JScrollPane partPane;
    private JScrollPane studentPane;


    /**
     * This is the constructor of the TablePanel class
     * which initialized the components the the program.
     * @param partPane
     * @param studentPane
     */
    public TablePanelPF(JScrollPane partPane, JScrollPane studentPane){
        this.partPane = partPane;
        this.studentPane = studentPane;
        setLayout(new BorderLayout(1, 1));
        setupComponents();
        add(partPane, BorderLayout.CENTER);
        add(studentPane, BorderLayout.SOUTH);
    }

    /**
     * This is the method that sets up the components and
     * specifies their size and so on.
     */
    public void setupComponents(){

    }



}
