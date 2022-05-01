# sudoku-solver

Solves a Sudoku from a file using a recursive algorithm.
The location and name of the file can be specified using the args parameter.
(e.g. java -jar sudoku.jar /home/user/sudoku/input.txt)
If the file does not match the correct syntax, an exception is thrown.
Empty spaces must be filled with 0.

Example format:

8 0 0 0 0 0 0 0 0
0 0 3 6 0 0 0 0 0
0 7 0 0 9 0 2 0 0
0 5 0 0 0 7 0 0 0
0 0 0 0 4 5 7 0 0
0 0 0 1 0 0 0 3 0
0 0 1 0 0 0 0 6 8
0 0 8 5 0 0 0 1 0
0 9 0 0 0 0 4 0 0

There are two ways to print the solved Sudoku, the console output or via a file called output.txt

Example format of the solved sudoku from input.txt:

8 1 2 7 5 3 6 4 9 
9 4 3 6 8 2 1 7 5 
6 7 5 4 9 1 2 8 3 
1 5 4 2 3 7 8 9 6 
3 6 9 8 4 5 7 2 1 
2 8 7 1 6 9 5 3 4 
5 2 1 9 7 4 3 6 8 
4 3 8 5 2 6 9 1 7 
7 9 6 3 1 8 4 5 2 
