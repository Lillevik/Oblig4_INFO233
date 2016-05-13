package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;

/**
 * Created on 09.05.16.
 * @author puz001, esj002
 */
public class PartEvaluation {

    private int partId;
    private int courseID;
    private String partName;
    private int partWeight;
    private double grade;

    /**
     * constructor method for the PartEvaluation class.
     * used in calculating grades for courseParts.
     * @param partId
     * @param courseID
     * @param partName
     * @param partWeight
     * @param grade
     */
    public PartEvaluation(int partId, int courseID, String partName, int partWeight, double grade){
        this.partId = partId;
        this.courseID = courseID;
        this.partName = partName;
        this.partWeight = partWeight;
        this.grade = grade;
    }

    /**
     * Getter for the grade variable.
     * @return grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * getter for the partWeight vriable.
     * @return partWeight
     */
    public int getPartWeight() {
        return partWeight;
    }

    /**
     * getter for the partID variable.
     * @return partId
     */
    public int getPartId() {

        return partId;
    }
}
