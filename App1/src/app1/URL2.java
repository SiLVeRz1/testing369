/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app1;

/**
 *
 * @author LEO_NB
 */
//Date,Country/Region,Province/State,Confirmed,Recovered,Deaths
public class URL2 {
    private final String date1;
    private final String country;
    private final String state;
    private final String confirmed;
    private final String recovered;
    private final String death;
    
    
    public URL2(String d1, String c, String s, String cf, String r, String d)
    {
        date1 = d1;
        country= c;
        state = s;
        confirmed = cf;
        recovered = r;
        death = d;
    }
    
    public String getdate()
    {
        return date1;
    }
    
    public String getcountry()
    {
        return country;
    }
    
    public String getstate()
    {
        return state;
    }
    
    public String getconfirmed()
    {
        return confirmed;
    }
          
    public String getrecovered()
    {
        return recovered;
    }
    
    public String getdeath()
    {
        return death;
    }
    
    @Override
    public String toString()
    {
        return date1 + "," + country + "," + state + "," + confirmed + "," + recovered + "," + death ;
    }
}
