package MainClassesForRunning;

import DataMiningTasks.ClassificationAlgorithms;
import preprocessing.DataResampling;
import util.Const;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class DataMiningOnSubsetsMain {
	public static void main(String args[]) throws Exception{

		//Run to conduct all data mining tasks for every subset derived from feature subset selection
		
		DataSource source ;
		Instances dataset;
		
		 source = new DataSource(Const.ALL_ATTRIBUTE_BASELINE_BINARY);
		 dataset = DataResampling.resampleData(source.getDataSet());
		dataset.setClassIndex(dataset.numAttributes() - 1);
		System.out.println("\n ALL_ATTRIBUTE_BASELINE_BINARY Evaluation ///////////////////////////////////// \n");
		
		ClassificationAlgorithms.RunClassificationTasks(dataset);
		
		 source = new DataSource(Const.ALL_ATTRIBUTE_BASELINE_CATEGORICAL);
		 dataset = DataResampling.resampleData(source.getDataSet());
		dataset.setClassIndex(dataset.numAttributes() - 1);
		System.out.println("\n ALL_ATTRIBUTE_BASELINE_CATEGORICAL Evaluation ///////////////////////////////////// \n");
		
		ClassificationAlgorithms.RunClassificationTasks(dataset);
		
		 source = new DataSource(Const.CORRELATION_SUBSET_BINARY);
		 dataset = DataResampling.resampleData(source.getDataSet());
		dataset.setClassIndex(dataset.numAttributes() - 1);
		System.out.println("\n CORRELATION_SUBSET_BINARY Evaluation ///////////////////////////////////// \n");
		
		ClassificationAlgorithms.RunClassificationTasks(dataset);
		
		 source = new DataSource(Const.CORRELATION_SUBSET_CATEGORICAL);
		 dataset = DataResampling.resampleData(source.getDataSet());
		dataset.setClassIndex(dataset.numAttributes() - 1);
		System.out.println("\n CORRELATION_SUBSET_CATEGORICAL Evaluation ///////////////////////////////////// \n");
		
		ClassificationAlgorithms.RunClassificationTasks(dataset);
		
		 source = new DataSource(Const.INFOGAIN_SUBSET_BINARY);
		 dataset = DataResampling.resampleData(source.getDataSet());
		dataset.setClassIndex(dataset.numAttributes() - 1);
		System.out.println("\n INFOGAIN_SUBSET_BINARY Evaluation ///////////////////////////////////// \n");
		
		ClassificationAlgorithms.RunClassificationTasks(dataset);
	
		
		 source = new DataSource(Const.INFOGAIN_SUBSET_CATEGORICAL);
		 dataset = DataResampling.resampleData(source.getDataSet());
		dataset.setClassIndex(dataset.numAttributes() - 1);
		System.out.println("\n INFOGAIN_SUBSET_CATEGORICAL Evaluation ///////////////////////////////////// \n");
		
		ClassificationAlgorithms.RunClassificationTasks(dataset);
		
		
		 source = new DataSource(Const.GAINRATIO_SUBSET_BINARY);
		 dataset = DataResampling.resampleData(source.getDataSet());
		dataset.setClassIndex(dataset.numAttributes() - 1);
		System.out.println("\n GAINRATIO_SUBSET_BINARY Evaluation ///////////////////////////////////// \n");
		
		ClassificationAlgorithms.RunClassificationTasks(dataset);
		
		 source = new DataSource(Const.GAINRATIO_SUBSET_CATEGORICAL);
		 dataset = DataResampling.resampleData(source.getDataSet());
		dataset.setClassIndex(dataset.numAttributes() - 1);
		System.out.println("\n GAINRATIO_SUBSET_CATEGORICAL Evaluation ///////////////////////////////////// \n");
		
		ClassificationAlgorithms.RunClassificationTasks(dataset);
		
	}
	
}
