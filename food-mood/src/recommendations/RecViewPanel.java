/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendations;

import database.*;

/**
 *
 * @author Kyle
 */
public class RecViewPanel extends javax.swing.JPanel {
    
    private final Mood_Table mood_DB;
    private final Food_Table food_DB;
    private String[] recData;
    private int accountID;

    /**
     * Creates new form RecViewPanel
     */
    public RecViewPanel(int accountID) {
        this.accountID = accountID;
        mood_DB = new Mood_Table("foodmood.db");
        food_DB = new Food_Table("foodmood.db");
        
        initComponents();
        initRecData();
    }
    
    public void initRecData() {
        //getRecTable().setModel();
        //Function for creating rec model for jtable goes here
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        recLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recTable = new javax.swing.JTable();

        recLabel.setText("Recommendations");

        recTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(recTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(64, 64, 64)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(recLabel)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(64, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(recLabel)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

     /**
     * @return the FoodTable
     */
    public javax.swing.JTable getRecTable() {
        return recTable;
    }
    
    /**
     * Sets accoundID
     * @param accountID 
     */
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    /**
     * @return the accountID
     */
    public int getAccountID() {
        return accountID;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel recLabel;
    private javax.swing.JTable recTable;
    // End of variables declaration//GEN-END:variables
}
