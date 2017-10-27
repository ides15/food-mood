/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import database.Drink_Table;
import database.Food_Table;
import database.Mood_Table;
import database.User_Table;
import drink.DrinkCntl;
import drink.DrinkView;
import food.FoodCntl;
import food.FoodView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import login.LoginCntl;
import login.LoginView;
import mood.MoodCntl;
import mood.MoodView;
import stats.*;
import recommendations.*;

/**
 *
 * @author John
 */
public class NavCntl {
    private User_Table db;
    private LoginView loginView;
    private LoginCntl loginCntl;
    
    private final NavView navView;

    private Food_Table food_db;
    private FoodView foodView;
    private FoodCntl foodCntl;

    private Drink_Table drink_db;
    private DrinkView drinkView;
    private DrinkCntl drinkCntl;

    private Mood_Table mood_db;
    private MoodView moodView;
    private MoodCntl moodCntl;

    private RecModel rec;
    private RecView recView;
    private RecCntl recCntl;
    
    private StatsModel stats;
    private StatsView statsView;
    private StatsCntl statsCntl;
    /**
     * Default constructor for MainCntl.
     *
     * @param navView view class for MVC architecture.
     */
    public NavCntl(NavView navView) {
        this.navView = navView;
        
        navView.addAddEntriesListener(new AddEntriesListener());
        navView.addViewRecsListener(new ViewRecsListener());
        navView.addViewEntriesListener(new ViewEntriesListener());
        navView.addViewProfileListener(new ViewProfileListener());
        navView.addLogoutListener(new LogoutButtonListener());
        
        navView.addNewFoodListener(new NewFoodListener());
        navView.addNewDrinkListener(new NewDrinkListener());
        navView.addNewMoodListener(new NewMoodListener());
        navView.addBackListener(new BackListener());
    }
    ///////////////////////////////////////////////////////////
    public class AddEntriesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            navView.getNavViewPanel().setVisible(false);
            navView.add(navView.getNewEntriesViewPanel());
        }
    }
    
    public class ViewRecsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("view recs clicked");
        }
    }
    
    public class ViewEntriesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("view etnries clicked");
        }
    }
    
    public class ViewProfileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("view profile clicked");
        }
    }
    
    public class LogoutButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            db = new User_Table("foodmood.db");
            loginView = new LoginView(db);
            loginCntl = new LoginCntl(db, loginView);
            
            navView.setVisible(false);
            loginCntl.getLoginView().setVisible(true);
        }
    }
    
    public class NewFoodListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            food_db = new Food_Table("foodmood.db");
            foodView = new FoodView(food_db);
            foodCntl = new FoodCntl(food_db, foodView);
        }
    }
    
    public class NewDrinkListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            drink_db = new Drink_Table("foodmood.db");
            drinkView = new DrinkView(drink_db);
            drinkCntl = new DrinkCntl(drink_db, drinkView);
        }
    }
    
    public class NewMoodListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mood_db = new Mood_Table("foodmood.db");
            moodView = new MoodView(mood_db);
            moodCntl = new MoodCntl(mood_db, moodView);
        }
    }
    /////////////////////////////////////////////////////
    public class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            navView.add(navView.getNavViewPanel());
            navView.getNewEntriesViewPanel().setVisible(false);
        }
    }

    /**
     * @return the mainView
     */
    public NavView getNavView() {
        return navView;
    }

    /**
     * @return the drinkView
     */
    public DrinkView getDrinkView() {
        return drinkView;
    }

    /**
     * @return the drinkCntl
     */
    public DrinkCntl getDrinkCntl() {
        return drinkCntl;
    }

    /**
     * @return the foodView
     */
    public FoodView getFoodView() {
        return foodView;
    }

    /**
     * @return the foodCntl
     */
    public FoodCntl getFoodCntl() {
        return foodCntl;
    }

    /**
     * @return the moodView
     */
    public MoodView getMoodView() {
        return moodView;
    }

    /**
     * @return the moodCntl
     */
    public MoodCntl getMoodCntl() {
        return moodCntl;
    }
    
    /**
     * @return the stats
     */
    public StatsModel getStats() {
        return stats;
    }

    /**
     * @return the statsView
     */
    public StatsView getStatsView() {
        return statsView;
    }

    /**
     * @return the statsCntl
     */
    public StatsCntl getStatsCntl() {
        return statsCntl;
    }
    
    /**
     * @return the rec
     */
    public RecModel getRec() {
        return rec;
    }

    /**
     * @return the recView
     */
    public RecView getRecView() {
        return recView;
    }

    /**
     * @return the recCntl
     */
    public RecCntl getRecCntl() {
        return recCntl;
    }
}
