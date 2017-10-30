package mood;

import app.EntryCntl;
import database.Mood_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Mood;

/*
 * @author BasicPanda
 */
public class AddMoodCntl extends EntryCntl {

    private Mood mood;
    private final Mood_Table db;
    private final AddMoodView addMoodView;

    public AddMoodCntl(Mood_Table db, AddMoodView addMoodView) {
        this.db = db;
        this.addMoodView = addMoodView;

        mood = new Mood();

        addMoodView.setVisible(true);

        addMoodView.submitBtnListener(new AddMoodCntl.submitBtnListener());
        addMoodView.backBtnListener(new AddMoodCntl.backBtnListener());
    }

    /**
     * @return the moodView
     */
    public AddMoodView getMoodView() {
        return addMoodView;
    }

    public class submitBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Mood Submitted");
            addMoodView.dispose();
        }
    }

    public class backBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Canceled Submission");
            addMoodView.dispose();
        }
    }

    public Mood_Table getDb() {
        return db;
    }
}
