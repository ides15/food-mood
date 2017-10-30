// John Ide - the main navigation frame, containing the main page and the new entries page

package app;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author John
 */
public class NavView extends JFrame {
    private final NavViewPanel navViewPanel;
    private final NewEntriesViewPanel newEntriesViewPanel;
    
    /**
     * Default constructor for MainView.
     */
    public NavView() {
        super("NavView");
        
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        newEntriesViewPanel = new NewEntriesViewPanel();
        navViewPanel = new NavViewPanel();
        
        add(navViewPanel);
    }
    
    public void addAddEntriesListener(ActionListener al) {
        getNavViewPanel().getAddEntriesButton().addActionListener(al);
    }
    
    public void addViewRecsListener(ActionListener al) {
        getNavViewPanel().getViewRecsButton().addActionListener(al);
    }
    
    public void addViewEntriesListener(ActionListener al) {
        getNavViewPanel().getViewEntriesButton().addActionListener(al);
    }
    
    public void addViewProfileListener(ActionListener al) {
        getNavViewPanel().getViewProfileButton().addActionListener(al);
    }
    
    public void addLogoutListener(ActionListener al) {
        getNavViewPanel().getLogoutButton().addActionListener(al);
    }
    
    public void addNewFoodListener(ActionListener al) {
        getNewEntriesViewPanel().getNewFoodButton().addActionListener(al);
    }
    
    public void addNewDrinkListener(ActionListener al) {
        getNewEntriesViewPanel().getNewDrinkButton().addActionListener(al);
    }
    
    public void addNewMoodListener(ActionListener al) {
        getNewEntriesViewPanel().getNewMoodButton().addActionListener(al);
    }
    
    public void addBackListener(ActionListener al) {
        getNewEntriesViewPanel().getBackButton().addActionListener(al);
    }

    /**
     * @return the navViewPanel
     */
    public NavViewPanel getNavViewPanel() {
        return navViewPanel;
    }

    /**
     * @return the newEntriesViewPanel
     */
    public NewEntriesViewPanel getNewEntriesViewPanel() {
        return newEntriesViewPanel;
    }
}
