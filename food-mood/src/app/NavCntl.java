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
import models.User;
import mood.MoodCntl;
import mood.MoodView;
import profile.ProfileCntl;
import profile.ProfileView;
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
    private User user;
    private int accountID;
    
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
    
    private ProfileView profileView;
    private ProfileCntl profileCntl;
    
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
        
        this.user = null;
        
        navView.addAddEntriesListener(new AddEntriesListener());
        navView.addViewRecsListener(new ViewRecsListener());
        navView.addViewEntriesListener(new ViewEntriesListener());
        navView.addViewProfileListener(new ViewProfileListener());
        navView.addLogoutListener(new LogoutButtonListener());
        
        navView.addNewFoodListener(new NewEntryCntlListener());
        navView.addNewDrinkListener(new NewEntryCntlListener());
        navView.addNewMoodListener(new NewEntryCntlListener());
        navView.addBackListener(new BackListener());
    }

    public class AddEntriesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            navView.getNavViewPanel().setVisible(false);
            navView.add(navView.getNewEntriesViewPanel());
            navView.getNewEntriesViewPanel().setVisible(true);
            navView.remove(navView.getNavViewPanel());
        }
    }
    
    // TODO
    public class ViewRecsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("view recs clicked");
        }
    }
    
    // TODO
    public class ViewEntriesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("view etnries clicked");
        }
    }
    
    public class ViewProfileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            profileView = new ProfileView(db);
            profileCntl = new ProfileCntl(db, profileView);
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

    public class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            navView.add(navView.getNavViewPanel());
            navView.getNewEntriesViewPanel().setVisible(false);
            navView.getNavViewPanel().setVisible(true);
        }
    }
    
    public class NewEntryCntlListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            EntryCntlFactory factory = new EntryCntlFactory();
            factory.getEntry(e.getActionCommand().toLowerCase().substring(4));
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

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the accountID
     */
    public int getAccountID() {
        return accountID;
    }

    /**
     * @param accountID the accountID to set
     */
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
