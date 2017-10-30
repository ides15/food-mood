/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import app.EntryCntl;
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
    
    private AddFoodPanel addFoodPanel;
    
    /**
     * Default constructor for FoodCntl.
     * @param db Food model for MVC architecture.
     * @param foodView FoodView for MVC architecture.
     */
    public FoodCntl(Food_Table db, FoodView foodView) {        
        this.db = db;
        this.foodView = foodView;
        
        foodView.setVisible(true);
        
        foodView.addAddButtonListener(new AddButtonListener());
        foodView.addDeleteButtonListener(new DeleteButtonListener());
        foodView.addEditButtonListener(new EditButtonListener());
    }
    
    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            foodView.getFoodViewPanel().setVisible(false);
            addFoodPanel = new AddFoodPanel();
            foodView.add(addFoodPanel);
            addFoodPanel.setVisible(true);
            foodView.remove(foodView.getFoodViewPanel());
        }
    }
    
    class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("delete button listener");
            if(!foodView.getFoodViewPanel().getFoodListView().isSelectionEmpty())
                System.out.println(foodView.getFoodViewPanel().getFoodListView().getSelectedValue().toString() + " needs to be deleted");
            
//            db.deleteEntry(food, navCntl.getAccountID());
            
        }
    }
    
    class EditButtonListener implements ActionListener {
        @Override
        public  void actionPerformed(ActionEvent e) {
            System.out.println("edit button listener");
            
//            System.out.println("Food edited");
//            //switch to edit panel with old info on left side and new food form 
//            //on right with update on bottom
//            foodView.getFoodPanel().setVisible(false);
//            foodView.add(foodView.getEditFoodPanel());
//            foodView.getEditFoodPanel().setVisible(true);
//            foodView.remove(foodView.getFoodPanel());
        }
    }
    
//    class SubmitButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("submit button listener");
//            
////            System.out.println("Food added");
////            name = foodView.getAddFoodPanel().getFoodField().getText();
////            amount = (String)foodView.getAddFoodPanel().getComboBox().getSelectedItem();
////            date = now();
////            
////            food = new Food(name, amount, date);
////            
////            //Need actual accountID
////            db.addEntry(food ,navCntl.getAccountID());
////            
////            //db.addEntry(food);
////            foodView.getAddFoodPanel().setVisible(false);
////            foodView.add(foodView.getFoodPanel());
////            foodView.getFoodPanel().setVisible(true);
////            foodView.remove(foodView.getAddFoodPanel());
//        }
//    }
    
//    class UpdateButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("update button listener");
//            
////            System.out.println("Food updated");
////            //db.updateEntry(oldFood, newFood, navCntl.getAccountID());
////            foodView.getEditFoodPanel().setVisible(false);
////            foodView.add(foodView.getFoodPanel());
////            foodView.getFoodPanel().setVisible(true);
////            foodView.remove(foodView.getEditFoodPanel());
//        }
//    }
    
//    public static String now() {
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        return sdf.format(cal.getTime());
//    }

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
}
