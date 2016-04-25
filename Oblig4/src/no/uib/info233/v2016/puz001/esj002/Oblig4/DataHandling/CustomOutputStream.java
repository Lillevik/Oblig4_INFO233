package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * Created by mariuslillevik on 10.03.16.
 */

public class CustomOutputStream extends OutputStream implements Serializable {
    /**
     * Fields for the Class CustomOutputStream
     */
    private static final long serialVersionUID = 1L;
    private JTextArea textArea;


    /**
     * @Param JTextArea
     */
    public CustomOutputStream(JTextArea textArea) {

        this.textArea = textArea;
    }


    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}