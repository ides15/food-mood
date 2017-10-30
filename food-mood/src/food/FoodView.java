/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import database.Food_Table;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import models.Food;

/**
 *
 * @author John
 */
public class FoodView extends JFrame {
    private Food food;
    private final Food_Table db;
    private FoodViewPanel foodViewPanel;
    
    /**
     * Default constructor for FoodView.
     * @param db FoodView for MVC architecture.
     */
    public FoodView(Food_Table db) {
        super("Food");
        this.db = db;
        
        setSize(450, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        foodViewPanel = new FoodViewPanel();
        add(foodViewPanel);
    }
    
    public void addAddButtonListener(ActionListener al) {
        getFoodViewPanel().getAddButton().addActionListener(al);
    }
    
    public void addDeleteButtonListener(ActionListener al) {
        getFoodViewPanel().getDeleteButton().addActionListener(al);
    }
    
    public void addEditButtonListener(ActionListener al) {
        getFoodViewPanel().getEditButton().addActionListener(al);
    }
    
    /**
     * @return the foodViewPanel
     */
    public FoodViewPanel getFoodViewPanel() {
        return foodViewPanel;
    }

    /**
     * @param foodViewPanel the foodViewPanel to set
     */
    public void setFoodViewPanel(FoodViewPanel foodViewPanel) {
        this.foodViewPanel = foodViewPanel;
    }
}
