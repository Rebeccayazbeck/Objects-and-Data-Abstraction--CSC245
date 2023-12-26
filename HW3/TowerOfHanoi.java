package homework3;

public class TowerOfHanoi {
	
	public class Stack
	{
	    int capacity;
	    int top;
	    int array[];
	}
	 
	// Function to create a stack of given capacity.
	Stack createStack(int capacity)
	{
	    Stack stack = new Stack();
	    stack.capacity = capacity;
	    stack.top = -1;
	    stack.array = new int[capacity];
	    return stack;
	}
	 
	// Stack is full when the top is equal
	// to the last index
	public boolean isFull(Stack stack)
	{
	    return (stack.top == stack.capacity - 1);
	}
	 
	// Stack is empty when top is equal to -1
	public boolean isEmpty(Stack stack)
	{
	    return (stack.top == -1);
	}
	 
	// Function to add an item to stack.It
	// increases top by 1
	public void push(Stack stack, int item)
	{
	    if (isFull(stack))
	        return;
	         
	    stack.array[++stack.top] = item;
	}
	 
	// Function to remove an item from stack.It
	// decreases top by 1
	public int pop(Stack stack)
	{
	    if (isEmpty(stack))
	        return Integer.MIN_VALUE;
	         
	    return stack.array[stack.top--];
	}
	 
	// Function to implement legal movement between
	// two poles
	public void moveDisksBetweenTwoPoles(Stack src, Stack dest,
	                              char s, char d)
	{
	    int pole1TopDisk = pop(src);
	    int pole2TopDisk = pop(dest);
	 
	    // When pole 1 is empty
	    if (pole1TopDisk == Integer.MIN_VALUE)
	    {
	        push(src, pole2TopDisk);
	        moveDisk(d, s, pole2TopDisk);
	    }
	     
	    // When pole2 pole is empty
	    else if (pole2TopDisk == Integer.MIN_VALUE)
	    {
	        push(dest, pole1TopDisk);
	        moveDisk(s, d, pole1TopDisk);
	    }
	     
	    // When top disk of pole1 > top disk of pole2
	    else if (pole1TopDisk > pole2TopDisk)
	    {
	        push(src, pole1TopDisk);
	        push(src, pole2TopDisk);
	        moveDisk(d, s, pole2TopDisk);
	    }
	    // When top disk of pole1 < top disk of pole2
	    else
	    {
	        push(dest, pole2TopDisk);
	        push(dest, pole1TopDisk);
	        moveDisk(s, d, pole1TopDisk);
	    }
	}
	 
	// Function to show the movement of disks
	public void moveDisk(char fromPeg, char toPeg, int disk)
	{
	    System.out.println("Move the disk " + disk +
	                            " from " + fromPeg +
	                              " to " + toPeg);
	}
	 
	// Function to implement TOH puzzle
	public void tohIterative(int num_of_disks, Stack
	                  src, Stack aux, Stack dest)
	{
	    int i, total_num_of_moves;
	    char s = 'S', d = 'D', a = 'A';
	  
	    // If number of disks is even, then
	    // interchange destination pole and
	    // auxiliary pole
	    if (num_of_disks % 2 == 0)
	    {
	        char temp = d;
	        d = a;
	        a  = temp;
	    }
	    total_num_of_moves = (int)(Math.pow(
	                         2, num_of_disks) - 1);
	  
	    // Larger disks will be pushed first
	    for(i = num_of_disks; i >= 1; i--)
	        push(src, i);
	  
	    for(i = 1; i <= total_num_of_moves; i++)
	    {
	        if (i % 3 == 1)
	          moveDisksBetweenTwoPoles(src, dest, s, d);
	  
	        else if (i % 3 == 2)
	          moveDisksBetweenTwoPoles(src, aux, s, a);
	  
	        else if (i % 3 == 0)
	          moveDisksBetweenTwoPoles(aux, dest, a, d);
	    }
	}

	/*
	 * I apologize for having to rely heavily on online resources to implement the Tower of Hanoi iteratively. 
	 * It was an incredibly challenging task, and I found it nearly impossible to come up with a solution on my own.
	 */
	
	
	
	
	public static void moveOneDisk(int i,int j) {
		System.out.println("Move disk from"+i+"to"+j);
	}
	
	public static void moveTower(int n, int s, int e, int m) {
			/*move disk from s to e using m as needed*/
		
		if (n==1)
			moveOneDisk(s,e);
		else {
			moveTower(n-1,s,m,e);
			moveOneDisk(s,e);
			moveTower(n-1,m,e,s);
		}
		
		/*for:
		 * n=3 t=31ms
		 * n=5 t=58ms
		 * n=10 t= 62ms
		 * n=30 t= more than 10 min
		 * n=100 t= more than 10 min
		 */
	}
	
	
	public static void main(String[] arg) {

           // moveTower(3,1,2,3);
		 int num_of_disks = 3;
	     
		    TowerOfHanoi ob = new TowerOfHanoi();
		    Stack src, dest, aux;
		     
		    // Create three stacks of size 'num_of_disks'
		    // to hold the disks
		    src = ob.createStack(num_of_disks);
		    dest = ob.createStack(num_of_disks);
		    aux = ob.createStack(num_of_disks);
		     
		    ob.tohIterative(num_of_disks, src, aux, dest);
		}	

}
		
	

