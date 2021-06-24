//Doubly Linked List Implementation
//insert : O(n)
//delete : O(n)
//search : O(n)
//reverse : theta(n)

package List;

class DNode<T>{
	T data;
	DNode prev;
	DNode next;
	
	DNode(T data){
		this.data = data;
		prev = null;
		next = null;
	}
}

class MyDoublyLinkedList<T>{
	DNode<T> head;

	boolean insert(int pos,T data){
		DNode<T> tmp = new DNode<T>(data);
		
		if(pos==1){
			tmp.next = head;
			if(head!=null)
				head.prev = tmp;
			head = tmp;
		}
		else{
			DNode<T> curr = head;
			for(int i=1;i<=pos-2&&curr!=null;i++){
				curr=curr.next;
			}
			if(curr==null) return false;
			tmp.next = curr.next;
			if(curr.next!=null)
			curr.next.prev = tmp;
			tmp.prev = curr;
			curr.next = tmp;
		}
		return true;
	}
	
	boolean delete(int pos){
		
		if(head==null)return false;
		if(pos==1){
			head=head.next;
			if(head!=null)
				head.prev=null;
		}
		else{
			DNode curr = head;
			for(int i=1;i<=pos-2&&curr.next!=null;i++){
				curr = curr.next;
			}
			if(curr.next==null)return false;
			curr.next = curr.next.next;
			if(curr.next!=null)
			curr.next.prev = curr;
		}
		return true;
	}
	
	int search(T data){
		DNode curr = head;
		int index = 0;
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
	
	void reverse(){
		DNode curr = head;
		DNode tmp = null;
		if(head==null || head.next==null)return;
		
		while(curr!=null){
			tmp = curr.prev;
			curr.prev = curr.next;
			curr.next = tmp;
			curr=curr.prev;
		}
		head = tmp.prev;
	}
	
	public String toString(){
		StringBuilder res = new StringBuilder("[");
		DNode curr = head;
		while(curr!=null){
			res.append(curr.data.toString()).append(", ");
			curr = curr.next;
		}
		if(head==null)res.append("]");
		else res.append("\b\b]");
		return res.toString();
	}
}

public class DoublyLinkedList_Implementation{
	
	public static void main(String[] args){
		MyDoublyLinkedList<Student> dll = new MyDoublyLinkedList<>();
		
		dll.insert(1,new Student(37,"sumit"));
		dll.insert(2,new Student(35,"shashank"));
		dll.insert(2,new Student(20,"shariq"));
		dll.insert(1,new Student(45,"sahal"));
		
		dll.delete(5);
		
		System.out.println(dll.contains(new Student(40,"shariq")));
		System.out.println(dll);
		dll.reverse();
		System.out.println(dll);
	}
}