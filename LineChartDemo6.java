/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classificationcrime;

/**
 *
 * @author Shuchita
 */
import Database.DatabaseConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;



/**
 * A simple demonstration application showing how to create a line chart using data from an
 * {@link XYDataset}.
 *
 */
public class LineChartDemo6 extends javax.swing.JFrame {
static DatabaseConnection db;
	static String columndata="";
	 static Connection con;
    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public LineChartDemo6(final String title) {

        super(title);
  db = new DatabaseConnection();
		con=db.dbconnection();
        try {
            final XYDataset dataset = createDataset();
            final JFreeChart chart = createChart(dataset);
            final ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
            setContentPane(chartPanel);
           
        } catch (SQLException ex) {
            Logger.getLogger(LineChartDemo6.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Creates a sample dataset.
     * 
     * @return a sample dataset.
     */
    private XYDataset createDataset() throws SQLException {
        
        db.dbconnection();
        
         String sql1="select * from graphtable t where t.type='N'";
         
       
//			    		ps1 = db.getResultSet(sql);
         // ps1.setString(1, "1" );
          final XYSeries series1 = new XYSeries("");
          ArrayList<Float> priceavg=new ArrayList<Float>();
         ResultSet rs1= db.getResultSet(sql1);
          final XYSeries series2 = new XYSeries("FCM time requrement");
            final XYSeries series3 = new XYSeries("K means time requirement");
            double additiondummy=1000;
            int idobt=0;
         while(rs1.next()) {
             idobt++;
             double valofid=idobt;//Double.parseDouble(rs1.getString("id"));
              double valofprice=Double.parseDouble(rs1.getString("time"));
               
               
            series1.add(valofid,valofprice); 
              series2.add(valofid, valofprice);
             
         }
        
        String sql11="select * from graphtable t where t.type='I'";
         
         ResultSet rs11= db.getResultSet(sql11);
//			    		ps1 = db.getResultSet(sql);
         // ps1.setString(1, "1" );
         int idobt1=0;
         while(rs11.next()) {
             idobt1++;
             double valofid=idobt1;//Double.parseDouble(rs11.getString("id"));
              double valofprice=Double.parseDouble(rs11.getString("time"));
               
               
            series3.add(valofid, valofprice);
             
         }
         
        
       
//        series1.add(1.0, 1.0);
//        series1.add(2.0, 4.0);
//        series1.add(3.0, 3.0);
//        series1.add(4.0, 5.0);
//        series1.add(5.0, 5.0);
//        series1.add(6.0, 7.0);
//        series1.add(7.0, 7.0);
//        series1.add(8.0, 8.0);

       
//        series2.add(1.0, 5.0);
//        series2.add(2.0, 7.0);
//        series2.add(3.0, 6.0);
//        series2.add(4.0, 8.0);
//        series2.add(5.0, 4.0);
//        series2.add(6.0, 4.0);
//        series2.add(7.0, 2.0);
//        series2.add(8.0, 1.0);

//        final XYSeries series3 = new XYSeries("Third");
//        series3.add(3.0, 4.0);
//        series3.add(4.0, 3.0);
//        series3.add(5.0, 2.0);
//        series3.add(6.0, 3.0);
//        series3.add(7.0, 6.0);
//        series3.add(8.0, 3.0);
//        series3.add(9.0, 4.0);
//        series3.add(10.0, 3.0);

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
       dataset.addSeries(series3);
                
        return dataset;
        
    }
    
    /**
     * Creates a chart.
     * 
     * @param dataset  the data for the chart.
     * 
     * @return a chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "Crime Prediction",      // chart title
            "Id",                      // x axis label
            "Time",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
  //      legend.setDisplaySeriesShapes(true);
        
        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.white);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.black);
        plot.setRangeGridlinePaint(Color.black);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.
                
        return chart;
        
    }

    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final LineChartDemo6 demo = new LineChartDemo6("Line Chart Demo 6");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}

         