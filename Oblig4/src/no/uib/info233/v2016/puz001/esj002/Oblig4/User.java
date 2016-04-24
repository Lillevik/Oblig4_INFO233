package no.uib.info233.v2016.puz001.esj002.Oblig4;

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
}
