// John Ide - date class
package models;

import parents.Entry;

/**
 *
 * @author John
 */
public class Drink_bk extends Entry {

    private final String date;
    private final String drink;
    private final String portion;
    private final int drinkID;

    /**
     * Default constructor for Drink class.
     */
    public Drink_bk(String drink, String portion, String date, int drinkID) {
        super();

        this.drink = drink;
        this.portion = portion;
        this.date = date;
        this.drinkID = drinkID;
    }

    public Drink_bk(String a, String b, String c, int d, String f) {
        drink = a;
        portion = b;
        date = c;
        drinkID = d;
    }

    /**
     * Function to set amount of drink
     *
     * @param amount Amount of drink, accepts amount of ounces as integer
     */
    @Override
    public void setAmount(int amount) {
        super.setAmount(amount);
    }

    /**
     * Function to set type of drink
     *
     * @param unit Type of drink, accepts type as string
     */
    @Override
    public void setUnit(String unit) {
        super.setUnit(unit);
    }

    /**
     * Function to get type of drink
     *
     * @return Type of drink as string
     */
    @Override
    public String getUnit() {
        return super.getUnit();
    }

    /**
     * @return the date
     */
    public String getDate() {
        return this.date;
    }

    public String getPortion() {
        return this.portion;
    }

    public int getDrinkID() {
        return drinkID;
    }

    public String getDrink() {
        return this.drink;
    }

}
