package no.uib.info233.v2016.puz001.esj002.Oblig4.Main;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection.ConnectionHandling;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames.Gui;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Created by marius on 25.04.2016.
 */
public class TableControls implements TableModelListener {

    private ConnectionHandling ch;
    private Gui g;

    public TableControls(ConnectionHandling ch, Gui g) {
        this.ch = ch;
        this.g = g;
    }


    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        Object data = model.getValueAt(row, column);

            int selectedRow = g.getTable().getSelectedRow();
            //int id = Integer.parseInt(g.getTable().getValueAt(selectedRow, 2).toString());

            ch.updateCourseTable(data.toString(), 23, g);

    }
}

