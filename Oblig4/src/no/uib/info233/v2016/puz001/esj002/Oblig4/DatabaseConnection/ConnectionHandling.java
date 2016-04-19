package no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection;

import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by marius on 16.04.2016.
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
        }   catch (SQLException e){
            System.out.println("Feil i oppkobling! Sjekk Konsoll");
            e.printStackTrace();
        }

        if(conn != null){
            System.out.println("Oppkolbing OK.");
        } else {
            System.out.println("Kunne ikke koble opp mot databasen.");
        }
        return conn;
    }


    private void insertRecordIntoDbUserTable(String grade, String name) {

        Connection dbConnection = null;
        Statement statement = null;

        try {


            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate("INSERT INTO Course (navn, grade)" + "VALUES " +
                    "('" + name + "', '" + grade + "')");


            System.out.println("A course is inserted into the Course table!");



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






    public static void main(String[] args){
        ConnectionHandling ch = new ConnectionHandling();
        Gui g = new Gui();

        g.getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ch.insertRecordIntoDbUserTable(
                        g.getGradeChooser().getSelectedItem().toString(),
                        g.getLocationText().getText());
            }
        });

        g.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.closeWindow();
            }
        });
    }


}
