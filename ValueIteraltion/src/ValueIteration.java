////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//													HW 5 Part I : Value iteration algorithm															  //
//The program is to find the optimal policy for each state of an MDP using Bellman's equation. The program consumes 4 command line parameters viz:	  //
//1. number of states of the MDP, 2.number of possible actions, 3.input file with following description, 4.discount factor							  //
//Each input file should have each line of the file stores information for one state in given MDP.For instance, the first line stores information about//
//state s1:the reward associated with s1 is 5, in action a1 we stay in s1 with probability 0.509 and move to s2 with probability 0.491 and on action a2//
//we  stay in s1 with probability 0.31 and move to s3 with probability 0.69.The remaining lines of the file can be interpreted in the similar fashion  //
//The program reads each line and assigns the value of the transition probability to the 3 dimensional matrix where number of columns are the number of//
//states and number of rows are number of statesXactions. On first iteration we find the optimal policy by finding the action which helps us to attain//
//the maximum rewards. Subsequently for next iteration we find the maximum rewards by finding the maximum of product of previous value iteration reward//
//of each state and the transition probability and then multiplying it with the discount factor and the adding it to the reward of each state. It also //
//tracks the action which led to the maximum reward in each state and the same is printed in following form:										   //
//After iteration 1:																																   //
//(s1 a1 -1.0000) (s2 a1 -1.0000) (s3 a1 0.0000) (s4 a1 -1.0000)																					   //
//Where 1 is the iteration number and (s1 a1 -1.0000) is the details of the state 1 ,its optimal policy and the maximum reward in that state after itera//
//tion 1.Similarly other state details are printed in each state and for the subsequent iteration till 20.												//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Library imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
//Value iteration class declaration
public class ValueIteration {

	//main starts here
	public static void main(String[] args) throws IOException {
		int NoofState = Integer.parseInt(args[0]);//number of states
		int NoofActions= Integer.parseInt(args[1]);//number of actions
		float [][] MDPMatrix=new float[NoofState*NoofActions][NoofState];//matrix to hold the MDP transition probabilities
		String MDPFileName = args[2];//file name containing the MDP model
		float discountFactor = Float.parseFloat(args[3]);//discount factor
//		System.out.println ("NumberOfStates:"+NoofState+"\tNoOfActions:"+NoofActions+"\tMDPFileName:"+MDPFileName+"\tDiscount:"+discountFactor+"\n");
		ValueIteration VI= new ValueIteration();
		MDPMatrix=VI.readFiletoMDP(NoofState,NoofActions,MDPFileName,discountFactor);		//call to process the input files to the Matrix
	}
	
