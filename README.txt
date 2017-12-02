---Longest Subsequence Matches--- 02/12/2017
The program is written in Java and is developed using Eclipse IDE (Neon.1).

Input:
A text file named list.txt that contains names of source code files in which subsequence has to be found 
several text or java files (to be read by program) containing source code 

Output:
The program creates and writes two output files Matches.csv and Tokens.csv 

1: It reads source code from a set of files and then tokenizes the lines of source code using following Regex expression.
"[\\w--]+|[\\w++][a-zA-Z]+|\\\\d+|[\\\\^$.|?<>;=]|[()]+|[\\{}]+|[++]+|[--]+\n\n\n"

2: The tokens are written to a file Tokens.csv along with the count and score of each line of source code.
The first csv column is for score, second is for number of tokens, third is for count and fourth onwards contains tokens.
I have saved tokens instead of source code line so to give the reader a hint of where is the problem in case the line is not tokenized as expected.

3: In the next step, the code finds unique tokens, associates an integer code with each token.

4: Each source code line is then converted to a string of integers and longest common match between two strings is found using Dynamic
Programming technique supplemented by a function that finds subsequences across files. The matches along with score and count of each match 
is written to Matches.csv file.


Testing:
I have tested the program on 6 files: input1, input2 , input3, input4, Logger and MetricsCalculator and the Matches.csv and Tokens.csv file contains the output.
 