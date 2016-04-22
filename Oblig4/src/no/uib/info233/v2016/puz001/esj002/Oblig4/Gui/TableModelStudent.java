package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui;

import javax.swing.table.DefaultTableModel;

/**
 * Created by svimanet on 22/04/16.
 */
public class TableModelStudent extends DefaultTableModel {

    final Class<?>[] columnClasses = new Class<?>[] {Integer.class, String.class, String.class};

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }
}