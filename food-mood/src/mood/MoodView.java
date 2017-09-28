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
        System.out.println("MoodView constructor called.");
        
        this.mood = mood;
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
}
