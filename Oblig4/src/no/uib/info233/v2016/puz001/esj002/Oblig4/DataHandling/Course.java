package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;

import java.util.ArrayList;

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
    private int currentPartId;
    private final ArrayList<Integer> partIds = new ArrayList<>();

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
     * This method adds an id to the partIds list
     * @param id - The ID integer to add
     */
    public void addPartId(int id){
        this.partIds.add(id);
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

    /**
     * This is a getter for the partIds ArrayList field
     * @return - The ArrayList partIds field List
     */
    public ArrayList<Integer> getPartIds() {
        return partIds;
    }

    /**
     * This is a getter for the currentPartId field
     * @return - The Integer currentPartId field value
     */
    public int getCurrentPartId() {
        return currentPartId;
    }

    /**
     * This is a setter for the currentPartId field
     * @param currentPartId - The currentPartId to set
     */
    public void setCurrentPartId(int currentPartId) {
        this.currentPartId = currentPartId;
    }
}
