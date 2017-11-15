/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mood;
import app.EntryCntl;
import database.Mood_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ListModel;
import models.Mood;
/**
 *
 * @author John
 */
public class MoodCntl extends EntryCntl {
    private Mood mood;
    private final Mood_Table db;
    private final MoodView moodView;
    private int accountID;
    
    private AddMoodPanel addMoodPanel;

    /**
     * Default constructor for MoodCntl.
     *
     * @param db Mood model for MVC architecture.
     * @param moodView MoodView for MVC architecture.
     * @param accountID
     */
    public MoodCntl(int accountID, Mood_Table db, MoodView moodView) {
        this.db = db;
        this.accountID = accountID;
        this.moodView = moodView;


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

    @Override
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public int getAccountID() {
        return this.accountID;
    }

    public class addBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moodView.getMoodViewPanel().setVisible(false);
            moodView.add(moodView.getAddMoodPanel());
            moodView.getAddMoodPanel().setVisible(true);
            moodView.remove(moodView.getMoodViewPanel());
            Mood_Table mood_db = new Mood_Table("foodmood.db");
            
        }
    }

    public class editBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moodView.getMoodViewPanel().setVisible(false);
            moodView.add(moodView.getEditMoodPanel());
            moodView.getEditMoodPanel().setVisible(true);
            moodView.remove(moodView.getMoodViewPanel());
            Mood_Table mood_db = new Mood_Table("foodmood.db");
        }
    }

    public class deleteBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!moodView.getMoodViewPanel().getMoodListView().isSelectionEmpty()) {
                db.deleteEntry(moodView.getMoodViewPanel().getMoodListView().getSelectedValue().toString(), getAccountID());
                moodView.getMoodViewPanel().initMoodsData();
            }
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
            
            String name = getMoodView().getAddMoodPanel().getMoodField().getText();
            ListModel amountModel = getMoodView().getAddMoodPanel().getComboBox().getModel();
            String amount = amountModel.getElementAt(getMoodView().getAddMoodPanel().getComboBox().getSelectedIndex()).toString();
            
            System.out.println("name: " + name);
            System.out.println("amount: " + amount);
            
            Mood newMood = new Mood(name, amount, new Date().toString());
            
            db.addNewMood(newMood, accountID);
            
            moodView.getMoodViewPanel().initMoodsData();
            
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
    
    public Mood getMood() {
        return mood;
    }
    
    public void setMood(Mood mood) {
        this.mood = mood; 
    }
}
