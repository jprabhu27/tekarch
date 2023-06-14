package AdvancedJava;

public class Queue {

	private int front, rear, capacity;
    private int queue[];
 
    public Queue(int c)
    {
        front = rear = 0;
        capacity = c;
        queue = new int[capacity];
    }
 
    // function to insert an element
    // at the rear of the queue
    public void enqueue(int data)
    {
        // check queue is full or not
        if (capacity == rear) {
            System.out.println("Queue is full can't enque " + data);
        }
 
        // insert element at the rear
        else {
            queue[rear] = data;
            rear++;
            System.out.println("Enqueuing " + data);
        }
    }
 
    // function to delete an element
    // from the front of the queue
    public int dequeue()
    {
    	int temp = -1;
    	
        // if queue is empty
        if (front == 0 && rear == 0) {
            System.out.println("Queue is empty can't deque");
        }
 
        // shift all the elements from index 2 till rear
        // to the right by one
        else {
        	temp = queue[front];
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }
 
            // store 0 at rear indicating there's no element
            if (rear < capacity)
                queue[rear] = 0;
 
            // decrement rear
            rear--;
            System.out.println("Dequeuing " + temp);
        }
        
        return temp;
    }
 
    // print queue elements
    public void display()
    {
        int i;
        if (front == rear) {
            System.out.println("Queue is Empty");
            return;
        }
 
        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
            System.out.print(" " + queue[i] + " <-- ");
        }
        System.out.println();
    }
 
    // print front of queue
    public int peek()
    {
    	int temp = -1;
    	
        if (front == 0 && rear == 0) {
            System.out.printf("Queue is Empty");
        }
        else 
        {
        	temp = queue[front];
        	System.out.println("Front Element is: " + temp);
        }
        return temp;
    }
	
	public static void main(String[] args) {

		// Create a queue of capacity 4
        Queue q = new Queue(4);
 
        // print Queue elements
        q.display();
 
        // inserting elements in the queue
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
 
        // print Queue elements
        q.display();
 
        // insert element in the queue
        q.enqueue(60);
 
        // print Queue elements
        q.display();
 
        q.dequeue();
        q.dequeue();
        System.out.println("\nAfter dequeing two elements\n");
 
        // print Queue elements
        q.display();
 
        // print front of the queue
        q.peek();
	}

}
