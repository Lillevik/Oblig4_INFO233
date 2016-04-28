package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by marius on 28.04.2016.
 */
public class ConfirmationFrame extends JFrame {

    private JButton yes = new JButton("Yes");
    private JButton no = new JButton("No");

    private JLabel info = new JLabel("<html><p>Are you sure you want to delete the course?<br>" +
            "                   This will also delete all of its part <br>" +
            "evaluations and students taking the course.<html>");

    private ConnectionHandling ch;
    private Gui g;

    public ConfirmationFrame(ConnectionHandling ch, Gui g){
        this.ch = ch;
        this.g = g;
        setTitle("Information");
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(500, 200));
        setVisible(true);
        deleteCourse();
        cancelDelete();
        placeComponents();
        pack();


        setLocationRelativeTo(null);
        setVisible(true);
    }



    public void deleteCourse(){
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = g.getTable().getSelectedRow();
                int id = Integer.parseInt(g.getTable().getValueAt(row, 0).toString());
                String name = g.getTable().getValueAt(row, 1).toString();

                ch.deleteCourse(id, name);
                dispose();
            }
        });
    }

    public void cancelDelete(){
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void placeComponents(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;

        gc.gridx = 0;
        gc.gridy = 0;
        this.add(info, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        this.add(yes, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        this.add(no, gc);
    }








    public JButton getYes() {
        return yes;
    }

    public JButton getNo() {
        return no;
    }
}
