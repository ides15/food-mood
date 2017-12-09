/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mood;

import app.NavViewPanel;
import database.Mood_Table;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import models.Mood;

/**
 *
 * @author John
 */
public class MoodView extends JFrame {

    private Mood mood;
    private final Mood_Table db;
    private MoodViewPanel moodViewPanel;
    private AddMoodPanel addMoodPanel;
    private EditMoodPanel editMoodPanel;
    private int accountID;

    public MoodView(int accountID, Mood_Table db) {
        super("Mood");
        this.accountID = accountID;
        this.db = db;

        setSize(450, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        moodViewPanel = new MoodViewPanel(accountID);
        editMoodPanel = new EditMoodPanel(accountID);
        addMoodPanel = new AddMoodPanel(accountID);
        add(moodViewPanel);
    }

    /**
     * @return the moodViewPanel
     */
    public MoodViewPanel getMoodViewPanel() {
        return moodViewPanel;
    }

    public void setMoodViewPanel(MoodViewPanel moodViewPanel) {
        this.moodViewPanel = moodViewPanel;
    }

    public AddMoodPanel getAddMoodPanel() {
        return this.addMoodPanel;
    }

    public void setAddMoodPanel(AddMoodPanel addMoodPanel) {
        this.addMoodPanel = addMoodPanel;
    }

    public EditMoodPanel getEditMoodPanel() {
        return this.editMoodPanel;
    }

    public void setEditMoodPanel(EditMoodPanel editMoodPanel) {
        this.editMoodPanel = editMoodPanel;
    }

    public void addBtnListener(ActionListener al) {
        getMoodViewPanel().getAddButton().addActionListener(al);
    }

    public void editBtnListener(ActionListener al) {
        getMoodViewPanel().getEditButton().addActionListener(al);
    }

    public void deleteBtnListener(ActionListener al) {
        getMoodViewPanel().getDeleteButton().addActionListener(al);
    }

    public void backBtnListener(ActionListener al) {
        getMoodViewPanel().getBackButton().addActionListener(al);
    }

    //Add
    public void addSubmitButtonListener(ActionListener al) {
        getAddMoodPanel().getSubmitButton().addActionListener(al);
    }

    //Edit
    public void addUpdateButtonListener(ActionListener al) {
        getEditMoodPanel().getUpdateButton().addActionListener(al);
    }

    //Back
    public void addCancelButtonListener(ActionListener al) {
        //getAddMoodPanel().getCancelButton().addActionListener(al);
        //getEditMoodPanel().getCancelButton().addActionListener(al);
    }
}