	public float [][] readFiletoMDP(int states,int actions, String MDPfile,float discount) throws IOException{
		//initialization of the variables
		int numofRows = states*actions,p=0,m=0,n=0;//number of rows
		int linecount=0;
		float transprob=0;
		float [][] MDPModel= new float[numofRows][states];//MDP transition probabilities
		float [] rewards= new float[states];//matrix to hold the rewards
		float [] ValueIterMatrix= new float[states];//matrix to hold the value iteration rewards for subsequent iterations
		float [][] maxstate= new float[states][2]; 
		int sub=0;
		//initialize the MDP matrix
		MDPModel=intializeMDPmatrix(MDPModel,numofRows,states,actions);
		//create a file pointer
		File file = new File(MDPfile);
		//pointer to read the file
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null;
		//while the read line is not null
		while( (line = br.readLine())!= null){
			String[] tokens = line.split("\\s+");
			//iteratively print each word in the line
			for(int i=0;i<tokens.length;i++){
				if(i==1)//read the reward value to the matrix
				rewards[linecount]=Float.parseFloat(tokens[1]);
				else if(tokens[i].contains("(a")){//identifying the state of in line to read the transition probabilities
					//parsing the value inside the brackets to assign the transition probabilities of each state against each action
					p=(Integer.parseInt(tokens[i].substring(tokens[i].length()-1)))-1;
					if(tokens[0].length()==3)
						sub=tokens[0].length()-2;
					else
						sub=tokens[0].length()-1;
					m=(Integer.parseInt(tokens[0].substring(sub)))-1;
					if(tokens[i+1].length()==3)
						sub=tokens[i+1].length()-2;
					else
						sub=tokens[i+1].length()-1;
					n=(Integer.parseInt(tokens[i+1].substring(sub)))-1;
					transprob=(Float.parseFloat(tokens[i+2].substring(0, tokens[i+2].length()-1)));
					MDPModel[p*states+m][n]=transprob;
				}
			}
			linecount++;
		}
		//for iteration one assigning the value iteration matrix to the reward values
		for(int j=0;j<linecount;j++)
		{
			ValueIterMatrix[j]=rewards[j];
		}
		//finding the optimal action for iteration 1
		maxstate=findMaxAction(rewards,MDPModel,states,actions,0);
		//Recursively calling the value Iteration function to find the value of the Value iteration reward updates for iteration 1 to 20
		for(int iteration=1;iteration<20;iteration++)
		{
			ValueIterMatrix=ValueIterations(ValueIterMatrix,rewards,MDPModel,states,actions,iteration,discount);
		}
		
		br.close();
		return MDPModel;
		
	}
	public float[] ValueIterations(float [] valueMatrix,float[] rewardMat,float [][] MDP, int state,int action, int iter,float discount){
		//initialization of the maxstate matrix to hold maximum of the reward and transition probability of each state
		float [][] maxstate=new float[state][2];
		float [] tempMat=new float[state];
		int pos=0;
		NumberFormat formatter = new DecimalFormat("#0.0000"); 
		//funciton call to find the maximum of reward and transition probability of each state
		maxstate=findMaxAction(valueMatrix,MDP,state,action,iter);
		//updating the valueIteration matrix
		for(int i=0;i<state;i++){
			tempMat[i]=maxstate[i][0];
			valueMatrix[i]=rewardMat[i]+(discount*tempMat[i]);
			pos=(int)maxstate[i][1];
			//printing the otiomal solution and the rewards for each iteration
			System.out.print("(s"+(i+1)+" a"+(pos+1)+" "+formatter.format(valueMatrix[i])+") ");
		}
		System.out.println();
		return valueMatrix;
	}
	public float [][] findMaxAction(float [] rewardMat, float [][] MDP,int state,int action,int iter)
	{
		float max=-999,reward=0;
		float [] temp=new float[action];
		int pos=0,j=0,count=0;
		float [][] rewardpos=new float[state][2];
		System.out.println("After iteration "+(iter+1)+":");
		for(int i=0;i<state;i++)
		{
			
			for(int p=0;p<action;p++)
			{
				temp[p]=0;
				count=0;
				//Check if for each state the transition probability is zero for all the states
				for(j=0;j<state;j++){
					if(MDP[state*p+i][j]==0)
						count++;
						
				}
				//if its zero for all the states then make the max of that state to large negative value
				if(count==state)
					temp[p]=-999;
				//else for each state find the product of the current reward and the transition probability against each action
				for(j=0;j<state;j++)
				{	
					temp[p]=temp[p] +(rewardMat[j]*MDP[state*p+i][j]);
				}
			}
			max=-999;
			pos=0;
			for(int p=0;p<action;p++)
			{
				//find the maximum of transition probability and reward
				if(max<temp[p]){
					max=temp[p];
					pos=p;
				}
				else {
					continue; 
				
				}
				//if its 1st iteration then reassign the reward to initial reward 
				if(iter==0){
					reward=rewardMat[i];

				}
				else{reward=max;
				}
			}
			rewardpos[i][1]=pos;
			rewardpos[i][0]=reward;
			if(iter==0){
				NumberFormat formatter = new DecimalFormat("#0.0000");
			System.out.print("(s"+(i+1)+" a"+(pos+1)+" "+formatter.format(reward)+") ");
			}
		}
		if(iter==0)
		System.out.println();
		return rewardpos;
	}
	//function to intialize the MDP transition matrix to hold zero value
	public float[][] intializeMDPmatrix(float [][] MDP, int rows,int col,int actions){
		int j=0,i=0,p=0;
		for(p=0;p<actions;p++){
			for(i=0;i<col;i++){
				for(j=0;j<col;j++){
					MDP[col*p+i][j]=0;
				}
			}
		}
		return MDP;
	}
}
