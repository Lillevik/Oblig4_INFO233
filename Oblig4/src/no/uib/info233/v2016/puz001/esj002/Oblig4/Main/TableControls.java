package no.uib.info233.v2016.puz001.esj002.Oblig4.Main;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.DataStores;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames.Gui;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Created by marius on 25.04.2016.
 */
public class TableControls implements TableModelListener {

    private ConnectionHandling ch;
    private Gui g;
    private DataStores ds;

    public TableControls(ConnectionHandling ch, Gui g, DataStores ds) {
        this.ch = ch;
        this.g = g;
        this.ds = ds;
    }

    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel) e.getSource();
        String columnName = model.getColumnName(column);

        //Object data = model.getValueAt(row, column); <-- This had to be defined within
        //the if clauses in order to avoid ArrayIndexOutOfBounds exception. When I tried to clear the
        //models, exceptions was thrown right away.



        if (columnName.equals("Description")) {
            Object data = model.getValueAt(row, column);
            int id = Integer.parseInt(model.getValueAt(row, 0).toString());
            ch.updateCourseTable("Course", "description", data.toString(), "c_id", id);
            JOptionPane.showMessageDialog(new JOptionPane(), "Successfully updated the Description in the database.", "Info", JOptionPane.INFORMATION_MESSAGE);


        } else if (columnName.equals("Professor")) {
            Object data = model.getValueAt(row, column);
            int id = Integer.parseInt(model.getValueAt(row, 0).toString());
            ch.updateCourseTable("Course", "professor", data.toString(), "c_id", id);
            JOptionPane.showMessageDialog(new JOptionPane(), "Successfully updated the Professor in the database.", "Info", JOptionPane.INFORMATION_MESSAGE);


        } else if (columnName.equals("Part Name")) {
            Object data = model.getValueAt(row, column);
            int id = Integer.parseInt(model.getValueAt(row, 0).toString());
            ch.updateCourseTable("Part", "Part_name", data.toString(), "part_id", id);
            JOptionPane.showMessageDialog(new JOptionPane(), "Successfully updated the Part Name in the database.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }


        else if(columnName.equals("Part Grade")){
            Object data = model.getValueAt(row, column);
            if(data.toString().equals("a") || data.toString().equals("A") ||
                    data.toString().equals("b") || data.toString().equals("B")||
                    data.toString().equals("c") || data.toString().equals("C")||
                    data.toString().equals("d") || data.toString().equals("D")||
                    data.toString().equals("e") || data.toString().equals("E")||
                    data.toString().equals("f") || data.toString().equals("F")){
                int studentId = Integer.parseInt(model.getValueAt(row, 1).toString());
                int partId = Integer.parseInt(model.getValueAt(row, 0).toString());
                ch.updatePartCourseGrade(data.toString(), studentId, partId);
                JOptionPane.showMessageDialog(new JOptionPane(), "Successfully updated the grade to " + data.toString() + ".", "Info", JOptionPane.INFORMATION_MESSAGE);

            } else{
                JOptionPane.showMessageDialog(new JOptionPane(), "You may only use the letters A, B, C, D, E or F.", "Error", JOptionPane.ERROR_MESSAGE);
                ch.fetchStudentPart(ds.getCourse().getCurrentPartId());
            }
        }
    }
}

