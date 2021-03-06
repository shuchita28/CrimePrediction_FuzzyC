/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classificationcrime;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Ningesh
 */
public class GenerateClass {
    public static String filesavepath=Constants.path+"//booksreview";
    	public static void main(String[] args) throws FileNotFoundException, IOException {
            
            
             BufferedReader brt= new BufferedReader(new FileReader(Constants.path+"\\process.csv"));
    String sCurrentLine;
    String wholedata="";
     while (((sCurrentLine = brt.readLine()) != null)) {
                               
                         String splitline[]=sCurrentLine.split(",");
                         
                         String oprequired=splitline[3]+"|"+splitline[4]+"|"+splitline[5]+"|"+splitline[6]+"|"+splitline[11]+"|"+splitline[17]+"|"+splitline[18]+"|"+splitline[0];
                         
                         
                         
                       wholedata=wholedata+oprequired+"\n";  
                        
            
     }
     
     
         PrintWriter writer = new PrintWriter(filesavepath+".csv", "UTF-8");
         
         writer.println(wholedata);
				
				writer.close();
         
				   
            
        }
    
}
