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
    public Drink() {
        super();
        System.out.println("Drink constructor");
    }

    @Override
    public void setAmount(int amount) {
        super.setAmount(amount);
    }

    @Override
    public int getAmount() {
        return super.getAmount();
    }

    @Override
    public void setUnit(String unit) {
        super.setUnit(unit);
    }

    @Override
    public String getUnit() {
        return super.getUnit();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }
    
    
}
