/****************************************************************************************************************************
 * File name : mapSideJoin.java
 * Author : Deepti Deshpande
 * Version : 1.0
 * Details : Filter userids,gender and age of users who rated the movie 4 or greater
 * Input : Distributes Cache-users.dat, ratings.dat
 ****************************************************************************************************************************/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class mapSideJoin {
	
	public static class ReplicatedJoinMapper extends Mapper<Object, Text, Text, Text> {
		/*
		 * Implementation of Map-side join/Replicated Join
		 */
	private static String mymovieid; 
	private HashMap<String, String> myMap = new HashMap<String, String>();
	private Text outvalue = new Text();
	
	public void configure(JobConf job) {	
		/*
		 * @param to assign the command line choise of movie as the filter listing the userid,gender and age of the user
		 */
		mymovieid = job.get("movieid"); 
	}
	
	protected void setup(Context context) throws IOException, InterruptedException {
		/*
		 * Setup method to load the data from distributed cache of user.dat file
		 */
			myMap = new HashMap<String, String >();
			Configuration conf = context.getConfiguration();
			mymovieid = conf.get("movieid");
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
					myMap.put(arr[0], arr[0]+" "+arr[1]+" "+arr[2]); //userid, gender and age
					line=br.readLine();
				}
				br.close();
			}
	}
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		/*
		 * Map method to list the movieid and the userid from ratings.dat file
		 */
		String[] mydata = value.toString().split("::");
			String userId = mydata[0];
			String userInformation = myMap.get(userId);
			// If the user information is not null, then output
			if (userInformation != null && mydata[1].equals(mymovieid) && Integer.parseInt(mydata[2])>=4) {
				outvalue.set("");
				context.write(new Text(userInformation), outvalue);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		
		JobConf conf = new JobConf(mapSideJoin.class);
		
		conf.setJobName("mapSideJoin");
		if (args.length != 3) {
			System.err.println("Usage: JoinExample <in><out> <anymovieid>");
			System.exit(2);
			}
		conf.set("movieid", args[2]); //setting global data variable for hadoop
		Job job = new Job(conf, "joinexc"); 
		job.setJarByClass(mapSideJoin.class);
		
		final String NAME_NODE = "hdfs://sandbox.hortonworks.com:8020";
		job.addCacheFile(new URI(NAME_NODE+ "/user/hue/user/users.dat"));;
		MultipleInputs.addInputPath(job, new Path(args[0]),TextInputFormat.class ,ReplicatedJoinMapper.class );
		job.setOutputKeyClass(Text.class);
		// set output value type
		job.setOutputValueClass(Text.class);
		//set the HDFS path of the input data
		// set the HDFS path for the output
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.waitForCompletion(true);
		}
}
