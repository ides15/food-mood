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
    /**
     * Default constructor for FoodCntl.
     * @param food Food model for MVC architecture.
     * @param foodView FoodView for MVC architecture.
     */
    public FoodCntl(Food food, FoodView foodView) {
        System.out.println("Food Controller constructor");
    }
}
