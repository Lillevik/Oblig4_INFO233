package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames;

import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels.TablePanel;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Models.StudentTableModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marius on 24.04.2016.
 */
public class AddStudentsFrame extends JFrame{

    private StudentTableModel model = new StudentTableModel();
    private JTable table = new JTable(model);
    private JScrollPane pane = new JScrollPane(table);

    //Panels
    private TablePanel tp = new TablePanel(pane);



    public AddStudentsFrame(){
        tableRows();
        this.setPreferredSize(new Dimension(1000, 600));
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLayout(new BorderLayout(1,1));
        this.setVisible(false);
        this.add(tp, BorderLayout.CENTER);
        setContentPane(tp);
        pack();
    }

    public void tableRows(){
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn("Student ID");
        model.addColumn("Student Name");
        model.addColumn("Tick box");
    }

    public StudentTableModel getModel() {
        return model;
    }
}
