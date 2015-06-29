
import java.io.IOException;
import java.util.*;
     
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
//main class    
public class AgeGrouping {
    //Mapper class implementation
	public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
          
		private final static IntWritable one = new IntWritable(1);
        
		private Text val = new Text();
        //map function
		public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
				
			String age ="" ;
			String gender ="";
			int iAge=0;
			
			String line = value.toString();//read the line from the input file
			age = line.split("::")[2];//parse age
			gender =line.split("::")[1];//and gender 
			iAge=Integer.parseInt(age);//conver the age to int
			//Using Age and gender as key and 1 as value in Mapper
			if(iAge <=18) {//if age is less then 18
				
				val.set("7"+" "+gender); //emit 7 and gender based on the gender
				output.collect(val, one);
			}
			
			else if(iAge >=18 && iAge <=24 ) {//if age is b/w 18 -24
				
				val.set("24"+" "+gender);//emit 24 and gender
				output.collect(val, one);
			}
			
			else if(iAge >= 25 && iAge <=34 ) {//if age is b/w 25 -34
				
				val.set("31"+" "+gender);//emit 31 and gender
				output.collect(val, one);
			}
			
			else if(iAge >= 35 && iAge <=44) {//if age is between 35 and 44
				
				val.set("41"+" "+gender);//emit 41 and gender
				output.collect(val, one);
			}
			
			else if(iAge >= 45 && iAge <=54 ) {//if age is between 45 and 54
				
				val.set("51"+" "+gender); //emit 51
				output.collect(val, one);
			}
			
			else if(iAge >= 55 && iAge <=61) {//if age is between 55 and 61
				
				val.set("56"+" "+gender);//emit 56
				output.collect(val, one);
			}
			
			else if(iAge >=62) {
				
				val.set("62"+" "+gender); //if age is greater then or equal to 62 emit 62
				output.collect(val, one);
			}
			
		}
	}
    //REduce class implementation 
	public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
		//reduce function
		public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
			
			int sum = 0;
			
			while (values.hasNext()) {//For the given key if count the number of values
				
				sum += values.next().get();	
				
			}
			
			output.collect(key, new IntWritable(sum));//emit the count of males or females based on the age group
		}
	}
    //main function
    public static void main(String[] args) throws Exception {
    	
		JobConf conf = new JobConf(AgeGrouping.class);
		
		conf.setJobName("AgeGrouping");
			 
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		conf.setMapperClass(Map.class);
		
		conf.setCombinerClass(Reduce.class);
		conf.setReducerClass(Reduce.class);
		
		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);
		
		FileInputFormat.setInputPaths(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		
		JobClient.runJob(conf);
    }
}
