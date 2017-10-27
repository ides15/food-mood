/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mood;

import database.Mood_Table;
import models.Mood;

/**
 *
 * @author John
 */
public class MoodCntl {
    private Mood mood;
    private final Mood_Table db;
    private final MoodView moodView;
    
    /**
     * Default constructor for MoodCntl.
     * @param db Mood model for MVC architecture.
     * @param moodView MoodView for MVC architecture.
     */
    public MoodCntl(Mood_Table db, MoodView moodView) {        
        this.db = db;
        this.moodView = moodView;
        
        mood = new Mood();
        
        moodView.setVisible(true);
    }

    /**
     * @return the moodView
     */
    public MoodView getMoodView() {
        return moodView;
    }
}
