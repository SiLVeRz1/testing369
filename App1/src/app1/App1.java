/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app1;

import java.net.*;
import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 ********************************
 * @author LEO_NB
 * By Lee Yu Ning
 * ******************************
 */
public class App1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String fname = "us.csv";  
         
       ArrayList<Excel> list = readDataFile(fname);   
       ArrayList<URL2> list2 = getUrlContents("https://raw.githubusercontent.com/datasets/covid-19/master/data/time-series-19-covid-combined.csv?opt_id=oeu1602683047550r0.4929949464591361");;   
       list.remove(0);

       ArrayList<URL2> list3 = Filtering(list2);
       
       List<String> ans = new ArrayList<>();
       ans = Joining(list, list3);
       
      System.out.println("date,cases,deaths,recoveries");
      for(int i =0 ; i< ans.size(); i++)
      System.out.println(ans.get(i).toString());
          
    }
    private static ArrayList<Excel> readDataFile(String fname)
    {
        // Read data from csv file
        ArrayList<Excel> list = new ArrayList();
        
        try (Scanner sc = new Scanner(new File(fname)))
        {
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] token = line.split(",");
                list.add(new Excel(token[0], token[1], token[2]));   
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }         
        return list;
    }
    
   
private static ArrayList<URL2> getUrlContents(String theUrl)
  {
     //get data from URL
    StringBuilder content = new StringBuilder();
     ArrayList<URL2> list = new ArrayList();
        
        try 
        {
            URL url = new URL(theUrl);

      // create a urlconnection object
      URLConnection urlConnection = url.openConnection();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));     
      String line;
       // read from the urlconnection via the bufferedreader
      while ((line = bufferedReader.readLine()) != null)
         {
        content.append(line + "\n");
        String[] token = line.split(",");
       list.add(new URL2(token[0], token[1], token[2], token[3], token[4], token[5]));   
        
      }
      bufferedReader.close();
            
        }
        catch(Exception e)
    {
      e.printStackTrace();
    }
        return list;
  }

private static ArrayList<URL2> Filtering( ArrayList<URL2> data)
  {
      
       ArrayList<URL2> list = new ArrayList();
       int j = 0 ;
       for (int i =0; i< data.size(); i++)
       {
            if (data.get(i).getcountry().contains("US") )
            {
               list.add(data.get(i));
            }
        }

      return list;
      
   }
  
private static List<String> Joining(ArrayList<Excel> data1, ArrayList<URL2> data2)
{
    List<String> result = new ArrayList<>();
    Boolean check = false;

    //Remove data from days that do not exist
    while(!check)
    {
        int i =0;
        if(data1.get(i).getdate().compareTo(data2.get(i).getdate())<0)
            {
         data1.remove(i);
            }
        else
            check = true;
    }
    
    //copy the recoveries to NYT data
    for (int j = 0; j< data1.size(); j++)
     result.add(data1.get(j).toString() + "," + data2.get(j).getrecovered().toString());
    
return result;


}

    
}
