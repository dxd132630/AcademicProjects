///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//															HW 4 PART II implementation of Viterbi Algorithm							 //
//The program takes 2 parameters from command line to generate the sequence of the most probable state for the given observation sequence//
//The first argument is the model filename which has the details of the HMM model.Each model file has following details:				 //
//# of states (let’s say N)                                                                                                              //
//Initial state probabilities (N values here)																							 //
//Transition probabilities (This will contain N*N values in the transition matrix. The values are row-based.)							 //
//# of output symbols (let’s say M)																										 //
//Output alphabet (M values here. They can be discrete numbers or strings for the observations)											 //
//Output distributions (This will contain N*M values, M values for probability mass function for each state, one by one.)                //
//Second parameter is the sequence file name which has each observation sequence in a line separated by the space between each observatio//
//n character																															 //
//The output has following details: Number of states,initial matrix pi, Transition matrix a, number of observation sequence, observation //
//Characters[Note the observation characters are case sensitive the case in model file should match the test sequence file]              //
//Observation matrix b. It displays the test sequence from the <test.dat> file and shows the most probable state transition sequence for //
//that observation sequence.																											 //
//The approach followed is as each observation sequence is read the state sequence is computed by viterbi function for that sequence by  //
//computing the StateTimeMatrix which holds the maximum of the possible transion in each state for given sequence using Viterbi algorithm//
//Once the max is calculated we store the parent of each state from which we arrived at this max value in a separate 2d array called     //
//parent array.Once we have filled the parent array we find the max in the final state and do the back tracking from that state          //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package viterbi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//class for viterbi program
public class viterbi {

	float [] pi=new float[10] ;
    float [][] a=new float[10][10];
	float [][] b=new float[10][10];
	String [] outputPred = new String[10];
	int numberOfStates;
	int numberofOutput;
	public static void main(String[] args) throws IOException{
		String model_File_Name = args[0]; //Training file name
		String Test_File_Name = args[1];
		viterbi vb = new viterbi();
		vb.readModelFile(model_File_Name);
		vb.readTestFile(Test_File_Name) ;
				
}
//reads the model file and assigns the value of number of states,initial,transition,observation matrix	
public void readModelFile(String Model) throws IOException
{
	File file = new File(Model);
	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
	String line = null;
	int count=1;
	while( (line = br.readLine())!= null){
		
		if(count ==1)
		{
			numberOfStates=Integer.parseInt(line);
			System.out.println("Number of States:"+numberOfStates);
			count++;
		}
		else if(count ==2)
		{
			String[] tokens=line.split("\\s");
			for(int i=0;i<numberOfStates;i++)
			{
				pi[i]=Float.parseFloat(tokens[i]);
				System.out.print("pi["+i+"]= "+pi[i]+" ");
			}
			System.out.println();
			count++;
		}
		else if(count == 3)
		{
		
			String[] tokens = line.split("\\s+");
			for(int i=0;i<numberOfStates;i++)
			{
				for(int j=0;j<numberOfStates;j++)
				{
					a[i][j]=Float.parseFloat(tokens[(numberOfStates*i)+j]);
					System.out.print("a["+i+"]["+j+"]="+a[i][j]+" ");
					
				}
				System.out.println();
			}
			count++;
		}
		else if(count==4)
		{
			numberofOutput=Integer.parseInt(line);
			System.out.println("Number of output:"+numberofOutput);
			count++;
		}
		else if(count==5)
		{
			outputPred = line.split("\\s+");
			for(int i=0;i<numberofOutput;i++)
			{
				System.out.print("outputPred["+i+"]="+outputPred[i]+" ");
			}
			System.out.println();
			count++;
		}
		else if(count==6)
		{
			String[] tokens = line.split("\\s+");
			for(int i=0;i<numberOfStates;i++)
			{
				for(int j=0;j<numberofOutput;j++)
				{
					b[i][j]=Float.parseFloat(tokens[(numberofOutput*i)+j]);
					System.out.print("b["+i+"]["+j+"]="+b[i][j]+" ");
					
				}
				System.out.println();
			}
			count++;
		}
		
	}
	br.close();
}	
//reads the observation sequence file and makes the call to viterbi Decoding
public void readTestFile(String Test) throws IOException{
	File file = new File(Test);
	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
	String line = null;
	String [] sequence = new String[100];
	while( (line = br.readLine())!= null){
		sequence=line.split("\\s+");
		System.out.println("Given Sequence:"+line);
		ViterbiDecoding(sequence);
	}
	br.close();
}
//this function is to find the index of probability  of the observed sequence
public int observationIndicator(String s){
	int pos = 0;
	for(int i=0;i<numberofOutput;i++){
		if(s.equals(outputPred[i]))
		{
			pos =i;
		}
		else 
			continue;
	}
	return pos;
}
//this function is do perform the viterbi decoding
public void ViterbiDecoding(String [] seq){
	float [][] StateTimeMatrix=new float[100][100];
	int [][] parent=new int [100][100];
	int t;
	int obs=observationIndicator(seq[0]);
	for(int j=0;j<numberOfStates;j++)
	{
		StateTimeMatrix[j][0]=pi[j]*b[j][obs];
	}
	for(t=1;t<seq.length;t++)
	{
		obs=observationIndicator(seq[t]);
		for(int j=0;j<numberOfStates;j++)
		{
			float [] tempTrans= new float[numberOfStates];
			float max=0;
			float buffer=0;				
				for(int p=0;p<numberOfStates;p++)
				{
					tempTrans[p]=a[p][j]*b[j][obs]*StateTimeMatrix[p][t-1];
					buffer=tempTrans[p];
					if(buffer>max)
					{
						max=buffer;
						parent[j][t]=p;
						
					}
					
										
				}
				StateTimeMatrix[j][t]=max;
		}
	}
	int finalState=0;
	float finalMax=0,finalTemp;
	
	for(int x=0;x<numberOfStates;x++)
	{
		finalTemp=StateTimeMatrix[x][seq.length-1];
		
	if(finalTemp>finalMax){
		finalMax=StateTimeMatrix[x][seq.length-1];
		finalState=x;
	}
	}
	int [] StateTran=new int[100];
	StateTran[seq.length-1]=finalState;
	int current=finalState;
	for(int tran=seq.length-1;tran>0;tran--)
	{
		
		StateTran[tran-1]=parent[current][tran];
		current=parent[StateTran[tran-1]][tran];		
	}
	System.out.println("The state sequence for the given transition is");
	for(int tran=0;tran<seq.length;tran++)
	{
		System.out.print("S"+(StateTran[tran]+1)+" ");
	}
	System.out.println();
	
}
}
