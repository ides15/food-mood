/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import models.Food;

/**
 *
 * @author John
 */
public class FoodCntl {
    private Food food;
    private FoodView foodView;
    
    /**
     * Default constructor for FoodCntl.
     * @param food Food model for MVC architecture.
     * @param foodView FoodView for MVC architecture.
     */
    public FoodCntl(Food food, FoodView foodView) {
        System.out.println("FoodCntl constructor called.");
        
        this.food = food;
        this.foodView = foodView;
    }

    /**
     * @return the food
     */
    public Food getFood() {
        System.out.println("getFood called.");
        return food;
    }

    /**
     * @param food the food to set
     */
    public void setFood(Food food) {
        System.out.println("setFood called.");
        this.food = food;
    }

    /**
     * @return the foodView
     */
    public FoodView getFoodView() {
        System.out.println("getFoodView called.");
        return foodView;
    }

    /**
     * @param foodView the foodView to set
     */
    public void setFoodView(FoodView foodView) {
        System.out.println("setFoodView called.");
        this.foodView = foodView;
    }
}
