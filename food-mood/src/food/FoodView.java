/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import database.Food_Table;
import javax.swing.JFrame;
import models.Food;

/**
 *
 * @author John
 */
public class FoodView extends JFrame {
    private Food food;
    private final Food_Table db;
    private final FoodViewPanel foodViewPanel;
    
    /**
     * Default constructor for FoodView.
     * @param db FoodView for MVC architecture.
     */
    public FoodView(Food_Table db) {
        super("Food");
        this.db = db;
        
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        foodViewPanel = new FoodViewPanel();
        add(foodViewPanel);
    }

    /**
     * @return the food
     */
    public FoodViewPanel getFoodViewPanel(){
        return foodViewPanel;
    }
}
