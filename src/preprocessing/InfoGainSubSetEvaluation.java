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

import weka.attributeSelection.CorrelationAttributeEval;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;

import weka.core.Instances;

import weka.filters.supervised.attribute.AttributeSelection;


import weka.core.converters.ConverterUtils.DataSource;

public class InfoGainSubSetEvaluation {
	public static void InfoGainSubSet (Instances dataset){
		dataset.setClassIndex(dataset.numAttributes() - 1);
		   //  cls.buildClassifier(data);
			// create AttributeSelection object
			AttributeSelection filter = new AttributeSelection();
			// create evaluator and search algorithm objects
			InfoGainAttributeEval eval = new InfoGainAttributeEval();
			Ranker search = new Ranker();
			search.setGenerateRanking(true);
			search.setNumToSelect(-1);
			search.setThreshold(-1.7976931348623157E308);
			// set the algorithm to search backward
			// set the algorithm to search backward
			// search.setSearchBackwards(true);
			// set the filter to use the evaluator and search algorithm
			try {
				eval.buildEvaluator(dataset);
				System.out.println("\n InfoGain Attribute Evaluation ///////////////////////////////////// \n");
				
				for (int i = 0; i < 20; i++) {
					double v = eval.evaluateAttribute(i);
					 System.out.print(i+""+dataset.attribute(i).name()+"\t\t");
					System.out.println(v);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
