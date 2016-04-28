package no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.DataStores;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.Student;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.User;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames.ConfirmationFrame;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames.Gui;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Main.TableControls;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created 16.04.2016.
 * Class for importing database data and creating a connection
 * to the database bu authenticating using username and password
 */
public class ConnectionHandling {

    private Gui g;
    private DataStores ds;

    public ConnectionHandling(DataStores ds, Gui g) {
        this.g = g;
        this.ds = ds;
    }


    /**
     * This method creates a new connection to the
     * databse and returns the connection to the system.
     * @return the database connection
     */
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
        //System.out.println(mySqlUrl);

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


    /**
     * This method inserts a new course into the database
     * table 'Course' if it does not allready exist. It
     * takes both a description and a name as a parameter.
     * @param desc
     * @param name
     */
    public void insertNewCourse(String desc, String name) {

        Connection dbConnection = null;
        Statement statement = null;


        if (name.equals("") && desc.equals("")) {
            System.out.println("Please enter values for name and description.");
        } else if (name.equals("")) {
            System.out.println("Please enter a name");
        } else if (desc.equals("")) {
            System.out.println("Please enter a description.");
        } else {
            try {
                dbConnection = getDbConnection();
                statement = dbConnection.createStatement();
                statement.executeUpdate("INSERT INTO Course (name, description, professor) " + "VALUES " +
                        "('" + name + "', '" + desc + "', '" + ds.getUser().getFullName() + "')");

                JOptionPane.showMessageDialog(new JOptionPane(), "Successfully added a new Course.", "Info", JOptionPane.INFORMATION_MESSAGE);


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
    }

    /**
     * This method takes a gui as a parameter and lists all the
     * current courses into the JTable from the database.
     */
    public void listCourses() {

        Connection dbConnection = null;
        Statement statement = null;
        //g.getModel().removeTableModelListener(tc);
        g.tableRows();

        try {


            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();

            String sql = ("SELECT * FROM  `Course`");
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("c_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String professor = rs.getString("professor");

                g.getModel().addRow(new Object[]{id, name, description, professor});
            }


            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
        //g.getModel().addTableModelListener(tc);
    }

    /**
     * This method is authenticating user input and checks
     * it towards the employee table in the database. If the
     * information is correct, the user will be sent to the
     * main panel of the application.
     * @param name
     * @param pass
     */
    public void authenticateLogin(String name, String pass) {

        Connection dbConnection = null;
        Statement statement = null;
        try {


            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();

            String sql = ("SELECT * FROM  `Employee`  WHERE name = '" + name + "' AND password = '" + pass + "' LIMIT 1;");
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                int userId = Integer.parseInt(rs.getString("employee_id"));
                String userName = rs.getString("name");
                String fullName = rs.getString("full_name");

                ds.setUser(new User(userId, userName, fullName));

                g.getCp().getLoggedInAs().setText("Logged in as : " + ds.getUser().getFullName());
                g.setContentPane(g.getSpine());
                g.pack();
            } else {
                g.getLp().getLoggedInLabel().setText("Wrong username or password, try again.");
            }

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    /**
     * This method inserts a new employee into the Employee
     * table if a user with the same username does not
     * allready exist.
     * @param name
     * @param pass
     */
    public void insertNewEmployee(String name, String fullname, String pass) {

        Connection dbConnection = null;
        Statement statement = null;


        if (name.equals("") && pass.equals("")) {
            System.out.println("Please enter values for name and description.");
        } else if (name.equals("")) {
            System.out.println("Please enter a name");
        } else if (pass.equals("")) {
            System.out.println("Please enter a description.");
        } else {
            try {
                dbConnection = getDbConnection();
                statement = dbConnection.createStatement();
                statement.executeUpdate("INSERT INTO Employee (name, full_name, password) " + "VALUES " +
                        "('" + name + "', '" + fullname + "', '" + pass + "')");


                if (statement != null) {
                    statement.close();
                }

                if (dbConnection != null) {
                    dbConnection.close();
                }
                JOptionPane.showMessageDialog(new JOptionPane(), "Successfully registered new user." +
                        "\n Welcome " + fullname + ".", "INFO", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }
        }
    }

    /**
     * This method fetches course part evaluations
     * and presents these in the PartPanel table.
     * @param course
     */
    public void fetchCourseParts(String course) {

        Connection dbConnection = null;
        Statement statement = null;
        ds.getWeigthList().clear();
        try {

            g.getPp().tableRows();
            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();

            String sql = ("SELECT * FROM  `Part` WHERE Course_name= '" + course + "';");
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String partId = rs.getString("part_id");
                String courseName = rs.getString("Course_name");
                String partName = rs.getString("Part_name");
                String partWeigth = rs.getString("Part_weight");

                g.getPp().getModel().addRow(new Object[]{partId, courseName, partName, partWeigth});
                ds.addNumberCalcList(Integer.parseInt(partWeigth));
            }
            ds.calculateWeigth();
            g.getPp().getCp().getCurrentWeight().setText("Totalt weight: " + ds.getCurrentValue() + "%");

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    /**
     * This method inserts a new part into the Part table
     * if the total weight will not go over 100%. If it goes
     * over 100% the user will recieve an error message.
     * @param name
     * @param weigth
     * @return
     */
    public boolean insertNewPart(String name, int weigth) {

        Connection dbConnection = null;
        Statement statement = null;

        try {
            if (ds.getCurrentValue() + weigth < 100) {

                dbConnection = getDbConnection();
                statement = dbConnection.createStatement();
                statement.executeUpdate("INSERT INTO Part (Course_name, Part_name, Part_weight) " + "VALUES " +
                        "('" + ds.getCourse().getName() + "', '" + name + "','" + weigth + "')");
                fetchCourseParts(ds.getCourse().getName());
                JOptionPane.showMessageDialog(new JOptionPane(), "Successfully added a new part." +
                        "\n Use 'add students' button to add students.", "Info", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(new JOptionPane(), "Max weight for a course is 100%" +
                                "\n Current total weight is " + ds.getCurrentValue() + "."
                        + "\n You may only add " + (100 - ds.getCurrentValue()) + " more.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return false;
    }

    public void fetchStudentPart(int partId) {

        Connection dbConnection = null;
        Statement statement = null;
        ds.getWeigthList().clear();
        try {

            g.getPp().setStudentTableRows();
            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();

            String sql = ("SELECT * FROM  `PartGrade` WHERE Part_id= '" + partId + "';");
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String partID = rs.getString("part_id");
                String student_id = rs.getString("student_id");
                String grade = rs.getString("grade");



                g.getPp().getStudentModel().addRow(new Object[]{partID, student_id, grade});

                if (statement != null) {
                    statement.close();
                }

                if (dbConnection != null) {
                    dbConnection.close();
                }
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    public void listStudentsNotOnCourse(int courseId) {

        Connection dbConnection = null;
        Statement statement = null;
        g.getAsf().tableRows();
        try {


            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();

            String sql = ("SELECT * FROM Student WHERE student_id NOT IN (SELECT DISTINCT Student_id FROM CourseGrade WHERE CourseGrade.Course_id ="+ courseId + ")");
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");

                g.getAsf().getModel().addRow(new Object[]{id, name});
            }

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    public void addStudentsToCourse() {

        Connection dbConnection = null;
        Statement statement = null;
        try {


            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();
            ArrayList<Integer> addedStudents = new ArrayList<>();
            for(int i = 0; i < g.getAsf().getTable().getRowCount(); i++) {
                Object row2 = g.getAsf().getTable().getValueAt(i, 2);
                boolean checked = false;
                if(row2 instanceof  Boolean){
                   checked = true;
                }

                if(checked) {
                    int id = Integer.parseInt(g.getAsf().getTable().getValueAt(i, 0).toString());
                    statement.executeUpdate("INSERT INTO CourseGrade (student_id, course_id) " + "VALUES " +
                            "('" + id + "', '" + ds.getCourse().getId() + "')");

                     for(Integer partId : ds.getCourse().getPartIds()) {
                        statement.executeUpdate("INSERT INTO PartGrade (student_id, part_id, course_id) VALUES" +
                                "('" + id + "', '" + partId + "', '"+ ds.getCourse().getId() + "')");
                    }
                    addedStudents.add(ds.getCourse().getId());


                }
            }
            JOptionPane.showMessageDialog(new JOptionPane(), "Successfully added " + addedStudents.size()
                    + " to the course " + ds.getCourse().getName(), "Info", JOptionPane.INFORMATION_MESSAGE);

            g.getAsf().tableRows();
            listStudentsNotOnCourse(ds.getCourse().getId());

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    public void updateCourseTable(String table, String tableColumn, String updatedData, String idColumn, int id){

        Connection dbConnection = null;
        Statement statement = null;

        g.getAsf().tableRows();
        try {
            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();

            String query = ("UPDATE  `gr9_16`.`" + table + "` " +
                    "SET  `" + tableColumn + "` =  '" + updatedData + "' " +
                    "WHERE  `"+ table + "`.`" + idColumn + "` = " + id + ";");
            statement.executeUpdate(query);
            //fetchCourseParts(ds.getCourse().getName(), g);
        } catch (SQLException s){
            System.out.println(s.getMessage());
        }
    }

    public void updatePartCourseGrade(String updatedData, int StudentId, int partId){

        Connection dbConnection = null;
        Statement statement = null;


        g.getAsf().tableRows();
        try {
            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();

            String query = ("UPDATE  `gr9_16`.`PartGrade` " +
                    "SET  `grade` =  '" + updatedData.toUpperCase() + "' " +
                    "WHERE  `PartGrade`.`student_id` = " + StudentId + " AND `PartGrade`.part_id = " + partId + ";");
            statement.executeUpdate(query);
            fetchCourseParts(ds.getCourse().getName());

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (SQLException s){
            System.out.println(s.getMessage());
        }
    }

    public void updatePart(String table, String tableColumn, int weight, String idColumn, int id, int previousWeight) {

        Connection dbConnection = null;
        Statement statement = null;

        ds.getWeigthList().clear();
        try {

            if(ds.getCurrentValue() + weight - previousWeight <= 100) {
                dbConnection = getDbConnection();
                statement = dbConnection.createStatement();

                String query = ("UPDATE  `gr9_16`.`" + table + "` " +
                        "SET  `" + tableColumn + "` =  '" + weight + "' " +
                        "WHERE  `" + table + "`.`" + idColumn + "` = " + id + ";");
                statement.executeUpdate(query);
                System.out.println("Updated");
                JOptionPane.showMessageDialog(new JOptionPane(), "Sucessfully updated the weight.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println(ds.getCurrentValue());
                JOptionPane.showMessageDialog(new JOptionPane(), "The max weight may not be higher than 100%." +
                        "\n Try lowering other weights and try again.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    public void deleteCourse(int CourseId, String courseName) {

        Connection dbConnection = null;
        Statement statement = null;

        try {


                dbConnection = getDbConnection();
                statement = dbConnection.createStatement();

                String query1 = "Delete from Course where c_id = "+ CourseId + ";";

                String query2 = "Delete from Part where Course_name = \"" + courseName + "\";";
            String query3 = "Delete from PartGrade where course_id = " + CourseId + ";";
                statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);
            listCourses();
            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }





}





