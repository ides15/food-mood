/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import models.Food;
import database.Food_Table;

/**
 *
 * @author John
 */
public class FoodCntl {
    private Food food;
    private final Food_Table db;
    private final FoodView foodView;
    
    private FoodViewPanel foodViewPanel;
    
    private final FoodPanel foodPanel;
    private final AddFoodPanel addFoodPanel;
    private final EditFoodPanel editFoodPanel;
    
    /**
     * Default constructor for FoodCntl.
     * @param food Food model for MVC architecture.
     * @param foodView FoodView for MVC architecture.
     */
    public FoodCntl(Food_Table db, FoodView foodView) {        
        this.db = db;
        this.foodView = foodView;
        
        foodView.setVisible(true);
        
        foodPanel = new FoodPanel();
        addFoodPanel = new AddFoodPanel();
        editFoodPanel = new EditFoodPanel();
        
    }
    
    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            //Switch to add panel
            
        }
    }
    
    class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            //Switch to edit panel
            
        }
    }
    
    class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            //Delete selected entry
            
        }
    }

    /**
     * @return the food
     */
    public Food getFood() {
        return food;
    }

    /**
     * @param food the food to set
     */
    public void setFood(Food food) {
        this.food = food;
    }

    /**
     * @return the foodView
     */
    public FoodView getFoodView() {
        return foodView;
    }

    /**
     * @param foodView the foodView to set
     */
}
