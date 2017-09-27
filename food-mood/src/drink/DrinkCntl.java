/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drink;

import models.Drink;

/**
 *
 * @author John
 */
public class DrinkCntl {
    private Drink drink;
    private DrinkView drinkView;
    
    /**
     * Default constructor for DrinkCntl.
     * @param drink Drink model for MVC architecture.
     * @param drinkView DrinkView for MVC architecture.
     */
    public DrinkCntl(Drink drink, DrinkView drinkView) {
        System.out.println("DrinkCntl constructor called.");
        
        this.drink = drink;
        this.drinkView = drinkView;
    }

    /**
     * @return the drink
     */
    public Drink getDrink() {
        System.out.println("getDrink called.");
        return drink;
    }

    /**
     * @param drink the drink to set
     */
    public void setDrink(Drink drink) {
        System.out.println("setDrink called.");
        this.drink = drink;
    }

    /**
     * @return the drinkView
     */
    public DrinkView getDrinkView() {
        System.out.println("getDrinkView called.");
        return drinkView;
    }

    /**
     * @param drinkView the drinkView to set
     */
    public void setDrinkView(DrinkView drinkView) {
        System.out.println("setDrinkView called.");
        this.drinkView = drinkView;
    }
}
