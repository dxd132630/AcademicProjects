import java.util.ArrayList;


public class calculateA {

	public double calcA(int i,ArrayList<ArrayList<Double>> input,ArrayList<Double> weights,int size)
	{
		Double a = 0.0;

		for(int j=0;j<size;j++)
		{
			a = a + input.get(i).get(j)*weights.get(j);
		}

		return a;
	}
	
}
