// John Ide - drink class (besides anything for date)

package models;

import parents.Entry;

/**
 *
 * @author John
 */
public class Drink extends Entry {
    private final String drink;
    private final String portion;
    private final String date;
    private final int drinkID;
    
    /**
     * Default constructor for Drink class.
     * @param drink name of the drink
     * @param amount amount of drink in ?units
     */
    public Drink(String drink, String portion, String date, int drinkID) {
        super();
        
        this.drink = drink;
        this.portion = portion;
        this.date = date;
        this.drinkID = drinkID;
        
    }

    /**
     * Function to set amount of drink consumed
     * @param amount accepts amount as integer
     */
    @Override
    public void setAmount(int amount) {
        super.setAmount(amount);
    }

    /**
     * Function to return amount of drink consumed
     * @return amount of the drink in ?units
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
     * Function to set units of drink consumed
     * @param unit accepts amount as integer
     */
    @Override
    public void setUnit(String unit) {
        super.setUnit(unit);
    }

    /**
     * Function to return units of drink consumed
     * @return units of the drink
     */
    @Override
    public String getUnit() {
        return super.getUnit();
    }
    
    /**
     * Function to return name of drink consumed
     * @return name of the drink
     */
    @Override
    public String getName() {
        return this.drink;
    }
    
    public String drinkToString(Drink f){
       String s = ""+f.getName()+", "+f.getAmount()+", "+f.getDate();
       return s;
    }
}
