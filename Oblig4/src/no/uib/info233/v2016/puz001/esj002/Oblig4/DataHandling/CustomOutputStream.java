package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * Created by mariuslillevik on 10.03.16.
 *
 * This class is used for redirecting the outputStream to a custom textField
 * @author Marius
 */

public class CustomOutputStream extends OutputStream implements Serializable {
    /**
     * Fields for the Class CustomOutputStream
     */
    private static final long serialVersionUID = 1L;
    private JTextArea textArea;


    /**
     * This is the constructor for the CustomOutputStream class
     * @param textArea - The text area to output information
     */
    public CustomOutputStream(JTextArea textArea) {

        this.textArea = textArea;
    }


    /**
     * This method writes a value to the textField
     * @param b - The b value
     * @throws IOException
     */
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}