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
import java.util.Calendar;
import java.text.SimpleDateFormat;

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
    
    private String name;
    private String amount;
    private String date;
    private int accountID;
    
    
    /**
     * Default constructor for FoodCntl.
     * @param db Food model for MVC architecture.
     * @param foodView FoodView for MVC architecture.
     */
    public FoodCntl(Food_Table db, FoodView foodView, int accountID) {        
        this.db = db;
        this.foodView = foodView;
        this.accountID = accountID;
        navView = new NavView();
        navCntl = new NavCntl(getNavView());
        
        foodView.setVisible(true);
        
        foodView.addAddButtonListener(new AddButtonListener());
        foodView.addDeleteButtonListener(new DeleteButtonListener());
        foodView.addEditButtonListener(new EditButtonListener());
        foodView.addSubmitButtonListener(new SubmitButtonListener());
        foodView.addUpdateButtonListener(new UpdateButtonListener());
    }
    
    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Food added");
            //Switch to add panel
            foodView.getFoodPanel().setVisible(false);
            foodView.add(foodView.getAddFoodPanel());
            foodView.getAddFoodPanel().setVisible(true);
            foodView.remove(foodView.getFoodPanel());
        }
    }
    
    class EditButtonListener implements ActionListener {
        @Override
        public  void actionPerformed(ActionEvent e) {
            
            System.out.println("Food edited");
            //switch to edit panel with old info on left side and new food form 
            //on right with update on bottom
            foodView.getFoodPanel().setVisible(false);
            foodView.add(foodView.getEditFoodPanel());
            foodView.getEditFoodPanel().setVisible(true);
            foodView.remove(foodView.getFoodPanel());
        }
    }
    
    class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String selection;
            System.out.println("Food deleted");
            //Get food object from list on FoodPanel
            selection = foodView.getFoodPanel().getFoodListView().getSelectedValue().toString();
            food.setName(selection);
            //Need to construct rest of food object in order to delete it
            db.deleteEntry(food, navCntl.getAccountID());
            
        }
    }
    
    class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Food added");
            name = foodView.getAddFoodPanel().getFoodField().getText().toString();
            amount = foodView.getAddFoodPanel().getComboBox().getSelectedItem().toString();
            
            date = now();
            
            food = new Food(name, amount, date);
            
            //Need actual accountID
            db.addEntry(food , accountID);
            
            //db.addEntry(food);
            foodView.getAddFoodPanel().setVisible(false);
            foodView.add(foodView.getFoodPanel());
            foodView.getFoodPanel().setVisible(true);
            foodView.remove(foodView.getAddFoodPanel());
        }
    }
    
    class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Food updated");
            //db.updateEntry(oldFood, newFood, navCntl.getAccountID());
            foodView.getEditFoodPanel().setVisible(false);
            foodView.add(foodView.getFoodPanel());
            foodView.getFoodPanel().setVisible(true);
            foodView.remove(foodView.getEditFoodPanel());
        }
    }
    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(cal.getTime());
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
