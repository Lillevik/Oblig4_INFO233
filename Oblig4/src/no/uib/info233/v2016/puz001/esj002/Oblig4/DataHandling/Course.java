package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;

/**
 * Created by marius on 24.04.2016.
 */
public class Course {

    private int id;
    private String name;
    private String description;
    private String professor;

    public Course(int id, String name, String description, String professor){
        this.id = id;
        this.name = name;
        this.description = description;
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getProfessor() {
        return professor;
    }
}
