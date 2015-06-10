package myudfs;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.commons.lang.ArrayUtils;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.util.WrappedIOException;

public class FORMAT_GENRE extends EvalFunc<String>{
    public String exec(Tuple input) throws IOException {
        if (input == null || input.size() == 0)
            return null;
        try{

			if (input == null || input.size() == 0) {
				return null;
			}
			String inputStream = (String) input.get(0);
			String[] tmp = inputStream.split("\\|");
			StringBuilder str = new StringBuilder();

			ArrayUtils.reverse(tmp);
			
			int count = 1;
			
			int Strlength = tmp.length;
			for(String element: tmp) {
				if(Strlength==1){
					str.append("1)").append(element).append(" dxd132630");
					break;
				}
				if(count==(Strlength-1)){
					str.append(count+")"+element+" & ");
					count++;
					continue;
				}
				if(count==Strlength){
					str.append(count+")").append(element).append(" dxd132630");
					break;
				}
				str.append(count+")").append(element+", ");
				count++;
			}
			return str.toString();
        }catch(Exception e){
            throw WrappedIOException.wrap("Caught exception processing input row ", e);
        }
    }
}