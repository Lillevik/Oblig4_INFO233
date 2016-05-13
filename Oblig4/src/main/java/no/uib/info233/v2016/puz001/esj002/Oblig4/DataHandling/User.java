package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;

/**
 * Created on 22.04.2016.
 * @author puz001, esj002
 */
public class User {

    //These are the fields for the User class
    private int id;
    private String name;
    private String fullName;

    /**
     * This is the constructor for the User class
     * @param id - The Integer id of the user
     * @param name - The String name of the user
     * @param fullName - The String fullName of the user
     */
    public User(int id, String name, String fullName){
        this.id = id;
        this.name = name;
        this.fullName = fullName;
    }

    /**
     * This is a getter for the id field
     * @return - The Integer value of the id field
     */
    public int getId() {
        return id;
    }

    /**
     * This is a setter for the name field
     * @return - The String value of the name field
     */
    public String getName() {
        return name;
    }

    /**
     * This is a getter for the fullName field
     * @return - The String value of the fullName field
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * This is a setter for the fueld id
     * @param id - The new Integer value to set of the id field
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This is a setter for the field name
     * @param name - The new String value to set of the name field
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is a setter for the field fullName
     * @param fullName - The new String value to set of the fullName field
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
