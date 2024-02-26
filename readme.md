Chutes and Ladder game introduction!!

Instructions:
1) This delightful game is simple and easy to play, even for children who can't read. 
    Fun pictures help kids understand the rewards of doing good deeds as they climb up the ladders-and the consequences 
    of naughty ones as they slide down the chutes.
2) It is designed for 2 to 4 Players
3) Contents applicable for this online version: Board, spinner(dice), ladders, chutes

Objective: 
- First Player who reaches #100, is the winner!!

V2 Functional Enhancements done as part of the assignment:
1) Dynamic input for number of players, rather than a fixed set of players. 
2) Only 2 to 4 players should be allowed to play, otherwise throw an exception with a proper message.
3) Initialize the board 100 * 100. 
if it's beyond a limit, throw an exception
4) Added exception class and exceptions wherever necessary.
5) Created Model classes, interfaces for service implementations
6) Added testcases
7) Modulerized the code. 
8) Added logger statements. Note: Logger.info is not be needed in the production environment. 

TO DO:
1) The code can be further enhanced to take an n * n input where n is user defined.
2) Dynamic assignment of ladders and chutes.

SOLID design principles followed as part of the enhancement:
1) Single responsibility: One model class is handling a single responsibility. e.g. Spinner service impl class
2) Open for extension, closed for modification: Classes are designed in such a way that, they can be extended when needed.
3) Interface segregation principle: Multiple interfaces designed. so that implemeting classes only have to be concerned about methods interest to them.


