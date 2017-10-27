/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.swing.JFrame;

/**
 *
 * @author John
 */
public class NavView extends JFrame {
    private NavViewPanel navViewPanel;
    
    /**
     * Default constructor for MainView.
     */
    public NavView() {
        super("NavView");
        
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        navViewPanel = new NavViewPanel();
        add(navViewPanel);
    }
}
