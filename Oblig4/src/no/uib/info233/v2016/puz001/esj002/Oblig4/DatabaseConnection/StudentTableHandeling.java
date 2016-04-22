package no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection;

import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Gui;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.StudentFrame;
import java.sql.*;

/**
 * Created 22/04/16.
 *
 * This class imports the 'Student' table from the database.
 * It uses the same method for connection as the original Handeling class.
 * The methods of the class is edited to get the right table.
 *
 */
public class StudentTableHandeling {

    private ConnectionHandling ch;
    private Gui g;

    /**
     * This method imports other classes to allow reusing methods.
     * The method reused is the 'DbConnection' class from
     * the connectionHandeling class. The method connects to the online
     * database.
     * @param ch
     * @param g
     */
    public StudentTableHandeling(ConnectionHandling ch, Gui g) {
        this.ch = ch;
        this.g = g;
        ch.getDbConnection();
    }

    /**
     * This metohd lets the user add a Student to the 'Student'
     * table in the database. It takes ahold of one user input defining
     * 'name' and auto implments the student_id row.
     *
     * @param name
     * @return
     */
    public String insertRecordIntoDbUserTable(String name) {

        Connection dbConnection = null;
        Statement statement = null;

        try {

            dbConnection = ch.getDbConnection();
            statement = dbConnection.createStatement();

            if (!g.getSf().getStudentName().equals(null)){
                g.getSf().getHeader().setText("ERROR: Name cant be null");

            } else {
                statement.executeUpdate("INSERT INTO Student (student_name)  " + "VALUES " +
                        "('" + name + "')");
                System.out.println("A student was sucsessfully inserted into the Student table!");

            }

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
        return name;
    }

    /**
     * This method imports the 'Student' table form the database
     * and lists it in the table deployed in 'StudentFrame'.
     *
     * @param sf
     */
    public void listStudents(StudentFrame sf) {

        Connection dbConnection = null;
        Statement statement = null;
        sf.tableRows();
        try {


            dbConnection = ch.getDbConnection();
            statement = dbConnection.createStatement();

            String sql = ("SELECT * FROM  `Student` ORDER BY student_id");
            ResultSet rs = statement.executeQuery(sql);


            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");

                sf.getStudentModel().addRow(new Object[]{id, name});
            }



        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }
}
