/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drink;

import database.Drink_Table;
import models.Drink;

/**
 *
 * @author John
 */
public class DrinkCntl {
    private Drink drink;
    private final Drink_Table db;
    private final DrinkView drinkView;
    
    /**
     * Default constructor for DrinkCntl.
     * @param db Drink model for MVC architecture.
     * @param drinkView DrinkView for MVC architecture.
     */
    public DrinkCntl(Drink_Table db, DrinkView drinkView) {       
        this.db = db;
        this.drinkView = drinkView;
        
        drink = new Drink();
        
        drinkView.setVisible(true);
    }

    /**
     * @return the drinkView
     */
    public DrinkView getDrinkView() {
        return drinkView;
    }
}
