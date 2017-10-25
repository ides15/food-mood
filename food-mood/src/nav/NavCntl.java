/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import app.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author reesmcdevitt
 */
public class NavCntl {
    
    private NavModel navModel;
    private NavView navView;
    
    private Database mainModel;
    private MainView mainView;
//    private SettingsView setView;
    private Database setModel;
    
    private Database taskModel;
//    private TaskView taskView;
//    private TaskCntl taskCntl;
    
//    private ContactView contactView;
//    private ContactCntl contactCntl;
    private Database contactModel;
    
    private Database loginModel;
    private LoginView loginView;
    private LoginCntl loginCntl;
    
    NavCntl(NavModel navModel, NavView navView)
    {   
        this.navModel = navModel;
        this.navView = navView;
        
        mainModel = new Database("tcm.db");
//        mainView = new MainView(mainModel);
        
        setModel = new Database("tcm.db");
//        setView = new SettingsView(setModel);
        
        taskModel = new Database("tcm.db");
//        taskView = new TaskView(taskModel);
//        taskCntl = new TaskCntl(taskModel, taskView);
        
        contactModel = new Database("tcm.db");
//        contactView = new ContactView(contactModel);
//        contactCntl = new ContactCntl(contactModel, contactView);
        
        navView.addMainButtonListener(new MainButtonListener());
        navView.addContactButtonListener(new ContactButtonListener());
        navView.addTaskButtonListener(new TaskButtonListener());
//        navView.addSettingsButtonListener(new SettingsButtonListener());
        navView.addLogoffButtonListener(new LogoffButtonListener());
    }

    /**
     * @return the taskCntl
     */
//    public TaskCntl getTaskCntl() {
//        return taskCntl;
//    }

    /**
     * @return the contactCntl
     */
//    public ContactCntl getContactCntl() {
//        return contactCntl;
//    }

    /**
     * @return the mainView
     */
    public MainView getMainView() {
        return mainView;
    }

    /**
     * @return the setView
     */
//    public SettingsView getSetView() {
//        return setView;
//    }

    /**
     * @return the mainCntl
     */
    
    class MainButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
//            navView.switchToMainPanel(getMainView());
        }
    }
     
    class ContactButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
//            navView.switchToContactPanel(contactView);
        }
    }
     
    class TaskButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
//            navView.switchToTaskPanel(taskView);
        }
    }
     
//    class SettingsButtonListener implements ActionListener
//    {
//        public void actionPerformed(ActionEvent e) 
//        {
//            navView.switchToSettingsPanel(getSetView());
//        }
//    }
     
    class LogoffButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
//            navView.setVisible(false);
//            loginModel = new Database("tcm.db");
//            loginView = new LoginView(loginModel);
//            loginCntl = new LoginCntl(loginModel, loginView);
        }
    }
}
