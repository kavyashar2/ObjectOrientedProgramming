package edu.scu.csen160.lab6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileReaderThread extends Thread {
	private String fileName;

	public FileReaderThread(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void run() {
		BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            int lineCount = 0;
            int charCount = 0;

            // Reading the file
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                
                // Simulating delay
                Thread.sleep((int) (Math.random() * 100));
            }

            System.out.println("File: " + fileName);
            System.out.println("Lines: " + lineCount);
            System.out.println("Characters: " + charCount);

        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName + ". " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted while processing file: " + fileName);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing file: " + fileName + ". " + e.getMessage());
                }
            }
        }
	}
}

public class MultiThreadedFileReader {
	public static void main(String[] args) {
		Thread t1 = new FileReaderThread("file1.txt");
		Thread t2 = new FileReaderThread("file2.txt");
		Thread t3 = new FileReaderThread("file3.txt");

		// Implement start all three threads
		t1.start();
        t2.start();
        t3.start();

        // Implement joining all three threads
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted while waiting for threads to finish.");
        }

        System.out.println("All threads have completed their tasks.");
		
	}
}