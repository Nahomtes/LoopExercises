# Array Exercises

1.) Write a program to print a string in reverse:
Eg: Welcome

    emocleW
 Pseudocode:

    BEGIN
        Set str = Welcome
        
        For i = str.length() - 1 To 0 Do
            print str[i]    
        ENDFOR
    END
2.) Prompt the user to input 10 integer values and store them into an array. If there are any duplicate values in that array, remove them and print out the remaining values.

Pseudocode:

    BEGIN
        Set tenIntegerValues = Array[10]
        Set numberOfElementIdx = 0;
        FOR i=0 TO 10 DO
            PROMPT: Enter an integer value
            get inputNumber
            Set thereIsDuplicate = false
            
            // check if inputNumber does not have dublicate value alrady in the array
            FOR j = 0 TO numberOfElement DO
                IF tenIntegerValues[j] == inputNumber THEN
                    thereIsDuplicate = true
                ENDIF
             ENDFOR
             
            IF !thereIsDuplicate THEN
                tenIntegerValues[numberOfElementIdx] = inputNumber
                numberOfElementIdx++;
             ENDIF   
        ENDFOR
    END

3.) Given array 1: [1,7,6,5,9] and array 2: [2,7,6,3,4]
Write a program that will print out all pairs from arrays 1 and 2 that gives a sum of 13:

Expected output:

    (6,7)
    
    (9,4)
    
Pseudocode:
Given array1, array2

    BEGIN
        Set result[][]
        FOR i=0 TO array1.length DO
            FOR j=0 TO array2.length Do
                IF (array1[i] + array2[j]) == 13 AND pair is not already in result THEN
                    put (array1[i], array2[j]) in result
        
        Display: result
               
    END
 
  
4.) Prompt the user to input 10 values and store them into an array. Output the total number of odd and even values in the array.
    
Pseudocode:
    
    BEGIN
        Set countOdd = 0, countEven = 0
        FOR i=0 to 10 DO
            PROMPT: Enter an interger value
            get inputNumber
            
            IF inputNumber % 2 == 0 THEN
                countEven++
            ELSE
                countOdd++
            ENDIF
         ENDFOR
         
         Print: There are (countOdd) odd and (countEven) even values in the array
    
    END
   
5.) (Challenge!)  Prompt the user to input one line of a string.  Parse the string into a word, print out the word and length of the word. Assume that the maximum size of a line is 132.

    Enter a string (max number of characters is 132)
    Today is Friday and it is raining.
    You entered Today is Friday and it is raining.
    Today has 5 characters
    is has 2 characters
    Friday has 6 characters
    and has 3 characters
    it has 2 characters
    is has 2 characters
    raining. has 8 characters

   