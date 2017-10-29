/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import database.Food_Table;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import models.Food;

/**
 *
 * @author Kyle
 */
public class EditFoodView extends JFrame {
    
    private Food food;
    private final Food_Table db;
    private EditFoodPanel editFoodPanel;
    
    public EditFoodView(Food_Table db){
        super("Food");
        this.db = db;
        
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        editFoodPanel = new EditFoodPanel();
        add(editFoodPanel);
    }
    
    public void addUpdateButtonListener(ActionListener al){
        getEditFoodPanel().getUpdateButton().addActionListener(al);
    }
    
    public EditFoodPanel getEditFoodPanel(){
        return this.editFoodPanel;
    }
    
    public void setEditFoodPanel(AddFoodPanel EditFoodPanel){
        this.editFoodPanel = editFoodPanel;
    }
}
