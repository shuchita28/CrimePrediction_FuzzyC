/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import Database.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Ningesh
 */
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class ScatterChartSample1 extends Application {
 Database.DatabaseConnection dbcon=new DatabaseConnection();
    @Override public void start(Stage stage) throws SQLException {
        stage.setTitle("Scatter Chart Sample");
        final NumberAxis xAxis = new NumberAxis(41.5, 42.3, 0.01);
        final NumberAxis yAxis = new NumberAxis(-87.5, -88.0, 0.01);        
        final ScatterChart<Number,Number> sc = new
            ScatterChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("Age (years)");                
        yAxis.setLabel("Returns to date");
        sc.setTitle("Investment Overview");
       
        
        String qry="select * from mainclusters";
        
        ResultSet rs=dbcon.getResultSet(qry);
        int val=1;
         XYChart.Series series1 = null;
         XYChart.Series series2 = null ;
         XYChart.Series series3 = null ;
          series1 = new XYChart.Series();
           series2 = new XYChart.Series();
           series3 = new XYChart.Series();
            series1.setName("Cluster 1");
              series2.setName("Cluster 2");
               series3.setName("Cluster 3");
//         series1.getData().add(new XYChart.Data(2.8, 33.6));
//         series1.getData().add(new XYChart.Data(2.0, 1.0));
//          series1.getData().add(new XYChart.Data(2.0, 2.0));
//           series1.getData().add(new XYChart.Data(2.0, 3.0));
        while(rs.next()){
            
         
       String clusterdata1[]=rs.getString("points").split(",");
//       double datapoint=Double.parseDouble(rs.getString("centroid"));
       
       for(int j=0;j<clusterdata1.length;j++)
       {
         String clusterdata[]=clusterdata1[j].split(" ");
       
       
//       for(int k=0;k<clusterdata.length;k++){
           
           double dataobt=Double.parseDouble(clusterdata[0]);
             double dataobt1=Double.parseDouble(clusterdata[1]); 
           
           if(val==1){
      
       
        series1.getData().add(new XYChart.Data(dataobt, dataobt1));
       }
      
       
        
          
            
                if(val==2){
    
         
      
//         series2.getData().add(new XYChart.Data(2.8, 33.6));
        series2.getData().add(new XYChart.Data(dataobt, dataobt1));
     
         }
         
       
           
         
             if(val==3){
    
          
       
//         series3.getData().add(new XYChart.Data(2.8, 33.6));
        series3.getData().add(new XYChart.Data(dataobt, dataobt1));
        
         }  
             
       
              
              
       } 
             val++; 
        
//       }
        
      
        }
        sc.getData().addAll(series1, series2,series3);
        Scene scene  = new Scene(sc, 500, 400);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}