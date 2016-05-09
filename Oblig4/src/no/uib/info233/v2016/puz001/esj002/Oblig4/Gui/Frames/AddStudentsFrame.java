package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames;


import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Models.ModelFactory;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels.ControlPanelStudentFrame;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels.TablePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by marius on 24.04.2016.
 * This class is a custom JFrame for adding students to a course
 * @author marius
 */
public class AddStudentsFrame extends JFrame{

    //These are the fields for the AddStudentsFrame class
    private DefaultTableModel model = ModelFactory.createStudentModel();
    private JTable table = new JTable(model);
    private ControlPanelStudentFrame cp = new ControlPanelStudentFrame();


    /**
     * This is the constructor for the AddStudentFrame class.
     */
    public AddStudentsFrame(){
        tableRows();
        this.setBounds(30, 30, 30, 30);
        this.setPreferredSize(new Dimension(1000, 600));
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLayout(new BorderLayout(1,1));
        this.setVisible(false);
        JScrollPane pane = new JScrollPane(table);
        TablePanel tp = new TablePanel(pane);
        this.add(tp, BorderLayout.CENTER);
        this.add(cp, BorderLayout.WEST);
        pack();
    }

    /**
     * This method clears the table rows to
     * make space for adding new rows.
     */
    public void tableRows(){
        model.setRowCount(0);
    }

    /**
     * This is a getter for the model field
     * @return - The DefaultTableModel from the model field
     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**
     * This is a getter for the table field
     * @return - The JTable table
     */
    public JTable getTable() {
        return table;
    }

    /**
     * This is a getter for the field cp
     * @return - The ControlPanelStudentFrame value from the field cp
     */
    public ControlPanelStudentFrame getCp() {
        return cp;
    }
}
