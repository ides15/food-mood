package recommendations;

import database.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
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
//        getRecView().addDrinkBtnActionListener(new DrinkBtnListener());
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

            int foodIndex = 0;
            System.out.println("FOOD BUTTON PRESSED");
            System.out.println("FoodArrSize= " + foodArr.size());
            for (Food a : foodArr) {
                foodName.add(a.getName());
                foodPortion.add(a.getPortion());
                foodDate.add(a.getDate());
                System.out.println("Food : " + foodName.size() + " - " + foodName.get(foodName.size() - 1) + " " + foodPortion.get(foodName.size() - 1) + " " + foodDate.get(foodName.size() - 1));
            }
            //Size = 13; 0-12; 6 choc; 2 taco; 2 bur; 2 sand; 1 cig
            //Choc 0, Taco 1, bur 2

            for (String a : foodName) {
                foodIndex = checkArr(a, uniqueFood);
                System.out.println("INDEX OF " + a + " = " + foodIndex);
                if (foodIndex < 0) {
                    uniqueFood.add(a);
                    foodCount.add(1);
                    System.out.println("Food to add: " + a);
                    System.out.println("Indexed at : " + uniqueFood.indexOf(a) + " with value " + foodCount.get(uniqueFood.indexOf(a)));
                } else {
                    System.out.println("Already Exists");
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

//    class DrinkBtnListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            DefaultCategoryDataset data = new DefaultCategoryDataset();
//            ArrayList<Drink> drinkArr = db_drink.getAllEntries(accountID);
//            ArrayList<String> drinkName = new ArrayList<>();
//            ArrayList<String> drinkPortion = new ArrayList<>();
//            ArrayList<String> drinkDate = new ArrayList<>();
//            ArrayList<Integer> drinkCount = new ArrayList<>();
//            ArrayList<String> uniqueDrink = new ArrayList<>();
//
//            System.out.println("DRINK ARRAY");
//            System.out.println(drinkArr);
//
//            int drinkIndex = 0;
//            System.out.println("DRINK BUTTON PRESSED");
//            System.out.println("DrinkArrSize= " + drinkArr.size());
//            for (Drink a : drinkArr) {
//                drinkName.add(a.getName());
//                drinkPortion.add(a.getPortion());
//                drinkDate.add(a.getDate());
//                System.out.println("DRINK : " + drinkName.size() + " - " + drinkName.get(drinkName.size() - 1) + " " + drinkPortion.get(drinkName.size() - 1) + " " + drinkDate.get(drinkName.size() - 1));
//
//            }
//
//            for (String a : drinkName) {
//                drinkIndex = checkArr(a, uniqueDrink);
//                System.out.println("INDEX OF " + a + " = " + drinkIndex);
//                if (drinkIndex < 0) {
//                    uniqueDrink.add(a);
//                    drinkCount.add(1);
//                    System.out.println("Food to add: " + a);
//                    System.out.println("Indexed at : " + uniqueDrink.indexOf(a) + " with value " + drinkCount.get(uniqueDrink.indexOf(a)));
//                } else {
//                    System.out.println("Already Exists");
//                    int tmpCount = drinkCount.get(drinkIndex) + 1;
//                    System.out.println(drinkIndex + " - " + tmpCount);
//
//                    drinkCount.set(drinkIndex, tmpCount);
//                }
//            }
//
//            for (String a : uniqueDrink) {
//                data.setValue(drinkCount.get(uniqueDrink.indexOf(a)), "Drink", a);
//            }
//            JFreeChart jchart = ChartFactory.createBarChart("Drink History", "Drink Name", "Drink Quantity", data, PlotOrientation.VERTICAL, true, true, false);
//            CategoryPlot plot = jchart.getCategoryPlot();
//            plot.setRangeGridlinePaint(Color.BLACK);
//            ChartFrame chartFrm = new ChartFrame("Drink History", jchart, true);
//            chartFrm.setSize(600, 400);
//
//            ChartPanel chartPanel = new ChartPanel(jchart);
//            recView.getRecPanel().getGraph().removeAll();
//            recView.getRecPanel().setGraph(chartPanel);
//            recView.getRecPanel().getGraph().updateUI();
//            chartFrm.setVisible(true);
//        }
//    }
    class BothBtnListener implements ActionListener {

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
            ArrayList<Food> foodArr = db_food.getAllEntries(accountID);
            ArrayList<String> foodName = new ArrayList<>();
            ArrayList<String> foodPortion = new ArrayList<>();
            ArrayList<String> foodDate = new ArrayList<>();
            ArrayList<Integer> foodCount = new ArrayList<>();
            ArrayList<String> uniqueFood = new ArrayList<>();

            ArrayList<String> uniqueDate = new ArrayList<>();

            int moodIndex = 0;
            for (Mood a : moodArr) {
                moodName.add(a.getName());
                moodPortion.add(a.getPortion());
                moodDate.add(a.getDate());
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
                foodIndex = foodArr.indexOf(a);
                foodName.add(a.getName());
                foodPortion.add(a.getPortion());
                foodDate.add(a.getDate());
                for (String b : uniqueDate) {
                    moodIndexIn = uniqueDate.indexOf(b);
                    if (b.equals(foodDate.get(foodIndex))) {
                        foodMood.add(moodAvg.get(moodIndexIn));
                    } else {
                        System.out.println("PROBLEM WITH DATA");
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
            recommendation(uniqueFood, FoodMoodAvg);
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
                System.out.println("MOOD INDEX: " + moodIndex);
                moodName.add(a.getName());
                moodPortion.add(a.getPortion());
                moodDate.add(a.getDate());
                System.out.println("NAME: " + moodName.get(moodIndex) + " PORTION: " + moodPortion.get(moodIndex) + " Date: " + moodDate.get(moodIndex));
            }
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
                double tempD = moodSum.get(moodIndexIn) / moodCount.get(moodIndexIn);
                System.out.println("TEMPD:" + moodSum.get(moodIndexIn) + "/" + moodCount.get(moodIndexIn) + " = " + tempD);
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
            System.out.println("FOOD BUTTON PRESSED");
            System.out.println("FoodArrSize= " + foodArr.size());
            for (Food a : foodArr) {
                foodName.add(a.getName());
                foodPortion.add(a.getPortion());
                foodDate.add(a.getDate());
                System.out.println("Food : " + foodName.size() + " - " + foodName.get(foodName.size() - 1) + " " + foodPortion.get(foodName.size() - 1) + " " + foodDate.get(foodName.size() - 1));
            }
            //Size = 13; 0-12; 6 choc; 2 taco; 2 bur; 2 sand; 1 cig
            //Choc 0, Taco 1, bur 2

            for (String a : foodName) {
                foodIndex = checkArr(a, uniqueFood);
                System.out.println("INDEX OF " + a + " = " + foodIndex);
                if (foodIndex < 0) {
                    uniqueFood.add(a);
                    foodCount.add(1);
                    System.out.println("Food to add: " + a);
                    System.out.println("Indexed at : " + uniqueFood.indexOf(a) + " with value " + foodCount.get(uniqueFood.indexOf(a)));
                } else {
                    System.out.println("Already Exists");
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
            ArrayList<String> moodName = new ArrayList<>();
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

            String defTimeTo = "";
            String defTimeFrom = "";
            defTimeTo = recView.getRecPanel().getToDateField();
            defTimeFrom = recView.getRecPanel().getFromDateField();
            String[] defTimeToArr = defTimeTo.split("/");
            String[] defTimeFromArr = defTimeFrom.split("/");
            System.out.println(defTimeToArr[0]);
            System.out.println(defTimeFromArr[0]);

            if (!defTimeTo.isEmpty() && !defTimeFrom.isEmpty()) {

                defTimeTo = recView.getRecPanel().getToDateField().toString();
                defTimeFrom = recView.getRecPanel().getFromDateField().toString();
//                String[] defTimeToArr = defTimeTo.split("-");
//                String[] defTimeFromArr = defTimeFrom.split("-");
                System.out.println(defTimeToArr[0] + " " + defTimeToArr[1] + " " + defTimeToArr[2]);
                System.out.println(defTimeFromArr[0] + " " + defTimeFromArr[1] + " " + defTimeFromArr[2]);

                if (false) {
                    int moodIndex = 0;
                    for (Mood a : moodArr) {
                        moodName.add(a.getName());
                        moodPortion.add(a.getPortion());
                        moodDate.add(a.getDate());
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
                        foodIndex = foodArr.indexOf(a);
                        foodName.add(a.getName());
                        foodPortion.add(a.getPortion());
                        foodDate.add(a.getDate());
                        for (String b : uniqueDate) {
                            moodIndexIn = uniqueDate.indexOf(b);
                            if (b.equals(foodDate.get(foodIndex))) {
                                foodMood.add(moodAvg.get(moodIndexIn));
                            } else {
                                System.out.println("PROBLEM WITH DATA");
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
                    recommendation(uniqueFood, FoodMoodAvg);
                } else {
                    System.out.println("TO IS BEFORE FROM");
                }
            } else {
                System.out.println("DATE FIELDS NOT FULL");
            }
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

    public void recommendation(ArrayList<String> tmpList, ArrayList<Double> avgList) {
        double highestVal = 0;
        String highestStr = "";
        int counter = -1;
        for (double a : avgList) {
            counter++;
            if (a > highestVal) {
                highestVal = a;
                highestStr = tmpList.get(counter);
            } else if (a == highestVal) {
                highestStr += " " + tmpList.get(counter);
            }
        }

        JLabel tmpLabel = new JLabel(highestStr);
        recView.getRecPanel().setFoodLabel(tmpLabel);
    }
}
