package org.hackucf.drunknights;

/**
 * Created by Cody on 10/8/2017.
 */

import java.util.*;
import java.lang.Math.*;

public class bac
{
    public static void main(String[] args) {
        java.util.Date date = new java.util.Date();
        double drinks[] = {1,2,3};
        Date[] time = new Date[3];
        GregorianCalendar g = new GregorianCalendar(2017, 9, 1, 0, 5, 0);
        time[0] = g.getTime();
        g = new GregorianCalendar(2017, 9, 8, 0, 15, 0);
        time[1] = g.getTime();
        g = new GregorianCalendar(2017, 9, 8, 1, 5, 0);
        time[2] = g.getTime();
        double bac = CalculateBAC(drinks, time);
        System.out.println(bac);
    }

    //drinks is a list of the actual alchohol content (that is, percentage * volume) and times are when they were consumed
    // rest is anthrometric data
    public static double CalculateBAC(double drinks[], Date times[], float height, int age, Bool woman)
    {
        // https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4361698/#bibr3-0025802414524385
        // http://web.archive.org/web/20060930091559/http://www.nhtsa.dot.gov/people/injury/alcohol/bacreport.html
        double bacDecayPerHour = 0.17;
        double bac = 0;
        for (int i=0; i < drinks.length; i++)
        {
            long milis = date.getTime() - times[i].getTime();
            double hours = milis / (1000*60*60);
            double bacEffect = java.lang.Math.max(0.0, drinks[i] - bacDecayPerHour*hours);
            bac = bac + bacEffect;
        }
        return bac;
    }
}