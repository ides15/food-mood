package DesignSelection;

import app.EntryCntl;
import app.NavCntl;
import app.NavView;
import database.Food_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Drink;
import models.Food;
import models.Mood;

/*
 * @author BasicPanda
 */
public class FoodMoodEntryFormCntl extends EntryCntl {

    private Food food;
    private Drink drink;
    private Mood mood;

    private final FoodMoodEntryFormView foodMoodView;

    private final NavCntl navCntl;
    private final NavView navView;

    public FoodMoodEntryFormCntl(FoodMoodEntryFormView foodMoodView) {
        this.foodMoodView = foodMoodView;

        navView = new NavView();
        navCntl = new NavCntl(getNavView());

        foodMoodView.setVisible(true);

        foodMoodView.toDrinkBtnListener(new ToDrinkBtnListener());
        foodMoodView.toMoodBtnListener(new ToMoodBtnListener());
        foodMoodView.submitBtnListener(new SubmitBtnListener());
    }

    class ToDrinkBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("Drink Screen");

        }
    }

    class ToMoodBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("Mood Screen");

        }
    }

    class SubmitBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("Submit");

        }
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood Mood) {
        this.mood = mood;
    }

    public FoodMoodEntryFormView getFoodMoodEntryFormView() {
        return foodMoodView;
    }

    public NavView getNavView() {
        return navView;
    }
}
