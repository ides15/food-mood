/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stats;

import database.Drink_Table;
import database.Food_Table;
import database.Mood_Table;
import java.util.ArrayList;
import models.Entry;

/**
 *
 * @author kjrya
 */
public class StatsModel {
    private ArrayList<Entry> drinkTable = new ArrayList<>();
    private ArrayList<Entry> foodTable = new ArrayList<>();
    private ArrayList<Entry> moodTable = new ArrayList<>();

    /**
     * Default constructor for StatsModel class
     * @param drinks accepts array list of type entry for drinks
     * @param foods accepts array list of type entry for foods
     * @param moods accepts array list of type entry for moods
     */
    public StatsModel(Drink_Table drinks, Food_Table foods, Mood_Table moods) {
        System.out.println("StatsModel constructor called.");
        drinkTable=drinks.getAllEntries();
        foodTable=foods.getAllEntries();
        moodTable=moods.getAllEntries();
    }
    
    /**
     * Function to get drink tables
     * @return ArrayList of entries
     */
    public ArrayList<Entry> getDrinkTable() {
        System.out.println("getDrinkTable called.");
        return drinkTable;
    }
    /**
     * Function to get food tables
     * @return ArrayList of entries
     */
    public ArrayList<Entry> getFoodTable() {
        System.out.println("getFoodTable called.");
        return foodTable;
    }
    /**
     * Function to get mood tables
     * @return ArrayList of entries
     */
    public ArrayList<Entry> getMoodTable() {
        System.out.println("getMoodTable called.");
        return moodTable;
    }

    /**
     * @param drinkTable the drinkTable to set
     */
    public void setDrinkTable(ArrayList<Entry> drinkTable) {
        System.out.println("setDrinkTable called.");
        this.drinkTable = drinkTable;
    }

    /**
     * @param foodTable the foodTable to set
     */
    public void setFoodTable(ArrayList<Entry> foodTable) {
        System.out.println("setFoodTable called.");
        this.foodTable = foodTable;
    }

    /**
     * @param moodTable the moodTable to set
     */
    public void setMoodTable(ArrayList<Entry> moodTable) {
        System.out.println("setMoodTable called.");
        this.moodTable = moodTable;
    }
}