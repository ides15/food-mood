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
public class Entry {
    private String name;
    private String unit;
    private int amount;
    
    /**
     * Default constructor for Entry class.
     */
    public Entry() {
        System.out.println("Entry constructor called.");
    }

    /**
     * @return the name
     */
    public String getName() {
        System.out.println("getName called in " + this.getClass());
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        System.out.println("setName called in " + this.getClass().getName());
        this.name = name;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        System.out.println("getUnit called in " + this.getClass().getName());
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        System.out.println("setUnit called in " + this.getClass().getName());
        this.unit = unit;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        System.out.println("getAmount called in " + this.getClass().getName());
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        System.out.println("setAmount called in " + this.getClass().getName());
        this.amount = amount;
    }
}
