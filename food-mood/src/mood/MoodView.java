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

    public MoodView(Mood_Table db) {
        super("Mood");
        this.db = db;

        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        moodViewPanel = new MoodViewPanel();
        editMoodPanel = new EditMoodPanel();
        addMoodPanel = new AddMoodPanel();
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

    public void setEditFoodPanel(EditMoodPanel editMoodPanel) {
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
    
    public void backBtnListener(ActionListener al){
        getMoodViewPanel().getBackButton().addActionListener(al);
    }

    //Add
    public void addSubmitButtonListener(ActionListener al) {
        getAddMoodPanel().getaMoodUpdBtn().addActionListener(al);
    }

    //Edit
    public void addUpdateButtonListener(ActionListener al) {
        getEditMoodPanel().geteMoodUpdBtn().addActionListener(al);
    }

    //Back
    public void addCancelButtonListener(ActionListener al) {
        getAddMoodPanel().getaMoodCnlBtn().addActionListener(al);
        getEditMoodPanel().geteMoodCnlBtn().addActionListener(al);
    }
}
