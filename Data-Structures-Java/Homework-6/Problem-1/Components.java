import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Components {
	public static void main(String[] args) {

		// Amount of elements in WeightedQuickUnionUF object
		int N = StdIn.readInt();

		// Create WeightedQuickUnionUF and array of Queue objects
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		Queue<Integer>[] components = (Queue<Integer>[]) new Queue[N];

		// Initialize queues within components array
		for (int i = 0; i < N; ++i) {
			components[i] = new Queue<Integer>();
		}

		// Read in vertices to union and connect them
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();

			uf.union(p, q);
		}

		// For each member of our WeightedQuickUnionUF object,
		//  i.e. integers 0 through N-1, we will add the integers
		//  to the appropriate queue, using the representative of
		//  the integer as the correct array index to indicate
		//  which queue from the array to enqueue our value into
		for (int i = 0; i < N; ++i) {
			components[uf.find(i)].enqueue(i);
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
