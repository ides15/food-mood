// John Ide - date class

package models;

import parents.Entry;

/**
 *
 * @author John
 */
public class Drink extends Entry {
    private final String date;
    private final String drink;
    private final String portion;
    
    /**
     * Default constructor for Drink class.
     */
    public Drink(String drink, String portion, String date){
        super();
        this.drink = drink;
        this.portion = portion;
        this.date = date;
        //System.out.println(date.toString());
    }

    public Drink(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Function to set amount of drink
     * @param amount Amount of drink, accepts amount of ounces as integer
     */
    @Override
    public void setAmount(int amount) {
        super.setAmount(amount);
    }

    /**
     * Function to set type of drink
     * @param unit Type of drink, accepts type as string
     */
    @Override
    public void setUnit(String unit) {
        super.setUnit(unit);
    }

    /**
     * Function to get type of drink
     * @return Type of drink as string
     */
    @Override
    public String getUnit() {
        return super.getUnit();
    }

    /**
     * Function to set name of drink
     * @param name Name of drink set as String
     */
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }
    
    public String getDrink() {
        return drink;
    }
    
    public String getPortion() {
        return portion;
    }
}
