import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;


/*
 *   This program implements the gradient descent algorithm to train a sigmoid unit for binary classification tasks.
 */

public class GradientDescent 
{

	/**
	 * @param args
	 * @throws IOException 
 
	 */

	public static ArrayList<Double> weights = new ArrayList<Double>();
	public static double eeta;
	public static double c = 0;

	//This is the main method where the all the functions of the various classes are called.
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		String lrate;
		int iterations;

		lrate = args[2];
		iterations = Integer.parseInt(args[3]);

		eeta = Double.parseDouble(lrate);

		DecimalFormat df = new DecimalFormat("#.##");

		//Read input from the file.
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String s;
		int size = 0;
		int index=0;

		s=br.readLine();
		String[] inputs=s.split("\\s");

		size = inputs.length;

		ArrayList<ArrayList<Double>>inputRecords=new ArrayList<ArrayList<Double>>();

		 while((s=br.readLine())!=null)
         {
             ArrayList<Double>arrL=new ArrayList<Double>();
             String[] line=s.split("\\s");

             for(int i=0;i<line.length;i++)
                 arrL.add(Double.parseDouble(line[i]));
             
             inputRecords.add(arrL);
             
         }

		 br.close();

		 double a=0.0;
		 double y;
		 double gdash;
		 //ArrayList<Double> op = new ArrayList<Double>();


		 weights = initializeWeights(size);

		 for(int j=0; j<iterations-1;j++)
		 {

			 while(index<inputRecords.size())
			 {
				 calculateA caa = new calculateA();
				 a = caa.calcA(index,inputRecords,weights,size);
				 y = calculateY(a);
				 calculateActivationFunction caf = new calculateActivationFunction();
				 gdash = caf.calculateActivation(y);
				 updateWeights uw = new updateWeights();
				 c = uw.updateWeight(weights,gdash,inputRecords,index,y,eeta,c);
				 index++;
			 }
			 index =0;

		 }

		 c=0;
		 for(int j=0; j<1;j++)
		 {

			 while(index<inputRecords.size())
			 {
				 calculateA caa = new calculateA();
				 a = caa.calcA(index,inputRecords,weights,size);
				 y = calculateY(a);
				 calculateActivationFunction caf = new calculateActivationFunction();
				 gdash = caf.calculateActivation(y);
				 updateWeights uw = new updateWeights();
				 c = uw.updateWeight(weights,gdash,inputRecords,index,y,eeta,c);
				 index++;
			 }
			 index=0;

		 }

		 //System.out.println(c);
		 c=(c/inputRecords.size())*100;
		 System.out.println("Accuracy on training set("+inputRecords.size()+" instances): "+df.format(c)+"%");

		 index = 0;


		 BufferedReader br1 = new BufferedReader(new FileReader(args[1]));
		 s= br1.readLine();

		 ArrayList<ArrayList<Double>>input1Records=new ArrayList<ArrayList<Double>>();
		 inputs=s.split("\\s");

		 while((s=br1.readLine())!=null)
         {
             ArrayList<Double>arrL=new ArrayList<Double>();
             String[] line=s.split("\\s");
             for(int i=0;i<line.length;i++)
                 arrL.add(Double.parseDouble(line[i]));
             
             input1Records.add(arrL);
             
         }
		 br1.close();

		 size = inputs.length;
		 weights = initializeWeights(size);
		 c=0;

		 for(int j=0; j<iterations-1;j++)
		 {

			 while(index<input1Records.size())
			 {
				 calculateA caa1 = new calculateA();
				 a = caa1.calcA(index,input1Records,weights,size);
				 y = calculateY(a);
				 calculateActivationFunction caf1 = new calculateActivationFunction();
				 gdash = caf1.calculateActivation(y);
				 updateWeights uw1 = new updateWeights();
				 c = uw1.updateWeight(weights,gdash,input1Records,index,y,eeta,c);
				 index++;
			 }
			 index =0;

		 }
		 c =0;

		 for(int j=0; j<1;j++)
		 {

			 while(index<input1Records.size())
			 {
				 calculateA caa1 = new calculateA();
				 a = caa1.calcA(index,input1Records,weights,size);
				 y = calculateY(a);
				 calculateActivationFunction caf1 = new calculateActivationFunction();
				 gdash = caf1.calculateActivation(y);
				 updateWeights uw1 = new updateWeights();
				 c = uw1.updateWeight(weights,gdash,input1Records,index,y,eeta,c);
				 index++;
			 }
			 index =0;

		 }
		 //System.out.println(c);
		 c=(c/input1Records.size())*100;
		 System.out.println("Accuracy on test set("+input1Records.size()+" instances): "+df.format(c) +"%");

	}

	//This method is used to initialize the weights of the neural network to zero.
	public static ArrayList<Double> initializeWeights(int size)
	{
		ArrayList <Double> weights = new ArrayList<Double>();

		for(int i=0;i<size;i++)
		{
			weights.add((double) 0);
		}

		return weights;
	}

	//This method is used to calculate the expected output of the particular node in the neural network. In this case it is a sigmoid function.
	public static double calculateY(double a)
	{
		double y;
		y = 1/(1+Math.exp(-a));

		return y;
	}
}