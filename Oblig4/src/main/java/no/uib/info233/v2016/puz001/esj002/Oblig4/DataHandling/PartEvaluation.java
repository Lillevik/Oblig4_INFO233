package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;

/**
 * Created by goat on 09.05.16.
 */
public class PartEvaluation {

    private int partId;
    private int courseID;
    private String partName;
    private int partWeight;
    private double grade;

    public PartEvaluation(int partId, int courseID, String partName, int partWeight, double grade){
        this.partId = partId;
        this.courseID = courseID;
        this.partName = partName;
        this.partWeight = partWeight;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getPartWeight() {
        return partWeight;
    }

    public void setPartWeight(int partWeight) {
        this.partWeight = partWeight;
    }

    public String getPartName() {

        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getCourseID() {

        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getPartId() {

        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }
}
