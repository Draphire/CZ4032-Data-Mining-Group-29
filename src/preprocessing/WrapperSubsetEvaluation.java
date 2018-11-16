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
import weka.attributeSelection.BestFirst;
//import required classes
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.attributeSelection.WrapperSubsetEval;
import weka.core.AttributeStats;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.core.converters.ArffSaver;
import java.io.File;
import weka.core.converters.ConverterUtils.DataSource;
import weka.experiment.Stats;

public class WrapperSubsetEvaluation{
	public static void WrapperEvaluation (Instances dataset){
		dataset.setClassIndex(dataset.numAttributes() - 1);
		
		//create AttributeSelection object
		AttributeSelection filter = new AttributeSelection();
		//create evaluator and search algorithm objects
		WrapperSubsetEval eval = new WrapperSubsetEval();
		BestFirst search = new BestFirst();
		
		//set the algorithm to search backward
		String[] options = new String[4];
		options[0] = "-D";   // attribute index
		options[1] = "0";    // 5
		options[2] = "-N";   // match if value is smaller than
		options[3] = "5"; 
		Instances data = null;
		try {
			search.setOptions(options);
			filter.setEvaluator(eval);
			filter.setSearch(search);
			//specify the dataset
			filter.setInputFormat(dataset);
			//apply
		 data = Filter.useFilter(dataset, filter);
			
			int numAttr = data.numAttributes()-1;
			for (int i = 0; i < numAttr; i++) {
				
				
				System.out.println("The "+i+ "th Attribute is " + data.attribute(i).name());
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	}

