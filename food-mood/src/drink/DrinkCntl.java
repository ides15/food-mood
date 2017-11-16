/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drink;

import app.EntryCntl;
import database.Drink_Table;
import models.Drink;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ListModel;

/**
 *
 * @author John
 */
public class DrinkCntl extends EntryCntl {
    private Drink drink;
    private final Drink_Table db;
    private final DrinkView drinkView;
    private int accountID;
    
    /**
     * Default constructor for DrinkCntl.
     * @param db Drink model for MVC architecture.
     * @param drinkView DrinkView for MVC architecture.
     * @param accountID
     */
    public DrinkCntl(int accountID, Drink_Table db, DrinkView drinkView) {       
        this.db = db;
        this.accountID = accountID;
        this.drinkView = drinkView;
        
        
        drinkView.setVisible(true);
        
        drinkView.addAddButtonListener(new AddButtonListener());
        drinkView.addDeleteButtonListener(new DeleteButtonListener());
        drinkView.addEditButtonListener(new EditButtonListener());
        drinkView.addSubmitButtonListener(new SubmitButtonListener());
        drinkView.addUpdateButtonListener(new UpdateButtonListener());
    }

    @Override
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public int getAccountID() {
        return this.accountID;
    }
    
    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
//            System.out.println("Drink added");
//            //Switch to add panel
            drinkView.getDrinkViewPanel().setVisible(false);
            drinkView.add(drinkView.getAddDrinkPanel());
            drinkView.getAddDrinkPanel().setVisible(true);
            drinkView.remove(drinkView.getDrinkViewPanel());
        }
    }
    
    class EditButtonListener implements ActionListener {
        @Override
        public  void actionPerformed(ActionEvent e) {
            
//            System.out.println("Drink edited");
//            //switch to edit panel with old info on left side and new food form 
//            //on right with update on bottom
            drinkView.getDrinkViewPanel().setVisible(false);
            drinkView.add(drinkView.getEditDrinkPanel());
            drinkView.getEditDrinkPanel().setVisible(true);
            drinkView.remove(drinkView.getDrinkViewPanel());
            
            int selectedRow = getDrinkView().getDrinkViewPanel().getDrinkTable().getSelectedRow();
            String selectedFoodName = getDrinkView().getDrinkViewPanel().getDrinkTable().getValueAt(selectedRow, 0).toString();
            getDrinkView().getEditDrinkPanel().getUpdateNameTextField().setText(selectedFoodName);
                
            int selectedDrinkID = Integer.parseInt(getDrinkView().getDrinkViewPanel().getDrinkTable().getValueAt(selectedRow, 1).toString());
            String portion = db.getPortionSize(selectedDrinkID, getAccountID());
                
            int index = 2;
            if (portion.equals("Small")) {
                index = 0;
            } else if (portion.equals("Medium")) {
                index = 1;
            }
            
            getDrinkView().getEditDrinkPanel().getUpdateComboBox().setSelectedIndex(index);
        }
    }
    
    class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(drinkView.getDrinkViewPanel().getDrinkTable().getSelectedRow() != -1) {
                int selectedRow = getDrinkView().getDrinkViewPanel().getDrinkTable().getSelectedRow();
                int selectedFoodID = Integer.parseInt(getDrinkView().getDrinkViewPanel().getDrinkTable().getValueAt(selectedRow, 1).toString());
                
                db.deleteEntry(selectedFoodID, getAccountID());
                drinkView.getDrinkViewPanel().initDrinksData();
            }
        }
    }
    
    class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
//            System.out.println("Food added");
//            //db.addEntry(food);
            
            String name = getDrinkView().getAddDrinkPanel().getDrinkField().getText();
            ListModel amountModel = getDrinkView().getAddDrinkPanel().getComboBox().getModel();
            String amount = amountModel.getElementAt(getDrinkView().getAddDrinkPanel().getComboBox().getSelectedIndex()).toString();
            
            Drink newDrink = new Drink(name, amount, new Date().toString(), 1);
            
            db.addNewDrink(newDrink, accountID);
            
            drinkView.getDrinkViewPanel().initDrinksData();
            drinkView.getAddDrinkPanel().setVisible(false);
            drinkView.add(drinkView.getDrinkViewPanel());
            drinkView.getDrinkViewPanel().setVisible(true);
            drinkView.remove(drinkView.getAddDrinkPanel());
        }
    }
    
    class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
//            System.out.println("Food updated");
//            //db.updateEntry(oldFood, newFood, navCntl.getAccountID());
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
}
