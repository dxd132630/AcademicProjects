//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This class is the Mapreduce implementation for HW1 part 3. The class lists movie based on the genre                  //
//mentioned by the user in the command line.Usage : hadoop jar jar_file_name class_name <input_dir> <output_fir> <genre>//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//Libraries
import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
//main class
public class GenreBasedList {
	//Mapper classs implementation
	public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, NullWritable> {
		
		private Text val = new Text();
		
		private static String gen; 
		//getting the command line parameter from the main function
		public void configure(JobConf job) {	
			gen = job.get("genre"); 
		}
		//map function
		public void map(LongWritable key, Text value, OutputCollector<Text, NullWritable> output, Reporter reporter) throws IOException {
			String movie ="" ;
			String type ="";
			String line = value.toString();//read the line form the input file
			movie = line.split("::")[1];//parse the movie field
			type = line.split("::")[2];//parse the genre filed
			
			if(type.contains(gen)) { //If the movie genre of the input file is same as the command line parameter then emit
				val.set(movie);
				output.collect(val, NullWritable.get());//emit the movie name and NULL key value
			}
		}
	}
	//main function

	public static void main(String[] args) throws Exception {
		//Job config object
		JobConf conf = new JobConf(GenreBasedList.class);
		
		conf.setJobName("GenreBasedList");
		if( args.length < 3){ //error handling if the number of parameters are less then 3
			System.out.println(" Usage: hadoop jar <jar location> <class_name> <input_file_location> <output_file_location> <Movie_Genre>");
		}
		else{
			conf.set("genre", args[2]);
		
		
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(NullWritable.class);
		conf.setMapperClass(Map.class);		//Only map class instantiation
		
		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);
		
		FileInputFormat.setInputPaths(conf, new Path(args[0]));//input directory in dfs
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));//output directory in dfs
		
		JobClient.runJob(conf);
		}
	}
}