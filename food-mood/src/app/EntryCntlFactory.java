// John Ide - factory class for controller classes for entries

package app;

import database.Drink_Table;
import database.Food_Table;
import database.Mood_Table;
import drink.DrinkCntl;
import drink.DrinkView;
import food.FoodCntl;
import food.FoodView;
import mood.MoodCntl;
import mood.MoodView;

/**
 *
 * @author John
 */
public class EntryCntlFactory {
    private final int accountID;
    
    public EntryCntlFactory(int accountID) {
        this.accountID = accountID;
    }
    
    public EntryCntl getEntry(String entryType) {
        switch(entryType) {
            case "food": {
                Food_Table food_db = new Food_Table("foodmood.db");
                FoodView foodView = new FoodView(accountID, food_db);
                FoodCntl foodCntl = new FoodCntl(accountID, food_db, foodView);
                return foodCntl;
            } case "drink": {
                Drink_Table drink_db = new Drink_Table("foodmood.db");
                DrinkView drinkView = new DrinkView(drink_db);
                DrinkCntl drinkCntl = new DrinkCntl(accountID, drink_db, drinkView);
                return drinkCntl;
            } case "mood": {
                Mood_Table mood_db = new Mood_Table("foodmood.db");
                MoodView moodView = new MoodView(mood_db);
                MoodCntl moodCntl = new MoodCntl(accountID, mood_db, moodView);
                return moodCntl;
            } default:
                return null;
        }
    }
}
