package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Models;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Created by marius on 25.04.2016.
 *
 * This is a class for creating custom models.
 * It is used as a kind of factory
 *
 * @author marius
 */
public class ModelFactory {

    //This is a model used for courses
    private static DefaultTableModel courseModel = new DefaultTableModel(){



        final Class<?>[] columnClasses = new Class<?>[]{Integer.class, String.class, String.class, String.class};

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnClasses[columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column){
            return column == 2 || column == 3;
        }


    };

    //This is a model used for displaying parts
    private static DefaultTableModel partModel = new DefaultTableModel(){


        final Class<?>[] columnClasses = new Class<?>[]{Integer.class, String.class, String.class, Integer.class};

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnClasses[columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column){
            return column == 2;
        }

    };

    //This is a model used for displaying part evalutations
    private static DefaultTableModel partEvaluationModel = new DefaultTableModel(){


        final Class<?>[] columnClasses = new Class<?>[]{Integer.class, Integer.class, String.class};

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnClasses[columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column){
            return column == 2;
        }

    };

    //This is a model used for displaying students
    private static DefaultTableModel studentModel = new DefaultTableModel(){

        final Class<?>[] columnClasses = new Class<?>[]{Integer.class, String.class, Boolean.class};

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return columnClasses[columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column){
            return column == 2;
        }

    };

    //This is a cellRenderer used for custom rendering
    public static DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer()

    {

        @Override
        public void setValue(Object value) {
            int value1 = Integer.parseInt(value.toString());
            setText(value1 + "%");
    }
    };

    /**
     * This is a getter for the custom model courseModel
     * @return - The DefaultTableModel from the courseModel field
     */
    public static DefaultTableModel createCourseModel(){
        return courseModel;
    }

    /**
     * This is a getter for the custom model partModel
     * @return - The DefaultTableModel from the partModel field
     */
    public static DefaultTableModel createPartModel(){
        return partModel;
    }

    /**
     * This is a getter for the custom model partEvaluationModel
     * @return - The DefaultTableModel from the partEvaluationModel field
     */
    public static DefaultTableModel createPartEvaluationModel(){
        return partEvaluationModel;
    }

    /**
     * This is a getter for the custom model studentModel
     * @return - The DefaultTableModel from the studentModel field
     */
    public static DefaultTableModel createStudentModel(){
        return studentModel;
    }

    /**
     * This is a getter for the custom cellRenderer cellRenderer
     * @return - The DefaultTableCellRenderer from the cellRenderer field
     */
    public static DefaultTableCellRenderer createCellRenderer(){
        return cellRenderer;
    }
}
