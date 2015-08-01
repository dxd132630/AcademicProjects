///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//															Author:Deepti Deshpande																		     //
//This java file is just the modification to the provided file, the program is augmented with the Java utilities like treeMap and filtering logic changes    //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.lang.Comparable;
import java.lang.Integer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

class topk {
    static class NGram implements Comparable<NGram> {
	public String ngram;
	public int year;
	public int count;

	public int compareTo(NGram n) {
	    return (n.count - count);
	}
    }

    static void TopK_NGrams(String[] filenames, int K, int target_year) throws IOException, FileNotFoundException {
    	long startTime = System.nanoTime();//parameter added to compute the execution time
    	//code
    TreeMap< Integer,String> mapTopN = new TreeMap<>();	
	//ArrayList<NGram> AllNGrams = new ArrayList<NGram>(); ***Array list to hold all the records is removed.There is no need to hold all the records we only need the top N ngrams***
	//ArrayList<NGram> FilteredNGrams = new ArrayList<NGram>();***Array list to hold filtered records is removed.Filtering logic is modified***

	// First, read in all of the data files
	for (String filename : filenames) {
	    FileInputStream fstream = new FileInputStream(filename);
	    DataInputStream ds = new DataInputStream(fstream);
	    BufferedReader in = new BufferedReader(new InputStreamReader(ds));
	    
	    String buffer;
	    while ((buffer = in.readLine()) != null) {
		String[] tokens = buffer.split("\t");

		// Do something reasonable if the input file is corrupt and gives us bad data
			if (tokens.length < 3) {
				System.err.println("ERROR: Invalid line: " + buffer);
				continue;
			}
		
			NGram n = new NGram();
			  
			n.year = Integer.parseInt(tokens[1]);  // Second column is the year
		  
		    if (n.year == target_year) {//If only the given records year match the desired year then parse further
				n.ngram = tokens[0];// First column is the NGram
				n.count = Integer.parseInt(tokens[2]);// Third column is the number of occurrences in that year
				// AllNGrams.add(n); *** Code to store all the Ngrams is removed as this storing is un-necessary
				mapTopN.put(n.count,n.ngram); //Put the record in TreeMap. TreeMap arranges the records seen so far into ascending order of ngram count
				if(mapTopN.size()> K){ //If at any point of time the number of records in TreeMap is greater than the K value remove the smallest record from the top
					mapTopN.remove(mapTopN.firstKey());
				}
			}
		}

	    fstream.close();
	}
//**following code from the provide file is commented as it is no more needed**//
	// Second, filter out all NGrams of the wrong year
//	for (NGram n : AllNGrams) {
//	    if (n.year == target_year) {
//		FilteredNGrams.add(n);
//	    }
//	}

	// Third, sort the list, so that we can pick out the top K NGrams by
	// simply listing the first K elements in the list.
	//Collections.sort(AllNGrams);

	// Fourth, print out the top K words
//	int count = 0;
//	for (NGram n : AllNGrams) {
//	    System.out.print(n.ngram);
//	    System.out.print('\t');
//	    System.out.print(n.count);
//	    System.out.println();
//
//	    count++;
//	    if (count >= K) { break; }
//	}
	//Print the top K records
	Iterator iter = mapTopN.entrySet().iterator();
	 while (iter.hasNext()) {
		    Map.Entry rec = (Map.Entry)iter.next();
		    System.out.println(rec.getValue()+"\t"+ rec.getKey());
		    iter.remove();
	 }
		long endTime = System.nanoTime();//Get the end time after processing all the records from the file
		System.out.println("Took "+(endTime - startTime) + " ns"); 
    }


    public static void main(String[] args) throws IOException, FileNotFoundException {
	if (args.length < 3) {
	    System.out.println("topk    Usage: ./topk K year file1 [file2 [file3 [...]]]");
	    System.out.println("               (for some integers K and year)");
	    return;
	}

	int K = Integer.parseInt(args[0]);
	int year = Integer.parseInt(args[1]);

	String[] filenames = Arrays.copyOfRange(args, 2, args.length);
       
	TopK_NGrams(filenames, K, year);
    }
}