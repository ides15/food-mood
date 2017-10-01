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
        System.out.println("Drink constructor called.");
    }

    /**
     * Function to set amount of drink
     * @param amount Amount of drink, accepts amount of ounces as integer
     */
    @Override
    public void setAmount(int amount) {
        System.out.println("setAmount called in " + this.getClass().getName());
        super.setAmount(amount);
    }

    /**
     * Function to return amount of drink
     * @return Amount of drinks as integer
     */
    @Override
    public int getAmount() {
        System.out.println("getAmount called in " + this.getClass().getName());
        return super.getAmount();
    }

    /**
     * Function to set type of drink
     * @param unit Type of drink, accepts type as string
     */
    @Override
    public void setUnit(String unit) {
        System.out.println("setUnit called in " + this.getClass().getName());
        super.setUnit(unit);
    }

    /**
     * Function to get type of drink
     * @return Type of drink as string
     */
    @Override
    public String getUnit() {
        System.out.println("getUnit called in " + this.getClass().getName());
        return super.getUnit();
    }

    /**
     * Function to set name of drink
     * @param name Name of drink set as String
     */
    @Override
    public void setName(String name) {
        System.out.println("setName called in " + this.getClass().getName());
        super.setName(name);
    }
}
