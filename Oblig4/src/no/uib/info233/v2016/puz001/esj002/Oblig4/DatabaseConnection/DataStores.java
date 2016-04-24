package no.uib.info233.v2016.puz001.esj002.Oblig4.DatabaseConnection;

import java.util.ArrayList;

/**
 * Created by marius on 23.04.2016.
 * This Class stores data in lists and constants in order
 * to use this data while calculation different numbers and
 * so on.
 * @Author Marius
 */
public class DataStores {

    //Strings
    private String currentCourseParts = new String();

    //Lists
    private ArrayList<Integer> weigthList = new ArrayList<Integer>();

    //Integers
    private int currentValue = 0;

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



    public String getCurrentCourseParts() {
        return currentCourseParts;
    }

    public void setCurrentCourseParts(String currentCourseParts) {
        this.currentCourseParts = currentCourseParts;
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
}
