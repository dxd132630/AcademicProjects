####################################################################################################
#					CS 6364 Artificial Intelligence				   #
#                                             Homework 1                                           #
#				Name:Deepti Deshpande UTD ID:dxd132630	                           #
####################################################################################################
1.Code is developed in Java using eclipse application on Windows 8 platform
2.The program can be run using comand line by passing programs javac file name and 1 argument: Start state file name
	Ex: Go to the location where  "RBFS.java" is present in command line
	execute following command:
	1. complie the code by: javac RBFS.java
	2. Execute the code by: java RBFS "<path_of_Start_State_filename>"
	   EX: C:\Users\Deepti\SummerWorkspace3\dxd132630_RBFS\src> java RBFS "c:\Summer2014\AI\Assignments\AI1\StartState.txt"
3.Attached is the Project exported from Java environment with prject name dxd132630_RBFS . This has src folder with RBFS.java
4.Code explanation:
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	AI Programming assignment HW 1 : Implementation of RBFS						      //
//The following code is the implementation of Recursive Best first search using AIMA built in functions       //
//The program takes a command line input which is a file name and assigns to the variable "startStateFileName"//
//The function "getStartState(<file_name>) reads the file and parses the contents based on the requirement    //
//into an array "startStatefromFile" [In the input from a text file with numbers in rows separated by a <tab> //
//character. Each row of the input file should be terminated by a newline character.The empty square should be//
//represented by the number 0].			                                                              //
//The next step is to check if the given input is solvable/unsolvable by using the 			      //
// rule::( (grid width odd) && (#inversions even) ) ->Solvable	else unsolvable	                              //
//If the startStatefromFile data is solvable then it calls the function eightRBFS() which calls the built in  //
//AIMA function included in the import list and assigns the actions taken to the actions array list and this  //
// is used to print the Solution action using tracing() function and the function statistics() is used to     //
//capture the number of node expanded and the depth of the search tree					      //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////