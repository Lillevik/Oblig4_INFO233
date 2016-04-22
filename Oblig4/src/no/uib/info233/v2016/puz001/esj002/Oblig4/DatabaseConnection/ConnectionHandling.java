package no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection;

import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Gui;

import java.sql.*;
import java.util.Properties;

/**
 * Created 16.04.2016.
 * Class for importing database data.
 */
public class ConnectionHandling {

    public Connection getDbConnection() {
        try {
            Class.forName(("com.mysql.jdbc.Driver"));
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Feil i lasting av jdbs-driver" + cnfe);
        }


        String host = "bigfoot.uib.no";
        String dbName = "gr9_16";
        int port = 3306;
        String mySqlUrl = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        System.out.println(mySqlUrl);

        Properties userInfo = new Properties();
        userInfo.put("user", "i233_16_gr9");
        userInfo.put("password", "oldkty");

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(mySqlUrl, userInfo);
        } catch (SQLException e) {
            System.out.println("Feil i oppkobling! Sjekk Konsoll");
            e.printStackTrace();
        }

        if (conn != null) {
            System.out.println("Oppkolbing OK.");
        } else {
            System.out.println("Kunne ikke koble opp mot databasen.");
        }
        return conn;
    }


    public void insertRecordIntoDbUserTable(String desc, String name, String professor) {

        Connection dbConnection = null;
        Statement statement = null;

        try {


            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate("INSERT INTO Course (name, description, professor) " + "VALUES " +
                    "('" + name + "', '" + desc + "', '" + professor + "')");


            System.out.println("A course was sucsessfully inserted into the Course table!");


            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }

    public void listCourses(Gui g) {

        Connection dbConnection = null;
        Statement statement = null;
        g.tableRows();
        try {


            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();

            String sql = ("SELECT * FROM  `Course` ORDER BY c_id DESC LIMIT 100;");// ORDER BY c_id DESC;");
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("c_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String professor = rs.getString("professor");

                //System.out.println("ID: " + id + " Name: " + name + "Description: " + description + " Professor: " + professor);
                g.getModel().addRow(new Object[]{id, name, description, professor});
            }



        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }
}
