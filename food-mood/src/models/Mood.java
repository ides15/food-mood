/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import parents.Entry;
import java.util.Date;

/**
 *
 * @author John
 */
public class Mood extends Entry {

    private Date date;
    private String name;

    /**
     * Default constructor for Mood class.
     */
    public Mood() {
        super();
        this.date = new Date();
        System.out.println(date.toString());
    }

    public Mood(String name) {
        super();
        this.date = new Date();
        this.name = name;
        System.out.println(date.toString());
    }
    /**
     * Function to accept scaled amount of emotions after consumption
     *
     * @param amount accepts amount as integer
     */
    @Override
    public void setAmount(int amount) {
        super.setAmount(amount);
    }

    /**
     * Function to return scaled amount of emotions after consumption
     */
    @Override
    public int getAmount() {
        return super.getAmount();
    }

    /**
     * Function to accept quality of emotions after consumption
     *
     * @param unit accepts quality as String
     */
    @Override
    public void setUnit(String unit) {
        super.setUnit(unit);
    }

    /**
     * Function to return quality of emotions after consumption
     */
    @Override
    public String getUnit() {
        return super.getUnit();
    }

    /**
     * Function to accept name of emotion after consumption
     *
     * @param name accepts name as String
     */
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * Function to return name of emotions after consumption
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }
}
