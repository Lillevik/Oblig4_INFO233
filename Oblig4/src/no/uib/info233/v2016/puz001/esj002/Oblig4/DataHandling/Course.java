package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by marius on 24.04.2016.
 *
 * This class was made to store data about a Course and is
 * used withing the dataStores class.
 * @author marius
 */
public class Course {

    //These are the fields for the Course class
    private final int id;
    private final String name;
    private final String description;
    private final String professor;
    private final HashMap<Integer, PartEvaluation> parts = new HashMap<>();

    /**
     * This is the constructor for the Course class which
     * initialized class fields on creation.
     * @param id - The courseID
     * @param name - The name of the course
     * @param description - A short description of the course
     * @param professor - The professor of the course
     */
    public Course(int id, String name, String description, String professor){
        this.id = id;
        this.name = name;
        this.description = description;
        this.professor = professor;
    }

    /**
     * This is a getter for the id fields
     * @return - The integer id field
     */
    public int getId() {
        return id;
    }

    /**
     * This is a getter for the name field
     * @return - The string name field value
     */
    public String getName() {
        return name;
    }

    /**
     * This is a getter for the description field
     * @return - The String description field value
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is a getter for the professor field
     * @return - The String professor field value
     */
    public String getProfessor() {
        return professor;
    }
}
