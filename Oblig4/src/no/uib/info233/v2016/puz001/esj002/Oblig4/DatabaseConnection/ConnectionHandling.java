package no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by marius on 16.04.2016.
 */
public class ConnectionHandling {

    public void connectToDatabase() {
        try {
            Class.forName(("com.mysql.jdbc.Driver"));
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Feil i lasting av jdbs-driver" + cnfe);
        }


        String host = "bigfoot.uib.no";
        String dbName = "gr9_16";
        int port = 3306;
        String mySqlUrl = "jdbc:mysql://" + host + ":" + port;// + "/" + dbName;
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

    }

    public static void main(String[] args){
        ConnectionHandling ch = new ConnectionHandling();
        ch.connectToDatabase();
    }


}
