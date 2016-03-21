#A Problem From Antiquity

In the *Joesephus* problem, *n* people are in dire straits and agree to the following strategy to reduce the population. They arrange themselves in a circle, at positions numbered 0 to *n*-1 and proceed around the circle, eliminating every *m*th person until only one person is left. Legend has it that *Josephus* figured out where to sit to avoid being eliminated.

Your solution should include a method, *idealPosition*, which will compute the position of the "last man standing", given *m* and *n*.

#Demonstrating your work

To demonstrate your method, write a complete Java program, named **Survivor**, which takes two comman-line arguments: *m* and *C*. The value of *m* is described above and *C* is the maximum number of people arranged in a circle. Your program should tabulate the ideal position for every possible circle size, 1 <= *n* <= *C*. Each line of output gives the circle size and ideal position for that circle.

************************************************************************************************************************************************************
Sample run:
************************************************************************************************************************************************************

    $	java Survivor 2 8
	    1	0
	    2	0
	    3	2
	    4	0
	    5	2
	    6	4
	    7	6
	    8	0
