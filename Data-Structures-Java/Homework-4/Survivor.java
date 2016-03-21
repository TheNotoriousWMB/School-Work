import edu.princeton.cs.algs4.Queue;

public class Survivor {
	public static void main(String[] args) {
		// Take m and C from command line input with program call
		int m = Integer.parseInt(args[0]);
		int C = Integer.parseInt(args[1]);

		// Tests 1 <= n <= C
		for (int i = 1; i <= C; ++i)
		{
			// i value will serve as our n
			System.out.println(i + "\t" + idealPosition(m, i));
		}
	}

	public static int idealPosition(int m, int n) {
		Queue<Integer> people = new Queue<Integer>();

		// Populate queue using zero-indexing from 0 to n
		for (int i = 0; i < n; ++i) {
			people.enqueue(i);
		}

		if (!people.isEmpty()) {
			// Leaves the survivor so we can return their position
			while (people.size() > 1) {
				for (int j = 0; j < (m - 1); ++j) {
					// This will shift the queue to the left m - 1 times in
					// order to simulate going around a circle. Simpler than
					// creating a doubly-linked list based structure that can
					// arbitrarily remove any node from the list. And we will
					// not need to reference the queue in its original form
					// again
					people.enqueue(people.dequeue());
				}
				// This will remove the person from the front of the queue as it
				// is currently, which after our shifting will be the mth person
				// since the last elimination
				people.dequeue();
			}
			// This will return the survivor who should be the only remaining
			// person in the queue at this point
			return people.peek();
		}
		return 0;
	}
}
