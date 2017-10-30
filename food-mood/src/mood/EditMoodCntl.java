package mood;

import database.Mood_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Mood;

/*
 * @author BasicPanda
 */
public class EditMoodCntl {

    private Mood mood;
    private final Mood_Table db;
    private final EditMoodView editMoodView;

    public EditMoodCntl(Mood_Table db, EditMoodView editMoodView) {
        this.db = db;
        this.editMoodView = editMoodView;

        mood = new Mood();

        editMoodView.setVisible(true);

        editMoodView.submitBtnListener(new EditMoodCntl.submitBtnListener());
        editMoodView.backBtnListener(new EditMoodCntl.backBtnListener());
    }

    /**
     * @return the moodView
     */
    public EditMoodView getMoodView() {
        return editMoodView;
    }

    public class submitBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Mood Submitted");
            editMoodView.dispose();
        }
    }

    public class backBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Canceled Submission");
            editMoodView.dispose();
        }
    }

    public Mood_Table getDb() {
        return db;
    }
}
