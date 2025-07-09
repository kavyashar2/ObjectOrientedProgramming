package edu.scu.csen160.lab5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

interface DataGetter {
	public void readDataFromFile(String fileName);
}

class Sales {
	int quarter;
	int year;
	int salesInK;

	// a) Complete the constructor for Sales
	public Sales(int quarter, int year, int salesInK) {
		this.quarter = quarter;
		this.year = year;
		this.salesInK = salesInK;
	}

	public int getAmount() {
		return salesInK;
	}

	public int getYear() {
		return year;
	}

	public int getQuarter() {
		return quarter;
	}

	public String toString() {
		return "Year: " + year + " Quarter: " + quarter + " Sales: " + salesInK;
	}
}

public class DataManager implements DataGetter {
	private Map<String, Sales> sales = new HashMap<String, Sales>();

	// b) Complete the makeKey method
	public String makeKey(Sales oneSale) {
		// Return the oneSale.year concatenated with "-" and oneSale.quarter
		return oneSale.year + "-" + oneSale.quarter;
	}

	// c) Complete the readDataFromFile method
	public void readDataFromFile(String fileName) {
		BufferedReader reader = null;

		try {
			File inFile = new File(fileName); // Open the file
			reader = new BufferedReader(new FileReader(inFile));
			String line;

			// Loop as long as there are input lines.
			while ((line = reader.readLine()) != null) {
				// Split each line into tokens
				String[] fields = line.split(":");
				
				// Convert String fields to int values for year, quarter, and sales
				int year = Integer.parseInt(fields[0].trim());
				int quarter = Integer.parseInt(fields[1].trim());
				int salesAmount = Integer.parseInt(fields[2].trim());

				// Create an instance of Sales
				Sales saleByQ = new Sales(quarter, year, salesAmount);
				
				// Place the sale object in the HashMap
				sales.put(makeKey(saleByQ), saleByQ);
			}
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
			System.exit(1);
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException: " + e.getMessage());
			System.exit(1);
		} finally {
			try {
				if (reader != null) reader.close();
			} catch (IOException e) {
				System.err.println("Error closing reader: " + e.getMessage());
			}
		}
	}

	public Map<String, Sales> getData() {
		return sales;
	}

	public static void main(String[] args) {
		DataManager manager = new DataManager();
		manager.readDataFromFile("sales.txt");
		Map<String, Sales> data = manager.getData();
		System.out.println(data.toString());
	}
}
