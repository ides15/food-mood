package app;

/**
 *
 * @author john
 */
public class NewEntriesViewPanel extends javax.swing.JPanel {
    /**
     * Creates new form NewEntriesViewPanel
     */
    public NewEntriesViewPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newFoodButton = new javax.swing.JButton();
        newMoodButton = new javax.swing.JButton();
        pickANewEntryLabel = new javax.swing.JLabel();
        newDrinkButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 600));

        newFoodButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newFoodButton.setText("New Food");

        newMoodButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newMoodButton.setText("New Mood");

        pickANewEntryLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        pickANewEntryLabel.setText("Pick an new entry:");
        pickANewEntryLabel.setToolTipText("");
        pickANewEntryLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pickANewEntryLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        newDrinkButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newDrinkButton.setText("New Drink");

        backButton.setText("< Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(newDrinkButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pickANewEntryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newFoodButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newMoodButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(197, 197, 197))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pickANewEntryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton))
                .addGap(31, 31, 31)
                .addComponent(newFoodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newDrinkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newMoodButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(329, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton newDrinkButton;
    private javax.swing.JButton newFoodButton;
    private javax.swing.JButton newMoodButton;
    private javax.swing.JLabel pickANewEntryLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the newDrinkButton
     */
    public javax.swing.JButton getNewDrinkButton() {
        return newDrinkButton;
    }

    /**
     * @return the newFoodButton
     */
    public javax.swing.JButton getNewFoodButton() {
        return newFoodButton;
    }

    /**
     * @return the newMoodButton
     */
    public javax.swing.JButton getNewMoodButton() {
        return newMoodButton;
    }
    
    /**
     * @return the backButton
     */
    public javax.swing.JButton getBackButton() {
        return backButton;
    }
}