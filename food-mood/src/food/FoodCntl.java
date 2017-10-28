/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import app.EntryCntl;
import app.NavCntl;
import app.NavView;
import models.Food;
import database.Food_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author John
 */
public class FoodCntl extends EntryCntl {
    private Food food;
    private final Food_Table db;
    private final FoodView foodView;
    
    private final NavCntl navCntl;
    private final NavView navView;
    
    private final FoodPanel foodPanel;
    private final AddFoodPanel addFoodPanel;
    private final EditFoodPanel editFoodPanel;
    
    /**
     * Default constructor for FoodCntl.
     * @param db Food model for MVC architecture.
     * @param foodView FoodView for MVC architecture.
     */
    public FoodCntl(Food_Table db, FoodView foodView) {        
        this.db = db;
        this.foodView = foodView;
        
        food = new Food("food", "amount");
        
        navView = new NavView();
        navCntl = new NavCntl(getNavView());
        
        foodView.setVisible(true);
        
        foodPanel = new FoodPanel();
        addFoodPanel = new AddFoodPanel();
        editFoodPanel = new EditFoodPanel();
    }
    
    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Food added");
            //Switch to add panel
            
        }
    }
    
    class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Food edited");
            //Switch edit panel
            
        }
    }
    
    class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String selection;
            System.out.println("Food deleted");
            //Get food object from list on FoodPanel
            selection = foodPanel.getFoodListView().getSelectedValue().toString();
            food.setName(selection);
            //Need to construct rest of food object in order to delete it
            db.deleteEntry(food);
            
        }
    }
    
    class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Food added");
            //db.addEntry(food);
            
        }
    }
    
    class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Food updated");
            //db.setEntry(oldFood, newFood);
            
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
    
    public NavView getNavView() {
        return navView;
    }

}
