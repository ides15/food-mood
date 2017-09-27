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
public class FoodView {
    private Food food;
    
    /**
     * Default constructor for FoodView.
     * @param food FoodView for MVC architecture.
     */
    public FoodView(Food food) {
        System.out.println("FoodView constructor called.");
        
        this.food = food;
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
}
