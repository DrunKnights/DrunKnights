package org.hackucf.drunknights;

public class Drink{

    private String name;
    private double alcCont;
    private double ounces;
    private double time;

    public Drink(String name, double alcCont, double ounces, double time) {

        this.name = name;
        this.alcCont = alcCont;
        this.ounces = ounces;
        this.time = time;
    }

    public String getName(){ return name; }
    public double getAlcCont(){ return alcCont; }
    public double getOunces() { return ounces; }
    public double getTime(){ return time; }
}
