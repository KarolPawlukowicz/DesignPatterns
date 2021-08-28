package com.pawlukowicz;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;

public class Chart {
    private DefaultXYDataset ds;
    private XYDataset dataset;
    private JFrame frame;

    public Chart(){
        dataset = new DefaultXYDataset();
        ds = new DefaultXYDataset();
    }

    public XYDataset createDataset() {
        double[][] data = { {0.1, 0.2, 0.3}, {1, 2, 3} };

        ds.addSeries("series1", data);

        return ds;
    }

    public void addDataset(String name, double[][] data){
        ds.addSeries(name, data);
    }


    public void createChart(){
        frame = new JFrame("Charts");
        dataset = ds;
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JFreeChart chart =
                ChartFactory.createXYLineChart("Compare sorting algorithms",
                        "Array size", "Time",
                        dataset, PlotOrientation.VERTICAL, true, true,
                        false);

        ChartPanel cp = new ChartPanel(chart);
        frame.getContentPane().add(cp);
    }
}
