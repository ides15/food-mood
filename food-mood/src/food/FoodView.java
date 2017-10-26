/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import models.Food;
import database.Food_Table;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
/**
 *
 * @author John
 */
public class FoodView extends JFrame{
    private Food food;
    private Food_Table db;
    private FoodViewPanel foodViewPanel;
    
    /**
     * Default constructor for FoodView.
     * @param food FoodView for MVC architecture.
     */
    public FoodView(Food food) {
        super("Food");
        this.db = db;
        
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        foodViewPanel = new FoodViewPanel();
        add(foodViewPanel);
    }

    /**
     * @return the food
     */
    public FoodViewPanel getFoodViewPanel(){
        return this.foodViewPanel;
    }
    
    public void setFoodViewPanel(FoodViewPanel foodViewPanel){
        this.foodViewPanel = foodViewPanel;
    }
}
