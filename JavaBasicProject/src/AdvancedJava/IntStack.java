package AdvancedJava;

//import java.lang.reflect.Array;

public class IntStack {

	public static int top=-1;
	public int size;
	public int[] arr;
	
	public IntStack(int size){
		this.arr= new int[size];
		this.size=size;
	}
	
	public boolean isFull(){
		return (top==size-1);
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	public void push(int element){
		if(isFull()){
			System.out.println("Stack is full, can't push " + element);			
		}else{
			top++;
			arr[top]=element;
			System.out.println("Pushing " + element);
		}
	}
	
	public int pop(){
		int temp=-1;
		if(isEmpty()){
			System.out.println("Stack is empty, can't pop");
		}else{
			temp=arr[top];
			top--;
			System.out.println("Popping " + temp);
		}
		return temp;
	}
	
	public int peek(){
		int temp=-1;
		if(isEmpty()){
			System.out.println("Stack is empty");
		}else{
			temp=arr[top];
			
		}
		return temp;
	}
	
	public void display(){
		if(isEmpty()){
			System.out.println("Stack is empty");
		}else{
			System.out.println("Stack contains");
			for(int i=top;i>=0;i--){
				System.out.println(arr[i] + " ");
			}
			System.out.println();
		}
	}
	
//	public void toDisplay(Object obj){
//		Student_Object so= (Student_Object) obj;
//		System.out.println(so.id+ " "+ so.name+ " "+so.marks);
//	}
	
	public static void main(String[] args) {
		IntStack s= new IntStack(5);
		int x;
		
		s.push(30);
		s.push(40);
		s.push(20);
		s.push(10);
		s.display();
		
		x = s.pop();
		x = s.pop();
		s.push(100);
		s.push(200);
		s.push(300);
		s.push(400);
		s.display();
		
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.display();
		
		x = s.peek();
		System.out.println("peek returned " + x);
		
		s.display();
		
		s.pop();
		s.pop();
		s.display();
	}

}
