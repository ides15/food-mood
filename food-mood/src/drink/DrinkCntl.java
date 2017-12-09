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
import java.text.SimpleDateFormat;
import java.util.Date;

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
     *
     * @param db Drink model for MVC architecture.
     * @param drinkView DrinkView for MVC architecture.
     * @param accountID
     */
    public DrinkCntl(int accountID, Drink_Table db, DrinkView drinkView) {
        this.db = db;
        this.accountID = accountID;
        this.drinkView = drinkView;
        getDrinkView().getDrinkViewPanel().setAccountID(getAccountID());
        getDrinkView().setVisible(true);

        getDrinkView().addAddButtonListener(new AddButtonListener());
        getDrinkView().addDeleteButtonListener(new DeleteButtonListener());
        getDrinkView().addEditButtonListener(new EditButtonListener());
        getDrinkView().addBackBtnListener(new DrinkCntl.BackBtnListener());

        getDrinkView().addSubmitButtonListener(new SubmitButtonListener());
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
            getDrinkView().add(getDrinkView().getAddDrinkPanel());
            drinkView.getDrinkViewPanel().setVisible(false);
            drinkView.getAddDrinkPanel().setVisible(true);
        }
    }

    class EditButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getDrinkView().getDrinkViewPanel().getDrinkTable().getSelectedRow() != -1) {
                getDrinkView().add(getDrinkView().getEditDrinkPanel());
                getDrinkView().getDrinkViewPanel().setVisible(false);
                getDrinkView().getEditDrinkPanel().setVisible(true);
                getDrinkView().addUpdateButtonListener(new UpdateButtonListener());

                int selectedRow = getDrinkView().getDrinkViewPanel().getDrinkTable().getSelectedRow();
                String selectedDrinkName = getDrinkView().getDrinkViewPanel().getDrinkTable().getValueAt(selectedRow, 0).toString();
                getDrinkView().getEditDrinkPanel().getUpdateNameTextField().setText(selectedDrinkName);

                int selectedDrinkID = Integer.parseInt(getDrinkView().getDrinkViewPanel().getDrinkTable().getValueAt(selectedRow, 1).toString());
                String portion = db.getPortionSize(selectedDrinkID);

                int index = 2;
                if (portion.equals("Small")) {
                    index = 0;
                } else if (portion.equals("Medium")) {
                    index = 1;
                }

                getDrinkView().getEditDrinkPanel().getUpdateComboBox().setSelectedIndex(index);
            }
        }
    }

    class DeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (drinkView.getDrinkViewPanel().getDrinkTable().getSelectedRow() != -1) {
                int selectedRow = getDrinkView().getDrinkViewPanel().getDrinkTable().getSelectedRow();
                int selectedDrinkID = Integer.parseInt(getDrinkView().getDrinkViewPanel().getDrinkTable().getValueAt(selectedRow, 1).toString());

                db.deleteEntry(selectedDrinkID);
                drinkView.getDrinkViewPanel().initDrinksData();
            }
        }
    }

    class SubmitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = getDrinkView().getAddDrinkPanel().getDrinkField().getText();
            String portion = getDrinkView().getAddDrinkPanel().getComboBox().getSelectedItem().toString();

            SimpleDateFormat dt = new SimpleDateFormat("MM-dd-yy");
            Drink newDrink = new Drink(name, portion, dt.format(new Date()), 1);

            db.addNewDrink(newDrink, accountID);

            getDrinkView().getDrinkViewPanel().initDrinksData();
            getDrinkView().getDrinkViewPanel().setVisible(true);
            getDrinkView().getAddDrinkPanel().setVisible(false);
            getDrinkView().remove(getDrinkView().getAddDrinkPanel());
        }
    }

    class UpdateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = getDrinkView().getDrinkViewPanel().getDrinkTable().getSelectedRow();
            int selectedDrinkID = Integer.parseInt(getDrinkView().getDrinkViewPanel().getDrinkTable().getValueAt(selectedRow, 1).toString());

            String updatedName = getDrinkView().getEditDrinkPanel().getUpdateNameTextField().getText();
            String updatedPortion = getDrinkView().getEditDrinkPanel().getUpdateComboBox().getSelectedItem().toString();

            db.updateEntry(updatedName, updatedPortion, selectedDrinkID);

            getDrinkView().getDrinkViewPanel().initDrinksData();
            getDrinkView().getDrinkViewPanel().setVisible(true);
            getDrinkView().getEditDrinkPanel().setVisible(false);
            getDrinkView().remove(getDrinkView().getEditDrinkPanel());
        }
    }

    public class BackBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            drinkView.dispose();
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
