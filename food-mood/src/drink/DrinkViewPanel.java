package drink;

import database.Drink_Table;

/**
 *
 * @author john
 */
public class DrinkViewPanel extends javax.swing.JPanel {
    private final Drink_Table db;
    private String drink;
    private String[] drinksData;
    private int accountID;

    /**
     * Creates new form DrinkViewPanel
     * @param accountID
     */
    public DrinkViewPanel(int accountID) {
        initComponents();
        this.accountID = accountID;
        db = new Drink_Table("foodmood.db");
        
        initDrinksData();
    }
    
    public void initDrinksData() {
        getDrinkTable().setModel(db.getDrinkList(getAccountID()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entryLabel = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        drinksTable = new javax.swing.JTable();

        entryLabel.setText("Entries");

        editButton.setText("Edit");

        deleteButton.setText("Delete");

        addButton.setText("Add");

        drinksTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(drinksTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(entryLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(editButton)
                        .addGap(27, 27, 27)
                        .addComponent(deleteButton)
                        .addGap(26, 26, 26)
                        .addComponent(addButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(entryLabel)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    /*private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel entryLabel;
    private javax.swing.JList<String> foodListView;
    private javax.swing.JScrollPane jScrollPane1; */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTable drinksTable;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel entryLabel;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getAddButton(){
        return this.addButton;
    }
    
    public void setAddButton(javax.swing.JButton addButton){
        this.addButton = addButton;
    }
    
    public javax.swing.JButton getDeleteButton(){
        return this.deleteButton;
    }
    
    public void setDeleteButton(javax.swing.JButton deleteButton){
        this.deleteButton = deleteButton;
    }
    
    public javax.swing.JButton getEditButton(){
        return this.editButton;
    }
    
    public void setEditButton(javax.swing.JButton editButton){
        this.editButton = editButton;
    }
    
    public javax.swing.JLabel getEntryLabel(){
        return this.entryLabel;
    }
    
    public void  setEntryLabel(javax.swing.JLabel entryLabel){
        this.entryLabel = entryLabel;
    }
    
    public int getAccountID() {
        return accountID;
    }
    
    public String[] getDrinksData() {
        return drinksData;
    }
    
    public void setDrinksData(String[] drinksData) {
        this.drinksData = drinksData;
    }
    
    /**
     * @return the foodsData
     */
    public String[] getDrinkData() {
        return drinksData;
    }

    /**
     * @param foodsData the foodsData to set
     */
    public void setDrinkData(String[] foodsData) {
        this.drinksData = foodsData;
    }

    /**
     * @return the DrinkTable
     */
    public javax.swing.JTable getDrinkTable() {
        return drinksTable;
    }

    /**
     * @param accountID the accountID to set
     */
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
