package recommendations;

import database.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import models.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import parents.Entry;


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

        recView.setVisible(true);

        getRecView().addFoodBtnActionListener(new FoodBtnListener());
        getRecView().addDrinkBtnActionListener(new DrinkBtnListener());
        getRecView().addBothBtnActionListener(new BothBtnListener());
        getRecView().addMoodOnBtnActionListener(new MoodOnBtnListener());
        getRecView().addMoodOffBtnActionListener(new MoodOffBtnListener());
        getRecView().addTimeBtnActionListener(new TimeBtnListener());
        getRecView().addBackBtnActionListener(new RecCntl.BackBtnListener());
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
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            ArrayList<Food> foodArr = db_food.getAllEntries(accountID);
            ArrayList<String> foodName = new ArrayList<>();
            ArrayList<String> foodPortion = new ArrayList<>();
            ArrayList<String> foodDate = new ArrayList<>();
            ArrayList<Integer> foodCount = new ArrayList<>();

            ArrayList<String> uniqueFood = new ArrayList<>();

            List<List<String>> foodItemList = new ArrayList<>();
            //FoodName, FoodPortion, FoodDate are related
            //FoodCount has a direct relation with UniqueFood

            int foodIndex = 0;
            System.out.println("FOOD BUTTON PRESSED");
            System.out.println("FoodArrSize= " + foodArr.size());
            for (Food a : foodArr) {
                foodName.add(a.getName());
                foodPortion.add(a.getPortion());
                foodDate.add(a.getDate());
                System.out.println("Food : " + foodName.size() + " - " + foodName.get(foodName.size() - 1) + " " + foodPortion.get(foodName.size() - 1) + " " + foodDate.get(foodName.size() - 1));
            }

            for (String a : foodName) {
                foodIndex = checkArr(a, uniqueFood);
                System.out.println("INDEX OF " + a + " = " + foodIndex);
                if (foodIndex < 0) {
                    uniqueFood.add(a);
                    foodCount.add(1);
                    System.out.println("Food to add: " + a);
                    System.out.println("Indexed at : " + uniqueFood.indexOf(a) + " with value " + foodCount.get(uniqueFood.indexOf(a)));
                } else {
                    System.out.println(foodIndex + " - " + foodCount.get(foodIndex) + 1);
                    foodCount.set(foodIndex, (foodCount.get(foodIndex) + 1));
                }
            }

            for (int b : foodCount) {
                System.out.println(uniqueFood.get(foodCount.indexOf(b)));
                data.setValue(b, "Food", uniqueFood.get(foodCount.indexOf(b)));
            }

            JFreeChart jchart = ChartFactory.createBarChart("Food History", "Food Name", "Food Quantity", data, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot = jchart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.BLACK);
            ChartFrame chartFrm = new ChartFrame("Food History", jchart, true);
            chartFrm.setVisible(true);
            chartFrm.setSize(500, 400);
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
            ArrayList<Entry> entryArr;
            db_mood.getMoodList(accountID);
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

    public int checkArr(String foodName, ArrayList<String> foodNameList) {
        int b = -1;

        for (String a : foodNameList) {
            if (foodName.equals(a)) {
                b = foodNameList.indexOf(a);
                break;
            }
        }
        return b;
    }
}
