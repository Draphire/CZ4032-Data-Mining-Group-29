package preprocessing;

import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.Resample;
import weka.filters.unsupervised.attribute.Remove;

public class DataResampling {
	public static void main(String args[]) throws Exception{
		
		DataSource source = new DataSource("data\\googleplaystoredata.csv");
		
		Instances dataset = source.getDataSet();
		dataset.setClassIndex(dataset.numAttributes() - 1);
		 
		//Instances dataset = new Instances(new BufferedReader(new FileReader("data\\googleplaystoredata.csv")));
		
		//System.out.println(dataset.toSummaryString());
		
		Resample r = new Resample(); 
		r.setNoReplacement(true); 
		r.setSampleSizePercent(1); // or whatever % you require 
		r.setInputFormat(dataset); 
		  
//		String[] opts = new String[]{ "-R", "12" };
//		
//		Remove remove = new Remove();
//		
//		remove.setOptions(opts);
//
//		remove.setInputFormat(dataset);
		
		Instances newData = Filter.useFilter(dataset, r);
		
//		
//		ArffSaver saver = new ArffSaver();
//		saver.setInstances(newData);
//		saver.setFile(new File("data\\new.arff"));
//		saver.writeBatch();
	}
	
	public static Instances resampleData(Instances dataset){
		
		
	//System.out.println(dataset.toSummaryString());
		
		Resample r = new Resample(); 
		r.setNoReplacement(true); 
		r.setSampleSizePercent(1); // or whatever % you require 
//		try {
//			r.setInputFormat(dataset);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		  
//		String[] opts = new String[]{ "-R", "12" };
//		
//		Remove remove = new Remove();
//		
//		remove.setOptions(opts);
//
//		remove.setInputFormat(dataset);
	//	Instances newData = Filter.useFilter(dataset, r);
		Instances newData = null;
		try {
			r.setInputFormat(dataset);
			
			newData = Filter.useFilter(dataset, r);
			newData.setClassIndex(newData.numAttributes() - 1);
		//	System.out.println(newData.toSummaryString());
			
			System.out.println("Data Resampled ///////////////////////////////////// \n");
			
			return newData;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dataset;
		
	}
	
	
}
