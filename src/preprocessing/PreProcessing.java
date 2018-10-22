/*
 *  How to use WEKA API in Java 
 *  Copyright (C) 2014 
 *  @author Dr Noureddin M. Sadawi (noureddin.sadawi@gmail.com)
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it as you wish ... 
 *  I ask you only, as a professional courtesy, to cite my name, web page 
 *  and my YouTube Channel!
 *  
 */

package preprocessing;
//import required classes
import weka.experiment.Stats;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.RemoveWithValues;

import java.io.File;

import weka.core.AttributeStats;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;

public class PreProcessing {
	public static void main(String args[]) throws Exception{
		//load dataset
		DataSource source = new DataSource("data\\athlete_events.csv");
		//get instances object 
		Instances data = source.getDataSet();

		RemoveWithValues filter = new RemoveWithValues();

		String[] options = new String[3];
		options[0] = "-C";   // attribute index
		options[1] = "4";    // 5
		options[2] = "-M";   // match if value is smaller than
		//options[3] = "NA";   // 10
//		options[2] = "-L";   // match if value is smaller than
//		options[3] = "NA";   // 10
		filter.setOptions(options);

		filter.setInputFormat(data);
		Instances newData = Filter.useFilter(data, filter);
		
//		for (int i = data.numInstances() - 1; i >= 0; i--) {
//		    Instance inst = data.instance(i);
//		    if (inst.equals("NA")) {
//		        data.delete(i);
//		    }
		
//		}
//		
//		ArffSaver saver = new ArffSaver();
//		saver.setInstances(newData);
//		saver.setFile(new File("data\\athlete_events.arff"));
//		saver.writeBatch();
		
		CSVSaver saver = new CSVSaver();
		saver.setInstances(newData);
		saver.setFile(new File("data\\athlete_events_processed.csv"));
		saver.writeBatch();
		
		
		
	}

}

