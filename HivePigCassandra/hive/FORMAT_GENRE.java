import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class FORMAT_GENRE extends UDF {
    public Text evaluate(Text input) {
        
    	String inputStream = input.toString();
		String[] tmp = inputStream.split("\\|");
		StringBuilder str = new StringBuilder();
		    		
		int count = 1;
		int length = tmp.length;
		for(String element: tmp)
		    {
		    	if(length==1){
		    		str.append("1)").append(element).append(" dxd132630 :hive");
		    	break;
		    	}
		    	if(count==(length-1)){
		    		str.append(count+")"+element+" & ");
		    		count++;
		    	continue;
		    	}
		    	if(count==length){
		    		str.append(count+")").append(element).append(" dxd132630 :hive");
		    	break;
		    	}
		    	str.append(count+")").append(element+", ");
		    	count++;
		   }
		return new Text(str.toString());
    }
}