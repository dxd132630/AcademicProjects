###########################################################################################################################################
#								CS 6375 Machine Learning 		 				  #
#                                            				 Homework 5                                      		  #
#							Name=Deepti Deshpande UTD ID:2021204846	                           		  #
###########################################################################################################################################

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//					       HW 5 Part I : Value iteration algorithm								      //
//The program is to find the optimal policy for each state of an MDP using Bellman's equation. The program consumes 4 command line parameters viz:    //
//1. number of states of the MDP, 2.number of possible actions, 3.input file with following description, 4.discount factor 			      //
//Each input file should have each line of the file stores information for one state in given MDP.For instance, the first line stores information about//
//state s1:the reward associated with s1 is 5, in action a1 we stay in s1 with probability 0.509 and move to s2 with probability 0.491 and on action a2//
//we  stay in s1 with probability 0.31 and move to s3 with probability 0.69.The remaining lines of the file can be interpreted in the similar fashion  //
//The program reads each line and assigns the value of the transition probability to the 3 dimensional matrix where number of columns are the number of//
//states and number of rows are number of statesXactions. On first iteration we find the optimal policy by finding the action which helps us to attain//
//the maximum rewards. Subsequently for next iteration we find the maximum rewards by finding the maximum of product of previous value iteration reward//
//of each state and the transition probability and then multiplying it with the discount factor and the adding it to the reward of each state. It also //
//tracks the action which led to the maximum reward in each state and the same is printed in following form:	                                       //
//After iteration 1:					 											       //
//(s1 a1 -1.0000) (s2 a1 -1.0000) (s3 a1 0.0000) (s4 a1 -1.0000)										       //
//Where 1 is the iteration number and (s1 a1 -1.0000) is the details of the state 1 ,its optimal policy and the maximum reward in that state after itera//
//tion 1.Similarly other state details are printed in each state and for the subsequent iteration till 20.					       //
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Instructions to execute the program:
1.Attached is the Project exported from Java eclips.
2.Once the project is imported in the java environment
3.Complie the code and pass the parameters like follows:
	compile > javac ValueIteration.java
	Execute > java ValueIteration 4 4 "C:\Spring2014\ML\Homeworks\HW5\InputFiles\test3-win.in" 0.9
			OR
	Execute > java ValueIteration <number of states> <number of actions> <MDP file name> <discount factor>

