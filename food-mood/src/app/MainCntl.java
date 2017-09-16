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
    
    public MainCntl(MainView mainView) {
        System.out.println("Main Controller constructor");
        
        this.mainView = mainView;
        
        drink = new Drink();
        drinkView = new DrinkView(drink);
        drinkCntl = new DrinkCntl(drink, drinkView);
        
        food = new Food();
        foodView = new FoodView(food);
        foodCntl = new FoodCntl(food, foodView);
        
        mood = new Mood();
        moodView = new MoodView(mood);
        moodCntl = new MoodCntl(mood, moodView);
    }
}
