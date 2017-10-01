package tests;

import app.MainCntl;
import app.MainView;
import models.Drink;
import models.Food;
import models.Mood;

/**
 *
 * @author john
 */
public class TestHarness {
    public static void main(String[] args) {
        System.out.println("Testing started.");
        MainView mainView = new MainView();
        System.out.println("MainView instantiated.");
        MainCntl mainCntl = new MainCntl(mainView);
        
        Food testFood = new Food();
        testFood.setName("TestTaco");
        testFood.setUnit("TestSavory");
        testFood.setAmount(2);
        if(testFood.getName()=="TestTaco" && testFood.getAmount()==2 && testFood.getUnit()=="TestSavory"){
            System.out.println("Food is working");
        }
        
        Drink testDrink = new Drink();
        testDrink.setName("TestCola");
        testDrink.setUnit("TestSweet");
        testDrink.setAmount(24);
        if(testDrink.getName()=="TestCola" && testDrink.getAmount()==24 && testDrink.getUnit()=="TestSweet"){
            System.out.println("Drink is working");
        }
        
        Mood testMood = new Mood();
        testMood.setName("TestHappy");
        testMood.setUnit("TestVery");
        testMood.setAmount(8);
        if(testMood.getName()=="TestHappy" && testMood.getAmount()==8 && testMood.getUnit()=="TestVery"){
            System.out.println("Mood is working");
        }
    }
}
