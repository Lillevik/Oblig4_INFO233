package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;

import java.util.ArrayList;

/**
 * Created on 25.04.2016.
 *
 * This class was made to represent student values
 *
 * @author puz001, esj002
 */
public class Student {

    private int id;
    private String name;
    private final ArrayList<PartEvaluation> partEvaluations = new ArrayList<>();

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
     * This is a getter for the name field
     * @return - The String value of the name field
     */
    public String getName() {
        return name;
    }

    /**
     * This is a getter for the field parts
     * @return - The HashMap value for the field parts
     */
    public ArrayList<PartEvaluation> getPartEvaluations() {
        return partEvaluations;
    }
}
