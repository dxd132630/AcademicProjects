import java.util.*;
import java.util.Map.Entry;

public class ZipfSongsSpotify{
	public static void main(String[] args){
		String[] input = new String[15];
		input[0] ="197812 re_hash";
		input[1] = "78906 5_4";
		input[2] = "189518 tomorrow_comes_today";
		input[3] = "39453 new_genious";
		input[4] = "210492 clint_eastwood";
		input[5] = "26302 man_research";
		input[6] = "22544 punk";
		input[7] = "19727 sound_check";
		input[8] = "17535 double_bass";
		input[9]= "18782 rock_the_house";
		input[10] = "198189 19_2000";
		input[11] = "13151 latin_simone";
		input[12] = "12139 starshine";
		input[13] = "11272 slow_country";
		input[14] = "10521 m1_a1";
		int num_of_songs = 15 ;
		int best = 3;
		findBestSongUsingZipf(input,num_of_songs,best);
	}
	public static void findBestSongUsingZipf(String[] input,int num,int best){
		HashMap<String,Double> map = new HashMap<String, Double>();
		for(int i=0;i<input.length;i++){
			double fi = Integer.parseInt(input[i].split(" ")[0]);
			double zi = (double) 1/(i+1);
			double qi = fi/zi;
			map.put(input[i].split(" ")[1],qi);
		}
		TreeMap<String, Double> sortedMap = SortByValue(map);
		int count = 0;
		for(Entry<String, Double> entry : sortedMap.entrySet()){
			if((count)>2)
				break;
			else
			{
				System.out.println(entry.getKey());
				count++;
			}
		}
	}
	public static TreeMap<String, Double> SortByValue 
			(HashMap<String, Double> map) {
		ValueComparator vc =  new ValueComparator(map);
		TreeMap<String,Double> sortedMap = new TreeMap<String,Double>(vc);
		sortedMap.putAll(map);
		return sortedMap;
	}
}
class ValueComparator implements Comparator<String> {
 
    Map<String, Double> map;
 
    public ValueComparator(Map<String, Double> base) {
        this.map = base;
    }
 
    public int compare(String a, String b) {
        if (map.get(a) >= map.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys 
    }
}
