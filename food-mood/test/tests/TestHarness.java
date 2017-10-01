package tests;

import app.*;
import models.*;
import food.*;
import drink.*; 
import mood.*;

/**
 *
 * @author john
 */
public class TestHarness {
    public static void main(String[] args) {
        System.out.println("Testing started.");
        testApp();
        testFood();      
        testDrink();        
        testMood();
    }
    
    public static void testApp() {
        MainView mainView = new MainView();
        System.out.println("MainView instantiated.");
        MainCntl mainCntl = new MainCntl(mainView);
    }
    
    public static void testFood() {
        Food test = new Food();
        test.setName("TestTaco");
        test.setUnit("TestSavory");
        test.setAmount(2);
        if(test.getName().equals("TestTaco") && test.getAmount()==2 && test.getUnit().equals("TestSavory")){
            System.out.println("Food is working");
        }
        
        FoodView foodView = new FoodView(test);      
        foodView.setFood(test);
        if (foodView.getFood().getName().equals("TestTaco")) {
            System.out.println("FoodView is working");
        } 
        
        FoodCntl foodCntl = new FoodCntl(test, foodView);
        foodCntl.setFood(test);
        foodCntl.setFoodView(foodView); 
        if (foodCntl.getFood().getName().equals("TestTaco") && foodCntl.getFoodView().getFood().getName().equals("TestTaco")) {
            System.out.println("FoodCntl is working");
        } 
    }
    
    public static void testDrink () {
        Drink test = new Drink();
        test.setName("TestCola");
        test.setUnit("TestSweet");
        test.setAmount(24);
        if(test.getName().equals("TestCola") && test.getAmount()==24 && test.getUnit().equals("TestSweet")){
            System.out.println("Drink is working");
        }
        
        DrinkView drinkView = new DrinkView(test); 
        drinkView.setDrink(test);
        if (drinkView.getDrink().getName().equals("TestCola")) {
            System.out.println("DrinkView is working");
        }
        
        DrinkCntl drinkCntl = new DrinkCntl(test, drinkView);
        drinkCntl.setDrink(test);
        drinkCntl.setDrinkView(drinkView);
        if (drinkCntl.getDrink().getName().equals("TestCola") && drinkCntl.getDrinkView().getDrink().getName().equals("TestCola")) {
            System.out.println("DrinkCntl is working");
        }
    }
    
    public static void testMood() {
        Mood test = new Mood();
        test.setName("TestHappy");
        test.setUnit("TestVery");
        test.setAmount(8);
        if(test.getName().equals("TestHappy") && test.getAmount()==8 && test.getUnit().equals("TestVery")){
            System.out.println("Mood is working");
        }
        
        MoodView moodView = new MoodView(test);
        moodView.setMood(test);
        if (moodView.getMood().getName().equals("TestHappy")) {
            System.out.println("MoodView is working");
        }
        
        MoodCntl moodCntl = new MoodCntl(test, moodView);
        moodCntl.setMood(test);
        moodCntl.setMoodView(moodView);
        if (moodCntl.getMood().getName().equals("TestHappy") && moodCntl.getMoodView().getMood().getName().equals("TestHappy")) {
            System.out.println("MoodCntl is working");
        }
    }
}