package preprocessing;

import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class AttributeFilter {
	public static void main(String args[]) throws Exception{
		
		DataSource source = new DataSource("data\\googleplaystoredata.csv");
		
		Instances dataset = source.getDataSet();
		//Instances dataset = new Instances(new BufferedReader(new FileReader("data\\googleplaystoredata.csv")));
		
		//System.out.println(dataset.toSummaryString());
		  
		String[] opts = new String[]{ "-R", "12" };
		
		Remove remove = new Remove();
		
		remove.setOptions(opts);

		remove.setInputFormat(dataset);
		
		Instances newData = Filter.useFilter(dataset, remove);
		
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File("data\\new.arff"));
		saver.writeBatch();
	}
}
