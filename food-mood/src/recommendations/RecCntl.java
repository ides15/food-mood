package recommendations;

import database.*;
import app.EntryCntl;

/*
 * @author BasicPanda
 */
public class RecCntl extends EntryCntl{

    private RecModel rec;
    private RecView recView;
    private Food_Table food_DB;
    private Mood_Table mood_DB;
    private int accountID;

    /**
     * Default constructor for RecCntl.
     *
     * @param rec Mood model for MVC architecture.
     * @param recView MoodView for MVC architecture.
     */
    public RecCntl(RecView recView, Food_Table food_DB, Mood_Table mood_DB, int accountID) {
        System.out.println("RecCntl constructor called.");
        
        this.food_DB = food_DB;
        this.mood_DB = mood_DB;
        this.recView = recView;
        
        recView.setVisible(true);
    }
    
    @Override
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public int getAccountID() {
        return this.accountID;
    }

    /**
     * @return the rec
     */
    public Food_Table getFoodDB() {
        System.out.println("Get Food Table called.");
        return food_DB;
    }

    /**
     * @param rec the rec to set
     */
    public void setFoodDB(Food_Table food_DB) {
        System.out.println("set Food Table called.");
        this.food_DB = food_DB;
    }
    
    /**
     * @return mood_DB
     */
    public Mood_Table getMoodDB() {
        System.out.println("Get Mood Table called.");
        return mood_DB;
    }

    /**
     * @param rec the rec to set
     */
    public void setNoodDB(Mood_Table mood_DB) {
        System.out.println("set Mood Table called.");
        this.food_DB = food_DB;
    }

    /**
     * @return the recView
     */
    public RecView getRecView() {
        System.out.println("getRecView called.");
        return recView;
    }

    /**
     * @param recView the recView to set
     */
    public void setRecView(RecView recView) {
        System.out.println("setRecView called.");
        this.recView = recView;
    }
}
