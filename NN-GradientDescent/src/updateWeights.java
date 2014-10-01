import java.util.ArrayList;


public class updateWeights {
	public  double updateWeight(ArrayList<Double>weight,double gdash,ArrayList<ArrayList<Double>> input, int i,double y,double eeta, double c)
	{
		int classindex = weight.size();
		int k = 0;

		double desiredop = input.get(i).get(classindex);
		double val = eeta*(desiredop-y);
		double val1 = val*gdash;
		double val2;

		if(y>=0.5)
		{
			y=1;
		}
		else
		{
			y=0;
		}

		if(desiredop != y)
		{
			for(k=0;k<classindex;k++)
			{
				val2 = val1*input.get(i).get(k);
				weight.set(k, weight.get(k)+val2);
			}
		}

		else
		{
			k++;
			c++;
		}

		return c;
	}

}
