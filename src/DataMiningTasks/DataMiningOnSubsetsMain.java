package DataMiningTasks;

import preprocessing.DataResampling;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class DataMiningOnSubsetsMain {
	public static void main(String args[]) throws Exception{
		DataSource source = new DataSource("data\\TerrorismDataBinaryBaseline.csv");
		Instances dataset = DataResampling.resampleData(source.getDataSet());
		dataset.setClassIndex(dataset.numAttributes() - 1);
		
		ClassificationAlgorithms.RunClassificationTasks(dataset);
	
	}
	
}
