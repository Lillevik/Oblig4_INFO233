package no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection;

import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.DataStores;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.Student;
import no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling.User;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames.Gui;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels.StudentGradesPanel;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Main.TableControls;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

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
     * database and returns the connection to the system.
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
     * @param desc - A description of the course
     * @param name - A name of the course
     */
    public void insertNewCourse(String desc, String name) {

        Connection dbConnection;
        Statement statement;


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


                statement.close();
                dbConnection.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }
        }
    }

    /**
     * This metod lets the user add new students
     * to the "Students" table in the database.
     * It only lets the user add a student by Name.
     * The students ID is auto generated and
     * the student has to manually be added to courses
     * through the course panels.
     *
     * @param name
     * @return
     */
    public String insertStudents(String name) {

        Connection dbConnection = null;
        Statement statement = null;

        try {

            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();

            if (g.getSgp().getStudentName().equals("")){
                g.getSgp().getHeader().setText("ERROR: Name cant be null");

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
     * This method lists all the students in the table
     * with what course they are taking and
     * what grade they got, if they got a grade, in the course.
     * Its use to fill the table in studentGGradePanel.
     * @param sgp
     */
    public void listStudents(StudentGradesPanel sgp) {

        Connection dbConnection = null;

        Statement statement = null;
        Statement statement2 = null;
        Statement statement3 = null;

        g.getSgp().tableRows();

        try {

            dbConnection = getDbConnection();

            statement = dbConnection.createStatement();
            statement2 = dbConnection.createStatement();
            statement3 = dbConnection.createStatement();


            String sql = ("SELECT * FROM  `Student` ORDER BY student_id");
            String csql = ("SELECT * FROM `Course` ORDER BY c_id");
            String gsql = ("SELECT * FROM `CourseGrade` ORDER BY course_id");

            ResultSet rs = statement.executeQuery(sql);
            ResultSet crs = statement2.executeQuery(csql);
            ResultSet grs = statement3.executeQuery(gsql);

            while (rs.next() && crs.next() && grs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                String course = crs.getString("name");
                String grade = grs.getString("grade");

                g.getSgp().getModel().addRow(new Object[]{id, name, course, grade});
            }

        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    /**
     * This method takes a gui as a parameter and lists all the
     * current courses into the JTable from the database.
     */
    public void listCourses() {

        Connection dbConnection;
        Statement statement;
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


            statement.close();
            dbConnection.close();

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
     * @param name - The user name of the user to log in
     * @param pass - The password of the user to log in
     */
    public void authenticateLogin(String name, String pass) {

        Connection dbConnection;
        Statement statement;
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

            statement.close();
            dbConnection.close();

        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    /**
     * This method inserts a new employee into the Employee
     * table if a user with the same username does not
     * allready exist.
     * @param name - The username of the new Employee
     * @param fullName - The fullname of the new Employee
     * @param pass - The password of the new Employee
     */
    public void insertNewEmployee(String name, String fullName, String pass) {

        Connection dbConnection;
        Statement statement;


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
                        "('" + name + "', '" + fullName + "', '" + pass + "')");


                statement.close();
                dbConnection.close();

                JOptionPane.showMessageDialog(new JOptionPane(), "Successfully registered new user." +
                        "\n Welcome " + fullName + ".", "INFO", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }
        }
    }

    /**
     * This method fetches course part evaluations
     * and presents these in the PartPanel table.
     * @param course - The courseName of the course to fetch parts from.
     */
    public void fetchCourseParts(String course) {

        Connection dbConnection;
        Statement statement;
        ds.getWeightList().clear();
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
                String partWeight = rs.getString("Part_weight");

                g.getPp().getModel().addRow(new Object[]{partId, courseName, partName, partWeight});
                ds.addNumberCalcList(Integer.parseInt(partWeight));
            }
            ds.calculateWeigth();
            g.getPp().getCp().getCurrentWeight().setText("Totalt weight: " + ds.getCurrentValue() + "%");

            statement.close();
            dbConnection.close();

        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    /**
     * This method inserts a new part into the Part table
     * if the total weight will not go over 100%. If it goes
     * over 100% the user will recieve an error message.
     * @param name - The name of the new part.
     * @param weight - The weight of the new part as an integer.
     */
    public void insertNewPart(String name, int weight) {

        Connection dbConnection = null;
        Statement statement = null;

        try {
            if (ds.getCurrentValue() + weight <= 100) {

                dbConnection = getDbConnection();
                statement = dbConnection.createStatement();
                statement.executeUpdate("INSERT INTO Part (Course_name, Part_name, Part_weight) " + "VALUES " +
                        "('" + ds.getCourse().getName() + "', '" + name + "','" + weight + "')");
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

            return;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    /**
     * This method fetches all the students taking a specific
     * part. The part is given by the partId as a parameter.
     * @param partId - The part ti fetch students from
     */
    public void fetchStudentPart(int partId) {

        Connection dbConnection;
        Statement statement;
        ds.getWeightList().clear();
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
            }

            statement.close();
            dbConnection.close();

        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    /**
     * This method fetches all the students who is not currently
     * registered to a given course.
     * @param courseId - The integer value Id to list students from.
     */
    public void listStudentsNotOnCourse(int courseId) {

        Connection dbConnection;
        Statement statement;
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

            statement.close();
            dbConnection.close();

        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    /**
     * This method adds a student to a course and all of its part courses.
     */
    public void addStudentsToCourse() {

        Connection dbConnection;
        Statement statement;
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
            dbConnection.close();

        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    /**
     * This method upates a table in the program and then updates the
     * database with the same information as the one in the local table.
     * This method is used in combination with a tableModel listener.
     * @param table - The table from the database to update a value
     * @param tableColumn - The column from the database to update
     * @param updatedData - The new and updated data to replace old data
     * @param idColumn - The column where the unique ID value is found
     * @param id - The id from the ID column
     */
    public void updateCourseTable(String table, String tableColumn, String updatedData, String idColumn, int id){

        Connection dbConnection;
        Statement statement;

        g.getAsf().tableRows();
        try {
            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();

            String query = ("UPDATE  `gr9_16`.`" + table + "` " +
                    "SET  `" + tableColumn + "` =  '" + updatedData + "' " +
                    "WHERE  `"+ table + "`.`" + idColumn + "` = " + id + ";");
            statement.executeUpdate(query);
            //fetchCourseParts(ds.getCourse().getName());

            statement.close();
            dbConnection.close();
            System.out.println(query);
        } catch (SQLException s){
            System.out.println(s.getMessage());
        }


    }

    /**
     * This method updates the PartGrade table Grade
     * both in the local table and in the database.
     * This method is used in combination with a
     * tableModel listener.
     * @param updatedData - The new data to update the database and table with
     * @param StudentId - The studentID for the student to give a grade
     * @param partId - The partID to for the part that is being graded
     */
    public void updatePartCourseGrade(String updatedData, int StudentId, int partId){

        Connection dbConnection;
        Statement statement;


        g.getAsf().tableRows();
        try {
            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();

            String query = ("UPDATE  `gr9_16`.`PartGrade` " +
                    "SET  `grade` =  '" + updatedData.toUpperCase() + "' " +
                    "WHERE  `PartGrade`.`student_id` = " + StudentId + " AND `PartGrade`.part_id = " + partId + ";");
            statement.executeUpdate(query);
            fetchCourseParts(ds.getCourse().getName());

            statement.close();
            dbConnection.close();

        } catch (SQLException s){
            System.out.println(s.getMessage());
        }
    }

    /**
     * This method updates a part weight if updating does not
     * make the weight go  over 100% in total.
     * @param weight - The new weight to update the old with
     * @param id - The ID of the part to update
     * @param previousWeight - The previous to calculate the max weight
     */
    public void updatePart(int weight, int id, int previousWeight) {

        Connection dbConnection = null;
        Statement statement = null;

        ds.getWeightList().clear();
        try {

            if(ds.getCurrentValue() + weight - previousWeight <= 100) {
                dbConnection = getDbConnection();
                statement = dbConnection.createStatement();

                String query = ("UPDATE  `gr9_16`.`" + "Part" + "` " +
                        "SET  `" + "Part_weight" + "` =  '" + weight + "' " +
                        "WHERE  `" + "Part" + "`.`" + "part_id" + "` = " + id + ";");
                statement.executeUpdate(query);
                System.out.println("Updated");
                JOptionPane.showMessageDialog(new JOptionPane(), "Sucessfully updated the weight.", "Error", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println(ds.getCurrentValue());
                JOptionPane.showMessageDialog(new JOptionPane(), "The max weight may not be higher than 100%." +
                        "\n Try lowering other weights and try again.", "Info", JOptionPane.ERROR_MESSAGE);
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
     * This method deletes a course from the dataBase with the given courseName and ID.
     * When the course is deleted all of the courseParts and all of the grades of the
     * students currently taking the course will also be removed.
     * @param CourseId - The ID of the course to remove
     * @param courseName - The name of the course to remove
     */
    public void deleteCourse(int CourseId, String courseName) {

        Connection dbConnection;
        Statement statement;

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

            statement.close();
            dbConnection.close();

        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    public void calculateCourseGrade(){

        Connection dbConnection = null;
        Statement getPart = null;
        Statement getPartGrade = null;
        Statement getStudent = null;
        Statement addGrade = null;

        try {

            dbConnection = getDbConnection();
            getPart = dbConnection.createStatement();
            getPartGrade = dbConnection.createStatement();
            getStudent = dbConnection.createStatement();

            String sqlParts = ("SELECT Course_name FROM `Part` ORDER BY part_id");
            String sqlPartGrade = ("SELECT grade FROM `PartGrade` ORDER BY part_id");
            String sqlWeight = ("SELECT Part_weight FROM `Part` ORDER BY part_id");

            ResultSet parts = getPart.executeQuery(sqlParts);
            ResultSet partGrade = getPartGrade.executeQuery(sqlPartGrade);
            ResultSet weight = getStudent.executeQuery(sqlWeight);

            while (partGrade.next() && weight.next() && parts.next()) {

                //((PartGrade % 100) * PartWeight) + ((PartGrade % 100) * PartWeight) FOR every part.

                String partGradeString = partGrade.getString("grade");
                int partWeight = weight.getInt("Part_weight");
                String part = parts.getString("Course_name");
                int partGradeInt = 0;

                //Change grades from String to Int for meth.
                if (partGradeString.contains("A")){
                    partGradeInt = 6;
                } else if(partGradeString.contains("B")){
                    partGradeInt = 5;
                } else if(partGradeString.contains("C")){
                    partGradeInt = 4;
                } else if(partGradeString.contains("D")){
                    partGradeInt = 3;
                } else if(partGradeString.contains("E")){
                    partGradeInt = 2;
                } else {
                    partGradeInt = 1;
                }

                int partGradeWeight = (partGradeInt/100)*partWeight;
                int courseGrade = 0;

                for (part){
                    courseGrade = courseGrade + partWeight;

                }



                addGrade = dbConnection.createStatement();
                String addCourseGrade = ("INSERT INTO `CourseGrade` (grade) VALUES (" + courseGrade + ");");


//
//                int id = rs.getInt("student_id");
//                String name = rs.getString("student_name");
//                String course = crs.getString("name");
//                String grade = grs.getString("grade");

//                g.getSgp().getModel().addRow(new Object[]{id, name, course, grade});
            }


        } catch (Exception e){
             System.out.print("Couldn't calculate grade");
        }
    }




public ArrayList<Student> getStudentsIds(int courseId){

        Connection dbConnection = null;
        Statement statement = null;
        ArrayList<Student> students = new ArrayList<>();


        try {

            dbConnection = getDbConnection();

            statement = dbConnection.createStatement();

            String sqlPartGrade = ("SELECT * FROM `PartGrade` WHERE course_id = " + courseId + " ORDER BY part_id");



            ResultSet partGrade = statement.executeQuery(sqlPartGrade);


            while (partGrade.next()) {
                int studentId = partGrade.getInt("student_id");
                Student student = new Student(studentId, "not important");
                students.add(student);
            }


        } catch (Exception e){
            System.out.print("Couldn't calculate grade");
        }
        return students;
    }



    public void calculateCourseGrade(ArrayList<Student> students){

        Connection dbConnection = null;
        Statement statement = null;



        try {
            ArrayList<StudentParts> parts = new ArrayList<>();
            dbConnection = getDbConnection();

            statement = dbConnection.createStatement();



            for(Student student : students) {
                String sqlPartGrade = ("SELECT * FROM `PartGrade` WHERE student_id = " + student.getId() + " ORDER BY part_id");
                ResultSet rs = statement.executeQuery(sqlPartGrade);
                StudentParts part = new StudentParts(student.getId(), ds);

                while (rs.next()) {
                    int partId = rs.getInt("part_id");
                    String grade = rs.getString("grade");
                    student.getParts().put(partId, grade);
                }

                for (Map.Entry<Integer, String> entry : student.getParts().entrySet()) {
                    int key = entry.getKey();
                    String value = entry.getValue();


                }


                for (StudentParts part : parts) {

                }
            }

        } catch (Exception e){
            System.out.print("Couldn't calculate grade");
        }
    }


}





