package mood;

import database.Mood_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JList;
import models.Mood;

/*
 * @author BasicPanda
 */
public class EditMoodCntl {

    private Mood mood;
    private final Mood_Table db;
    private final EditMoodView editMoodView;
    public String moodInput;
    public int moodSlider;

    public EditMoodCntl(Mood_Table db, EditMoodView editMoodView) {
        this.db = db;
        this.editMoodView = editMoodView;

        mood = new Mood();

        editMoodView.setVisible(true);

        editMoodView.updateButtonListener(new EditMoodCntl.submitButtonListener());
        editMoodView.cancelButtonListener(new EditMoodCntl.cancelButtonListener());
    }

    public EditMoodView getMoodView() {
        return editMoodView;
    }

    public class submitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Mood Submitted");
            moodInput = editMoodView.getEditMoodPanel().getMField().getText();
            System.out.println("Mood: " + moodInput);
            moodSlider = editMoodView.getEditMoodPanel().getMSlider().getValue();
            moodSlider /= 10;
            System.out.println("Mood Scale: " + moodSlider);

            Mood mood = new Mood();
            mood.setName(moodInput);
            mood.setAmount(moodSlider);

            db.addNewMood(mood);

            editMoodView.dispose();
        }
    }

    public class cancelButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Canceled Submission");
            editMoodView.dispose();
        }
    }

    public Mood_Table getDb() {
        return db;
    }

    public void updateList(MoodViewPanel moodViewPanel) {
        ArrayList<Mood> temp = new ArrayList<>();
        temp.add(db.getUserMood(103));
        JList moods = new JList(temp.toArray());
        moodViewPanel.setFoodListView(moods);
    }
}
