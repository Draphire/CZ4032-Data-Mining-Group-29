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
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.core.AttributeStats;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.core.converters.ArffSaver;
import java.io.File;
import weka.core.converters.ConverterUtils.DataSource;
import weka.experiment.Stats;

public class AttrSelection{
	public static void main(String args[]) throws Exception{
		//load dataset
		DataSource source = new DataSource("data\\TerrorismDataResampled.csv");
		Instances dataset = source.getDataSet();
		//create AttributeSelection object
		AttributeSelection filter = new AttributeSelection();
		//create evaluator and search algorithm objects
		CfsSubsetEval eval = new CfsSubsetEval();
		GreedyStepwise search = new GreedyStepwise();
		//set the algorithm to search backward
		search.setSearchBackwards(true);
		//set the filter to use the evaluator and search algorithm
		filter.setEvaluator(eval);
		filter.setSearch(search);
		//specify the dataset
		filter.setInputFormat(dataset);
		//apply
		Instances data = Filter.useFilter(dataset, filter);
		//save
		   if (data.classIndex() == -1) {
		       data.setClassIndex(data.numAttributes() - 1);
		    }
		   
		    //get number of attributes (notice class is not counted)
			int numAttr = data.numAttributes()-1;
			for (int i = 0; i < numAttr; i++) {
				
				
				System.out.println("The "+i+ "th Attribute is " + data.attribute(i).name());
				
				//check if current attr is of type nominal
//				if (data.attribute(i).isNominal()) {
//					System.out.println("The "+i+"th Attribute is Nominal");	
//					//get number of values
//					int n = data.attribute(i).numValues();
//					System.out.println("The "+i+"th Attribute has: "+n+" values");
//					
//				}			
//				
//				//get an AttributeStats object
//				AttributeStats as = data.attributeStats(i);
//				int dC = as.distinctCount;
//				System.out.println("The "+i+"th Attribute has: "+dC+" distinct values");
//				
//				//get a Stats object from the AttributeStats
//				if (data.attribute(i).isNumeric()){
//					System.out.println("The "+i+"th Attribute is Numeric");	
//				    Stats s = as.numericStats;
//				    System.out.println("The "+i+"th Attribute has min value: "+s.min+" and max value: "+s.max+" and mean value: "+s.mean);
//				}
			}
			//get number of instances
//			int numInst = data.numInstances();
//			int missingCountHeight = 0;
//			//loop through all instances
//			for (int j = 0; j < numInst; j++) {
//				//get the j'th instance
//				Instance instance = data.instance(j);
//				//check if 1st attr is missing from the j'th instance
//				if (instance.isMissing(4)) {
//					missingCountHeight++;
//				}
//				
//				
//				
//				//check if the class is missing from the j'th instance
//				if (instance.classIsMissing()) {
//					System.out.println("The class is missing in the "+j+"th Instance");		
//				}
//				//if you want to access the value of Class in your data
//				//notice classes of type nominal and string are given ID's
////				double cV = instance.classValue();
////				System.out.println(instance.classAttribute().value((int)cV));
//				
//			}
//			System.out.println("The "+4+"th has " + missingCountHeight + " Missing Values");	
//			
//			
		}
//		
//		
//		ArffSaver saver = new ArffSaver();
//		saver.setInstances(newData);
//		saver.setFile(new File("data\\TerrorismDataResampled.csv"));
//		saver.writeBatch();
	}

