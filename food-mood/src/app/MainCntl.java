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
    
    /**
     * Default constructor for MainCntl.
     * @param mainView View class for MVC architecture.
     */
    public MainCntl(MainView mainView) {
        System.out.println("Main Controller constructor");
        
        this.mainView = mainView;
        
        drink = new Drink();
        drinkView = new DrinkView(getDrink());
        drinkCntl = new DrinkCntl(getDrink(), getDrinkView());
        
        food = new Food();
        foodView = new FoodView(getFood());
        foodCntl = new FoodCntl(getFood(), getFoodView());
        
        mood = new Mood();
        moodView = new MoodView(getMood());
        moodCntl = new MoodCntl(getMood(), getMoodView());
    }

    /**
     * @return the mainView
     */
    public MainView getMainView() {
        return mainView;
    }

    /**
     * @return the drink
     */
    public Drink getDrink() {
        return drink;
    }

    /**
     * @return the drinkView
     */
    public DrinkView getDrinkView() {
        return drinkView;
    }

    /**
     * @return the drinkCntl
     */
    public DrinkCntl getDrinkCntl() {
        return drinkCntl;
    }

    /**
     * @return the food
     */
    public Food getFood() {
        return food;
    }

    /**
     * @return the foodView
     */
    public FoodView getFoodView() {
        return foodView;
    }

    /**
     * @return the foodCntl
     */
    public FoodCntl getFoodCntl() {
        return foodCntl;
    }

    /**
     * @return the mood
     */
    public Mood getMood() {
        return mood;
    }

    /**
     * @return the moodView
     */
    public MoodView getMoodView() {
        return moodView;
    }

    /**
     * @return the moodCntl
     */
    public MoodCntl getMoodCntl() {
        return moodCntl;
    }
}
