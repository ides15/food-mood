package mood;

import database.Mood_Table;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import models.Mood;
import app.NavViewPanel;
import database.Mood_Table;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import models.Mood;

public class AddMoodView extends JFrame {

    private Mood mood;
    private final Mood_Table db;
    private AddMoodPanel addMoodPanel;
    private MoodViewPanel moodViewPanel;

    public AddMoodView(Mood_Table db) {
        super("Mood");
        this.db = db;

        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addMoodPanel = new AddMoodPanel();
        add(addMoodPanel);
    }

    /**
     * @return the moodViewPanel
     */
    public AddMoodPanel getAddMoodPanel() {
        return addMoodPanel;
    }

    public void setAddMoodPanel(MoodViewPanel moodViewPanel) {
        this.addMoodPanel = addMoodPanel;
    }
    
    public MoodViewPanel getMoodViewPanel() {
        return moodViewPanel;
    }
//Check
    public void setMoodViewPanel(MoodViewPanel moodViewPanel) {
        this.moodViewPanel = moodViewPanel;
    }

    public void submitButtonListener(ActionListener al) {
        getAddMoodPanel().getSubmitButton().addActionListener(al);
    }

    
    public void cancelButtonListener(ActionListener al){
        getAddMoodPanel().getCancelButton().addActionListener(al);
    }
}
