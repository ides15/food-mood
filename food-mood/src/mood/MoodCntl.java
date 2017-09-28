/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mood;

import models.Mood;

/**
 *
 * @author John
 */
public class MoodCntl {
    private Mood mood;
    private MoodView moodView;
    
    /**
     * Default constructor for MoodCntl.
     * @param mood Mood model for MVC architecture.
     * @param moodView MoodView for MVC architecture.
     */
    public MoodCntl(Mood mood, MoodView moodView) {
        System.out.println("MoodCntl constructor called.");
        
        this.mood = mood;
        this.moodView = moodView;
    }

    /**
     * @return the mood
     */
    public Mood getMood() {
        System.out.println("getMood called.");
        return mood;
    }

    /**
     * @param mood the mood to set
     */
    public void setMood(Mood mood) {
        System.out.println("setMood called.");
        this.mood = mood;
    }

    /**
     * @return the moodView
     */
    public MoodView getMoodView() {
        System.out.println("getMoodView called.");
        return moodView;
    }

    /**
     * @param moodView the moodView to set
     */
    public void setMoodView(MoodView moodView) {
        System.out.println("setMoodView called.");
        this.moodView = moodView;
    }
}
