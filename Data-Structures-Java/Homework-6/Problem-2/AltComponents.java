import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class AltComponents {
	public static void main(String[] args) {

	    // Amount of elements in WeightedQuickUnionUF object
		int N = StdIn.readInt();

		// Create WeightedQuickUnionUF object
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);

		// Read in vertices to union and connect them
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();

			uf.union(p, q);
		}

		// Create new Symbol Table object to store representatives and their
		//  approrpiated index
		ST<Integer, Integer> st = new ST<Integer, Integer>();

		// Initialize out index counter at 0
		int index = 0;

		// For each member of our WeightedQuickUnionUF object,
		//  i.e. integers 0 through N-1, we check to see if their
		//  representative is in our symbol table. If not, we
		//  add the representative to the table with the value of
		//  index currently, then increment index
		for (int i = 0; i < N; ++i) {
			if (!st.contains(uf.find(i))) {
				st.put(uf.find(i), index);

				++index;
			}
		}

		// Create new array of Queues for out components
		Queue<Integer>[] components = (Queue<Integer>[]) new Queue[st.size()];

		// Initialize queues within components array
		for (int i = 0; i < st.size(); ++i) {
			components[i] = new Queue<Integer>();
		}

		// For each member of our WeightedQuickUnionUF object,
		//  i.e. integers 0 through N-1, add the integer to the
		//  appropriate queue, using the value associated to
		//  the integer's representative in our symbol table
		//  as the appropriate index within the array of
		//  component queues
		for (int i = 0; i < N; ++i) {
			components[st.get(uf.find(i))].enqueue(i);
		}

		displayComponents(uf, components);
	}

        public static void displayComponents(WeightedQuickUnionUF uf,
			Queue<Integer>[] components) {
		// Output header
		StdOut.println(uf.count() + " components");

		int count = 0;	// Indicates which # component

		// For the size of the components array
		for (int i = 0; i < components.length; ++i) {
			// If the array element is not an empty queue,
			//  i.e. the queue has data in it, we will then
			//  print out all of the vertices for that component
			if (!components[i].isEmpty()) {
				StdOut.println("Component " + count + ":");

				// Print elements of specific component array to
				//  console until we have exhausted it
				while (!components[i].isEmpty()) {
					StdOut.print("\t" + components[i].dequeue());
				}

				++count;	// Incremented if we have just
							//  printed a non-empty queue

				StdOut.println();
			}
		}
	}
}
