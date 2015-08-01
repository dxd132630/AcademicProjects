///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//															Author:Deepti Deshpande																		     //
//Hadoop MapReduce approach for listing the TopK Ngram used in the Google Books. This method reads the files from the input location and then filters the    //
//Records based on the year passed in the command line. In the mapper phase we create the list of frequently used Top K words into the TreeMap mapTopN. And  //
//in the reducer we use this mapTopN array list from all the other mappers to find the frequently used Top K words.											 //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package org.myorg;
import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;
import org.apache.hadoop.mapreduce.Job ;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
public class topN {

	public static class Map extends Mapper<Object, Text, NullWritable, Text> {
		private TreeMap<Integer, Text> mapTopN = new TreeMap<Integer, Text>();
		private static int K; //command line parameter passed to mapper 
		private static int Year;//command line parameter passed to mapper 
		public void configure(JobConf job) {    
			K = Integer.parseInt(job.get("N")); 
			Year = Integer.parseInt(job.get("yr"));
		}

		@Override
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String line="";//read line by line of the file into this variable
			String ngram=""; 
			int ngYear=0; 
			int ngCount=0; 
			try{
				line = value.toString(); 
				ngYear = Integer.parseInt(line.split("\t")[1]) ; //get the year of the record
				if(ngYear ==Year){ //Filter those records that match the desired year
					ngram = line.split("\t")[0]; 
					ngCount = Integer.parseInt(line.split("\t")[2]); 
					mapTopN.put(n.count,n.ngram); //add the parsed word and the count to TreeMap if the year match
					if(mapTopN.size()>K){ //if the count of the treeMap is greater than the required top K then remove the least frequent word from bottom
						mapTopN.remove(mapTopN.firstKey());
					}
				}
			}
			catch(IndexOutOfBoundsException e){ 
				System.out.println("Ivalid Input"); 
			}
		}
		//map all the key-value pair with the single key to be grouped in the reduce pahse
		protected void cleanup(Context context) throws IOException, InterruptedException {
			for (Text t : mapTopN.values()) {
				context.write(NullWritable.get(), t);
			}
		}
	}
	//reducer class
	public static class Reduce extends Reducer<NullWritable, Text, NullWritable, Text> {
		private TreeMap<Integer, Text> mapTopN = new TreeMap<Integer, Text>();
			public void reduce(NullWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			for (Text value : values) {
				mapTopN.put(value,key);
				//get only the Top K ngrams from mapper
				if (mapTopN.size() > K) {
					mapTopN.remove(mapTopN.firstKey());
				}
			}

			for (Text t : mapTopN.descendingMap().values()) {
				context.write(NullWritable.get(), t);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = new Job(conf, "topK Ngrams");
		conf.set("N", args[2]); //pass the N value form command line to the mapper
		conf.set("yr", args[3]); //pass the year to be filtered to the job
		job.setJarByClass(topN.class);
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		job.setNumReduceTasks(1);
		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}