
import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
//Main class
public class AgeBasedList {
	//Map class implementation
	public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, NullWritable> {
		
		private Text uId = new Text();
		//Map function			
		public void map(LongWritable key, Text value, OutputCollector<Text, NullWritable> output, Reporter reporter) throws IOException {
			
			String age ="" ;
			String uid ="";
			String gender ="";
			int iAge=0;
			
			String line = value.toString();//read a line from the input file
			age = line.split("::")[2];//Parse the age
			uid =line.split("::")[0];//User Id
			gender =line.split("::")[1];//and Gender
			
			iAge=Integer.parseInt(age);
			//check if age is less then or equal to 7 and gender is Male
			if(iAge <=7 && gender.equals("M")) {
				uId.set(uid);
				output.collect(uId, NullWritable.get());//Then emit UserId and Null as the key
			}
		}
	}
	//main function
	public static void main(String[] args) throws Exception {
		//Job config object
		JobConf conf = new JobConf(AgeBasedList.class);
		//job name
		conf.setJobName("AgeBasedList");
				
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(NullWritable.class);
		//Only map class instantiation
		conf.setMapperClass(Map.class);   
			
		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);
				
		FileInputFormat.setInputPaths(conf, new Path(args[0]));//input directory in dfs
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));//output directory in dfs
				
		JobClient.runJob(conf);
		
	}
}
