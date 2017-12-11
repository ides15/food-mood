// John Ide - page for adding a new drink

package drink;

/**
 *
 * @author Kyle
 */
public class AddDrinkPanel extends javax.swing.JPanel {
    private int accountID;
    
    /**
     * Creates new form DrinkCreatePanel
     * @param accountID
     */
    protected AddDrinkPanel(int accountID) {
        initComponents();
        this.accountID = accountID;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        drinkField = new javax.swing.JTextField();
        foodLabel = new javax.swing.JLabel();
        portionLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox<>();

        drinkField.setText("Ex. Water");
        drinkField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drinkFieldActionPerformed(evt);
            }
        });

        foodLabel.setText("Drink");

        portionLabel.setText("Portion");

        submitButton.setText("Submit");

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large"}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(foodLabel)
                            .addComponent(drinkField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(portionLabel)
                            .addComponent(comboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(submitButton)))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(foodLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drinkField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(portionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(submitButton)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void drinkFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drinkFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drinkFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JTextField drinkField;
    private javax.swing.JLabel foodLabel;
    private javax.swing.JLabel portionLabel;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
    
    public javax.swing.JTextField getDrinkField(){
        return this.drinkField;
    }
    
    public void setDrinkField(javax.swing.JTextField drinkField){
        this.drinkField = drinkField;
    }
    
    public javax.swing.JComboBox getComboBox(){
        return this.comboBox;
    }
    
    public javax.swing.JButton getSubmitButton(){
        return this.submitButton;
    }
    
    public void setSubmitButton(javax.swing.JButton submitButton){
        this.submitButton = submitButton;
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
}
