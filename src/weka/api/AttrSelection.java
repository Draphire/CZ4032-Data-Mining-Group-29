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
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.core.converters.ArffSaver;
import java.io.File;
import java.util.BitSet;

import weka.core.converters.ConverterUtils.DataSource;

public class AttrSelection{
	public static void main(String args[]) throws Exception{
		//load dataset
		DataSource source = new DataSource("data\\googleplaystoredata.csv");
		Instances dataset = source.getDataSet();
		//create AttributeSelection object
		AttributeSelection filter = new AttributeSelection();
		//create evaluator and search algorithm objects
		CfsSubsetEval eval = new CfsSubsetEval();
//		BitSet arg0 = new BitSet(3);
//		eval.evaluateSubset(arg0);
		GreedyStepwise search = new GreedyStepwise();
		
		// GreedyStepwise search = new GreedyStepwise();
		 search.setSearchBackwards(true);
		 search.setGenerateRanking(true);
		 search.setNumToSelect(5);
		//set the algorithm to search backward
	
		//search.setSearchBackwards(true);
	
		//set the filter to use the evaluator and search algorithm
		filter.setEvaluator(eval);
		filter.setSearch(search);
		//specify the dataset
		filter.setInputFormat(dataset);
		
		//apply
		Instances newData = Filter.useFilter(dataset, filter);
		System.out.println(newData.toSummaryString());
		
		//save
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File("data\\new.arff"));
		saver.writeBatch();
	}
}
