package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;

import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames.Gui;

import java.util.ArrayList;

/**
 * Created by marius on 23.04.2016.
 * This Class stores data in lists and constants in order
 * to use this data while calculation different numbers and
 * to know which course is currently being edited.
 * @author Marius
 */
public class DataStores {

    /**
     * This is the constructor of the DataStores class
     * @param g - The gui for fetch data from
     */
    public DataStores(Gui g){
        this.g = g;
    }

    //These are the fields of the DataStores class
    private Gui g;
    private ArrayList<Integer> weightList = new ArrayList<>();
    private int currentValue = 0;
    private Course course;
    private User user;



    /**
     * This is an add method for the
     * weightList. Which simply adds another
     * integer to the list.
     * @param number - The number to add to the weightList
     */
    public void addNumberCalcList(int number){
        this.weightList.add(number);
    }

    /**
     * This method calculates the current weigth
     * of for a course and sets the result to
     * the field currentValue.
     * @return currentValue
     */
    public void calculateWeigth(){
        this.currentValue = 0;
        for(Integer number : weightList) {
                currentValue = currentValue + number;
        }
    }


    /**
     * This method clears the partIds list and fills it with new
     * partIds from the Parts table in the PartPanel panel.
     */
    public void addPartsToList(){
        getCourse().getPartIds().clear();
        for(int i = 0; i < g.getPp().getTable().getRowCount(); i++){
            getCourse().addPartId(Integer.parseInt(g.getPp().getTable().getValueAt(i, 0).toString()));
        }
    }

    /**
     * This is a getter for the ArrayList weight
     * @return - The ArrayList weightList field value
     */
    public ArrayList<Integer> getWeightList() {
        return weightList;
    }


    /**
     * This is a getter for the int currentValue field
     * @return - The Integer currentValue
     */
    public int getCurrentValue() {
        return currentValue;
    }

    /**
     * This is a setter for the currentValue field
     * @param currentValue - The new currentValue Integer
     */
    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }


    /**
     * This is a getter for the Course field
     * @return - The Course field value
     */
    public Course getCourse() {
        return course;
    }

    /**
     * This is a setter for the field value Course
     * @param course - The Course to set to course field
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * This is a getter for the user field
     * @return - The User value from the user field
     */
    public User getUser() {
        return user;
    }

    /**
     * This is a setter for the user field
     * @param user - The new User to set for the user field
     */
    public void setUser(User user) {
        this.user = user;
    }
}
