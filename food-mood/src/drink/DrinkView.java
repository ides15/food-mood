/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drink;

import database.Drink_Table;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import models.Drink;

/**
 *
 * @author John
 */
public class DrinkView extends JFrame {

    private Drink drink;
    private final Drink_Table db;
    private DrinkViewPanel drinkViewPanel;
    private EditDrinkPanel editDrinkPanel;
    private AddDrinkPanel addDrinkPanel;
    private int accountID;

    /**
     * Default constructor for DrinkView.
     *
     * @param db DrinkView for MVC architecture.
     * @param accountID
     */
    public DrinkView(int accountID, Drink_Table db) {
        super("Drink");
        this.db = db;
        this.accountID = accountID;

        setSize(450, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addDrinkPanel = new AddDrinkPanel(accountID);
        editDrinkPanel = new EditDrinkPanel(accountID);
        drinkViewPanel = new DrinkViewPanel(accountID);
        add(drinkViewPanel);
    }

    public void addAddButtonListener(ActionListener al) {
        getDrinkViewPanel().getAddButton().addActionListener(al);
    }

    public void addDeleteButtonListener(ActionListener al) {
        getDrinkViewPanel().getDeleteButton().addActionListener(al);
    }

    public void addEditButtonListener(ActionListener al) {
        getDrinkViewPanel().getEditButton().addActionListener(al);
    }

    public void addSubmitButtonListener(ActionListener al) {
        getAddDrinkPanel().getSubmitButton().addActionListener(al);
    }

    public void addUpdateButtonListener(ActionListener al) {
        getEditDrinkPanel().getUpdateButton().addActionListener(al);
    }

    public void addBackBtnListener(ActionListener al) {
        getDrinkViewPanel().getBackButton().addActionListener(al);
    }

    /**
     * @return the drinkViewPanel
     */
    public DrinkViewPanel getDrinkViewPanel() {
        return drinkViewPanel;
    }

    /**
     * @param drinkViewPanel the drinkViewPanel to set
     */
    public void setDrinkViewPanel(DrinkViewPanel drinkViewPanel) {
        this.drinkViewPanel = drinkViewPanel;
    }

    public AddDrinkPanel getAddDrinkPanel() {
        return addDrinkPanel;
    }

    public EditDrinkPanel getEditDrinkPanel() {
        return editDrinkPanel;
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
