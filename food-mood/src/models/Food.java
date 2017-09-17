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
public class Food extends Entry {
    /**
     * Default constructor for Food class.
     */
    public Food() {
        super();
        System.out.println("Food constructor");
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
     * @param amount return amount as integer
     */
    @Override
    public int getAmount() {
        return super.getAmount();
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
     * @param unit returns amount as integer
     */
    @Override
    public String getUnit() {
        return super.getUnit();
    }

    /**
     * Function to accept name of food consumed
     * @param name accepts name as String
     */
    @Override
    public void setName(String name) {
        super.setName(name);
    }
    
    /**
     * Function to return name of food consumed
     * @param name returns name as String
     */
    @Override
    public String getName() {
        return super.getName();
    }
}
