package edu.scu.csen160.lab5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProcessor {

	// a) Implement the fileCopy method
    public static void fileCopy(String inputFileName, String outputFileName) throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inputFileName));
            writer = new BufferedWriter(new FileWriter(outputFileName));

            String line;
            // Read each line and write it directly to the output file
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Preserve the original newline format
            }
        } finally {
            // Close resources in a finally block to ensure they're closed even if an error occurs
            if (reader != null) reader.close();
            if (writer != null) writer.close();
        }
    }

    /// Implement the wordCount method
    public static void wordCount(String inputFileName, String outputFileName) throws IOException {
        Scanner in = null;
        PrintWriter out = null;

        try {
            in = new Scanner(new File(inputFileName));
            out = new PrintWriter(new FileWriter(outputFileName));

            // Line delimiter is a new line
            int lineNum = 0;
            while (in.hasNextLine()) {
                String line = in.nextLine();

                // Split line into words based on space as a delimiter
                String[] words = line.trim().split("\\s+");
                int wordCount = words.length;

                // Write line number and word count to output file
                out.println("Line " + lineNum + " No. of words: " + wordCount);
                lineNum++;
            }
        } finally {
            // Ensure resources are closed
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }

    // Main method to execute fileCopy and wordCount
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile1 = "input_copy.txt";
        String outputFile2 = "input_wc.txt";

        try {
            // Call fileCopy to create a copy of input.txt
            FileProcessor.fileCopy(inputFile, outputFile1);
            
         // Call wordCount to count words per line in input.txt
            FileProcessor.wordCount(inputFile, outputFile2);

            System.out.println("Word count complete. Check " + outputFile2 + " for results.");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
