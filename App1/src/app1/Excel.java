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
public class Excel {
    private final String date1;
    private final String cases;
    private final String death;
    
    public Excel(String d1, String c, String d)
    {
        date1 = d1;
        cases = c;
        death = d;
    }
    
    public String getdate()
    {
        return date1;
    }
    
    public String getcase()
    {
        return cases;
    }
    
    public String getdeath()
    {
        return death;
    }
    
    @Override
    public String toString()
    {
        return date1 + "," + cases + "," + death;
    }
}
