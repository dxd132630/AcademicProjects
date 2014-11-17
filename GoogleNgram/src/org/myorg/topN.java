//package org.myorg;
//import java.io.IOException;
//import java.util.*;
//
//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.conf.*;
//import org.apache.hadoop.io.*;
//import org.apache.hadoop.mapred.*;
//import org.apache.hadoop.util.*;
//import org.apache.hadoop.mapreduce.Job ;
//import org.apache.hadoop.mapreduce.Reducer.Context;
//import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
//public class topN {
//
//public static class Map extends
//Mapper<Object, Text, NullWritable, Text> {
//private TreeMap<Integer, Text> repToRecordMap = new TreeMap<Integer, Text>();
//private static int K; 
//private static int Year;
//public void configure(JobConf job) {    
//K = Integer.parseInt(job.get("N")); 
//Year = Integer.parseInt(job.get("yr"));
//}
//
//@Override
//public void map(Object key, Text value, Context context)
//throws IOException, InterruptedException {
//String line="";
//String ngram=""; 
//int ngYear=0; 
//int ngCount=0; 
//try{
//line = value.toString(); 
//ngYear = Integer.parseInt(line.split("\t")[1]) ; 
//if(ngYear ==Year){
//ngram = line.split("\t")[0]; 
//ngCount = Integer.parseInt(line.split("\t")[2]); 
//repToRecordMap.put(n.count,n.ngram);
//if(repToRecordMap.size()>10){
//repToRecordMap.remove(repToRecordMap.firstKey());
//}
//}
//}
//catch(IndexOutOfBoundsException e){ 
//System.out.println("Ivalid Input"); 
//}
//}
//
//protected void cleanup(Context context) throws IOException,
//InterruptedException {
//for (Text t : repToRecordMap.values()) {
//context.write(NullWritable.get(), t);
//}
//}
//}
//
//public static class Reduce extends
//Reducer<NullWritable, Text, NullWritable, Text> {
//
//private TreeMap<Integer, Text> repToRecordMap = new TreeMap<Integer, Text>();
//
//public void reduce(NullWritable key, Iterable<Text> values,
//Context context) throws IOException, InterruptedException {
//for (Text value : values) {
//Map<String, String> parsed = MRDPUtils.transformXmlToMap(value
//.toString());
//
//repToRecordMap.put(Integer.parseInt(parsed.get("Reputation")),
//new Text(value));
//
//if (repToRecordMap.size() > 10) {
//repToRecordMap.remove(repToRecordMap.firstKey());
//}
//}
//
//for (Text t : repToRecordMap.descendingMap().values()) {
//context.write(NullWritable.get(), t);
//}
//}
//}
//
//public static void main(String[] args) throws Exception {
//Configuration conf = new Configuration();
//Job job = new Job(conf, "Top Ten Users by Reputation");
//conf.set("N", args[2]); 
//conf.set("yr", args[3]);
//job.setJarByClass(topN.class);
//job.setMapperClass(Map.class);
//job.setReducerClass(Reduce.class);
//job.setNumReduceTasks(1);
//job.setOutputKeyClass(NullWritable.class);
//job.setOutputValueClass(Text.class);
//FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
//FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
//System.exit(job.waitForCompletion(true) ? 0 : 1);
//}
//}