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
public class DrinkView {
    private Drink drink;
    
    /**
     * Default constructor for DrinkView.
     * @param drink Drink model for MVC architecture.
     */
    public DrinkView(Drink drink) {       
        this.drink = drink;
    }

    /**
     * @return the drink
     */
    public Drink getDrink() {
        return drink;
    }

    /**
     * @param drink the drink to set
     */
    public void setDrink(Drink drink) {
        this.drink = drink;
    }
}
