package tests;

import app.MainCntl;
import app.MainView;
import models.Drink;
import models.Food;
import models.Mood;
import food.FoodCntl;
import food.FoodView; 

/**
 *
 * @author john
 */
public class TestHarness {
    public static void main(String[] args) {
        System.out.println("Testing started.");
        testApp();
        //MainView mainView = new MainView();
        //System.out.println("MainView instantiated.");
        //MainCntl mainCntl = new MainCntl(mainView);
        
        testFood(); 
        
        /*Food testFood = new Food();
        testFood.setName("TestTaco");
        testFood.setUnit("TestSavory");
        testFood.setAmount(2);
        if(testFood.getName()=="TestTaco" && testFood.getAmount()==2 && testFood.getUnit()=="TestSavory"){
            System.out.println("Food is working");
        } */
        
        testDrink();
        
        /*
        Drink testDrink = new Drink();
        testDrink.setName("TestCola");
        testDrink.setUnit("TestSweet");
        testDrink.setAmount(24);
        if(testDrink.getName()=="TestCola" && testDrink.getAmount()==24 && testDrink.getUnit()=="TestSweet"){
            System.out.println("Drink is working");
        }*/
        
        testMood();
        
        /*
        Mood testMood = new Mood();
        testMood.setName("TestHappy");
        testMood.setUnit("TestVery");
        testMood.setAmount(8);
        if(testMood.getName()=="TestHappy" && testMood.getAmount()==8 && testMood.getUnit()=="TestVery"){
            System.out.println("Mood is working");
        }*/
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
        if(test.getName()=="TestTaco" && test.getAmount()==2 && test.getUnit()=="TestSavory"){
            System.out.println("Food is working");
        }
        
        FoodView foodView = new FoodView(test);      
        foodView.setFood(test);
        foodView.getFood(); 
        
        FoodCntl foodCntl = new FoodCntl(test, foodView);
        foodCntl.setFood(test);
        foodCntl.getFood(); 
        foodCntl.setFoodView(foodView); 
        foodCntl.getFoodView();
    }
    
    public static void testDrink () {
        Drink test = new Drink();
        test.setName("TestCola");
        test.setUnit("TestSweet");
        test.setAmount(24);
        if(test.getName()=="TestCola" && test.getAmount()==24 && test.getUnit()=="TestSweet"){
            System.out.println("Drink is working");
        }
    }
    
    public static void testMood() {
        Mood test = new Mood();
        test.setName("TestHappy");
        test.setUnit("TestVery");
        test.setAmount(8);
        if(test.getName()=="TestHappy" && test.getAmount()==8 && test.getUnit()=="TestVery"){
            System.out.println("Mood is working");
        }
    }
}
