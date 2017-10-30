package mood;

import database.Mood_Table;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import models.Mood;

/*
 * @author BasicPanda
 */
public class EditMoodView extends JFrame {

    private Mood mood;
    private final Mood_Table db;
    private EditMoodPanel editMoodPanel;
    private MoodViewPanel moodViewPanel;

    public EditMoodView(Mood_Table db) {
        super("Mood");
        this.db = db;

        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        editMoodPanel = new EditMoodPanel();
        add(editMoodPanel);
    }

    /**
     * @return the moodViewPanel
     */
    public EditMoodPanel getEditMoodPanel() {
        return editMoodPanel;
    }

    public void setEditMoodPanel(MoodViewPanel moodViewPanel) {
        this.editMoodPanel = editMoodPanel;
    }

    public MoodViewPanel getMoodViewPanel() {
        return moodViewPanel;
    }
//Check

    public void setMoodViewPanel(MoodViewPanel moodViewPanel) {
        this.moodViewPanel = moodViewPanel;
    }

    public void submitBtnListener(ActionListener al) {
        getEditMoodPanel().geteMoodUpdBtn().addActionListener(al);
    }

    public void backBtnListener(ActionListener al) {
        getEditMoodPanel().geteMoodCnlBtn().addActionListener(al);
    }
}
