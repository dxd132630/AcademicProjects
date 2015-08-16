/*
 * 				Author : Deepti Deshpande
 * 				Net ID : dxd132630
 * 				File Name : GP_P3
 * 				Details : This program implements Swarm Intelligence for network topology design using java.
 */
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

public class SI_P3 {
	static int Max_Nodes=15;
	static double global_min_cost = 0;
	static  String strSeparator = "";
	static DecimalFormat df = new DecimalFormat("###.####");
	static int[][] NodePoints = new int[Max_Nodes][3];
	static int possible_edges = (int)(Max_Nodes*(Max_Nodes-1)/2);
	static double[] dist_mat = new double[possible_edges];
	static double[][] dist_mat_2d = new double[Max_Nodes][Max_Nodes];
	static int[] global_final_state = new int[possible_edges];
	static HashMap<Integer,Integer> xHash = new HashMap<Integer,Integer>();
	static int[][] Initial_state = new int[Max_Nodes][Max_Nodes];
	static int[][] Prev_State = new int[Max_Nodes][Max_Nodes];
	static HashMap<Integer,Integer> visited_nodes = new HashMap<Integer,Integer>();
	static int broad_cast_iteration = 0;
	static int number_of_ants = 8;
	public static int[] gen_points(){
		int[] points = new int[2];
		while(true){
			int x =(int) (Math.random() * 10);
			int y =(int) (Math.random()*10);
			if(!xHash.containsValue(y)){
				points[0]=x;
				points[1]=y;
				xHash.put(x, y);
				break;
				
			}
			
		}
		return points;
	}
	public static void Generate_coordinates(){
		/*
		 * Generate random x and y co-ordinates 
		 */
		
		for(int i=0;i<Max_Nodes;i++){
				int[] points=gen_points();
				NodePoints[i][0] = i;
				NodePoints[i][1]= points[0];
				NodePoints[i][2] = points[1];
				//System.out.println("Point name:"+NodePoints[i][0]+" X-co-ordinate="+NodePoints[i][1]+" Y-co-ordinate="+NodePoints[i][2]);
		}
		
		convert_coordinates_to_state();
	}
	public static void convert_coordinates_to_state(){
		/*
		 * converts the co-ordinates to array representation of link cost
		 */
		//System.out.println(possible_edges);
		
		int count=0;
		for(int i=0;i<Max_Nodes-1;i++){
			for(int j=i+1;j<Max_Nodes;j++){
				dist_mat[count] = Math.sqrt(((NodePoints[i][1]-NodePoints[j][1])*(NodePoints[i][1]-NodePoints[j][1]))+((NodePoints[i][2]-NodePoints[j][2])*(NodePoints[i][2]-NodePoints[j][2])));
//				System.out.println("dist_mat["+(count)+"]= "+df.format(dist_mat[count]));
				count++;
			}
		}
	}
	public static void distance_matrix_calc(){
		int count = 0;
		for(int i=0;i<Max_Nodes;i++){
			for(int j=0;j<Max_Nodes;j++){
				if(i==j){
					dist_mat_2d[i][j] = 9999.99;
				}
			}
		}
		for(int i=0;i<Max_Nodes-1;i++){
			for(int j=i+1;j<Max_Nodes;j++){
				dist_mat_2d[i][j]=dist_mat[count];
				dist_mat_2d[j][i]=dist_mat[count];
				count++ ;
			}
		}
//		for(int i=0;i<Max_Nodes;i++){
//			for(int j=0;j<Max_Nodes;j++){
//				System.out.print(" "+dist_mat_2d[i][j]);
//			}
//			System.out.println();
//		}
	}
	public static double compute_cost(int[] stateIntArray){
		double cost_total = 0.0;
		for(int i=0;i<possible_edges;i++){
			cost_total +=dist_mat[i]*stateIntArray[i];
		}
		return cost_total;
	}
	public static int[] bin_to_int(String binString){
		int[] tempStateArray = new int[possible_edges];
		for(int j=0;j<possible_edges;j++){
			 char c = binString.charAt(j);
			 tempStateArray[j] = Character.getNumericValue(c);
		 }
		return tempStateArray;
	}
	public static boolean EvalState(int[] stateMatrix){
		int[][] stateIndicator = new int[Max_Nodes][Max_Nodes];
		int[][] stateIndicator1 = new int[Max_Nodes][Max_Nodes];
		int count = 0;
		for(int i=0;i<Max_Nodes-1;i++){
			for(int j=i+1;j<Max_Nodes;j++)
				if(stateMatrix[count++]==1){
					stateIndicator[i][j]=j+1;
					stateIndicator[j][i]=i+1;
					stateIndicator1[i][j]=1;
					stateIndicator1[j][i]=1;
				}
			
		}
		int[] out_bound=new int[Max_Nodes];
		
		for(int i=0;i<Max_Nodes;i++){
			int count_out = 0;
			for(int j=0;j<Max_Nodes;j++){
				if(stateIndicator[i][j]!=0){
					count_out++;
					
				}
			}
			if(count_out>=3)
				out_bound[i]=1;
			else
				out_bound[i]=0;
		}
		boolean flag = false;
		int sum=0;
		for(int i=0;i<Max_Nodes;i++){sum+=out_bound[i];}
		if(sum==Max_Nodes)
			flag=true;
		boolean graphConnectivity = false;
		
		DepthFirstSearch newdfs = new DepthFirstSearch(stateIndicator);
		if(flag==true){
		graphConnectivity= newdfs.checkConnectivity();
		}
		boolean hop_count = false;
		hop_count = checkHopCount(stateIndicator1);
		boolean fitness = false;
		if(graphConnectivity && hop_count)
			fitness=true;
		return fitness;
	}
	public static boolean checkHopCount(int[][] stateIndicator){
		boolean flag = false;
		for(int k=0;k<5;k++){
			
			for(int i=0;i<Max_Nodes;i++){
				
				for(int j=0;j<Max_Nodes;j++){
					
					if(k==i || k==j ||i==j)
						continue;
					
					else{
						if(stateIndicator[i][k]==1 && stateIndicator[k][j]==1){
							
							stateIndicator[i][j] = 1;
							
						}
					}
				}
			}
		}	
		 int sum = 0;
		   for(int i=0;i<Max_Nodes-1;i++){
				
				for(int j=i+1;j<Max_Nodes;j++){
					if(stateIndicator[i][j]==1)
						sum++;
				}
				
		   }
		   
		 if(sum==possible_edges)
			 flag = true;
		return flag;
		
	}
	public static int[] indexesOfLowElements(double[] orig, int nummax) {
        double[] copy = Arrays.copyOf(orig,orig.length);
        Arrays.sort(copy);
        double[] honey = Arrays.copyOfRange(copy,0, nummax);
        int[] result = new int[nummax];
        int resultPos = 0;
        for(int i = 0; i < orig.length; i++) {
            double onTrial = orig[i];
            int index = Arrays.binarySearch(honey,onTrial);
            if(index < 0) continue;
            if(resultPos<nummax)
            result[resultPos++] = i;
        }
        return result;
    }
	public static int[][] broadcast_forward(int[][] Initial_state){
		
		int[][] new_colony = new int[Max_Nodes][Max_Nodes];
		new_colony = Initial_state;
//		System.out.println("Iter = [");
//		for(int i=0;i<Max_Nodes;i++){
//			for(int j=0;j<Max_Nodes;j++)
//					System.out.print(Initial_state[i][j]+" ");
//			System.out.println(";");
//		}
//		HashMap<Integer,Integer> ant = new HashMap<Integer,Integer>();
//		for(int i=0;ant.size()<number_of_ants;i++){
//			Random rand = new Random();
//			int rand_val = rand.nextInt(Max_Nodes);
//			if(!ant.containsValue(rand_val)){
//			 ant.put(i, rand_val);
//			System.out.println("ant :"+ant.get(i));
//			}
//		}
		int[] ant = new int[number_of_ants];
		for(int i=0;i<number_of_ants;i++){
			Random rand = new Random();
			int rand_val = rand.nextInt(Max_Nodes);
			ant[i] = rand_val;
		}
//		System.out.println("ant size: "+ant.size());
		for(int i=0;i<number_of_ants;i++){
		//	System.out.println("ant :"+ant[i]);
			int[] ant_broadcast = new int[3];
//			if(broad_cast_iteration<1)
//				ant_broadcast = indexesOfLowElements(dist_mat_2d[ant[i]],3);
//			else
//			{
				for(int z=0;z<3;z++){
					Random rand = new Random();
					int rand_val = rand.nextInt(Max_Nodes);
					ant_broadcast[z] = rand_val;
				}
//			}
				for(int j=0;j<3;j++){
		//			System.out.println("ant b :"+ant_broadcast[j]);
					if(i!=j){
							new_colony[ant[i]][ant_broadcast[j]]=1;
							new_colony[ant_broadcast[j]][ant[i]]=1;
					}
			}
		}
		
		return new_colony;
	}
	public static boolean check_for_saturation(double cost){
		double difference = global_min_cost - cost;
		if((difference < 0)){
			return true;
		}
		else if (difference > 0 && difference < 10)
			return false;
		else
			return true;
	}
	public static void build_colony(){
		Prev_State = Initial_state;
		broad_cast_iteration++;
		System.out.println("broad_cast_iteration"+broad_cast_iteration);
		Initial_state = broadcast_forward(Initial_state);
		int[] state_string = new int[possible_edges];
		int count = 0 ;
		for(int i=0;i<Max_Nodes-1;i++){
			for(int j=i+1;j<Max_Nodes;j++){
					state_string[count++] = Initial_state[i][j];
			}
		}
		int[] state_string_pres= new int[possible_edges];
		count = 0 ;
		for(int i=0;i<Max_Nodes-1;i++){
			for(int j=i+1;j<Max_Nodes;j++){
				state_string_pres[count++] = Prev_State[i][j];
			}
		}
		boolean fit_prev = EvalState(state_string_pres);
		boolean fit_cur = EvalState(state_string);
		double c1 = compute_cost(state_string_pres);
		double c2 = compute_cost(state_string);
//		System.out.println("prev_state cost :"+c1+"fitness ="+fit_prev);
//		System.out.println("initial cost :"+c2+"fitness ="+fit_cur);
		while(broad_cast_iteration<=5){
			if(c2<c1 && fit_cur){
					Prev_State = Initial_state;
					build_colony();
			}
			else if(c1<c2 && fit_prev){
					Initial_state= Prev_State;
					build_colony();
			}
			else 
				build_colony();
		
		}
	}
	public static void initialize_network(){

		for(int i=0;i<Max_Nodes;i++){
			for(int j=0;j<Max_Nodes;j++){
				if(i==j)
					Initial_state[i][j]=9999;
				else
					Initial_state[i][j]=0;
			}
		}
		Prev_State = Initial_state;
	}
	
	public static void main(String[] args){
		Generate_coordinates();
		convert_coordinates_to_state();
		distance_matrix_calc();
		initialize_network();
			build_colony();
		int count = 0 ;
		int[] state_string_pres= new int[possible_edges];
		for(int i=0;i<Max_Nodes-1;i++){
			for(int j=i+1;j<Max_Nodes;j++){
				state_string_pres[count++] = Initial_state[i][j];
			}
		}
		boolean fit_prev = EvalState(state_string_pres);
		double c1 = compute_cost(state_string_pres);
		System.out.print("cd = [");
		for(int i=0;i<Max_Nodes-1;i++){
			System.out.println("["+NodePoints[i][1]+","+NodePoints[i][2]+"],");
		}
		System.out.println("["+NodePoints[Max_Nodes-1][1]+","+NodePoints[Max_Nodes-1][2]+"],");
		System.out.println("Global  :"+c1+" fitness ="+fit_prev);
			System.out.println("A = [");
			for(int i=0;i<Max_Nodes;i++){
				System.out.print("[");
				for(int j=0;j<Max_Nodes;j++){
					if(i==j){
						System.out.print(0+",");
					}
					else
						System.out.print(Initial_state[i][j]+",");
				}
				System.out.print("],");
			}
	}

}
