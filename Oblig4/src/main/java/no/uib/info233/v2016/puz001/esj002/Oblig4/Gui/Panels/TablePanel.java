package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.CustomOutputStream;

import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;

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
        setupComponents();
        add(pane, BorderLayout.CENTER);
    }

    /**
     * This is the method that sets up the components and
     * specifies their size and so on.
     */
    public void setupComponents(){
        // Initialize the text area
        JTextArea textArea = new JTextArea(10, 0);
        textArea.setBounds(0, 0, 100, 100);
        textArea.setEditable(false);
        textArea.setLineWrap(true); // Wrap text
        textArea.setWrapStyleWord(true); // Wrap by word

        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        PrintStream standardOut = System.out;

        JScrollPane informationPanel = new JScrollPane(textArea);
        informationPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(informationPanel, BorderLayout.SOUTH);
    }
}

