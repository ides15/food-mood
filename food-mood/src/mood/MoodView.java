/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mood;

import database.Mood_Table;
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
    }

    /**
     * @return the moodViewPanel
     */
    public MoodViewPanel getMoodViewPanel() {
        return moodViewPanel;
    }
}
