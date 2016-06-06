#Description

This program reads in from a text file, the number of vertices in a graph, and an adjacency matrix for the graph. It will then use a Topological Sorting algorithm to find the sorting of the graph. In the event there exists a cycle on the graph, this will be detected. 

Upon detection of a cycle, a recursive depth first search will be used to find a cycle on the graph. Whether the graph is cyclic or acyclic, this will be acknowledged in the output, along with the appropriate data from the graph. Either a correct Topological Sorting or a cycle will be printed.

*****************************************************************************************************************************************
 Sample run:
*****************************************************************************************************************************************

	$ cat input.txt 
		6
		0 1 0 0 0 0
		0 0 1 0 0 0
		0 0 0 1 0 0
		0 0 0 0 1 0
		0 0 0 0 0 1
		0 0 0 1 0 0
		
	$ java main < input.txt
		Cycle:  3 -> 4 -> 5 -> 3
		
	$ cat input.txt
		3
		0 1 0
		0 0 1
		0 0 0
		
	$ java main < input.txt
		Topological sorting: 0, 1, 2
