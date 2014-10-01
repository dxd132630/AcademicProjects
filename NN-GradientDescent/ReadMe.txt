####################################################################################################
#					CS 6375 Machine Learning 				   #
#                                             Homework 3                                           #
#				Name=Deepti Deshpande UTD ID:2021204846	                           #
####################################################################################################
1.Code is developed in Java using eclipse application on Windows 8 platform
2.The program can be run using comand line by passing programs javac file name and 4 arguments: train file name,test file name,learning rate and number of iterations
	Ex: Go to the location when "NN.java" is present in command line
	execute following command:
	1. complie the code by: javac NN.java
	2. Execute the code by: java NN "<path_of_taining_filename>" "<path_of_test_filename>" LearningRate NoOfIterations
3.Attached is the Projected exported from Java environment with prject name NeuralNetwork . This has src folder with NN.java
4.Code explanation:
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		            HW3:Neural Network implementation for single layer perceptron with sigmoid function                          //
//																	 //																	 //
//This code is to Train the Neural network using sigmoid function. The program takes 4 input parameters. One the train file name (full   //
//qualified) and test file name(fully qualified) and the learning rate and number of iterations.                                         //
//The algorithm is based on the Incremental weight updation logic                                                                        //
//Each time the dataset from the Training file is read the error is calculated by passing the inputs and weight to incremental functions //
//First we calculate the Summation of weight*inputs.Second, we compute g(Summation)=1/(1+e^-(summation)) & we compute                    //
// error=(Expected output[t] -actual output[o]) where o=g(summation).                                                                    //
//Then the weight of the attribute i is updated by using wi= wi+ learningRate*error*xi. This updates ith weight                          //
//Similarly based on the number of iterations given in the command lines 4th argument we repeat the process                              //
//If the number of iterations are greater than the number of instances in the class then we run the weight weight updation process starti//
//-ng from the beginning of the training file.                                                                                           //
//Once the Weights are finalized we compute the accuracy of the Training file by reading the input dataset and calculating the result of //
//the activation function and if the output is >0.5 then it is  classified to class 1 else to class 0.                                   //
//This is checked against the Expected class in training , if they match the successRate is incremented and we calculate the Accuracy by //
//(successRate/totalNoOfinstances)*100.                                                                                                  //
//Similar accuracy is calculated for the test file.   																					 //
//Hence the Final output is of the form "Accuracy of file "Filename" (with n instance ) =accuracy %" where fileName is command line      //
//argument and   n is the number of dataset in the train and test file and accuracy is the computed accuracy value.                      //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
