#Desription

Research the following games. For example, view YouTube clips, read Wikipedia articles, do Internet searches, play modern versions, and the like. Yes you get to play games for this assignment.

    1024
    1942
    Asteroids
    Ataxx
    Battle City
    Bejeweled
    Boulder Dash
    Frogger
    Joust
    Lunar Lander
    Minesweeper
    Missile Command
    Omega Race
    Pacman
    Puzzle bobble
    Qix
    Reversi
    Solitaire
    Space Invaders
    Tron (only need to implement one stage)

Pick one of the above games and design your own version using SDL. It should feature the core mechanics from the original with at least one additional feature of your own design. You do not need to, and I suggest you do not, implement computer players e.g. Reversi between two human players that take turns. You game only needs to have one level that highlights all of your features. However, it should be fully playable with sound. Use freely available sounds and graphics or make your own.

************************************************************************************************************************************************************
Sample run:
************************************************************************************************************************************************************

    $ make

        gcc main.c -Wall -std=c99 -I/opt/local/include -lm -lSDL2 -lSDL2_image -lSDL2_ttf -lSDL2_mixer -L/opt/local/lib  -o project03_01
        
    $ ./project03_01 

