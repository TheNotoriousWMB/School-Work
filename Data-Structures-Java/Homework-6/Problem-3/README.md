#Description

##RandomizedQueue.java

This program gives us a RandomizedQueue class with which we can enqueue elements, dequeue random elements, sample random elements, and iterate through the entire queue

************************************************************************************************************************************************************
Sample run:
************************************************************************************************************************************************************

Adding numbers 0 - 4 to the queue...

    Iterating through 1 outer queue and 5 inner queues...
    Outer queue slot 0: 1
        Inner queue: [ 1 2 3 4 0 ]
    Outer queue slot 1: 4
        Inner queue: [ 4 2 3 0 1 ]
    Outer queue slot 2: 2
        Inner queue: [ 0 3 4 1 2 ]
    Outer queue slot 3: 0
        Inner queue: [ 0 3 4 2 1 ]
    Outer queue slot 4: 3
        Inner queue: [ 2 1 4 3 0 ]

    5 random samples from the queue...
    Sample 1: 1
    Sample 2: 3
    Sample 3: 2
    Sample 4: 1
    Sample 5: 3

    Dequeueing the entire queue...
    Queue: [ 0 3 2 4 1 ]

##Subset.java

This program creates a new RandomizedQueue object and adds string data from the command line. It then prints k amount, as designated from the command line, to the console

************************************************************************************************************************************************************
Sample run:
************************************************************************************************************************************************************

    $ echo Tom Dick Harry | java Subset 2
        Dick
        Tom
