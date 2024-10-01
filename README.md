# Assignment 2

Odds and evens game is a very simple game.

Setup: Two players face each other.

Decision: One player decides if they want to be odds or evens. Let’s say Player A chooses evens.

Gameplay: Both players simultaneously show any number of fingers from 0 to 5.

Counting: If the total number of fingers shown by both players is even (0, 2, 4, 6, 8, 10), Player A wins because they chose evens. If it’s odd (1, 3, 5, 7, 9), Player B wins because they didn’t choose evens.

Winner: The player who correctly predicted the total (odd or even) wins that round.

Repeat: Players can play multiple rounds to determine an overall winner.

Consider that it is not really important what the exact numbers the players show are; what is important is whether they are odds or evens.

When you add two numbers:

Odd + Odd = Even: When you add two odd numbers together, the result is always even. For example: 1 (odd) + 3 (odd) = 4 (even)

Even + Even = Even: When you add two even numbers together, the result is always even. For example: 2 (even) + 4 (even) = 6 (even)

Odd + Even = Odd: When you add an odd number and an even number together, the result is always odd. For example: 1 (odd) + 2 (even) = 3 (odd)

Even + Odd = Odd: This is the same as above, just in reverse order. When you add an even number and an odd number together, the result is always odd. For example: 2 (even) + 3 (odd)= 5 (odd)

In this assignment you need to implement this game in Java. A human player plays against an artificial intelligence (AI), called HAL-9000 (I hope you get the reference :)). This is a game of chance, but also a game of psychology! The AI will try to learn the behaviour of the human player and attempt to guess the player’s next move.

# The Commands
Before proceeding with the tasks, read the code provided to you and start to familiarise yourself with the command-line interface.

To run the application in VS Code in an interactive mode, run the Main class using the Maven wrapper through VS Code’s built-in terminal. If the terminal window is not open, you can open it by clicking on the Terminal menu, then New Terminal. Then type the following command:

./mvnw clean compile exec:java@run for Unix/Mac OS or .\mvnw.cmd clean compile exec:java@run for Windows

To run test cases:

./mvnw clean compile test for Unix/Mac OS or .\mvnw.cmd clean compile test for Windows
