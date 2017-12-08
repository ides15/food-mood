package recommendations;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import mood.MoodViewPanel;
/*
 * @author BasicPanda
 */
public class RecView extends JFrame{
    
    private RecModel rec;
    private RecViewPanel recPanel;
    private int accountID;
    
    /**
     * Default constructor for rec view
     * @param rec accepts Rec model as parameter
     */
    public RecView(int accountID) {
        super("Recommendations"); 
        
        this.accountID = accountID;

        setSize(450, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        recPanel = new RecViewPanel(accountID);
        add(recPanel);
    }

    /**
     * @return the rec
     */
    public RecModel getRec() {
        System.out.println("getRec called.");
        return rec;
    }

    /**
     * @param rec the rec to set
     */
    public void setRec(RecModel rec) {
        System.out.println("setRec called.");
        this.rec = rec;
    }
}