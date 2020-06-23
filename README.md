# Roulette_Console_Project

Roulette is a popular casino game. The aim of the exercise is to create a simple command line multiplayer version of the game.
On start-up, load a file which contains a list of player's names, For my case I did create a file named "file.txt" which contains two names of two players,the txt file is commited as well.

Once started, it should read lines from the console, each line will contain the player's name, what they want to bet on (either a number from 1-36, EVEN or ODD), and how much they want to bet, For example Tiki_monkey as a player name, 2 number what they want to bet andm 3.0 as a bet's amount.

To make it clear the player should write it like this, Tiki_Monkey 2 3.0

The application should support multiple bets from the same user within a round.
Every 30 seconds the game should choose a random number between 0 and 36 (inclusive) for the ball to land on.
If the number is 1-36 then any bet on that number wins, and the player wins 36x the bet's amount.
If the number is even, any bet on EVEN wins, and the player wins 2x the bet's amount.
If the number is odd, any bet on ODD wins, and the player wins 2x the bet's amount.
All other bets lose.
It must be possible to place bets and choose a random number concurrently.
The game should print to the console the number and for each bet - the player's name, the bet, whether they won or lost, and how much they won.

We will have to excepect somethin like this as output

Number: 4

Player      Bet   Outcome   Winnings
---
Tiki_Monkey 2     LOSE      0.0
Barbara EVEN      WIN       6.0


########################################
How to run it?

Once in the folder called Part2, you follow the command lines below since we have diffrentes folders in which we have the txt file and the main file as well,

cd src
java com.company.Main // if the file is forgotten, the program will remind you add it
java com.company.Main file.txt

It is your turn to bet.
