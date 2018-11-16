package preprocessing;

import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.Resample;
import weka.filters.unsupervised.attribute.Remove;

public class DataResampling {
	
	public static Instances resampleData(Instances dataset){

		Resample r = new Resample(); 
		r.setNoReplacement(true); 
		r.setSampleSizePercent(1); // or whatever % you require 

		Instances newData = null;
		try {
			r.setInputFormat(dataset);
			
			newData = Filter.useFilter(dataset, r);
			newData.setClassIndex(newData.numAttributes() - 1);

			System.out.println("Data Resampled ///////////////////////////////////// \n");
			return newData;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataset;
	}
	
}
