package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;

/**
 * Created by marius on 22.04.2016.
 */
public class User {

    private int id;
    private String name;
    private String fullName;

    public User(int id, String name, String fullName){
        this.id = id;
        this.name = name;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
