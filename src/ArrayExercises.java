import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayExercises {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Problem 1.
         reverseAString(scanner);


        // Problem 2.
          storingTenIntegersAsSet(scanner);


        // Problem 3.
        int[] array1 = {1,7,6,5,9}, array2= {2,7,6,3,4};
        allPairsAddUpTo13(array1, array2);

        // Problem 4.
        displayNumberOfOddAndEven(scanner);

        // Problem 5. (Challenge!)
        challenge(scanner);


    }

    // Method for problem 1.
    public static void reverseAString(Scanner scanner) {
        System.out.println("1.) Write a program to print a string in reverse\n");
        System.out.print("Enter s string: ");
        String inputStr = scanner.nextLine();

        for (int charIdx = inputStr.length() - 1; charIdx >= 0; charIdx--){
            System.out.print(inputStr.charAt(charIdx));
        }
        System.out.println("\n");
    }

    // Method for problem 2.
    public static void storingTenIntegersAsSet(Scanner scanner) {
        System.out.println("2.) Prompting the user to input 10 integer values and store them into an array. " +
                "If there are any duplicate values in that array, will remove them and print out the remaining values.\n");

        int[] originalInput = new int[10];
        int numberOfElementIdx = 0;

        int numberOfDuplicate = 0;
        int setIdx = 0;
        int[] setOfNumbers = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter an integer value: ");
            int inputNumber = scanner.nextInt();

            if (!find(originalInput, i+1, inputNumber)){
                setOfNumbers[setIdx++] = inputNumber;
            }
            originalInput[i] = inputNumber;
        }
        System.out.println("Original input: " + Arrays.toString(originalInput));
        System.out.print("Input integer without duplicates: [" );
        for (int i=0; i < setIdx; i++) {
            if (i != setIdx-1 ) System.out.print(setOfNumbers[i] + ", ");
            else System.out.print(setOfNumbers[i]);
        }
        System.out.print("]\n\n");

    }

    // Method for problem 3.
    public static void allPairsAddUpTo13(int[] array1, int[] array2) {
        System.out.println("3.) Given two arrays This program will print out all pairs " +
                "from arrays 1 and 2 that gives a sum of 13: ");
        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: \n" + Arrays.toString(array2));

        int[][] result = new int[array1.length+array2.length][2];
        int len = 0;
        int prev = 0;
        System.out.println("Output: ");
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if ((array1[i] + array2[j] == 13) && notInList(result, array1[i], array2[j], len)) {
                    result[len][0] = array1[i];
                    result[len++][1] = array2[j];
                }
            }
            if (prev != len) {
                System.out.printf("\t(%d, %d)\n" , result[prev][0], result[prev][1]);
                prev = len;
            }
        }
        System.out.println();

    }

    // Method for problem 4.
    public static void displayNumberOfOddAndEven(Scanner scanner) {
        System.out.println(" 4.) Output the total number of odd and even values from 10 input integer.");

        int SIZE = 10;
        int[] arrayOfTenInteger = new int[SIZE];
        int countOdd = 0, countEven = 0;

        for(int i= 0; i < SIZE; i++) {
            System.out.println("Enter an integer value: ");
            int inputNumber = scanner.nextInt();
            arrayOfTenInteger[i] = inputNumber;
            if (inputNumber % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }

        System.out.println("All input integers: " + Arrays.toString(arrayOfTenInteger));
        System.out.printf("There are (%d) odd and (%d) even values in the array\n",
                countOdd, countEven);
    }


    // Method for problem 5.
    public static void challenge(Scanner scanner) {
        System.out.println("\n5. (Challenge!)\n");

        String[] listOfWords = new String[132];
        System.out.println("Enter a string (max number of characters is 132)");
        String inputString = scanner.nextLine();
        System.out.println("You entered " + inputString);

        String oneWord = "";
        int numberOfWordsIdx = 0, numberOfWords=0;
        for (int i = 0; i < inputString.length(); i++){

            if (inputString.charAt(i) == ' ' || inputString.charAt(i) == '\t' ||
                    inputString.charAt(i) == '\n') {
                if (!oneWord.equals("")) {
                    listOfWords[numberOfWordsIdx] = oneWord;
                    numberOfWordsIdx++;
                    numberOfWords++;
                }
                oneWord = "";
                //  continue;
            } else {
                oneWord += inputString.charAt(i);
            }
        }
        // Handle words that does not have space after the word.
        if (!oneWord.equals("")){
            listOfWords[numberOfWordsIdx] = oneWord;
            numberOfWords++;
        }
        for (int wordIdx = 0; wordIdx < numberOfWords; wordIdx++) {
            String word = listOfWords[wordIdx];

            System.out.printf("%s\n\t|\n\t ---> has %d characters\n", word, word.length());
        }
    }

    // Utility Method: find()
    public static boolean find(int[] tenIntegerValues, int numberOfElement, int inputNumber) {
        boolean found = false;
        for (int j = 0; j < numberOfElement; j++) {
            if (tenIntegerValues[j] == inputNumber)
                found = true;
        }
        return found;
    }

    // Utility Method: notInList()
    public static boolean notInList(int[][] result, int input1, int input2, int length) {
        boolean isPairHere = true;
        for (int row=0; row < length; row++) {
            int pair1 = result[row][0];
            int pair2 = result[row][1];

            if (pair1 == input1 || pair1 == input2)
                if (pair2 == input1 || pair2 == input2) return false;

        }
        return isPairHere;
    }

}
