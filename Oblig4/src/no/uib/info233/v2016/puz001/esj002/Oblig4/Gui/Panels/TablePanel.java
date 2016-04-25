package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.CustomOutputStream;

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
public class TablePanel extends JPanel {



    private JScrollPane pane = new JScrollPane();
    //JScrollPane informationPanel = new JScrollPane(this.textArea);
    private JTextArea textArea;
    private PrintStream standardOut;


    /**
     * This is the constructor of the TablePanel class
     * which initialized the components the the program.
     * @param pane
     */
    public TablePanel(JScrollPane pane){
        this.pane = pane;
        setLayout(new BorderLayout(1, 1));
        setupComponents();
        add(pane, BorderLayout.CENTER);
    }

    /**
     * This is the method that sets up the components and
     * specifies their size and so on.
     */
    public void setupComponents(){
        // Initialize the text area
        this.textArea = new JTextArea(10, 0);
        this.textArea.setBounds(0, 0, 100, 100);
        this.textArea.setEditable(false);
        this.textArea.setLineWrap(true); // Wrap text
        this.textArea.setWrapStyleWord(true); // Wrap by word


        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        standardOut = System.out;

        //System.setOut(printStream);
        //System.setErr(printStream); disabled so the users will not be confused

        // Put the text area into a JScrollPane so it can be scrolled
        JScrollPane informationPanel = new JScrollPane(this.textArea);
        // Always show vertical scroll bar
        informationPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the informationPanel to the bottom og the window
        this.add(informationPanel, BorderLayout.SOUTH);
    }



}

