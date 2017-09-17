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
public class MoodView {
    private Mood mood;
    
    /**
     * Default constructor for MoodView.
     * @param mood Mood model for MVC architecture.
     */
    public MoodView(Mood mood) {
        System.out.println("Mood View constructor");
        
        this.mood = mood;
    }

    /**
     * @return the mood
     */
    public Mood getMood() {
        return mood;
    }

    /**
     * @param mood the mood to set
     */
    public void setMood(Mood mood) {
        this.mood = mood;
    }
}
