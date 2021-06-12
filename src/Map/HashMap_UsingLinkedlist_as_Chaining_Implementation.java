//HashSet implementation using Array of LinkedList...
//Search : O(l) where l is length of chaining
//Insert : O(l)
//Delete : O(l)

package Map;
import java.util.*;
import java.util.LinkedList;

class Entry<K,V>{
	K key;
	V value;
	
	Entry(K k,V v){
		key = k;
		value = v;
	}
	
	public int hashCode(){
		return key.hashCode();
	}
	
	public boolean equals(Object obj){
		Entry<K,V> e = (Entry<K,V>)obj;
		if(key.equals(e.key))return true;
		return false;
	}
	
	public String toString(){
		return ("("+key.toString()+","+value.toString()+")");
	}
}

class MyHashMap<K,V>{
	int bucket;
	ArrayList<LinkedList<Entry<K,V>>> table;
	
	MyHashMap(int size){
		bucket = size;
		table = new ArrayList<>();
		for(int i=0;i<size;i++)table.add(new LinkedList<Entry<K,V>>());
	}
	
	boolean put(K key,V value){
		//Typical hash function
		int hash = key.hashCode()%bucket;
		
		Entry<K,V> tmp = new Entry<K,V>(key,value);
		if(table.get(hash).contains(tmp)) {
			table.get(hash).set(table.get(hash).indexOf(tmp),tmp);
		}
		else {
			table.get(hash).add(tmp);
		}
		return true;
	}
	
	boolean remove(K key,V value){
		int hash = key.hashCode()%bucket;
		
		Entry<K,V> tmp = new Entry<K,V>(key,value);
		//type cast to call object remove method as we don't know index
		if(table.get(hash).contains(tmp)) {
			table.get(hash).remove(tmp);
			return true;
		}
		return false;
	}
	
	boolean contains(K key,V value){
		int hash = key.hashCode()%bucket;
		return table.get(hash).contains(new Entry<K,V>(key,value));
	}
	
	public String toString() {
		return table.toString();
	}
}


class Student{
	int roll;
	String name;
	
	Student(int roll,String name){
		this.roll = roll;
		this.name = name;
	}
	
	public int hashCode(){
		return roll;
	}
	
	public boolean equals(Object obj) {
		Student s = (Student)obj;
		return roll==s.roll;
	}
	
	public String toString() {
		return ("("+roll+", "+name+")");
	}
}

public class HashMap_UsingLinkedlist_as_Chaining_Implementation{
	
	public static void main(String[] args){
		
		MyHashMap<Student,Integer> hm = new MyHashMap<Student,Integer>(10);
		hm.put(new Student(2,"sahil"),Integer.valueOf(80));
		hm.put(new Student(5,"aftab"),Integer.valueOf(75));
		
		System.out.println(hm.contains(new Student(5,"aftab"),75));
	
		System.out.println(hm);
		hm.remove(new Student(5,"aftab"),75);
		
		System.out.print(hm);
	}
}
