package Day4;

public class Student {
	
	String name;
	int roll_no;
	String address;
	String phone_no;
	
	 
	Student(String name,int roll_no,String stuaddress,String stuphone_no){
		this.name = name;
		this.roll_no = roll_no;
		this.address = stuaddress;
		this.phone_no = stuphone_no;
	}
	void display()
	{
		System.out.println(name);
		System.out.println(roll_no);
		System.out.println(address);
		System.out.println(phone_no);
			}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s1= new Student("John",2,"3400 Nathan ct, Rocklin CA 95677","916-234-2233");
		Student s2= new Student("Sam",3,"2300 Cirby ct, Roseville CA 95677","916-222-3456");
		
		s1.display();
		s2.display();
		
		
	}

}
