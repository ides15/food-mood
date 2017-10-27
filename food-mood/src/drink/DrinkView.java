/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drink;

import database.Drink_Table;
import javax.swing.JFrame;
import models.Drink;

/**
 *
 * @author John
 */
public class DrinkView extends JFrame {
    private Drink drink;
    private final Drink_Table db;
    private final DrinkViewPanel drinkViewPanel;
    
    /**
     * Default constructor for DrinkView.
     * @param db Drink model for MVC architecture.
     */
    public DrinkView(Drink_Table db) {    
        super("Drink");
        this.db = db;
        
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        drinkViewPanel = new DrinkViewPanel();
        add(drinkViewPanel);
    }

    /**
     * @return the drinkViewPanel
     */
    public DrinkViewPanel getDrinkViewPanel() {
        return drinkViewPanel;
    }
}
