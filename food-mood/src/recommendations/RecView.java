package recommendations;

import database.Drink_Table;
import database.Food_Table;
import database.Mood_Table;
import java.awt.event.ActionListener;
import javafx.beans.value.ChangeListener;
import javax.swing.JFrame;
import models.Drink;
import models.Food;
import models.Mood;

public class RecView extends JFrame {

    private Food food;
    private Drink drink;
    private Mood mood;
    private final Food_Table db_food;
    private final Drink_Table db_drink;
    private final Mood_Table db_mood;
    private int accountID;

    private final RecPanel recPanel;

    public RecView(int accountID, Food_Table db_food, Drink_Table db_drink, Mood_Table db_mood) {
        super("Recommendation");
        this.db_food = db_food;
        this.db_drink = db_drink;
        this.db_mood = db_mood;

        this.accountID = accountID;

        setSize(600, 420);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        recPanel = new RecPanel(accountID);
        add(recPanel);
    }

    public void addFoodBtnActionListener(ActionListener al) {
        recPanel.getFoodBtn().addActionListener(al);
    }

    public void addDrinkBtnActionListener(ActionListener al) {
        recPanel.getDrinkBtn().addActionListener(al);
    }

    public void addBothBtnActionListener(ActionListener al) {
        recPanel.getBothBtn().addActionListener(al);
    }

    public void addMoodOnBtnActionListener(ActionListener al) {
        recPanel.getMoodOnBtn().addActionListener(al);
    }

    public void addMoodOffBtnActionListener(ActionListener al) {
        recPanel.getMoodOffBtn().addActionListener(al);
    }

    public void addTimeBtnActionListener(ActionListener al) {
        recPanel.getTimeBtn().addActionListener(al);
    }

    public RecPanel getRecPanel() {
        return recPanel;
    }

    public void addBackBtnActionListener(ActionListener al) {
        recPanel.getBkBtn().addActionListener(al);
    }
}
