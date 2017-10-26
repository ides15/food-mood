/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import javax.swing.JPanel;
/**
 *
 * @author Kyle
 */
public class FoodViewPanel extends JPanel{
    private FoodPanel foodPanel;
    
    public FoodViewPanel() {
        super();
        
        foodPanel = new FoodPanel();
        
        add(foodPanel);
    }

    /**
     * @return the userLoginPanel
     */
    public FoodPanel getFoodPanel() {
        return foodPanel;
    }

    /**
     * @param userLoginPanel the userLoginPanel to set
     */
    public void setFoodPanel(FoodPanel foodPanel) {
        this.foodPanel = foodPanel;
    }
}
