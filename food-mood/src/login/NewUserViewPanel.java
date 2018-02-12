// John Ide - new user page
package login;

/**
 *
 * @author john
 */
public class NewUserViewPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewUserViewPanel
     */
    public NewUserViewPanel() {
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

        newUsernameLabel = new javax.swing.JLabel();
        newPasswordLabel = new javax.swing.JLabel();
        newUsernameTextField = new javax.swing.JTextField();
        newSubmitButton = new javax.swing.JButton();
        newPasswordTextField = new javax.swing.JPasswordField();
        newFirstNameLabel = new javax.swing.JLabel();
        newLastNameLabel = new javax.swing.JLabel();
        newEmailLabel = new javax.swing.JLabel();
        newFirstNameTextField = new javax.swing.JTextField();
        newLastNameTextField = new javax.swing.JTextField();
        newEmailTextField = new javax.swing.JTextField();
        fillOutFieldsLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(500, 500));

        newUsernameLabel.setText("Username:");

        newPasswordLabel.setText("Password:");

        newSubmitButton.setText("Submit");

        newFirstNameLabel.setText("First name:");

        newLastNameLabel.setText("Last name:");

        newEmailLabel.setText("Email:");

        fillOutFieldsLabel.setForeground(new java.awt.Color(255, 0, 0));
        fillOutFieldsLabel.setText("You must fill out all fields.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fillOutFieldsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newSubmitButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newUsernameLabel)
                            .addComponent(newPasswordLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newUsernameTextField)
                            .addComponent(newPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newLastNameLabel)
                            .addComponent(newFirstNameLabel)
                            .addComponent(newEmailLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newFirstNameTextField)
                            .addComponent(newEmailTextField)
                            .addComponent(newLastNameTextField))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newFirstNameLabel)
                    .addComponent(newFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newLastNameLabel)
                    .addComponent(newLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newEmailLabel)
                    .addComponent(newEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newUsernameLabel)
                    .addComponent(newUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPasswordLabel)
                    .addComponent(newPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newSubmitButton)
                    .addComponent(fillOutFieldsLabel))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fillOutFieldsLabel;
    private javax.swing.JLabel newEmailLabel;
    private javax.swing.JTextField newEmailTextField;
    private javax.swing.JLabel newFirstNameLabel;
    private javax.swing.JTextField newFirstNameTextField;
    private javax.swing.JLabel newLastNameLabel;
    private javax.swing.JTextField newLastNameTextField;
    private javax.swing.JLabel newPasswordLabel;
    private javax.swing.JPasswordField newPasswordTextField;
    private javax.swing.JButton newSubmitButton;
    private javax.swing.JLabel newUsernameLabel;
    private javax.swing.JTextField newUsernameTextField;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the newEmailTextField
     */
    public javax.swing.JTextField getNewEmailTextField() {
        return newEmailTextField;
    }

    /**
     * @return the newFirstNameTextField
     */
    public javax.swing.JTextField getNewFirstNameTextField() {
        return newFirstNameTextField;
    }

    /**
     * @return the newLastNameTextField
     */
    public javax.swing.JTextField getNewLastNameTextField() {
        return newLastNameTextField;
    }

    /**
     * @return the newPasswordTextField
     */
    public javax.swing.JPasswordField getNewPasswordTextField() {
        return newPasswordTextField;
    }

    /**
     * @return the newSubmitButton
     */
    public javax.swing.JButton getNewSubmitButton() {
        return newSubmitButton;
    }

    /**
     * @return the newUsernameTextField
     */
    public javax.swing.JTextField getNewUsernameTextField() {
        return newUsernameTextField;
    }

    /**
     * @return the fillOutFieldsLabel
     */
    public javax.swing.JLabel getFillOutFieldsLabel() {
        return fillOutFieldsLabel;
    }
}
