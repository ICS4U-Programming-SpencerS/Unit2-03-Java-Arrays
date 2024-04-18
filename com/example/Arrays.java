package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Change me.
 *
 * @author Spencer Scarlett
 * @version 1.0
 * @since 2024-04-04
 */

// Arrays class
public final class Arrays {

    /** Private constructor to prevent instantiation. */
    private Arrays() {
        throw new UnsupportedOperationException("Cannot instantiate");
    }

    /**
     * This is the main method.
     *
     * @param args Unused
     */
    public static void main(final String[] args) {
        // file path
        final File fileInput = new File("input.txt");
        final File fileOutput = new File("output.txt");

        // empty list for strings
        final List<String> listOfStrings =
            new ArrayList<String>();

        // empty variable for later
        String stringList;

        try {
            // to write for file
            final FileWriter fW = new FileWriter(fileOutput);
            // to read from file
            final Scanner sc = new Scanner(fileInput);
            // for output writing
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // read line...
                stringList = sc.next();
                // ... add line to string
                listOfStrings.add(stringList);
            }

            // convert from str > int
            final String[] arrayOfStr =
                listOfStrings.toArray(new String[0]);

            // loop to convert to int
            final int[] arrayNum =
                new int[arrayOfStr.length];
            for (int counter = 0; counter < arrayNum.length; counter++) {
                arrayNum[counter] = Integer.parseInt(arrayOfStr[counter]);
            }

            // sorts the values
            java.util.Arrays.sort(arrayNum);

            // calls
            final double mean = calcMean(arrayNum);
            final double median = calcMedian(arrayNum);

            // output for user(done for console to end)
            System.out.println("Done");

            // more output for files
            write.println("The mean is: " + mean);
            write.println("The median is: "
                + median);

            // closes for resources
            write.close();
            sc.close();
        } catch (IOException error) {
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }

    /**
    * calculates mean
    *
    * @param arrayNum passed
    * @return mean
    */
    public static double calcMean(int arrayNum[]) {
        // declaring
        double sum = 0;
        double mean = 0;

        // loop to add each value from the list
        for (int num : arrayNum) {
            sum = sum + num;
            mean = sum / arrayNum.length;
        }
        // return
        return mean;
    }

    /**
    * 
    *
    * @param arrayNum passed.
    * @return median.
    */
    public static double calcMedian(int arrayNum[]) {
        // declaring
        double median = 0;
        final int arrLength = arrayNum.length;

        // calculates median, checks for even data sets
        if (arrLength % 2 == 0) {
            // calculates average of two terms
            median = (arrayNum[arrLength / 2 - 1]
                    + arrayNum[arrLength / 2]) / 2;
        } else {
            // for odd cases
            median = arrayNum[arrLength / 2];
        }
        // return
        return median;
    }
}