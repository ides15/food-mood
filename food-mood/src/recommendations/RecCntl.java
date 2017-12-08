package recommendations;

import database.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.*;


/*
 * @author BasicPanda
 */
public class RecCntl {

    private Food food;
    private Drink drink;
    private Mood mood;

    private Food_Table db_food;
    private Drink_Table db_drink;
    private Mood_Table db_mood;

    private RecView recView;

    private int accountID;

    public RecCntl(int accountID, Food_Table db_food, Drink_Table db_drink, Mood_Table db_mood, RecView recView) {
        System.out.println("RecCntl constructor called.");

        this.accountID = accountID;
        this.db_food = db_food;
        this.db_drink = db_drink;
        this.db_mood = db_mood;
        this.recView = recView;

        getRecView().addFoodBtnActionListener(new FoodBtnListener());
        getRecView().addDrinkBtnActionListener(new DrinkBtnListener());
        getRecView().addBothBtnActionListener(new BothBtnListener());
        getRecView().addMoodOnBtnActionListener(new MoodOnBtnListener());
        getRecView().addMoodOffBtnActionListener(new MoodOffBtnListener());
        getRecView().addTimeBtnActionListener(new TimeBtnListener());
        getRecView().addBackBtnActionListener(new RecCntl.BackBtnListener());

        this.recView = recView;
    }

    /**
     * @return the recView
     */
    public RecView getRecView() {
        System.out.println("getRecView called.");
        return recView;
    }

    /**
     * @param recView the recView to set
     */
    public void setRecView(RecView recView) {
        System.out.println("setRecView called.");
        this.recView = recView;
    }

    public class BackBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            recView.dispose();
        }
    }

    class FoodBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time");
        }
    }

    class DrinkBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time");
        }
    }

    class BothBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time");
        }
    }

    class MoodOnBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time");
        }
    }

    class MoodOffBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time");
        }
    }

    class TimeBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time");
        }
    }

}
