package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;

import java.util.HashMap;

/**
 * Created by marius on 25.04.2016.
 *
 * This class was made to represent student values
 *
 * @author marius
 */
public class Student {

    //These are the fields of the student class
    private int id;
    private String name;
    private HashMap<Integer, String> parts = new HashMap<>();

    /**
     * This is the constructor for the student class
     * which initializes the fields with parameter.
     * @param id - The Integer ID of the student
     * @param name - The String name of the student
     */
    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * This is a getter for the field id
     * @return - The Integer id field
     */
    public int getId() {
        return id;
    }

    /**
     * This is a setter for the id field
     * @param id - The new Integer value id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This is a getter for the name field
     * @return - The String value of the name field
     */
    public String getName() {
        return name;
    }

    /**
     * This is a setter for the name field
     * @param name - The new String value for the name field
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is a getter for the field parts
     * @return - The HashMap value for the field parts
     */
    public HashMap<Integer, String> getParts() {
        return parts;
    }
}
