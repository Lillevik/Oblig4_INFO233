package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;

/**
 * Created by goat on 09.05.16.
 */
public class PartEvaluation {

    private int partId;
    private String courseID;
    private String partName;
    private String partWeight;

    public PartEvaluation(int partId, String courseID, String partName, String partWeight){
        this.partId = partId;
        this.courseID = courseID;
        this.partName = partName;
        this.partWeight = partWeight;
    }

    public String getPartWeight() {
        return partWeight;
    }

    public void setPartWeight(String partWeight) {
        this.partWeight = partWeight;
    }

    public String getPartName() {

        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getCourseID() {

        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getPartId() {

        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }
}
