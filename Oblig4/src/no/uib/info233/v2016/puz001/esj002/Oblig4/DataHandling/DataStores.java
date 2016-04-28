package no.uib.info233.v2016.puz001.esj002.Oblig4.DataHandling;

import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames.Gui;

import java.util.ArrayList;

/**
 * Created by marius on 23.04.2016.
 * This Class stores data in lists and constants in order
 * to use this data while calculation different numbers and
 * so on.
 * @Author Marius
 */
public class DataStores {


    public DataStores(Gui g){
        this.g = g;
    }


    private Gui g;

    //Lists
    private ArrayList<Integer> weigthList = new ArrayList<Integer>();

    //Integers
    private int currentValue = 0;

    //Courses
    private Course course;

    //Users
    private User user;



    /**
     * This is an add method for the
     * weightList. Which simply adds another
     * integer to the list.
     * @param number
     */
    public void addNumberCalcList(int number){
        this.weigthList.add(number);
    }

    /**
     * This method calculates the current weigth
     * of for a course and sets the result to
     * the field currentValue.
     * @return currentValue
     */
    public int calculateWeigth(){
        this.currentValue = 0;
        for(Integer number : weigthList) {
                currentValue = currentValue + number;
        }
        return currentValue;
    }

    public void addPartsToList(){
        getCourse().getPartIds().clear();
        for(int i = 0; i < g.getPp().getTable().getRowCount(); i++){
            getCourse().addPartId(Integer.parseInt(g.getPp().getTable().getValueAt(i, 0).toString()));
        }
    }

    public ArrayList<Integer> getWeigthList() {
        return weigthList;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
