/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.swing.JFrame;

/**
 *
 * @author john
 */
public class NotificationView extends JFrame {
    private int accountID;
    
    private NotificationViewPanel notificationViewPanel;
    
    public NotificationView() {
        super("Notification");
        
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        notificationViewPanel = new NotificationViewPanel(getAccountID());
        add(notificationViewPanel);
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

    /**
     * @return the notificationViewPanel
     */
    public NotificationViewPanel getNotificationViewPanel() {
        return notificationViewPanel;
    }
}
