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
public class Mood extends Entry {
    /**
     * Default constructor for Mood class.
     */
    public Mood() {
        super();
        System.out.println("Mood constructor");
    }

    /**
     * Function to accept scaled amount of emotions after consumption
     * @param amount accepts amount as integer
     */
    @Override
    public void setAmount(int amount) {
        System.out.println("setAmount called in " + this.getClass().getName());
        super.setAmount(amount);
    }

    /**
     * Function to return scaled amount of emotions after consumption
     * @param amount returns amount as integer
     */
    @Override
    public int getAmount() {
        System.out.println("getAmount called in " + this.getClass().getName());
        return super.getAmount();
    }

    /**
     * Function to accept quality of emotions after consumption
     * @param unit accepts quality as String
     */
    @Override
    public void setUnit(String unit) {
        System.out.println("setUnit called in " + this.getClass().getName());
        super.setUnit(unit);
    }

    /**
     * Function to return quality of emotions after consumption
     * @param unit return quality as String
     */    
    @Override
    public String getUnit() {
        System.out.println("getUnit called in " + this.getClass().getName());
        return super.getUnit();
    }

    /**
     * Function to accept name of emotion after consumption
     * @param name accepts name as String
     */
    @Override
    public void setName(String name) {
        System.out.println("setName called in " + this.getClass().getName());
        super.setName(name);
    }

    /**
     * Function to return name of emotions after consumption
     * @param name returns name as String
     */
    @Override
    public String getName() {
        System.out.println("getName called in " + this.getClass().getName());
        return super.getName();
    }
}
