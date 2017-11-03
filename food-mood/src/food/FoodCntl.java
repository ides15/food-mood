// John Ide - food controller (I did the delete and add functions)

package food;

import app.EntryCntl;
import models.Food;
import database.Food_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ListModel;

/**
 *
 * @author John
 */
public class FoodCntl extends EntryCntl {
    private Food food;
    private final Food_Table db;
    private final FoodView foodView;
    private int accountID;
    
    private AddFoodPanel addFoodPanel;
    
    /**
     * Default constructor for FoodCntl.
     * @param db Food model for MVC architecture.
     * @param foodView FoodView for MVC architecture.
     * @param accountID
     */
    public FoodCntl(int accountID, Food_Table db, FoodView foodView) {        
        this.db = db;
        this.accountID = accountID;
        this.foodView = foodView;
        getFoodView().getFoodViewPanel().setAccountID(getAccountID());
        
        foodView.setVisible(true);
        
        foodView.addAddButtonListener(new AddButtonListener());
        foodView.addDeleteButtonListener(new DeleteButtonListener());
        foodView.addEditButtonListener(new EditButtonListener());
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
            getFoodView().addSubmitButtonListener(new SubmitButtonListener());
        }
    }
    
    class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!foodView.getFoodViewPanel().getFoodListView().isSelectionEmpty()) {
                db.deleteEntry(foodView.getFoodViewPanel().getFoodListView().getSelectedValue().toString(), getAccountID());
                foodView.getFoodViewPanel().initFoodsData();
            }
        }
    }
    
    class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("edit");
//            name = foodView.getAddFoodPanel().getFoodField().getText().toString();
//            amount = foodView.getAddFoodPanel().getComboBox().getSelectedItem().toString();
            
//            date = now();
            
//            food = new Food(name, amount, date);
            
            //Need actual accountID
//            db.addEntry(food , accountID);
        }
    }
    
    class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            foodView.remove(foodView.getAddFoodPanel());
            //foodView.getAddFoodPanel().setVisible(false);
            
            String name = getFoodView().getAddFoodPanel().getFoodField().getText();
            ListModel amountModel = getFoodView().getAddFoodPanel().getComboBox().getModel();
            String amount = amountModel.getElementAt(getFoodView().getAddFoodPanel().getComboBox().getSelectedIndex()).toString();
            
            System.out.println("name: " + name);
            System.out.println("amount: " + amount);
            
            Food newFood = new Food(name, amount, new Date().toString());
            
            db.addEntry(newFood, accountID);
            
            foodView.getFoodViewPanel().initFoodsData();
            
            foodView.revalidate();
            foodView.repaint();
            foodView.add(foodView.getFoodViewPanel());
            foodView.getFoodViewPanel().setVisible(true);
            //foodView.repaint();
        }
    }
    
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
