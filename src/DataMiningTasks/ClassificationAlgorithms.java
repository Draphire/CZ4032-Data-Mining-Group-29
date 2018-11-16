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

package DataMiningTasks;
//import required classes
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.functions.SMO;
import weka.classifiers.lazy.IBk;
public class ClassificationAlgorithms{
	
	public static void RunClassificationTasks(Instances dataset){
		
		dataset.setClassIndex(dataset.numAttributes()-1);
		//create and build the classifier!
	
		try {
			System.out.println("\n  ----- Evaluating, Please wait, may take a minute (or eternity) depending on your PC -----  \n\n");
			
			NaiveBayes nb = new NaiveBayes();
			nb.buildClassifier(dataset);
			
			IBk knn = new IBk();
			knn.buildClassifier(dataset);
			
			RandomForest rf = new RandomForest();
			rf.buildClassifier(dataset);
			
			SMO svm = new SMO();
			svm.buildClassifier(dataset);	
			
			
			String[] options = new String[4];
			options[0] = "-C"; options[1] = "0.11";
			options[2] = "-M"; options[3] = "3";
			J48 tree = new J48();
			tree.setOptions(options);
			tree.buildClassifier(dataset);
			//System.out.println(tree.getCapabilities().toString());
			
			
			//Evaluate output Results for Decision Tree
			
			
			Random rand = new Random(1);
			int folds = 10;
			
			Evaluation eval = new Evaluation(dataset);
			
			eval.crossValidateModel(tree, dataset, folds, rand);
			System.out.println("Decision Tree --------------- \n Evaluation results:\n");		
			ResultStringOutput(eval);

			eval.crossValidateModel(nb, dataset, folds, rand);
			System.out.println("Naive Bayes --------------- \n Evaluation results:\n");		
			ResultStringOutput(eval);
			
			eval.crossValidateModel(knn, dataset, folds, rand);
			System.out.println("Decision Tree --------------- \n Evaluation results:\n");		
			ResultStringOutput(eval);
			
			eval.crossValidateModel(rf, dataset, folds, rand);
			System.out.println("Decision Tree --------------- \n Evaluation results:\n");		
			ResultStringOutput(eval);
			
			eval.crossValidateModel(svm, dataset, folds, rand);
			System.out.println("Support Vector Machine --------------- \n Evaluation results:\n");		
			ResultStringOutput(eval);
			
			//System.out.println("\n Decision Tree Diagram Output \n"+tree.graph());
			
			
			
//			System.out.println(eval.toSummaryString("Decision Tree --------------- \n Evaluation results:\n", false));
//			
//			System.out.println("Correct % = "+eval.pctCorrect());
//			System.out.println("Incorrect % = "+eval.pctIncorrect());
//			System.out.println("AUC = "+eval.areaUnderROC(1));
//			System.out.println("kappa = "+eval.kappa());
//			System.out.println("MAE = "+eval.meanAbsoluteError());
//			System.out.println("RMSE = "+eval.rootMeanSquaredError());
//			System.out.println("RAE = "+eval.relativeAbsoluteError());
//			System.out.println("RRSE = "+eval.rootRelativeSquaredError());
//			System.out.println("Precision = "+eval.precision(1));
//			System.out.println("Recall = "+eval.recall(1));
//			System.out.println("fMeasure = "+eval.fMeasure(1));
//			System.out.println("Error Rate = "+eval.errorRate());
//		    //the confusion matrix
//			System.out.println(eval.toMatrixString("=== Overall Confusion Matrix ===\n"));
//		        

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//print out capabilities
	
		
	}
	
	public static void ResultStringOutput (Evaluation eval){
		
			
		try {	
			System.out.println(eval.toSummaryString("\n\n --------------- Evaluation results:\n", false));
			
			System.out.println("Correct % = "+eval.pctCorrect());
			System.out.println("Incorrect % = "+eval.pctIncorrect());
			System.out.println("AUC = "+eval.areaUnderROC(1));
			System.out.println("kappa = "+eval.kappa());
			System.out.println("MAE = "+eval.meanAbsoluteError());
			System.out.println("RMSE = "+eval.rootMeanSquaredError());
			System.out.println("RAE = "+eval.relativeAbsoluteError());
			
			System.out.println("RRSE = "+eval.rootRelativeSquaredError());
			System.out.println("Precision = "+eval.precision(1));
			System.out.println("Recall = "+eval.recall(1));
			System.out.println("fMeasure = "+eval.fMeasure(1));
			System.out.println("Error Rate = "+eval.errorRate());
		    //the confusion matrix
			System.out.println(eval.toMatrixString("=== Overall Confusion Matrix ===\n"));
		
				} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
