package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;

/**
 * Created by marius on 25.04.2016.
 */
public class Student {

    private int id;
    private String name;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
