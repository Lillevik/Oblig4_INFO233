package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marius on 28.04.2016.
 *
 * This is a frame for confirming deletion of a course
 * @author marius
 */
public class ConfirmationFrame extends JFrame {

    //These are the fields for the ConfirmationFrame class
    private JButton yes = new JButton("Yes");
    private JButton no = new JButton("No");
    private JLabel info = new JLabel("<html><p>Are you sure you want to delete the course?<br>" +
            "                   This will also delete all of its part <br>" +
            "evaluations and students taking the course.<html>");
    private ConnectionHandling ch;
    private Gui g;

    /**
     * This is the constructor for the ConfirmationFrame class
     * @param ch - The ConnectionHandling to use
     * @param g - The Gui to use
     */
    public ConfirmationFrame(ConnectionHandling ch, Gui g){
        this.ch = ch;
        this.g = g;
        setTitle("Information");
        setVisible(true);
        deleteCourse();
        cancelDelete();
        setLayout(new FlowLayout());
        placeComponents();
        setPreferredSize(new Dimension(300, 150));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    /**
     * This is an actionListener for the yes button which
     * deletes a course on activation
     */
    private void deleteCourse(){
        yes.addActionListener(e -> {
            int row = g.getTable().getSelectedRow();
            int id = Integer.parseInt(g.getTable().getValueAt(row, 0).toString());
            String name1 = g.getTable().getValueAt(row, 1).toString();
            ch.deleteCourse(id, name1);
            dispose();
        });
    }

    /**
     * This is an actionListener for the no button which
     * disposes the frame on activation.
     */
    private void cancelDelete(){
        no.addActionListener(e -> dispose());
    }

    /**
     * This method customises components in the frame
     * and then adds them to the frame.
     */
    private void placeComponents(){
        info.setBounds(50, 50, 50, 50);
        yes.setBounds(100, 100, 100, 100);
        no.setBounds(200, 100, 100, 100);

        add(info);
        add(yes);
        add(no);
    }

    /**
     * This is a getter for the field yes
     * @return - The JButton from the field yes
     */
    public JButton getYes() {
        return yes;
    }

    /**
     * This is a getter for the field no
     * @return - The JButton from the field no
     */
    public JButton getNo() {
        return no;
    }
}
