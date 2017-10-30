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
    private int accountID;
    
    /**
     * Default constructor for FoodView.
     * @param db FoodView for MVC architecture.
     * @param accountID
     */
    public FoodView(int accountID, Food_Table db) {
        super("Food");
        this.db = db;
        this.accountID = accountID;
        
        setSize(450, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        foodViewPanel = new FoodViewPanel(accountID);
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

    /**
     * @return the accountID
     */
    public int getAccountID() {
        return accountID;
    }

    /**
     * @param accountID the accountID to set
     */
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
