import java.util.*;

class HashEntry{
	
	String key;
	int value ;
	HashEntry next ;
	
	HashEntry(String key,int value){
		this.key = key;
		
		this.value = value;
		
		this.next = null;
	}
}

class HashTable{
	private static int TABLE_SIZE;
	private static int size;
	
	private static HashEntry[] table;
	
	HashTable(int s){
		size = 0;
		TABLE_SIZE = s;
		table = new HashEntry[TABLE_SIZE];
		for(int i=0;i<TABLE_SIZE;i++){
			table[i] = null;
		}
	}
	
	public static int size(){
		return size;
	}
	public static int get(String key){
		int hashVal = (myHashFunction(key)%TABLE_SIZE);	
		if(table[hashVal] == null)
			return -1;
		else{
			HashEntry entry = table[hashVal];
			while(entry!=null && !entry.key.equals(key)){
				entry = entry.next;
				if(entry == null)
					return -1;
				else
					return entry.value;
			}
		}
		return -1;
	}
	public static int myHashFunction(String key){
		int hashVal = key.hashCode();
		hashVal %= TABLE_SIZE;
		if(hashVal < 0)
			hashVal +=TABLE_SIZE;
		return hashVal;
	}
	
	public static void put(String key,int val){
		int hashVal = (myHashFunction(key)%TABLE_SIZE);
		if(table[hashVal]==null)
			table[hashVal] = new HashEntry(key,val);
		else{
			HashEntry entry = table[hashVal];
			while(entry.next!=null && !entry.key.equals(key)){
				entry = entry.next;
				if(entry.key.equals(key))
					entry.value = val;
				else
					entry.next = new HashEntry(key,val);
			}
			size++;
		}
	}
}

public class HashTableImplementation {
	/*
	 * main function
	 */

}
