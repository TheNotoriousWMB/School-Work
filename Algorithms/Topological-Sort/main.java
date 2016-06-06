import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class main {
	private static boolean[][] graph; // Graph from user
	private static int N; // User designated number of vertices
	private static Queue<Integer> adjacency[]; // Adjacency list for each vertex
	private static Queue<Integer> sorting; // Topological sorting
	private static Queue<Integer> inDegZero; // Queue of vertices with indegree
												// of 0, used in topological
												// sorting
	private static int[] inDegrees; // Array of indegrees for each vertex
	private static int remEdges = 0; // # of remaining edges, used in cycle
										// detection
	private static boolean cycleDetected = false; // Cycle detection sentinel
	private static boolean visited[]; // Used in DFS
	private static Stack<Integer> cycle; // Cycle, if detected
	private static boolean cycleFound = false; // If cycle found

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Get # of vertices from user
		N = scan.nextInt();

		// Initialize data structures
		graph = new boolean[N][N];
		adjacency = new Queue[N];
		for (int i = 0; i < N; ++i)
			adjacency[i] = new LinkedList<Integer>();
		inDegZero = new LinkedList<Integer>();
		sorting = new LinkedList<Integer>();
		visited = new boolean[N];

		// Populate graph
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				if (scan.nextInt() == 1) {
					set(i, j);
					adjacency[i].add(j); // Add vertex j to i's adjacency list
					remEdges++; // Increment # of edges in graph
				} else
					clear(i, j);

		topologicalSort();

		// Cyclic case
		if (cycleDetected) {
			StringBuilder cycleStr = new StringBuilder();
			while (!cycle.isEmpty()) {
				cycleStr.append(cycle.pop() + " >- ");
			}
			cycleStr.delete(cycleStr.length() - 3, cycleStr.length());
			cycleStr.reverse();
			System.out.println("Cycle: " + cycleStr.toString());
		}
		// Acyclic case
		else {
			StringBuilder sortingStr = new StringBuilder();
			for (int n : sorting)
				sortingStr.append(n + ", ");
			sortingStr.delete(sortingStr.length() - 2, sortingStr.length());
			System.out.println("Topological sorting: " + sortingStr.toString());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void topologicalSort() {
		// Initialize indegrees for all vertices
		setIndegrees();

		// Find initial vertices with indegree of 0 and add to queue
		for (int i = 0; i < N; ++i)
			if (inDegrees[i] == 0)
				inDegZero.add(i);

		do {
			int curr = inDegZero.remove(); // Current vertex to process
			int outDegree = adjacency[curr].size(); // Outdegree of current
													// vertex
			sorting.add(curr); // Add current vertex to topological sorting

			for (int i = 0; i < outDegree; ++i) {
				// Remove edge from curr to w
				int w = adjacency[curr].remove();
				inDegrees[w]--;
				remEdges--;

				// If w now has indegree 0, add to queue for processing
				if (inDegrees[w] == 0)
					inDegZero.add(w);
			}
		} while (!inDegZero.isEmpty());

		// Cycle detected if edges exists not yet processed
		if (remEdges == 0)
			return;

		cycleDetected = true; // Cycle detected

		cycle = new Stack();

		// Find first remaining vertex of indegree > 0
		int i = 0;
		while (inDegrees[i] == 0)
			i++;

		cycleDFS(i);
	}

	private static void cycleDFS(int i) {
		cycle.push(i); // Add i to cycle

		if (visited[i]) { // Cycle found
			cycleFound = true;
			return;
		}

		visited[i] = true; // Mark visited

		for (int j = 0; j < N; ++j)
			// Recursively run cycleDFS for all valid neighbors. Valid neighbors
			// are both adjacent to i and remain in the subgraph after the
			// initial topological sorting algorithm, this is detected by
			// checking the indegree of these neighbors for 0.
			if (graph[i][j] && inDegrees[j] > 0) {
				cycleDFS(j);

				if (cycleFound)
					return;
			}
		cycle.pop(); // Remove i from cycle
	}

	private static void setIndegrees() {
		inDegrees = new int[N];

		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				if (graph[i][j])
					inDegrees[j]++;
	}

	private static void set(int i, int j) {
		graph[i][j] = true;
	}

	private static void clear(int i, int j) {
		graph[i][j] = false;
	}
}
