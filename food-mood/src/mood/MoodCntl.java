/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mood;

import app.EntryCntl;
import app.NavCntl;
import database.Mood_Table;
import database.User_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Mood;
import models.User;

/**
 *
 * @author John
 */
public class MoodCntl extends EntryCntl {

    private Mood mood;
    private final Mood_Table db;
    private final MoodView moodView;

    /**
     * Default constructor for MoodCntl.
     *
     * @param db Mood model for MVC architecture.
     * @param moodView MoodView for MVC architecture.
     */
    public MoodCntl(Mood_Table db, MoodView moodView) {
        this.db = db;
        this.moodView = moodView;

        mood = new Mood();

        moodView.setVisible(true);

        moodView.addBtnListener(new MoodCntl.addBtnListener());
        moodView.editBtnListener(new MoodCntl.editBtnListener());
        moodView.deleteBtnListener(new MoodCntl.deleteBtnListener());
        moodView.backBtnListener(new MoodCntl.backBtnListener());
    }

    /**
     * @return the moodView
     */
    public MoodView getMoodView() {
        return moodView;
    }

    private MoodCntl moodCntl;

    public class addBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moodView.getMoodViewPanel().setVisible(false);
            moodView.add(moodView.getAddMoodPanel());
            moodView.getAddMoodPanel().setVisible(true);
            moodView.remove(moodView.getMoodViewPanel());
        }
    }

    public class editBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moodView.getMoodViewPanel().setVisible(false);
            moodView.add(moodView.getEditMoodPanel());
            moodView.getEditMoodPanel().setVisible(true);
            moodView.remove(moodView.getMoodViewPanel());
        }
    }

    public class deleteBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class backBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moodView.dispose();
        }
    }

    /**
     * @return the moodCntl
     */
    public MoodCntl getMoodCntl() {
        return moodCntl;
    }

    /**
     * @return the db
     */
    public Mood_Table getDb() {
        return db;
    }
}
