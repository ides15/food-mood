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
<<<<<<< HEAD
    private Food_Table db;
    private FoodPanel foodPanel;
    private AddFoodPanel addFoodPanel;
    private EditFoodPanel editFoodPanel;
=======
    private final Food_Table db;
    private final FoodViewPanel foodViewPanel;
>>>>>>> origin/master
    
    /**
     * Default constructor for FoodView.
     * @param db FoodView for MVC architecture.
     */
    public FoodView(Food_Table db) {
        super("Food");
        this.db = db;
        
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        foodPanel = new FoodPanel();
        addFoodPanel = new AddFoodPanel();
        editFoodPanel = new EditFoodPanel();
        add(foodPanel);
    }

    /**
     * @return the food
     */
<<<<<<< HEAD
    public FoodPanel getFoodPanel(){
        return this.foodPanel;
    }
    
    public void setFoodPanel(FoodPanel foodPanel){
        this.foodPanel = foodPanel;
    }
    
    public AddFoodPanel getAddFoodPanel(){
        return this.addFoodPanel;
    }
    
    public void setFoodPanel(AddFoodPanel addFoodPanel){
        this.addFoodPanel = addFoodPanel;
    }
    
    public EditFoodPanel getEditFoodPanel(){
        return this.editFoodPanel;
    }
    
    public void setEditFoodPanel(AddFoodPanel EditFoodPanel){
        this.editFoodPanel = editFoodPanel;
    }
    
    public void addAddButtonListener(ActionListener al) {
        getFoodPanel().getAddButton().addActionListener(al);
    }
    
    public void addEditButtonListener(ActionListener al) {
        getFoodPanel().getEditButton().addActionListener(al);
    }
    
    public void addDeleteButtonListener(ActionListener al) {
        getFoodPanel().getDeleteButton().addActionListener(al);
    }
    
    public void addSubmitButtonListener(ActionListener al){
        getAddFoodPanel().getSubmitButton().addActionListener(al);
    }
    
    public void addUpdateButtonListener(ActionListener al){
        getEditFoodPanel().getEditButton().addActionListener(al);
=======
    public FoodViewPanel getFoodViewPanel(){
        return foodViewPanel;
>>>>>>> origin/master
    }
}
