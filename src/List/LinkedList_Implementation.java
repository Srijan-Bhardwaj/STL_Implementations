package List;

//Linked List implementation
//insert : O(n)
//delete : O(n)
//search : O(n)

class Node<T>{
	T data;
	Node next;
	
	Node(T data){
	this.data = data;
	next = null;
	}
}

class MyLinkedList<T>{
	Node<T> head;
	
	MyLinkedList(){
	head = null;
	}
	
	boolean insert(int pos,T data){
		Node<T> tmp = new Node<T>(data);
		
		if(pos==1){
			tmp.next = head;
			head = tmp;
		}
		else{
			Node<T> curr=head;
			for(int i=1;i<=pos-2&&curr!=null;i++)
				curr = curr.next;
			if(curr==null)return false;
			tmp.next = curr.next;
			curr.next = tmp;
		}
		return true;
	}
	
	boolean delete(int pos){
		
		if(head==null)return false;
		if(pos==1){
			head = head.next;
		}
		else{
			Node curr = head;
			for(int i=1;i<=pos-2&&curr.next!=null;i++)
				curr = curr.next;
			if(curr.next==null)return false;
			curr.next = curr.next.next;
		}
		return true;
	}
	
	int search(T data){
		int index=0;
		Node<T> curr = head;
		while(curr!=null){
			if(curr.data.equals(data))return index;
			index++;
			curr = curr.next;
		}
		return -1;
	}
	
	boolean contains(T data){
		return search(data)>-1;
	}
	
	public String toString(){
		Node curr = head;
		String ans="[";
		while(curr!=null){
			ans += curr.data.toString()+" ";
			curr = curr.next;
		}
		return ans+"]";
	}
}


public class LinkedList_Implementation{

	public static void main(String[] args){
	
		MyLinkedList<Student> ll = new MyLinkedList<Student>();

		ll.insert(1,new Student(20,"sahil"));
		ll.insert(2,new Student(30,"shariq"));
		ll.insert(3,new Student(40,"sangam"));
		ll.insert(4,new Student(50,"shyam"));
		ll.delete(3);
		System.out.println(ll.contains(new Student(20,"sahil")));
		System.out.println(ll);
	}
}