package recommendations;

import models.Drink;
import models.Food;
import models.Mood;
import stats.StatsModel;

/**
 *
 * @author kjrya
 */
public class RecModel {
    private StatsModel stats;
    private Drink recDrink;
    private Food recFood;
    private Mood estMood;
    /**
     * Default constructor for recommended meal model
     * @param stats accepts stats as statsModel
     * @param mood accepts desired mood as Mood object
     */
    public RecModel(StatsModel stats, Mood mood){
        this.stats=stats;
        this.estMood=mood;
    }
    /**
     * Function to return drink
     * @return recommended drink as Drink object
     */
    public Drink getRecDrink(){
        return recDrink;
    }
    /**
     * Function to return food
     * @return recommended food as Food object
     */
    public Food getRecFood(){
        return recFood;
    }
    /**
     * Function to return estimated mood after consumption
     * @return estimated mood as Mood object
     */
    public Mood getEstMood(){
        return estMood;
    }
    
    /**
     * Function to generate meal for mood
     */
    public void recMealGen(){
        Food recommendedFood=(Food) stats.getFoodTable().get(0);
        Drink recommendedDrink=(Drink) stats.getDrinkTable().get(0);
        this.recFood=recommendedFood;
        this.recDrink=recommendedDrink;
    }
}
