package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import dao.RecordDao;
import entity.Record;


public class ChartUtil {
	
	public static double max(double[] sampleValues) {
		ArrayList<Double> al = new ArrayList<>();
		for(double d: sampleValues) {
			al.add(d);
		}
		double res = al.stream().distinct().sorted((i,j)->i>=j?-1:1).findFirst().get();
		return res ;
	}
	 
	public static String[]  sampleLabels() {
		String[] labels = new String[30];
		for (int i = 0; i < 30; i++) {
			if(0 == i%5 ) {
				labels[i] = String.valueOf(i+1) + "日";
			}
		}
		return labels;
	}
	
	public static String[]  sampleLabels(double[] samples) {
		String[] labels = new String[samples.length];
		for (int i = 0; i < 30; i++) {
			if(0 == i%5 ) {
				labels[i] = String.valueOf(i+1) + "日";
			}
		}
		return labels;
	}
	
	public static double[]  sampleValues() {
		double[] values = new double[30];
		for (int i = 0; i < values.length; i++) {
			values[i] = (int) (Math.random() * 300);
		}
		return values;
	}
	
	public static double[]  sampleValues(double[] samples) {
		double[] values = samples;
		return values;
	}
	
	public static Image getImage(int w, int h,double[] samples) {
		double[] sample_values;
		String[] sample_labels;
		if(samples == null) {
			sample_values =  sampleValues();
			sample_labels = sampleLabels();
		}else {
			sample_values =  sampleValues(samples);
			sample_labels = sampleLabels(samples);
		}
		int max = (int) max(sample_values);
		Color[] sample_color =  new Color[] {ColorUtil.blueColor};
		
		BarChart chart = new BarChart();
		chart.setSampleCount(sample_values.length);
		chart.setSampleLabels(sample_labels);
		chart.setSampleValues(0, sample_values);
		chart.setSampleColors(sample_color);
		chart.setRange(0, max*1.2);
		chart.setValueLinesOn(true);
		chart.setSampleLabelsOn(true);
		chart.setSampleLabelStyle(Chart.BELOW);
        chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
        chart.setLegendOn(true);
        chart.setLegendPosition(Chart.LEFT);
        chart.setLegendLabels(new String[] { "月消费报表" });
        chart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
        chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
        chart.setChartBackground(Color.white);
        chart.setBackground(ColorUtil.backgroundColor);
        Image img = chart.getImage(w,h);
		return img;
	}
}
