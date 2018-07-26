PROJECT TITLE: TimeTable

PURPOSE OF PROJECT:
To allocate different slots to different courses based on the subject selections of the student,such
that no two courses selected by the same student fall on the same slot.

VERSION or DATE: November 2016

HOW TO START THIS PROJECT:
Compile the file "TimeTable.java"
run the file TimeTable with following command line arguments:
<name of text file to input> <maximum number of vertices> <choice of coloring algorithm> <number of colours(optional)>

AUTHORS: Shreyansh Agrawal.

USER INSTRUCTIONS:
Create a text file containing the subjects selected by students i different lines.
Make sure the format of the file is like following:
phy101 che101 mth101 cs101
ees102 phy102 che102 bio102
mth102 cs102 bio102 che102
phy101 ees101 mth101 cs101
where there are only spaces between two subjects.
If the file is not in the sam folder as TimeTable, specify the whole path of the file as first argument in the command line.
In the third argument, give a number 1,2 or 3 accordingly,
1 for greedy colouring algorithm
2 for backtracking algorithm
3 for coloring with optimum number of colours
If giving '2', then also specify the number of colours to check for.
The output will be the colours alloted to different vertices, if colouring will be possible.
