package no.uib.info233.v2016.puz001.esj002.Oblig4;

/**
 * Created by marius on 22.04.2016.
 */
public class User {

    private int id;
    private String name;

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
