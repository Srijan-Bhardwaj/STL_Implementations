package List;

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
