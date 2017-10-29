/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drink;

import app.EntryCntl;
import database.Drink_Table;
import models.Drink;
import app.NavCntl;
import app.NavView;
import database.Food_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author John
 */
public class DrinkCntl extends EntryCntl {
    private Drink drink;
    private final Drink_Table db;
    private final DrinkView drinkView;
    
    private final NavCntl navCntl;
    private final NavView navView;
    
    /**
     * Default constructor for DrinkCntl.
     * @param db Drink model for MVC architecture.
     * @param drinkView DrinkView for MVC architecture.
     */
    public DrinkCntl(Drink_Table db, DrinkView drinkView) {       
        this.db = db;
        this.drinkView = drinkView;
        
        drink = new Drink();
        
        navView = new NavView();
        navCntl = new NavCntl(getNavView());
        
        drinkView.setVisible(true);
        
        drinkView.addAddButtonListener(new AddButtonListener());
        drinkView.addDeleteButtonListener(new DeleteButtonListener());
        drinkView.addEditButtonListener(new EditButtonListener());
        drinkView.addSubmitButtonListener(new SubmitButtonListener());
        drinkView.addUpdateButtonListener(new UpdateButtonListener());
    }
    
    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Drink added");
            //Switch to add panel
            drinkView.getDrinkViewPanel().setVisible(false);
            drinkView.add(drinkView.getAddDrinkPanel());
            drinkView.getAddDrinkPanel().setVisible(true);
            drinkView.remove(drinkView.getDrinkViewPanel());
        }
    }
    
    class EditButtonListener implements ActionListener {
        @Override
        public  void actionPerformed(ActionEvent e) {
            
            System.out.println("Drink edited");
            //switch to edit panel with old info on left side and new food form 
            //on right with update on bottom
            drinkView.getDrinkViewPanel().setVisible(false);
            drinkView.add(drinkView.getEditDrinkPanel());
            drinkView.getEditDrinkPanel().setVisible(true);
            drinkView.remove(drinkView.getDrinkViewPanel());
        }
    }
    
    class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String selection;
            System.out.println("Food deleted");
            //Get food object from list on FoodPanel
            selection = drinkView.getDrinkViewPanel().getDrinkListView().getSelectedValue().toString();
            drink.setName(selection);
            //Need to construct rest of food object in order to delete it
            db.deleteEntry(drink, navCntl.getAccountID());
            
        }
    }
    
    class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Food added");
            //db.addEntry(food);
            drinkView.getAddDrinkPanel().setVisible(false);
            drinkView.add(drinkView.getDrinkViewPanel());
            drinkView.getDrinkViewPanel().setVisible(true);
            drinkView.remove(drinkView.getAddDrinkPanel());
        }
    }
    
    class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Food updated");
            //db.updateEntry(oldFood, newFood, navCntl.getAccountID());
            drinkView.getEditDrinkPanel().setVisible(false);
            drinkView.add(drinkView.getDrinkViewPanel());
            drinkView.getDrinkViewPanel().setVisible(true);
            drinkView.remove(drinkView.getEditDrinkPanel());
        }
    }
    
    public Drink getDrink() {
        return drink;
    }
    
    public void setDrink(Drink drink) {
        this.drink = drink;
    }
    
    /**
     * @return the drinkView
     */
    public DrinkView getDrinkView() {
        return drinkView;
    }
    
    public NavView getNavView() {
        return navView;
    }
}
