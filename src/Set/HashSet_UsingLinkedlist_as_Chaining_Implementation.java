//HashSet implementation using Array of LinkedList...
//Search : O(l) where l is length of chaining
//Insert : O(l)
//Delete : O(l)

package Set;
import java.util.*;
import java.util.LinkedList;


class MyHashSet<T>{
	int bucket;
	ArrayList<LinkedList<T>> table;
	
	MyHashSet(int size){
		bucket = size;
		table = new ArrayList<>();
		for(int i=0;i<size;i++)table.add(new LinkedList<T>());
	}
	
	boolean add(T s){
		//Typical hash function
		int hash = s.hashCode()%bucket;
		
		//Duplicate values are not allowed
		if(!table.get(hash).contains(s)) {
		table.get(hash).add(s);
		return true;
		}
		return false;
	}
	
	boolean remove(T s){
		int hash = s.hashCode()%bucket;
		
		//type cast to call object remove method as we don't know index
		if(table.get(hash).contains(s)) {
		table.get(hash).remove(s);
		return true;
		}
		return false;
	}
	
	boolean contains(T s){
		int hash = s.hashCode()%bucket;
		return table.get(hash).contains(s);
	}
	
	public String toString() {
		return (table.toString());
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

public class HashSet_UsingLinkedlist_as_Chaining_Implementation{
	
	public static void main(String[] args){
		
		MyHashSet<Student> hs = new MyHashSet<Student>(10);
		
		hs.add(new Student(3,"srijan"));
		hs.add(new Student(5,"sahil"));
		hs.add(new Student(15,"srijan"));
		
		System.out.println(hs.contains(new Student(5,"sahil")));
		System.out.println(hs);
		
		hs.remove(new Student(3,"srijan"));
		
		System.out.println(hs);
	}
}