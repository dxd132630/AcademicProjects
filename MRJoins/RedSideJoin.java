
/****************************************************************************************************************************
 * File name : RedSideJoin.java
 * Author : Deepti Deshpande
 * Version : 1.2
 * Details : Titles of top 5 average movies rated by female users.
 * Input : Distributes Cache-users.dat, ratings.dat and movies.dat 
 ****************************************************************************************************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class RedSideJoin {
	public static class RatingMapper extends Mapper<Object, Text, Text, Text> {
		
		private HashMap<String, String> userMap = new HashMap<String, String>();
		
		protected void setup(Context context) throws IOException, InterruptedException {
			/*
			 * Preprocessing of the User.dat data from the distributed cache to be joined with Ratings.dat file inorder to filter only those ratings
			 * that is given by the female users
			 */
			Configuration conf = context.getConfiguration();
			Path[] localPaths = context.getLocalCacheFiles ();
			for(Path myfile:localPaths)
			{
				String line=null;
				String nameofFile=myfile.getName();
				File file =new File(nameofFile+"");
				FileReader fr= new FileReader(file);
				BufferedReader br= new BufferedReader(fr);
				line=br.readLine();
				while(line!=null)
				{
					String[] arr=line.split("::");
					if(arr[1].equals("F")) //if female users only then emit the userid
					userMap.put(arr[0], arr[0]); //userid and userid
					line=br.readLine();
				}
				br.close();
			}
		}
		private Text movieId = new Text("");
		private Text rating;
		
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			/*
			 * Mapper method to join the data of the female userid's with the id's in Ratings.dat file to fetch the Movie id's rated by female users
			 * and to get the list of ratings
			 */
			String[] mydata = value.toString().split("::");
			String userId = mydata[0];
			String userInformation = userMap.get(userId);
			if( userInformation != null){//&& mydata[1].equals(mymovieid)
				rating = new Text("A"+mydata[1]+"~"+mydata[2]);
				movieId.set(mydata[1]);
				context.write(movieId,rating);
			}
		}
		
	}
	public static class MovieMapper extends Mapper<Object, Text, Text, Text> {
		/*
		 * Mapper method to list the Movie id's and the title of the movies from movies.dat file
		 * 
		 */
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String[] mydata = value.toString().split("::");
			context.write(new Text(mydata[0]), new Text("B"+mydata[0]+"~"+mydata[1]));
		}
		
	}
	public static class Reduce extends Reducer<Text, Text, Text, Text> {
		/*
		 * Reduce side join of the movies.dat and ratings.dat file based on the movieid and finding the average and emits the key:avg and value:Title
		 * to intermediate_output for next mapper to be consumed
		 */
		private ArrayList<Text> listA = new ArrayList<Text>();
		private ArrayList<Text> listB = new ArrayList<Text>();
		DecimalFormat f = new DecimalFormat("##.00");

		
		public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			
				listA.clear();
				listB.clear();
				int count=0;
				double sum=0.0;
				double avg = 0.0;
				
			for (Text val : values) {
				if (val.charAt(0) == 'A') {
					listA.add(new Text(val.toString().substring(1)));
				} else if (val.charAt(0) == 'B') {
					listB.add(new Text(val.toString().substring(1)));
				}
			}
			if(!listA.isEmpty() && !listB.isEmpty()){
				count =0;
				String title = null;
				sum =0;
				for(Text A:listA){
					String[] mid = A.toString().split("~");
					count++;
					sum = sum + Double.parseDouble(mid[1]);
					String movid = mid[0];
					for(Text B:listB){
						String[] bmid = B.toString().split("~");
						if(movid.contains(bmid[0])){
							title = bmid[1];
						}
					}
				}
				avg = sum / count;
				
				context.write(new Text(f.format(avg)+""), new Text(title));
				
			}
			
		}
		/*
		 * Method executed post the execution of all the reducer jobs
		 * This does the list of the TreeMap key values.
		 */
		

		
	}
	public static class FilterMapper extends Mapper<Object, Text, Text, Text> {
		/*
		 * Reads movie title and the average as key.
		 * 
		 */
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			String[] mydata = value.toString().split("\t");
			context.write(new Text(mydata[0]), new Text(mydata[1]));
		}
		
	}
	public static class Reduce2 extends Reducer<Text, Text, Text, Text> {
		/*
		 * Reducer adds the movie title and the average as key in TreeMap. This sorts the avg key and adds duplicate values to arraylist in Treemap
		 */
		private TreeMap<Text, Text> mapTopN = new TreeMap<Text,Text>();
		DecimalFormat f = new DecimalFormat("##.00");

		
		public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			Text titles = new Text();
			for( Text val:values){
				if(mapTopN.containsKey(key)){
					titles=new Text(val+"~"+mapTopN.get(key));
					mapTopN.put(new Text(key.toString()), titles);
				}
				else
					mapTopN.put(new Text(key), new Text(val));
			}
				
		}
		protected void cleanup(Context context) throws IOException,
	    InterruptedException {
		/*
		 * For every key if there are more then one values start listing the top 5 values 
		 */
		int count=0;
		for (Entry<Text, Text> entry : mapTopN.descendingMap().entrySet()) {
			Text avg = entry.getKey();
			/*
			 * Values from the reducer output have separater ~
			 */
			String[] titlelist = entry.getValue().toString().split("~");
			for(String t: titlelist){
				if(count<5){
				context.write(new Text(t),new Text(f.format(Double.parseDouble(avg.toString()))+""));count++;
				}
			}
		}
	}
	}
	
	//Driver code
	public static void main(String[] args) throws Exception {
		
		final String OUTPUT_PATH = "intermediate_output";
		JobConf conf = new JobConf(RedSideJoin.class);
				
		conf.setJobName("RedSideJoin");
		//get all args
		if (args.length != 3) {
			System.err.println("Usage: JoinExample <in> <in2> <out>");
			System.exit(2);
		}

		// create a job with name "joinexc" 
		Job job = new Job(conf, "joinexc"); 
		job.setJarByClass(RedSideJoin.class);
		//Define the location of the distributed cache
		final String NAME_NODE = "hdfs://sandbox.hortonworks.com:8020";job.addCacheFile(new URI(NAME_NODE+ "/user/hue/user/users.dat"));
		
		job.setReducerClass(Reduce.class);
		/*
		 * Multiple files that are to be read for reduce side join from HDFs locations
		 */
		MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class ,RatingMapper.class );

		MultipleInputs.addInputPath(job, new Path(args[1]),TextInputFormat.class,MovieMapper.class );

		job.setOutputKeyClass(Text.class);
		// set output value type
		job.setOutputValueClass(Text.class);

		//set the HDFS path of the input data
		// set the HDFS path for the output 
		FileOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH));
		//wait for the first job to complete 
		job.waitForCompletion(true);
		
		//create the next box for map-reduce chaining
		JobConf conf2 = new JobConf(RedSideJoin.class);
		conf2.setJobName("RedSideJoin1");
		Job job2 = new Job(conf2, "filterexec");
		//Define the mapper and the reducer class
		job2.setJarByClass(RedSideJoin.class);
		job2.setMapperClass(FilterMapper.class);
		job2.setReducerClass(Reduce2.class);
		job2.setOutputKeyClass(Text.class);
		job2.setOutputValueClass(Text.class);
		job2.setInputFormatClass(TextInputFormat.class);
		//Mapper job reads the data from the intermediate location
		TextInputFormat.setInputPaths(job2, new Path(OUTPUT_PATH));
		//Reducer writes the data to the final output location defined by the user
		FileOutputFormat.setOutputPath(job2, new Path(args[2]));
		job2.waitForCompletion(true);

	}

}


