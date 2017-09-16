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
    /**
     * Default constructor for MoodCntl.
     * @param mood Mood model for MVC architecture.
     * @param moodView MoodView for MVC architecture.
     */
    public MoodCntl(Mood mood, MoodView moodView) {
        System.out.println("Mood Controller constructor");
    }
}
