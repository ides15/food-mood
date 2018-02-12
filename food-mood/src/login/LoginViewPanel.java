// John Ide - normal login page
package login;

import database.User_Table;

/**
 *
 * @author John
 */
public class LoginViewPanel extends javax.swing.JPanel {

    private User_Table db;

    private String username;
    private String password;

    /**
     * Creates new form UserLoginPanel
     */
    public LoginViewPanel() {
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

        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        newUserButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        tryAgainBooBooLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();

        usernameLabel.setText("Username:");

        passwordLabel.setText("Password:");

        newUserButton.setText("New User");

        loginButton.setText("Login");

        tryAgainBooBooLabel.setForeground(new java.awt.Color(200, 0, 0));
        tryAgainBooBooLabel.setText("Username / password incorrect");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tryAgainBooBooLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(newUserButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                            .addComponent(loginButton))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(usernameLabel)
                                .addComponent(passwordLabel))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(usernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                .addComponent(passwordTextField)))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newUserButton)
                    .addComponent(loginButton))
                .addGap(18, 18, 18)
                .addComponent(tryAgainBooBooLabel)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loginButton;
    private javax.swing.JButton newUserButton;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel tryAgainBooBooLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the loginButton
     */
    public javax.swing.JButton getLoginButton() {
        return loginButton;
    }

    /**
     * @return the newUserButton
     */
    public javax.swing.JButton getNewUserButton() {
        return newUserButton;
    }

    /**
     * @return the passwordTextField
     */
    public javax.swing.JTextField getPasswordTextField() {
        return passwordTextField;
    }

    /**
     * @param passwordTextField the passwordTextField to set
     */
    public void setPasswordTextField(javax.swing.JPasswordField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    /**
     * @return the usernameTextField
     */
    public javax.swing.JTextField getUsernameTextField() {
        return usernameTextField;
    }

    /**
     * @param usernameTextField the usernameTextField to set
     */
    public void setUsernameTextField(javax.swing.JTextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    /**
     * @return the tryAgainBooBooLabel
     */
    public javax.swing.JLabel getTryAgainBooBooLabel() {
        return tryAgainBooBooLabel;
    }
}
