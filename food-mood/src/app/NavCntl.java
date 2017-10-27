/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import database.User_Table;
import drink.DrinkCntl;
import drink.DrinkView;
import food.FoodCntl;
import food.FoodView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import login.LoginCntl;
import login.LoginView;
import models.Drink;
import models.Food;
import models.Mood;
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
    
    private NavView navView;

    private Drink drink;
    private DrinkView drinkView;
    private DrinkCntl drinkCntl;

    private Food food;
    private FoodView foodView;
    private FoodCntl foodCntl;

    private Mood mood;
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

        drink = new Drink();
        drinkView = new DrinkView(getDrink());
        drinkCntl = new DrinkCntl(getDrink(), getDrinkView());

//        food = new Food();
//        System.out.println("New Food instantiated.");
//        foodView = new FoodView(getFood());
//        System.out.println("New FoodView instantiated.");
//        foodCntl = new FoodCntl(getFood(), getFoodView());
//        System.out.println("New FoodCntl instantiated.");

        mood = new Mood();
        moodView = new MoodView(getMood());
        moodCntl = new MoodCntl(getMood(), getMoodView());
        
        navView.getNavViewPanel().getAddEntriesButton().addActionListener(new AddEntriesListener());
        navView.getNavViewPanel().getViewRecsButton().addActionListener(new ViewRecsListener());
        navView.getNavViewPanel().getViewProfileButton().addActionListener(new ViewProfileListener());
        navView.getNavViewPanel().getLogoutButton().addActionListener(new LogoutButtonListener());
    }
    
    public class AddEntriesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("add entries clicked");
        }
    }
    
    public class ViewRecsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("view recs clicked");
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

    /**
     * @return the mainView
     */
    public NavView getNavView() {
        return navView;
    }

    /**
     * @return the drink
     */
    public Drink getDrink() {
        return drink;
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
     * @return the food
     */
    public Food getFood() {
        return food;
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
     * @return the mood
     */
    public Mood getMood() {
        return mood;
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
