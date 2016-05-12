package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Models.ModelFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Marius on 04.05.2016.
 * @author marius
 */
public class CourseGradesPanel extends JPanel{

    private DefaultTableModel model = ModelFactory.getFinalGradeModel();
    private JTable table = new JTable(model);
    private JScrollPane pane = new JScrollPane(table);


    public CourseGradesPanel(){
        this.add(pane);
        this.setPreferredSize(new Dimension(300, 300));
        model.addColumn("Student");
        model.addColumn("Course");
        model.addColumn("Grade");
    }

}
