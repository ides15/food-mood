// John Ide - mood class

package models;

import parents.Entry;
import java.util.Date;

/**
 *
 * @author John
 */
public class Mood extends Entry {

    private final String mood;
    private final String portion;
    private final String date;

    /**
     * Default constructor for Mood class.
     */
    public Mood(String mood, String portion, String date) {
        super();
        this.mood = mood;
        this.portion = portion;
        this.date = date;
    }

    /**
     * Function to accept scaled amount of emotions after consumption
     *
     * @param amount accepts amount as integer
     */
    @Override
    public void setAmount(int amount) {
        super.setAmount(amount);
    }

    /**
     * Function to return scaled amount of emotions after consumption
     */
    @Override
    public int getAmount() {
        return super.getAmount();
    }

    /**
     * Function to accept quality of emotions after consumption
     *
     * @param unit accepts quality as String
     */
    @Override
    public void setUnit(String unit) {
        super.setUnit(unit);
    }

    /**
     * Function to return quality of emotions after consumption
     */
    @Override
    public String getUnit() {
        return super.getUnit();
    }

    /**
     * Function to accept name of emotion after consumption
     *
     * @param name accepts name as String
     */
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * Function to return name of emotions after consumption
     */
    @Override
    public String getName() {
        return this.mood;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }
    
        public String getPortion(){
        return this.portion;
    }
    
}
