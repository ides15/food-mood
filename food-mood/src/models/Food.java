/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author John
 */
public class Food extends Entry {
    /**
     * Default constructor for Food class.
     */
    private String food;
    private String amount;
    private Date date;
    
    public Food(String food, String amount, Date date) {
        super();
        
        this.food = food;
        this.amount = amount;
        this.date = date;
        System.out.println("Food constructor");
    }

    /**
     * Function to set amount of food consumed
     * @param amount accepts amount as integer
     */
    @Override
    public void setAmount(int amount) {
        System.out.println("setAmount called in " + this.getClass().getName());
        super.setAmount(amount);
    }

    /**
     * Function to return amount of food consumed
     * @param amount return amount as integer
     */
    @Override
    public int getAmount() {
        System.out.println("getAmount called in " + this.getClass().getName());
        return super.getAmount();
    }
    
    public void setDate(Date date){
        this.date = date;
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
        System.out.println("setUnit called in " + this.getClass().getName());
        super.setUnit(unit);
    }

    /**
     * Function to return units of food consumed
     * @param unit returns amount as integer
     */
    @Override
    public String getUnit() {
        System.out.println("getUnit called in " + this.getClass().getName());
        return super.getUnit();
    }

    /**
     * Function to accept name of food consumed
     * @param name accepts name as String
     */
    @Override
    public void setName(String name) {
        System.out.println("setName called in " + this.getClass().getName());
        super.setName(name);
    }
    
    /**
     * Function to return name of food consumed
     * @param name returns name as String
     */
    @Override
    public String getName() {
        System.out.println("getName called in " + this.getClass().getName());
        return super.getName();
    }
}
