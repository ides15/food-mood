/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mood;
import app.EntryCntl;
import app.NavCntl;
import app.NavView;
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
    
    private final NavCntl navCntl;
    private final NavView navView;

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
        
        navView = new NavView();
        navCntl = new NavCntl(getNavView());

        moodView.setVisible(true);

        moodView.addBtnListener(new MoodCntl.addBtnListener());
        moodView.editBtnListener(new MoodCntl.editBtnListener());
        moodView.deleteBtnListener(new MoodCntl.deleteBtnListener());
        moodView.backBtnListener(new MoodCntl.backBtnListener());
        moodView.addSubmitButtonListener(new MoodCntl.submitButtonListener());
        moodView.addUpdateButtonListener(new MoodCntl.updateButtonListener());
        moodView.addCancelButtonListener(new MoodCntl.cancelButtonListener());
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
//            moodView.getMoodViewPanel().setVisible(false);
//            moodView.add(moodView.getAddMoodPanel());
//            moodView.getAddMoodPanel().setVisible(true);
//            moodView.remove(moodView.getMoodViewPanel());
            Mood_Table mood_db = new Mood_Table("foodmood.db");
            AddMoodView addMoodView = new AddMoodView(mood_db);
            AddMoodCntl addMoodCntl = new AddMoodCntl(db, addMoodView);
        }
    }

    public class editBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            moodView.getMoodViewPanel().setVisible(false);
//            moodView.add(moodView.getEditMoodPanel());
//            moodView.getEditMoodPanel().setVisible(true);
//            moodView.remove(moodView.getMoodViewPanel());
            Mood_Table mood_db = new Mood_Table("foodmood.db");
            EditMoodView editMoodView = new EditMoodView(mood_db);
            EditMoodCntl editMoodCntl = new EditMoodCntl(db, editMoodView);
        }
    }

    public class deleteBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String selection;
            System.out.println("Food deleted");
            
            selection = moodView.getMoodViewPanel().getMoodListView().getSelectedValue().toString();
            mood.setName(selection);
            
            db.deleteEntry(mood, navCntl.getAccountID());
        }
    }
    
     public class cancelButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moodView.getAddMoodPanel().setVisible(false);
            moodView.getEditMoodPanel().setVisible(false);
            moodView.add(moodView.getMoodViewPanel());
            moodView.getMoodViewPanel().setVisible(true);
            moodView.remove(moodView.getAddMoodPanel());
            moodView.remove(moodView.getEditMoodPanel());
        }
    }
    
    public class submitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moodView.getAddMoodPanel().setVisible(false);
            moodView.add(moodView.getMoodViewPanel());
            moodView.getMoodViewPanel().setVisible(true);
            moodView.remove(moodView.getAddMoodPanel());
        }
    }
    
    public class updateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moodView.getEditMoodPanel().setVisible(false);
            moodView.add(moodView.getMoodViewPanel());
            moodView.getMoodViewPanel().setVisible(true);
            moodView.remove(moodView.getEditMoodPanel());
        }
    }

    public class backBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moodView.dispose();
        }
    }

    public MoodCntl getMoodCntl() {
        return moodCntl;
    }

    public Mood_Table getDb() {
        return db;
    }
    
    public NavView getNavView() {
        return navView;
    }
    
    public Mood getMood() {
        return mood;
    }
    
    public void setMood(Mood mood) {
        this.mood = mood; 
    }
}
