package DesignSelection;

import database.Drink_Table;
import database.Food_Table;
import database.Mood_Table;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import models.Drink;
import models.Food;
import models.Mood;

/*
 * @author BasicPanda
 */
public class FoodMoodEntryFormView extends JFrame {

    private Food food;
    private Drink drink;
    private Mood mood;
    private FoodMoodEntryForm foodMoodEntryForm;

    public FoodMoodEntryFormView() {

        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        foodMoodEntryForm = new FoodMoodEntryForm();
        add(foodMoodEntryForm);
    }

    public FoodMoodEntryForm getFoodMoodEntryForm() {
        return foodMoodEntryForm;
    }

    public void setFoodMoodEntryForm(FoodMoodEntryForm foodMoodEntryForm) {
        this.foodMoodEntryForm = foodMoodEntryForm;
    }

    public void toDrinkBtnListener(ActionListener al) {
        getFoodMoodEntryForm().getToDrinkBtn().addActionListener(al);
    }

    public void toMoodBtnListener(ActionListener al) {
        getFoodMoodEntryForm().getToMoodBtn().addActionListener(al);
    }

    public void submitBtnListener(ActionListener al) {
        getFoodMoodEntryForm().getSubmitBtn().addActionListener(al);
    }
}
