////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//The program takes a command line input which is a file name and assigns to the variable "startStateFileName"//
//The function "getStartState(<file_name>) reads the file and parses the contents based on the requirement    //
//into an array "startStatefromFile" [In the input from a text file with numbers in rows separated by a <tab> //
//character. Each row of the input file should be terminated by a newline character.The empty square should be//
//represented by the number 0].																				  //
//The next step is to check if the given input is solvable/unsolvable by using the 							  //
// rule::( (grid width odd) && (#inversions even) ) ->Solvable	else unsolvable								  //
//If the startStatefromFile data is solvable then it calls the function eightRBFS() which calls the built in  //
//AIMA function included in the import list and assigns the actions taken to the actions array list and this  //
// is used to print the Solution action using tracing() function and the function statistics() is used to     //
//capture the number of node expanded and the depth of the search tree										  //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//imports of the java libraries
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
//import of the AIMA libraries
import aima.core.agent.Action;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.environment.eightpuzzle.EightPuzzleFunctionFactory;
import aima.core.environment.eightpuzzle.EightPuzzleGoalTest;
import aima.core.environment.eightpuzzle.ManhattanHeuristicFunction;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.informed.AStarEvaluationFunction;
import aima.core.search.informed.RecursiveBestFirstSearch;
//Recursive Best first search class
public class RBFS {
	static EightPuzzleBoard startState;
	static int [] startStatefromFile= new int[9];//input array list
	static String startStateFileName;//command line input file name

	public static void main(String[] args) throws Exception {
		startStateFileName=args[0]; //read the file name from the command line
		int solvability=0;//assign the solvability to zero initially 
		RBFS rbfs= new RBFS();
		rbfs.getStartState(startStateFileName);//call the function to parse the input data to the array
		solvability=rbfs.checkSolvability();//call the function to check the solvability
		if(solvability==0) //if number of inverses is even then call the search function
		eightRBFS();
		else // if the number of inverses in the start state is odd then print the following statement
		System.out.println("The given start state is not solvable!!");
		
	}
	// function to parse the input file and assign the data to the array
	public void getStartState( String fileName) throws Exception{
		File file = new File(fileName);// file handler
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file))); //file reader
		String line = null;
		int i=0,j;
		
		//read line by line
		while( (line = br.readLine())!= null){
			String[] tokens=line.split("\\s"); //slit tokens into words separated by space or tab
			for (j=0;j<3;j++ ){
				startStatefromFile[i]= Integer.parseInt(tokens[j]);//assign the data to the array
				i++;
				}
			
			}
		br.close();//close the file buffer reader
		System.out.println("This is a RBFS implemention for Sliding tile puzzle");
		System.out.println("The start state is read from the file: \""+startStateFileName+"\" and the contents are:");
		int count=0;
		//print the contents of the file on the screen
		for (i=0;i <9;i++)
		{
				System.out.print(startStatefromFile[i]+"\t");
				count++;
				if(count==3|| count==6)
					System.out.println();
		}
		System.out.println();
		System.out.println("Solution is as follows:");
		}
	//Function is used to check if the given startState is solbvable
	public int checkSolvability(){
		int inverse_count=0;
		for(int i=0;i<9;i++){
			for(int j=i+1;j<9;j++){
				//count the number of inverses
				if(startStatefromFile[i] > 0 && startStatefromFile[j] >0 && startStatefromFile[i] > startStatefromFile[j] && startStatefromFile[i]!=0 && startStatefromFile[j]!=0  )
					inverse_count++;
				}
		}
		//in number of inverses is odd then return unsolvable
		if(inverse_count%2==1)
			return 1;
		//else return solvable
		else
			return 0;
	}
	//RBFS search function
	private static void eightRBFS() {
		
		startState = new EightPuzzleBoard(startStatefromFile);
		try {
			//define the problem by assigning the srartState array and action and puzzleFunctiofactory function
			Problem problem = new Problem(startState, EightPuzzleFunctionFactory
					.getActionsFunction(), EightPuzzleFunctionFactory
					.getResultFunction(), new EightPuzzleGoalTest());
			//call the RBFW function built in to AIMA and pass the parameters to perform search and assign the search tracing to action array list
			Search search = new RecursiveBestFirstSearch(
					new AStarEvaluationFunction(new ManhattanHeuristicFunction()));
			SearchAgent agent = new SearchAgent(problem, search);
			tracing(agent.getActions());//print the actions using AIMA getActions() function
			statistics(agent.getInstrumentation());// prints the statistics using AIMA getInstrument function
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//function to print the statistics using AIMA getInstrument function
	private static void statistics(Properties statistics_name) {
		Iterator<Object> keys = statistics_name.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String statisticsName = statistics_name.getProperty(key);
			System.out.println(key + " : " + statisticsName);
		}

	}
	//function print the actions using AIMA libraries
	private static void tracing(List<Action> moves) {
		for (int i = 0; i < moves.size(); i++) {
			String action = moves.get(i).toString();
			System.out.println(action.substring(13, action.length()-1));
		}
	}

}
