// John Ide - food class (besides anything for date)

package models;

import parents.Entry;

/**
 *
 * @author John
 */
public class Food extends Entry {
    private final String food;
    private final String portion;
    private final String date;
    private final int foodID;
    
    /**
     * Default constructor for Food class.
     * @param food name of the food
     * @param amount amount of food in ?units
     */
    public Food(String food, String portion, String date, int foodID) {
        super();
        
        this.food = food;
        this.portion = portion;
        this.date = date;
        this.foodID = foodID;
        
    }

    /**
     * Function to set amount of food consumed
     * @param amount accepts amount as integer
     */
    @Override
    public void setAmount(int amount) {
        super.setAmount(amount);
    }

    /**
     * Function to return amount of food consumed
     * @return amount of the food in ?units
     */
    @Override
    public int getAmount() {
        return super.getAmount();
    }
    
    public String getPortion(){
        return this.portion;
    }
    
    public String getDate(){
        return this.date;
    }

    /**
     * Function to set units of food consumed
     * @param unit accepts amount as integer
     */
    @Override
    public void setUnit(String unit) {
        super.setUnit(unit);
    }

    /**
     * Function to return units of food consumed
     * @return units of the food
     */
    @Override
    public String getUnit() {
        return super.getUnit();
    }
    
    /**
     * Function to return name of food consumed
     * @return name of the food
     */
    @Override
    public String getName() {
        return this.food;
    }
    
    public String foodToString(Food f){
       String s = ""+f.getName()+", "+f.getAmount()+", "+f.getDate();
       return s;
    }
}
