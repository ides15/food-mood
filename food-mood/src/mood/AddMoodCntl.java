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
    public  String moodInput;
    public int moodSlider;

    public AddMoodCntl(Mood_Table db, AddMoodView addMoodView) {
        this.db = db;
        this.addMoodView = addMoodView;

        mood = new Mood();

        addMoodView.setVisible(true);

        addMoodView.submitButtonListener(new AddMoodCntl.submitButtonListener());
        addMoodView.cancelButtonListener(new AddMoodCntl.cancelButtonListener());
    }

    public AddMoodView getMoodView() {
        return addMoodView;
    }

    public class submitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Mood Submitted");
            moodInput = addMoodView.getAddMoodPanel().getMField().getText();
            System.out.println("Mood: " + moodInput);
            moodSlider = addMoodView.getAddMoodPanel().getMSlider().getValue();
            moodSlider/=10;
            System.out.println("Mood Scale: " + moodSlider);
            
            Mood mood = new Mood();
            mood.setName(moodInput);
            mood.setAmount(moodSlider);
            
            addMoodView.dispose();
        }
    }

    public class cancelButtonListener implements ActionListener {

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
