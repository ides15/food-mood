/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profile;

/**
 *
 * @author John
 */
public class ProfileViewPanel extends javax.swing.JPanel {
    /**
     * Creates new form ProfileViewPanel
     */
    public ProfileViewPanel() {
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

        usersProfileLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        changeableNameLabel = new javax.swing.JLabel();
        changeableEmailLabel = new javax.swing.JLabel();
        changeableUsernameLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        changeablePasswordTextField = new javax.swing.JPasswordField();

        usersProfileLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        usersProfileLabel.setText("User's Profile");
        usersProfileLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nameLabel.setText("Name:");

        emailLabel.setText("Email:");

        usernameLabel.setText("Username:");

        passwordLabel.setText("Password:");

        changeableNameLabel.setText("FirstnameLastname");

        changeableEmailLabel.setText("email@email.com");

        changeableUsernameLabel.setText("UserName");

        backButton.setText("Back");

        saveButton.setText("Save");

        changeablePasswordTextField.setText("existingpass");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(usersProfileLabel)
                .addGap(169, 169, 169))
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordLabel)
                            .addComponent(nameLabel)
                            .addComponent(emailLabel)
                            .addComponent(usernameLabel))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changeableNameLabel)
                            .addComponent(changeableEmailLabel)
                            .addComponent(changeableUsernameLabel)
                            .addComponent(changeablePasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(usersProfileLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(changeableNameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(changeableEmailLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(changeableUsernameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(changeablePasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(saveButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel changeableEmailLabel;
    private javax.swing.JLabel changeableNameLabel;
    private javax.swing.JPasswordField changeablePasswordTextField;
    private javax.swing.JLabel changeableUsernameLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usersProfileLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the backButton
     */
    public javax.swing.JButton getBackButton() {
        return backButton;
    }

    /**
     * @return the changeableEmailLabel
     */
    public javax.swing.JLabel getChangeableEmailLabel() {
        return changeableEmailLabel;
    }

    /**
     * @param changeableEmailLabel the changeableEmailLabel to set
     */
    public void setChangeableEmailLabel(javax.swing.JLabel changeableEmailLabel) {
        this.changeableEmailLabel = changeableEmailLabel;
    }

    /**
     * @return the changeableNameLabel
     */
    public javax.swing.JLabel getChangeableNameLabel() {
        return changeableNameLabel;
    }

    /**
     * @param changeableNameLabel the changeableNameLabel to set
     */
    public void setChangeableNameLabel(javax.swing.JLabel changeableNameLabel) {
        this.changeableNameLabel = changeableNameLabel;
    }

    /**
     * @return the changeablePasswordTextField
     */
    public javax.swing.JPasswordField getChangeablePasswordTextField() {
        return changeablePasswordTextField;
    }

    /**
     * @param changeablePasswordTextField the changeablePasswordTextField to set
     */
    public void setChangeablePasswordTextField(javax.swing.JPasswordField changeablePasswordTextField) {
        this.changeablePasswordTextField = changeablePasswordTextField;
    }

    /**
     * @return the changeableUsernameLabel
     */
    public javax.swing.JLabel getChangeableUsernameLabel() {
        return changeableUsernameLabel;
    }

    /**
     * @param changeableUsernameLabel the changeableUsernameLabel to set
     */
    public void setChangeableUsernameLabel(javax.swing.JLabel changeableUsernameLabel) {
        this.changeableUsernameLabel = changeableUsernameLabel;
    }

    /**
     * @return the saveButton
     */
    public javax.swing.JButton getSaveButton() {
        return saveButton;
    }
}