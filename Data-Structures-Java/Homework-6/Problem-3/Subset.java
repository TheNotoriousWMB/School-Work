import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Subset 
{
	public static void main(String[] args) 
	{
		// Read size of RandomizedQueue from command line
		int k = Integer.parseInt(args[0]);
		
		// Create new RandomizedQueue object
		RandomizedQueue<String> data = new RandomizedQueue<String>();
		
		// Read in string objects from command line and add
		//  them to RandomizedQueue
		while(!StdIn.isEmpty())
		{
			data.enqueue(StdIn.readString());
		}
		
		// Dequeue k items from the RandomizedQueue and
		//  print them to the console
		for (int i = 0; i < k; ++i)
		{
			StdOut.println(data.dequeue());
		}
	}
}
