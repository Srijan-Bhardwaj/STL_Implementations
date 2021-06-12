//ArrayList implementation
//Time complexity :
//insert : O(n)
//delete : O(n)
//search : O(n)

package List;

class MyArrayList<T>{
	private T[] arr;
	private int size=0;
	
	@SuppressWarnings("unchecked")
	MyArrayList()
	{
		arr = (T[])new Object[10];
	}
	
	@SuppressWarnings("unchecked")
	MyArrayList(int capacity){
		arr = (T[])new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	private void extend(T[] arr) {
		T[] tmp = (T[])new Object[(3*arr.length)/2+1];
		//copying elements
		for(int i=0;i<size;i++)tmp[i]=arr[i];
		this.arr = tmp;
	}
	
	public boolean add(T ele) {
		if(size==arr.length)extend(arr);
		arr[size++] = ele;
		return true;
	}
	
	public boolean add(int index,T ele) throws Exception{
		if(index<0 || index>size)throw new Exception("Invalid index");
		if(size==arr.length)extend(arr);
		
		for(int i=size;i>index;i++) {
			arr[i] = arr[i-1];
		}
		arr[index] = ele;
		size--;
		return true;
	}
	
	public T get(int index) throws Exception{
		if(index<0 || index>=size)throw new Exception("Invalid index");
		return arr[index];
	}
	
	public boolean remove(int index) throws Exception {
		if(index<0 || index>=size)throw new Exception("Invalid index");
		for(int i=index+1;i<size;i++) {
			arr[i-1] = arr[i];
		}
		arr[--size]=null;
		return true;
	}
	
	public boolean remove(T ele) throws Exception{
		if(indexOf(ele)==-1)return false;
		return remove(indexOf(ele));
	}
	
	public int indexOf(T ele) {
		for(int i=0;i<size;i++) {
			if(arr[i].equals(ele))
				return i;
		}
		return -1;
	}
	
	public boolean contains(T ele) {
		for(int i=0;i<size;i++)
			if(arr[i].equals(ele))
				return true;
		
		return false;
	}
	
	public String toString() {
		String ans="[";
		for(T ele:arr) {
			ans += ele+", ";
		}
		ans = ans.substring(0,ans.length()-2);
		ans += "]";
		return ans;
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
		return roll==s.roll && name.equals(s.name);
	}
	
	public String toString() {
		return ("("+roll+", "+name+")");
	}
}

public class ArrayList_Implementation {
	
	public static void main(String[] args) {
		MyArrayList<Student> arr = new MyArrayList<Student>();
		try {
		arr.add(new Student(23,"paraksh"));
		arr.add(new Student(40,"satyam"));
		arr.add(new Student(13,"rohit"));

		System.out.println(arr.get(2));
		System.out.println(arr.contains(new Student(13,"rohit")));
		System.out.println(arr);
		arr.remove(new Student(40,"satyam"));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(arr);	
	}
}
