/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drink;

import database.Drink_Table;
import javax.swing.JFrame;
import models.Drink;
import java.awt.event.ActionListener;

/**
 *
 * @author John
 */
public class DrinkView extends JFrame {
    private Drink drink;
    private final Drink_Table db;
    private DrinkViewPanel drinkViewPanel;
    private AddDrinkPanel addDrinkPanel;
    private EditDrinkPanel editDrinkPanel;
    private int accountID;
    
    /**
     * Default constructor for DrinkView.
     * @param db Drink model for MVC architecture.
     */
    public DrinkView(int accountID, Drink_Table db) {    
        super("Drink");
        this.accountID = accountID;
        this.db = db;
        
        setSize(450, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        drinkViewPanel = new DrinkViewPanel(accountID);
        addDrinkPanel = new AddDrinkPanel(accountID);
        editDrinkPanel = new EditDrinkPanel(accountID);
        add(drinkViewPanel);
    }

    /**
     * @return the drinkViewPanel
     */
    public DrinkViewPanel getDrinkViewPanel() {
        return this.drinkViewPanel;
    }
    
    public void setDrinkViewPanel(DrinkViewPanel drinkViewPanel) {
        this.drinkViewPanel = drinkViewPanel;
    }
    
    public AddDrinkPanel getAddDrinkPanel() {
        return this.addDrinkPanel; 
    }
    
    public void setAddDrinkPanel(AddDrinkPanel addDrinkPanel) {
        this.addDrinkPanel = addDrinkPanel;
    }
    
    public EditDrinkPanel getEditDrinkPanel() {
        return this.editDrinkPanel;
    }
    
    public void setEditDrinkPanel(EditDrinkPanel editDrinkPanel) {
        this.editDrinkPanel = editDrinkPanel;
    }
    
    public void setEditDrinkPanel(AddDrinkPanel addDrinkPanel){
        this.addDrinkPanel = addDrinkPanel;
    }
    
    public void addAddButtonListener(ActionListener al) {
        getDrinkViewPanel().getAddButton().addActionListener(al);
    }
    
    public void addEditButtonListener(ActionListener al) {
        getDrinkViewPanel().getEditButton().addActionListener(al);
    }
    
    public void addDeleteButtonListener(ActionListener al) {
        getDrinkViewPanel().getDeleteButton().addActionListener(al);
    }
    
    public void addSubmitButtonListener(ActionListener al){
        getAddDrinkPanel().getSubmitButton().addActionListener(al);
    }
    
    public void addUpdateButtonListener(ActionListener al){
        getEditDrinkPanel().getUpdateButton().addActionListener(al);
    }
    public void addBackBtnListener(ActionListener al){
        getDrinkViewPanel().getBackButton().addActionListener(al);
    }
}
