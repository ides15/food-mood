/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import DesignSelection.FoodMoodEntryForm;
import DesignSelection.FoodMoodEntryFormCntl;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author John
 */
public class NavView extends JFrame {
    private final NavViewPanel navViewPanel;
    private final FoodMoodEntryForm foodMoodEntryForm;
    
    /**
     * Default constructor for MainView.
     */
    public NavView() {
        super("NavView");
        
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        foodMoodEntryForm = new FoodMoodEntryForm();
        navViewPanel = new NavViewPanel();
        
        add(navViewPanel);
    }
    
    public void addAddEntriesListener(ActionListener al) {
        getNavViewPanel().getAddEntriesButton().addActionListener(al);
    }
    
    public void addViewRecsListener(ActionListener al) {
        getNavViewPanel().getViewRecsButton().addActionListener(al);
    }
    
    public void addViewEntriesListener(ActionListener al) {
        getNavViewPanel().getViewEntriesButton().addActionListener(al);
    }
    
    public void addViewProfileListener(ActionListener al) {
        getNavViewPanel().getViewProfileButton().addActionListener(al);
    }
    
    public void addLogoutListener(ActionListener al) {
        getNavViewPanel().getLogoutButton().addActionListener(al);
    }

    /**
     * @return the navViewPanel
     */
    public NavViewPanel getNavViewPanel() {
        return navViewPanel;
    }

    /**
     * @return the newEntriesViewPanel
     */
    public FoodMoodEntryForm getNewEntriesViewPanel() {
        return foodMoodEntryForm;
    }
}
