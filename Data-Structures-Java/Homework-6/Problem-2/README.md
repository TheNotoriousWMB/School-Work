#Description

This program reads in data from a text file regarding	the size of a WeightedQuickUnionUF object and vertices to union. It then unions those vertices and adds them to a component object which we can then display to the console. This program differs from Components.java in that it will not have unused component array elements as we will streamline the process utilizing a symbol table


************************************************************************************************************************************************************
Sample run:
************************************************************************************************************************************************************

    $ cat microUF.txt
        5
        1 0
        1 3
        2 4

    $ java AltComponents < microUF.txt
        2 components
            Component 0:
                0	1	3
            Component 1:
                2	4
