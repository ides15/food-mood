package recommendations;

import database.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import models.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


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
//        getRecView().addDrinkBtnActionListener(new DrinkBtnListener());
        getRecView().addBothBtnActionListener(new BothBtnListener());
        getRecView().addMoodOnBtnActionListener(new MoodOnBtnListener());
        getRecView().addMoodOffBtnActionListener(new MoodOffBtnListener());
        getRecView().addTimeBtnActionListener(new TimeBtnListener());
        getRecView().addBackBtnActionListener(new RecCntl.BackBtnListener());
    }

    public RecView getRecView() {
        System.out.println("getRecView called.");
        return recView;
    }

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

            int foodIndex = 0;
            for (Food a : foodArr) {
                foodName.add(a.getName());
                foodPortion.add(a.getPortion());
                foodDate.add(a.getDate());
            }

            for (String a : foodName) {
                foodIndex = checkArr(a, uniqueFood);
                if (foodIndex < 0) {
                    uniqueFood.add(a);
                    foodCount.add(1);
                } else {
                    int tmpCount = foodCount.get(foodIndex) + 1;
                    foodCount.set(foodIndex, tmpCount);
                }
            }

            for (String a : uniqueFood) {
                data.setValue(foodCount.get(uniqueFood.indexOf(a)), "Food", a);
            }

            JFreeChart jchart = ChartFactory.createBarChart("Food History", "Food Name", "Food Quantity", data, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot = jchart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.BLACK);

            ChartPanel chartPanel = new ChartPanel(jchart);
            Dimension panelSize = new Dimension(recView.getRecPanel().getGraph().getPreferredSize());
            chartPanel.setPreferredSize(panelSize);

            recView.getRecPanel().getGraph().removeAll();
            recView.getRecPanel().getGraph().setLayout(new java.awt.BorderLayout());
            recView.getRecPanel().getGraph().validate();
            recView.getRecPanel().getGraph().add(chartPanel, BorderLayout.CENTER);
            recView.getRecPanel().updateUI();
            recView.getRecPanel().getGraph().setVisible(true);
        }
    }

    class DrinkBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class BothBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            ArrayList<Mood> moodArr = db_mood.getAllEntries(accountID);
            ArrayList<String> moodPortion = new ArrayList<>();
            ArrayList<String> moodDate = new ArrayList<>();
            ArrayList<Double> moodCount = new ArrayList<>();
            ArrayList<Double> moodSum = new ArrayList<>();
            ArrayList<Double> moodAvg = new ArrayList<>();
            ArrayList<Food> foodArr = db_food.getAllEntries(accountID);
            ArrayList<String> foodName = new ArrayList<>();
            ArrayList<String> foodPortion = new ArrayList<>();
            ArrayList<String> foodDate = new ArrayList<>();
            ArrayList<Integer> foodCount = new ArrayList<>();
            ArrayList<String> uniqueFood = new ArrayList<>();
            ArrayList<String> uniqueDate = new ArrayList<>();
            int moodIndex = 0;
            for (Mood a : moodArr) {
                moodPortion.add(a.getPortion());
                moodDate.add(a.getDate());
            }
            int moodIndexIn = 0;
            int counter = -1;
            for (String a : moodDate) {
                counter++;
                moodIndex = checkArr(a, uniqueDate);
                if (moodIndex > -1) {
                    moodCount.set(moodIndex, (moodCount.get(moodIndex) + 1));
                    moodSum.set(moodIndex, moodSum.get(moodIndex) + Double.parseDouble(moodPortion.get(counter)));
                } else {
                    uniqueDate.add(a);
                    moodSum.add(Double.parseDouble(moodPortion.get(moodDate.indexOf(a))));
                    moodCount.add(1.0);
                }
            }
            for (String a : uniqueDate) {
                moodIndexIn = uniqueDate.indexOf(a);
                moodAvg.add(moodSum.get(moodIndexIn) / moodCount.get(moodIndexIn));
            }
            int foodIndex = 0;
            ArrayList<Double> foodMood = new ArrayList<>();
            ArrayList<Double> uniqueFoodMood = new ArrayList<>();
            for (Food a : foodArr) {
                foodIndex = foodArr.indexOf(a);
                foodName.add(a.getName());
                foodPortion.add(a.getPortion());
                foodDate.add(a.getDate());
                for (String b : uniqueDate) {
                    moodIndexIn = uniqueDate.indexOf(b);
                    if (b.equals(foodDate.get(foodIndex))) {
                        foodMood.add(moodAvg.get(moodIndexIn));
                    }
                }
            }

            int foodOut = 0;
            for (String a : foodName) {
                foodOut = foodName.indexOf(a);
                foodIndex = checkArr(a, uniqueFood);
                if (foodIndex < 0) {
                    uniqueFood.add(a);
                    foodCount.add(1);

                    //CHECK THIS INDEX
                    uniqueFoodMood.add(foodMood.get(foodOut));
                } else {
                    int tmpCount = foodCount.get(foodIndex) + 1;
                    foodCount.set(foodIndex, tmpCount);

                    uniqueFoodMood.set(foodIndex, uniqueFoodMood.get(foodIndex) + foodMood.get(foodOut));
                }
            }

            ArrayList<Double> FoodMoodAvg = new ArrayList<>();
            for (Double b : uniqueFoodMood) {
                foodIndex = uniqueFoodMood.indexOf(b);

                FoodMoodAvg.add(b / foodCount.get(foodIndex));
            }
            //FoodMoodAvg should have a unique list of sum for uniqe list of food

            for (String a : uniqueFood) {
                foodIndex = uniqueFood.indexOf(a);

                data.setValue(foodCount.get(foodIndex), "Food", a);
                data.setValue(FoodMoodAvg.get(foodIndex), "Mood", a);
            }
            recommendation(uniqueFood, FoodMoodAvg);
            JFreeChart jchart = ChartFactory.createBarChart("FoodMood History", "Food", "Level", data, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot = jchart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.BLACK);
            ChartPanel chartPanel = new ChartPanel(jchart);
            Dimension panelSize = new Dimension(recView.getRecPanel().getGraph().getPreferredSize());
            chartPanel.setPreferredSize(panelSize);
            recView.getRecPanel().getGraph().removeAll();
            recView.getRecPanel().getGraph().setLayout(new java.awt.BorderLayout());
            recView.getRecPanel().getGraph().validate();
            recView.getRecPanel().getGraph().add(chartPanel, BorderLayout.CENTER);
            recView.getRecPanel().updateUI();
            recView.getRecPanel().getGraph().setVisible(true);
        }
    }

    class MoodOnBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            ArrayList<Mood> moodArr = db_mood.getAllEntries(accountID);
            ArrayList<String> moodName = new ArrayList<>();
            ArrayList<String> moodPortion = new ArrayList<>();
            ArrayList<String> moodDate = new ArrayList<>();
            ArrayList<Double> moodCount = new ArrayList<>();
            ArrayList<Double> moodSum = new ArrayList<>();
            ArrayList<Double> moodAvg = new ArrayList<>();
            ArrayList<String> uniqueDate = new ArrayList<>();

            int moodIndex = 0;
            int moodIndexIn = 0;

            for (Mood a : moodArr) {
                moodIndex = moodArr.indexOf(a);
                moodName.add(a.getName());
                moodPortion.add(a.getPortion());
                moodDate.add(a.getDate());
            }
            int counter = -1;
            for (String a : moodDate) {
                counter++;
                moodIndex = checkArr(a, uniqueDate);

                if (moodIndex > -1) {
                    moodCount.set(moodIndex, (moodCount.get(moodIndex) + 1));
                    moodSum.set(moodIndex, moodSum.get(moodIndex) + Double.parseDouble(moodPortion.get(counter)));
                } else {
                    uniqueDate.add(a);
                    moodSum.add(Double.parseDouble(moodPortion.get(moodDate.indexOf(a))));
                    moodCount.add(1.0);
                }
            }

            for (String a : uniqueDate) {
                moodIndexIn = uniqueDate.indexOf(a);
                double tempD = moodSum.get(moodIndexIn) / moodCount.get(moodIndexIn);
                moodAvg.add(tempD);
            }

            for (String a : uniqueDate) {
                moodIndexIn = uniqueDate.indexOf(a);
                data.setValue(moodAvg.get(moodIndexIn), "Mood", a);
            }

            JFreeChart jchart = ChartFactory.createBarChart("Mood History", "Date", "Mood Level", data, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot = jchart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.BLACK);

            ChartPanel chartPanel = new ChartPanel(jchart);
            Dimension panelSize = new Dimension(recView.getRecPanel().getGraph().getPreferredSize());
            chartPanel.setPreferredSize(panelSize);

            recView.getRecPanel().getGraph().removeAll();
            recView.getRecPanel().getGraph().setLayout(new java.awt.BorderLayout());
            recView.getRecPanel().getGraph().validate();
            recView.getRecPanel().getGraph().add(chartPanel, BorderLayout.CENTER);
            recView.getRecPanel().updateUI();
            recView.getRecPanel().getGraph().setVisible(true);
        }
    }

    class MoodOffBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            ArrayList<Food> foodArr = db_food.getAllEntries(accountID);
            ArrayList<String> foodName = new ArrayList<>();
            ArrayList<String> foodPortion = new ArrayList<>();
            ArrayList<String> foodDate = new ArrayList<>();
            ArrayList<Integer> foodCount = new ArrayList<>();
            ArrayList<String> uniqueFood = new ArrayList<>();
            int foodIndex = 0;
            for (Food a : foodArr) {
                foodName.add(a.getName());
                foodPortion.add(a.getPortion());
                foodDate.add(a.getDate());
            }
            for (String a : foodName) {
                foodIndex = checkArr(a, uniqueFood);
                if (foodIndex < 0) {
                    uniqueFood.add(a);
                    foodCount.add(1);
                } else {
                    int tmpCount = foodCount.get(foodIndex) + 1;
                    System.out.println(foodIndex + " - " + tmpCount);
                    foodCount.set(foodIndex, tmpCount);
                }
            }
            for (String a : uniqueFood) {
                data.setValue(foodCount.get(uniqueFood.indexOf(a)), "Food", a);
            }
            JFreeChart jchart = ChartFactory.createBarChart("Food History", "Food Name", "Food Quantity", data, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot = jchart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.BLACK);
            ChartPanel chartPanel = new ChartPanel(jchart);
            Dimension panelSize = new Dimension(recView.getRecPanel().getGraph().getPreferredSize());
            chartPanel.setPreferredSize(panelSize);
            recView.getRecPanel().getGraph().removeAll();
            recView.getRecPanel().getGraph().setLayout(new java.awt.BorderLayout());
            recView.getRecPanel().getGraph().validate();
            recView.getRecPanel().getGraph().add(chartPanel, BorderLayout.CENTER);
            recView.getRecPanel().updateUI();
            recView.getRecPanel().getGraph().setVisible(true);
        }
    }

    class TimeBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            ArrayList<Mood> moodArr = db_mood.getAllEntries(accountID);
            ArrayList<String> moodPortion = new ArrayList<>();
            ArrayList<String> moodDate = new ArrayList<>();
            ArrayList<Double> moodCount = new ArrayList<>();
            ArrayList<Double> moodSum = new ArrayList<>();
            ArrayList<Double> moodAvg = new ArrayList<>();
            ArrayList<Food> foodArr = db_food.getAllEntries(accountID);
            ArrayList<String> foodName = new ArrayList<>();
            ArrayList<String> foodDate = new ArrayList<>();
            ArrayList<Integer> foodCount = new ArrayList<>();
            ArrayList<String> uniqueFood = new ArrayList<>();
            ArrayList<String> uniqueDate = new ArrayList<>();

            String defTimeTo = recView.getRecPanel().getToDateField();
            String defTimeFrom = recView.getRecPanel().getFromDateField();
            if (defTimeTo.isEmpty() && defTimeFrom.isEmpty()) {
                defTimeTo = "01-01-20";
                defTimeFrom = "01-01-10";
            }

            int moodIndex = 0;
            for (Mood a : moodArr) {
                if (withinTime(defTimeTo, defTimeFrom, a.getDate())) {
                    moodPortion.add(a.getPortion());
                    moodDate.add(a.getDate());
                }
            }

            int moodIndexIn = 0;
            int counter = -1;
            for (String a : moodDate) {
                counter++;
                moodIndex = checkArr(a, uniqueDate);
                System.out.println("MOOD INDEX: " + moodIndex);

                if (moodIndex > -1) {
                    //Exists
                    moodCount.set(moodIndex, (moodCount.get(moodIndex) + 1));
                    moodSum.set(moodIndex, moodSum.get(moodIndex) + Double.parseDouble(moodPortion.get(counter)));
                } else {
                    //Not Exist
                    uniqueDate.add(a);
                    moodSum.add(Double.parseDouble(moodPortion.get(moodDate.indexOf(a))));
                    System.out.println(moodIndex + " VALUE = " + Double.parseDouble(moodPortion.get(counter)));
                    moodCount.add(1.0);
                }
                System.out.println("UNIQUE DATE SIZE = " + uniqueDate.size());
            }

            for (String a : uniqueDate) {
                moodIndexIn = uniqueDate.indexOf(a);
                moodAvg.add(moodSum.get(moodIndexIn) / moodCount.get(moodIndexIn));
            }

            int foodIndex = 0;
            ArrayList<Double> foodMood = new ArrayList<>();
            ArrayList<Double> uniqueFoodMood = new ArrayList<>();
            for (Food a : foodArr) {
                if (withinTime(defTimeTo, defTimeFrom, a.getDate())) {
                    foodIndex = foodArr.indexOf(a);
                    foodName.add(a.getName());
                    foodDate.add(a.getDate());
                    for (String b : uniqueDate) {
                        moodIndexIn = uniqueDate.indexOf(b);
                        if (b.equals(foodDate.get(foodIndex))) {
                            foodMood.add(moodAvg.get(moodIndexIn));
                        }
                    }
                }
            }

            int foodOut = 0;
            for (String a : foodName) {
                foodOut = foodName.indexOf(a);
                foodIndex = checkArr(a, uniqueFood);
                if (foodIndex < 0) {
                    uniqueFood.add(a);
                    foodCount.add(1);
                    uniqueFoodMood.add(foodMood.get(foodOut));
                } else {
                    int tmpCount = foodCount.get(foodIndex) + 1;
                    foodCount.set(foodIndex, tmpCount);

                    uniqueFoodMood.set(foodIndex, uniqueFoodMood.get(foodIndex) + foodMood.get(foodOut));
                }
            }

            ArrayList<Double> FoodMoodAvg = new ArrayList<>();
            for (Double b : uniqueFoodMood) {
                foodIndex = uniqueFoodMood.indexOf(b);

                FoodMoodAvg.add(b / foodCount.get(foodIndex));
            }
            for (String a : uniqueFood) {
                foodIndex = uniqueFood.indexOf(a);
                data.setValue(foodCount.get(foodIndex), "Food", a);
                data.setValue(FoodMoodAvg.get(foodIndex), "Mood", a);
            }
            recommendation(uniqueFood, FoodMoodAvg);
            JFreeChart jchart = ChartFactory.createBarChart("FoodMood History", "Food", "Level", data, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot = jchart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.BLACK);
            ChartPanel chartPanel = new ChartPanel(jchart);
            Dimension panelSize = new Dimension(recView.getRecPanel().getGraph().getPreferredSize());
            chartPanel.setPreferredSize(panelSize);
            recView.getRecPanel().getGraph().removeAll();
            recView.getRecPanel().getGraph().setLayout(new java.awt.BorderLayout());
            recView.getRecPanel().getGraph().validate();
            recView.getRecPanel().getGraph().add(chartPanel, BorderLayout.CENTER);
            recView.getRecPanel().updateUI();
            recView.getRecPanel().getGraph().setVisible(true);
        }
    }

    public boolean withinTime(String a, String b, String c) {
        int abc1, abc2, abc3;
        String abcA, abcB, abcC;
        String[] tmpStringA = a.split("-");//To
        String[] tmpStringB = b.split("-");//From
        String[] tmpStringC = c.split("-");//Target
        abcA = tmpStringA[2] + tmpStringA[1] + tmpStringA[0];
        abcB = tmpStringB[2] + tmpStringB[1] + tmpStringB[0];
        abcC = tmpStringC[2] + tmpStringC[1] + tmpStringC[0];
        System.out.println(abcA);
        System.out.println(abcB);
        System.out.println(abcC);
        abc1 = Integer.parseInt(abcA);
        abc2 = Integer.parseInt(abcB);
        abc3 = Integer.parseInt(abcC);
        System.out.println(abc1);
        System.out.println(abc2);
        System.out.println(abc3);
        if (abc1 >= abc3 && abc3 > abc2) {
            return true;
        }
        return false;
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

    public void recommendation(ArrayList<String> tmpList, ArrayList<Double> avgList) {
        double highestVal = 0;
        String highestStr = "";
        int counter = -1;
        for (double a : avgList) {
            counter++;
            if (a > highestVal) {
                highestVal = a;
                highestStr = tmpList.get(counter);
            }
        }
        System.out.println("Highest Value = " + highestVal);
        System.out.println("Highest Food = " + highestStr);

//COMPONENT 0 = FOOD ITEM; 1 = DRINK ITEM; 2 = DRINK TITLE; 4 = FOOD TITLE
        JLabel tmp = (JLabel) recView.getRecPanel().getRecFoodPane().getComponent(0);
        tmp.setText(highestStr);
        recView.getRecPanel().updateUI();
    }
}
