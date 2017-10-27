/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author John
 */
public class Drink extends Entry {    
    /**
     * Default constructor for Drink class.
     */
    public Drink(){
        super();
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
     * Function to return amount of drink
     * @return Amount of drinks as integer
     */
    @Override
    public int getAmount() {
        return super.getAmount();
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
}
