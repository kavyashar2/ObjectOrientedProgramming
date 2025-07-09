package lab1_2_4;

import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
// Declarations
		Scanner in = new Scanner(System.in);
		int anInteger;
		float aFloat;
		double aDoubleNumber;
// Prompts
		System.out.println("Enter an integer");
		anInteger = in.nextInt();
		System.out.println("Enter a float");
		aFloat = in.nextFloat();
		System.out.println("Enter a double");
		aDoubleNumber = in.nextDouble();
// Output the user input
		System.out.println("Here is what you entered: ");
		System.out.println(anInteger);
		System.out.println(aFloat);
		System.out.println(aDoubleNumber);
		in.close();
	}
}
