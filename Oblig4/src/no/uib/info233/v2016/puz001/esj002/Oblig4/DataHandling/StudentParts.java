package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;


/**
 * Created by marius on 04.05.2016.
 */
public class StudentParts {

    private int studentId;
    private int partId;
    private String grade;
    private int courseId;



    public StudentParts(int studentId, DataStores ds){
        this. studentId = studentId;
        this.courseId = ds.getCourse().getId();
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getGrade() {

        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getPartId() {

        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public int getStudentId() {

        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


}
