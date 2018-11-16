package MainClassesForRunning;

import preprocessing.CorrelationSubSetEvaluation;
import preprocessing.DataResampling;
import preprocessing.GainRatioSubSetEvaluation;
import preprocessing.InfoGainSubSetEvaluation;
import preprocessing.WrapperSubsetEvaluation;
import util.Const;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class FeatureSubsetSelectionMain {
	public static void main(String args[]) throws Exception{
		
		//Run to conduct Feature Subset Selection on Baseline (all attributes) with class label declared  
		
		DataSource source = new DataSource(Const.ALL_ATTRIBUTE_BASELINE_BINARY);
		Instances dataset = DataResampling.resampleData(source.getDataSet());
		dataset.setClassIndex(dataset.numAttributes() - 1);
		
	
		CorrelationSubSetEvaluation.CorrelationSubSet(dataset);
		InfoGainSubSetEvaluation.InfoGainSubSet(dataset);
		GainRatioSubSetEvaluation.GainRatioSubSet(dataset);
		WrapperSubsetEvaluation.WrapperEvaluation(dataset);
		
		
	}
}
