/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stats;

import database.Drink_DB;
import database.Food_DB;
import database.Mood_DB;
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
    public StatsModel(Drink_DB drinks, Food_DB foods, Mood_DB moods){
        drinkTable=drinks.getAllEntries();
        foodTable=foods.getAllEntries();
        moodTable=moods.getAllEntries();
    }
    
    /**
     * Function to get drink tables
     * @return ArrayList of entries
     */
    public ArrayList<Entry> getDrinkTable() {
        return drinkTable;
    }
    /**
     * Function to get food tables
     * @return ArrayList of entries
     */
    public ArrayList<Entry> getFoodTable() {
        return foodTable;
    }
    /**
     * Function to get mood tables
     * @return ArrayList of entries
     */
    public ArrayList<Entry> getMoodTable() {
        return moodTable;
    }
}