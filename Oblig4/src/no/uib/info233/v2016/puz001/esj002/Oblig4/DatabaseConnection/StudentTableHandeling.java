package no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection;

import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Gui;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.StudentFrame;

import java.sql.*;
import java.util.Properties;

/**
 * Created by svimanet on 22/04/16.
 */
public class StudentTableHandeling {

    private ConnectionHandling ch;

    public StudentTableHandeling(ConnectionHandling ch) {
        this.ch = ch;
        ch.getDbConnection();
    }

    public String insertRecordIntoDbUserTable(String name) {

        Connection dbConnection = null;
        Statement statement = null;

        try {


            dbConnection = ch.getDbConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate("INSERT INTO Student (student_name)  " + "VALUES " +
                    "('" + name + "')");


            System.out.println("A student was sucsessfully inserted into the Student table!");


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


    public void listStudents(StudentFrame sf) {

        Connection dbConnection = null;
        Statement statement = null;
        sf.tableRows();
        try {


            dbConnection = ch.getDbConnection();
            statement = dbConnection.createStatement();

            String sql = ("SELECT * FROM  `Student` ORDER BY student_id;");
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
