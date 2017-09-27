/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import drink.DrinkCntl;
import drink.DrinkView;
import food.FoodCntl;
import food.FoodView;
import models.Drink;
import models.Food;
import models.Mood;
import mood.MoodCntl;
import mood.MoodView;
import stats.*;
import recommendations.*;

/**
 *
 * @author John
 */
public class MainCntl {

    private MainView mainView;

    private Drink drink;
    private DrinkView drinkView;
    private DrinkCntl drinkCntl;

    private Food food;
    private FoodView foodView;
    private FoodCntl foodCntl;

    private Mood mood;
    private MoodView moodView;
    private MoodCntl moodCntl;

    private RecModel rec;
    private RecView recView;
    private RecCntl recCntl;
    
    private StatsModel stats;
    private StatsView statsView;
    private StatsCntl statsCntl;
    /**
     * Default constructor for MainCntl.
     *
     * @param mainView View class for MVC architecture.
     */
    public MainCntl(MainView mainView) {
        System.out.println("Main Controller constructor called.");

        this.mainView = mainView;

        drink = new Drink();
        System.out.println("New Drink instantiated.");
        drinkView = new DrinkView(getDrink());
        System.out.println("New DrinkView instantiated.");
        drinkCntl = new DrinkCntl(getDrink(), getDrinkView());
        System.out.println("New DrinkCntl instantiated.");

        food = new Food();
        System.out.println("New Food instantiated.");
        foodView = new FoodView(getFood());
        System.out.println("New FoodView instantiated.");
        foodCntl = new FoodCntl(getFood(), getFoodView());
        System.out.println("New FoodCntl instantiated.");

        mood = new Mood();
        System.out.println("New Mood instantiated.");
        moodView = new MoodView(getMood());
        System.out.println("New MoodView instantiated.");
        moodCntl = new MoodCntl(getMood(), getMoodView());
        System.out.println("New MoodCntl instantiated.");
    }

    /**
     * @return the mainView
     */
    public MainView getMainView() {
        System.out.println("getMainView called.");
        return mainView;
    }

    /**
     * @return the drink
     */
    public Drink getDrink() {
        System.out.println("getDrink called.");
        return drink;
    }

    /**
     * @return the drinkView
     */
    public DrinkView getDrinkView() {
        System.out.println("getDrinkView called.");
        return drinkView;
    }

    /**
     * @return the drinkCntl
     */
    public DrinkCntl getDrinkCntl() {
        System.out.println("getDrinkCntl called.");
        return drinkCntl;
    }

    /**
     * @return the food
     */
    public Food getFood() {
        System.out.println("getFood called.");
        return food;
    }

    /**
     * @return the foodView
     */
    public FoodView getFoodView() {
        System.out.println("getFoodView called.");
        return foodView;
    }

    /**
     * @return the foodCntl
     */
    public FoodCntl getFoodCntl() {
        System.out.println("getFoodCntl called.");
        return foodCntl;
    }

    /**
     * @return the mood
     */
    public Mood getMood() {
        System.out.println("getMood called.");
        return mood;
    }

    /**
     * @return the moodView
     */
    public MoodView getMoodView() {
        System.out.println("getMoodView called.");
        return moodView;
    }

    /**
     * @return the moodCntl
     */
    public MoodCntl getMoodCntl() {
        System.out.println("getMoodCntl called.");
        return moodCntl;
    }
    
    /**
     * @return the stats
     */
    public StatsModel getStats() {
        System.out.println("getStats called.");
        return stats;
    }

    /**
     * @return the statsView
     */
    public StatsView getStatsView() {
        System.out.println("getStatsView called.");
        return statsView;
    }

    /**
     * @return the statsCntl
     */
    public StatsCntl getStatsCntl() {
        System.out.println("getStatsCntl called.");
        return statsCntl;
    }
    
    /**
     * @return the rec
     */
    public RecModel getRec() {
        System.out.println("getRec called.");
        return rec;
    }

    /**
     * @return the recView
     */
    public RecView getRecView() {
        System.out.println("getRecView called.");
        return recView;
    }

    /**
     * @return the recCntl
     */
    public RecCntl getRecCntl() {
        System.out.println("getRecCntl called.");
        return recCntl;
    }
}
