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
    /**
     * Default constructor for DrinkCntl.
     * @param drink Drink model for MVC architecture.
     * @param drinkView DrinkView for MVC architecture.
     */
    public DrinkCntl(Drink drink, DrinkView drinkView) {
        System.out.println("Drink Controller constructor");
    }
}
