/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import database.Drink_Table;
import database.Food_Table;
import database.Mood_Table;
import drink.DrinkCntl;
import drink.DrinkView;
import food.FoodCntl;
import food.FoodView;
import models.Drink;
import models.Entry;
import models.Food;
import models.Mood;
import mood.MoodCntl;
import mood.MoodView;

/**
 *
 * @author John
 */
public class EntryFactory {
    public Entry getEntry(String entryType) {
        switch(entryType) {
            case "food": {
                Food_Table food_db = new Food_Table("foodmood.db");
                FoodView foodView = new FoodView(food_db);
                FoodCntl foodCntl = new FoodCntl(food_db, foodView);
                return new Food("food", "amount");
            } case "drink": {
                Drink_Table drink_db = new Drink_Table("foodmood.db");
                DrinkView drinkView = new DrinkView(drink_db);
                DrinkCntl drinkCntl = new DrinkCntl(drink_db, drinkView);
                return new Drink();
            } case "mood": {
                Mood_Table mood_db = new Mood_Table("foodmood.db");
                MoodView moodView = new MoodView(mood_db);
                MoodCntl moodCntl = new MoodCntl(mood_db, moodView);
                return new Mood();
            } default:
                return null;
        }
    }
}
