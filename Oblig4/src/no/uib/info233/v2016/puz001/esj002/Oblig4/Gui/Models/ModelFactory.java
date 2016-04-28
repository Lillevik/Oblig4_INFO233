package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Models;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Created by marius on 25.04.2016.
 */
public class ModelFactory {

    private static DefaultTableModel courseModel = new DefaultTableModel(){



        final Class<?>[] columnClasses = new Class<?>[]{Integer.class, String.class, String.class, String.class};

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnClasses[columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column){
            if(column == 2 || column == 3){
                return true;
            } else {

                return false;
            }
        }


    };

    private static DefaultTableModel partModel = new DefaultTableModel(){


        final Class<?>[] columnClasses = new Class<?>[]{Integer.class, String.class, String.class, Integer.class};

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnClasses[columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column){
            if(column == 2 || column == 3){
                return true;
            } else {
                return false;
            }
        }

    };

    private static DefaultTableModel partEvaluationModel = new DefaultTableModel(){


        final Class<?>[] columnClasses = new Class<?>[]{Integer.class, Integer.class, String.class};

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnClasses[columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column){
            if(column == 2){
                return true;
            } else {
                return false;
            }
        }

    };

    private static DefaultTableModel studentModel = new DefaultTableModel(){

        final Class<?>[] columnClasses = new Class<?>[]{Integer.class, String.class, Boolean.class};

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnClasses[columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column){
            if(column == 2){
                return true;
            } else {
                return false;
            }
        }

    };


    public static DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer()

    {

        @Override
        public void setValue(Object value) {
            int value1 = Integer.parseInt(value.toString());
            String percentage = Integer.toString(value1);
            setText(value1 + "%");
    }
    };
    public static DefaultTableModel createCourseModel(){
        return courseModel;
    }

    public static DefaultTableModel createPartModel(){
        return partModel;
    }

    public static DefaultTableModel createPartEvaluationModel(){
        return partEvaluationModel;
    }

    public static DefaultTableModel createStudentModel(){
        return studentModel;
    }

    public static DefaultTableCellRenderer createCellRenderer(){
        return cellRenderer;
    }




}
