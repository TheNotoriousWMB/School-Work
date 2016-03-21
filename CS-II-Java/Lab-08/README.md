#Monetary Value

Write an application that prompts for and reads a double value representing a monetary amount. Then determine the fewest number of each bill and coin needed to represent that amount, starting with the highest (assume that a ten-dollar bill is the maximum size needed). For example, if the value entered is 47.63 (forty-seven dollars and sixty-three cents), then the program should print the equivalent amount as shown below. Continue prompting until the user enters “quit”.

    4 ten dollar bills
    1 five dollar bills
    2 one dollar bills
    2 quarters
    1 dimes
    0 nickels
    3 pennies

You must develop at least one class (excluding the driver class) for this assignment. You must also use a try-catch statement in your driver class to handle invalid input entered by the user (e.g. an invalid string is entered instead of a double). In the event of such an exception, print a statement indicating the exception occurred as follows and continue looping until the user enters “quit”.

    EXCEPTION: Invalid input
    
************************************************************************************************************************************************************
Sample run:
************************************************************************************************************************************************************

    Please enter a monetary value ($x.xx): $47.63
    
    4 ten dollar bills
    1 five dollar bills
    2 one dollar bills
    2 quarters
    1 dimes
    0 nickels
    3 pennies

    Please press Enter to continue or enter Quit to quit: enter

    Please enter a monetary value ($x.xx): $hi

    EXCEPTION: Invalid input
    
    Please press Enter to continue or enter Quit to quit: enter
    
    Please enter a monetary value ($x.xx): $8.63
    
    0 ten dollar bills
    1 five dollar bills
    3 one dollar bills
    2 quarters
    1 dimes
    0 nickels
    3 pennies
    
    Please press Enter to continue or enter Quit to quit: quit

