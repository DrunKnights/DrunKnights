package org.hackucf.drunknights;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private double weight;
    private boolean isFemale;
    private List<Drink> drinkList = new ArrayList<Drink>();

    public User(String name, double weight, boolean isFemale){

        this.name = name;
        this.weight = weight;
        this.isFemale = isFemale;
    }

    public String getName(){ return name; }
    public double getWeight(){ return weight; }
    public boolean getIsFemale(){ return isFemale; }
    public List<Drink> getDrinkList(){ return drinkList; }

    public void updateName(String name){ this.name = name; }
    public void updateWeight(double weight){ this.weight = weight; }
    public void updateIsFemale(boolean isFemale){ this.isFemale = isFemale; }

    public boolean addDrink(Drink d){ return drinkList.add(d); }
}