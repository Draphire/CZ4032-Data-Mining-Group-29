package util;

import weka.core.Instances;
import weka.core.converters.CSVSaver;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class LoadSaveData {
	
	public static void main(String args[]) throws Exception{
		
		DataSource source = new DataSource("data\\googleplaystoredata.csv");
		
		Instances dataset = source.getDataSet();
		//Instances dataset = new Instances(new BufferedReader(new FileReader("data\\googleplaystoredata.csv")));
		
		System.out.println(dataset.toSummaryString());
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(dataset);
		saver.setFile(new File("data\\new.arff"));
		saver.writeBatch();
	}

}
