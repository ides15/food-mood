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
import java.text.SimpleDateFormat;
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

        moodView.addBtnListener(new MoodCntl.AddBtnListener());
        moodView.editBtnListener(new MoodCntl.EditBtnListener());
        moodView.deleteBtnListener(new MoodCntl.DeleteBtnListener());
        moodView.backBtnListener(new MoodCntl.BackBtnListener());
        moodView.addSubmitButtonListener(new MoodCntl.SubmitButtonListener());
        moodView.addUpdateButtonListener(new MoodCntl.UpdateButtonListener());
        moodView.addCancelButtonListener(new MoodCntl.CancelButtonListener());
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

    public class AddBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moodView.getMoodViewPanel().setVisible(false);
            moodView.add(moodView.getAddMoodPanel());
            moodView.getAddMoodPanel().setVisible(true);
            moodView.remove(moodView.getMoodViewPanel());
            Mood_Table mood_db = new Mood_Table("foodmood.db");

        }
    }

    public class EditBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (getMoodView().getMoodViewPanel().getMoodTable().getSelectedRow() != -1) {
                getMoodView().add(getMoodView().getEditMoodPanel());
                getMoodView().getMoodViewPanel().setVisible(false);
                getMoodView().getEditMoodPanel().setVisible(true);
                getMoodView().addUpdateButtonListener(new UpdateButtonListener());

                int selectedRow = getMoodView().getMoodViewPanel().getMoodTable().getSelectedRow();
                String selectedMoodName = getMoodView().getMoodViewPanel().getMoodTable().getValueAt(selectedRow, 0).toString();
                getMoodView().getEditMoodPanel().getUpdateNameTextField().setText(selectedMoodName);

                int selectedMoodID = Integer.parseInt(getMoodView().getMoodViewPanel().getMoodTable().getValueAt(selectedRow, 1).toString());
                String portion = db.getPortionSize(selectedMoodID, getAccountID());

                int index = 9;
                if (portion.equals("1")) {
                    index = 0;
                } else if (portion.equals("2")) {
                    index = 1;
                } else if (portion.equals("3")) {
                    index = 2;
                } else if (portion.equals("4")) {
                    index = 3;
                } else if (portion.equals("5")) {
                    index = 4;
                } else if (portion.equals("6")) {
                    index = 5;
                } else if (portion.equals("7")) {
                    index = 6;
                } else if (portion.equals("8")) {
                    index = 7;
                } else if (portion.equals("9")) {
                    index = 8;
                }

                getMoodView().getEditMoodPanel().getUpdateComboBox().setSelectedIndex(index);
            }
        }
    }

    public class DeleteBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (moodView.getMoodViewPanel().getMoodTable().getSelectedRow() != -1) {
                int selectedRow = getMoodView().getMoodViewPanel().getMoodTable().getSelectedRow();
                int selectedMoodID = Integer.parseInt(getMoodView().getMoodViewPanel().getMoodTable().getValueAt(selectedRow, 1).toString());

                db.deleteEntry(selectedMoodID, getAccountID());
                moodView.getMoodViewPanel().initMoodsData();
            }
        }
    }

    public class CancelButtonListener implements ActionListener {

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

    public class SubmitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moodView.getAddMoodPanel().setVisible(false);

            String name = getMoodView().getAddMoodPanel().getMoodField().getText();
            ListModel amountModel = getMoodView().getAddMoodPanel().getComboBox().getModel();
            String amount = amountModel.getElementAt(getMoodView().getAddMoodPanel().getComboBox().getSelectedIndex()).toString();

            SimpleDateFormat dt = new SimpleDateFormat("MM-dd-yy");
            Mood newMood = new Mood(name, amount, dt.format(new Date()), 1);

            db.addNewMood(newMood, accountID);

            moodView.getMoodViewPanel().initMoodsData();

            moodView.add(moodView.getMoodViewPanel());
            moodView.getMoodViewPanel().setVisible(true);
            moodView.remove(moodView.getAddMoodPanel());
        }
    }

    public class UpdateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = getMoodView().getMoodViewPanel().getMoodTable().getSelectedRow();
            int selectedMoodID = Integer.parseInt(getMoodView().getMoodViewPanel().getMoodTable().getValueAt(selectedRow, 1).toString());

            String updatedName = getMoodView().getEditMoodPanel().getUpdateNameTextField().getText();
            String updatedPortion = getMoodView().getEditMoodPanel().getUpdateComboBox().getSelectedItem().toString();

            db.updateEntry(updatedName, updatedPortion, selectedMoodID);

            moodView.getEditMoodPanel().setVisible(false);
            moodView.add(moodView.getMoodViewPanel());
            moodView.getMoodViewPanel().setVisible(true);
            moodView.remove(moodView.getEditMoodPanel());

            moodView.getMoodViewPanel().initMoodsData();
        }
    }

    public class BackBtnListener implements ActionListener {

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
