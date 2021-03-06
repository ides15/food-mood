// John Ide - food controller (I did the delete and add functions)
package food;

import app.EntryCntl;
import models.Food;
import database.Food_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author John
 */
public class FoodCntl extends EntryCntl {

    private Food food;
    private final Food_Table db;
    private final FoodView foodView;
    private int accountID;

    private AddDrinkPanel addFoodPanel;
    private EditFoodPanel editFoodPanel;

    /**
     * Default constructor for FoodCntl.
     *
     * @param db Food model for MVC architecture.
     * @param foodView FoodView for MVC architecture.
     * @param accountID
     */
    public FoodCntl(int accountID, Food_Table db, FoodView foodView) {
        this.db = db;
        this.accountID = accountID;
        this.foodView = foodView;
        getFoodView().getFoodViewPanel().setAccountID(getAccountID());
        getFoodView().setVisible(true);

        getFoodView().addAddButtonListener(new AddButtonListener());
        getFoodView().addDeleteButtonListener(new DeleteButtonListener());
        getFoodView().addEditButtonListener(new EditButtonListener());
        getFoodView().addBackBtnListener(new BackBtnListener());

        getFoodView().addSubmitButtonListener(new SubmitButtonListener());
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
            getFoodView().add(getFoodView().getAddFoodPanel());
            getFoodView().getFoodViewPanel().setVisible(false);
            getFoodView().getAddFoodPanel().setVisible(true);
        }
    }

    class DeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (foodView.getFoodViewPanel().getFoodTable().getSelectedRow() != -1) {
                int selectedRow = getFoodView().getFoodViewPanel().getFoodTable().getSelectedRow();
                int selectedFoodID = Integer.parseInt(getFoodView().getFoodViewPanel().getFoodTable().getValueAt(selectedRow, 1).toString());

                db.deleteEntry(selectedFoodID, getAccountID());
                foodView.getFoodViewPanel().initFoodsData();
            }
        }
    }

    class EditButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getFoodView().getFoodViewPanel().getFoodTable().getSelectedRow() != -1) {
                getFoodView().add(getFoodView().getEditFoodPanel());
                getFoodView().getFoodViewPanel().setVisible(false);
                getFoodView().getEditFoodPanel().setVisible(true);
                getFoodView().addUpdateButtonListener(new UpdateButtonListener());

                int selectedRow = getFoodView().getFoodViewPanel().getFoodTable().getSelectedRow();
                String selectedFoodName = getFoodView().getFoodViewPanel().getFoodTable().getValueAt(selectedRow, 0).toString();
                getFoodView().getEditFoodPanel().getUpdateNameTextField().setText(selectedFoodName);

                int selectedFoodID = Integer.parseInt(getFoodView().getFoodViewPanel().getFoodTable().getValueAt(selectedRow, 1).toString());
                String portion = db.getPortionSize(selectedFoodID, getAccountID());

                int index = 2;
                if (portion.equals("Small")) {
                    index = 0;
                } else if (portion.equals("Medium")) {
                    index = 1;
                }

                getFoodView().getEditFoodPanel().getUpdateComboBox().setSelectedIndex(index);
            }
        }
    }

    class SubmitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = getFoodView().getAddFoodPanel().getFoodField().getText();
            String portion = getFoodView().getAddFoodPanel().getComboBox().getSelectedItem().toString();

            SimpleDateFormat dt = new SimpleDateFormat("MM-dd-yy");
            Food newFood = new Food(name, portion, dt.format(new Date()), 1);

            db.addEntry(newFood, accountID);

            getFoodView().getFoodViewPanel().initFoodsData();
            getFoodView().getFoodViewPanel().setVisible(true);
            getFoodView().getAddFoodPanel().setVisible(false);
            getFoodView().remove(getFoodView().getAddFoodPanel());
        }
    }

    class UpdateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = getFoodView().getFoodViewPanel().getFoodTable().getSelectedRow();
            int selectedFoodID = Integer.parseInt(getFoodView().getFoodViewPanel().getFoodTable().getValueAt(selectedRow, 1).toString());

            String updatedName = getFoodView().getEditFoodPanel().getUpdateNameTextField().getText();
            String updatedPortion = getFoodView().getEditFoodPanel().getUpdateComboBox().getSelectedItem().toString();

            db.updateEntry(updatedName, updatedPortion, selectedFoodID);

            getFoodView().getFoodViewPanel().initFoodsData();
            getFoodView().getFoodViewPanel().setVisible(true);
            getFoodView().getEditFoodPanel().setVisible(false);
            getFoodView().remove(getFoodView().getEditFoodPanel());
        }
    }

    public class BackBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            foodView.dispose();
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
}
