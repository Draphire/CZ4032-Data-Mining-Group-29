package MainClassesForRunning;

import preprocessing.CorrelationSubSetEvaluation;
import preprocessing.DataResampling;
import preprocessing.GainRatioSubSetEvaluation;
import preprocessing.InfoGainSubSetEvaluation;
import preprocessing.WrapperSubsetEvaluation;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class FeatureSubsetSelectionMain {
	public static void main(String args[]) throws Exception{
		
		
		DataSource source = new DataSource("data\\TerrorismDataBinaryBaseline.csv");
		Instances dataset = DataResampling.resampleData(source.getDataSet());
		dataset.setClassIndex(dataset.numAttributes() - 1);
		
	
		CorrelationSubSetEvaluation.CorrelationSubSet(dataset);
		InfoGainSubSetEvaluation.InfoGainSubSet(dataset);
		GainRatioSubSetEvaluation.GainRatioSubSet(dataset);
		WrapperSubsetEvaluation.WrapperEvaluation(dataset);
		
		
		
	}
}
