// John Ide - frame for addFoodPanel

package food;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author John
 */
public class AddFoodView extends JFrame {
    private int accountID;
    private final AddFoodPanel addFoodPanel;
    
    public AddFoodView(int accountID) {
        super("Add Food");
        this.accountID = accountID;
        
        setSize(450, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        addFoodPanel = new AddFoodPanel(accountID);
        add(addFoodPanel);
    }
    
    public void addSubmitButtonListener(ActionListener al) {
        getAddFoodPanel().getSubmitButton().addActionListener(al);
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
     * @return the addFoodPanel
     */
    public AddFoodPanel getAddFoodPanel() {
        return addFoodPanel;
    }
}
