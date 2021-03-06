/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classificationcrime;

import java.util.ArrayList;

/**
 *
 * @author Ningesh
 */
public class FindingFuzzyCmeans {
    //https://www.slideshare.net/foofiM/fuzzy-image-processing
   
    static int mval=0;
      public static   ArrayList<String> userdata1=new ArrayList<>();
     
      static String tmpvar="";
    
    public static void main(String args[])
    {
          double x[];
        x = new double[]{1.5,2.1,18,2,3,4,5,6,7,8,9,10,11,12,13,14};
          String   userdata11=null;
            double clusterpoint[]=new double[]{3,13};
        String dataone1[]=  dataobt(clusterpoint,x).split(" ");
   while(true){
 if(userdata1.size()>0){
     tmpvar=userdata11;
    clusterpoint=new double[]{Double.parseDouble(dataone1[0]),Double.parseDouble(dataone1[1])};
        if(userdata1.contains(userdata11))
        {
            
            //stop
            break;
        }
        else
        {
       userdata11= dataobt(clusterpoint,x);
       dataone1=  userdata11.split(" ");
        }
        
        
         if(mval==25){
              break;
        }
        
        if(userdata11.equals(tmpvar))
        {
            
            System.out.println("final op of cluster "+userdata11);
            
        break;
        }
   }
   }
    }
    
    public static  String dataobt(double clusterpoint[],double x[])
    {
        double m=2;
   
    
        ArrayList<String> data1=new ArrayList<>();
         ArrayList<String> data2=new ArrayList<>();
   
        
       
        
        double c1pointnewcluster=0,c2pointnewcluster=0;
        
        double denominoterfirst=0;
        double denominoterfsecond=0;
        for(int k=0;k<x.length;k++)
        {
        double elem=x[k];
        
        double c1point=clusterpoint[0];
        double c2point=clusterpoint[1];
        double power=m/(m-1);
        
        
        double firstterm=(elem-c1point)/(elem-c2point);
        
        double secondtterm=(elem-c2point)/(elem-c1point); 
        double denominatorfirst=1+Math.pow(firstterm,power);
        
        double denominatorsecond=1+Math.pow(secondtterm,power);
        
        double overall1=(1/denominatorfirst)*100;
        double overall2=(1/denominatorsecond)*100;
        if(overall1>overall2){
         data1.add(elem+"");
        }else
        {
        data2.add(elem+"");
        }
//        System.out.println(overall1+" "+overall2);
         c1pointnewcluster=c1pointnewcluster+(Math.pow(overall1,2))*elem;
         c2pointnewcluster=c2pointnewcluster+(Math.pow(overall2,2))*elem;
        
         denominoterfirst=denominoterfirst+(Math.pow(overall1,2));
           denominoterfsecond=denominoterfsecond+(Math.pow(overall2,2));
        }
    
       
        
        double c1net=c1pointnewcluster/denominoterfirst;
        double c2net=c2pointnewcluster/denominoterfsecond;
        
        
        System.out.println(data1+" "+data2);
        
         System.out.println(c1net+" "+c2net);
        if(mval==0){
           userdata1.add(c1net+" "+c2net);
        }
        
           
           mval++;
           return c1net+" "+c2net;
    }
    
    
}
