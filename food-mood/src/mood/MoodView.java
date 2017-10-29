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
    private final MoodViewPanel moodViewPanel;
    private final AddMoodPanel addMoodPanel;
    private final EditMoodPanel editMoodPanel;
    
    /**
     * Default constructor for MoodView.
     * @param db Mood model for MVC architecture.
     */
    public MoodView(Mood_Table db) {
        super("Mood");
        this.db = db;
        
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        moodViewPanel = new MoodViewPanel();
        add(moodViewPanel);
        
        addMoodPanel = new AddMoodPanel();
        add(addMoodPanel);
        
        editMoodPanel = new EditMoodPanel();
        add(editMoodPanel);
    }

    /**
     * @return the moodViewPanel
     */
    public MoodViewPanel getMoodViewPanel() {
        return moodViewPanel;
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
    
    void backBtnListener(MoodCntl.backBtnListener backBtnListener) {

    }
}
