import java.lang.Comparable;
import java.lang.Integer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
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
	ArrayList<NGram> AllNGrams = new ArrayList<NGram>();
	ArrayList<NGram> FilteredNGrams = new ArrayList<NGram>();

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
		n.ngram = tokens[0];  // First column is the NGram
		n.year = Integer.parseInt(tokens[1]);  // Second column is the year
		n.count = Integer.parseInt(tokens[2]);  // Third column is the number of occurrences in that year
		// There are more columns in the raw data, but we don't need them to answer this question

		AllNGrams.add(n);
	    }

	    fstream.close();
	}

	// Second, filter out all NGrams of the wrong year
	for (NGram n : AllNGrams) {
	    if (n.year == target_year) {
		FilteredNGrams.add(n);
	    }
	}

	// Third, sort the list, so that we can pick out the top K NGrams by
	// simply listing the first K elements in the list.
	Collections.sort(FilteredNGrams);

	// Fourth, print out the top K words
	int count = 0;
	for (NGram n : FilteredNGrams) {
	    System.out.print(n.ngram);
	    System.out.print('\t');
	    System.out.print(n.count);
	    System.out.println();

	    count++;
	    if (count >= K) { break; }
	}
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