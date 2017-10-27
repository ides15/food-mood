/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author John
 */
public class Food extends Entry {
    private final String food;
    private final String amount;
    private final Date date;
    
    /**
     * Default constructor for Food class.
     * @param food name of the food
     * @param amount amount of food in ?units
     */
    public Food(String food, String amount) {
        super();
        
        this.food = food;
        this.amount = amount;
        this.date = new Date();
        System.out.println(date.toString());
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
    
    public Date getDate(){
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
        return super.getName();
    }
}
