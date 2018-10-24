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

package weka.api;
//import required classes
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;

import java.io.File;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;

public class DiscretizeAttribute{
	public static void main(String args[]) throws Exception{
		//load dataset
		DataSource source = new DataSource("data\\athlete_events.csv");
		Instances dataset = source.getDataSet();		
		//set options
		String[] options = new String[4];
		//choose the number of intervals, e.g. 2 :
		options[0] = "-B"; options[1] = "4";
		//choose the range of attributes on which to apply the filter:
		options[2] = "-R";
		options[3] = "4-6";
		//options[4] = "-V";
		//Apply discretization:
		Discretize discretize = new Discretize();
		discretize.setOptions(options);
		discretize.setInputFormat(dataset);
		Instances newData = Filter.useFilter(dataset, discretize);

		
		ArffSaver asaver = new ArffSaver();
		asaver.setInstances(newData);
		asaver.setFile(new File("data\\athlete_events_discretized.arff"));
		asaver.writeBatch();
		
		CSVSaver saver = new CSVSaver();
		saver.setInstances(newData);
		saver.setFile(new File("data\\athlete_events_discretized.csv"));
		saver.writeBatch();
	}
}
