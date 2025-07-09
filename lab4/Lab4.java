package edu.scu.csen160.lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab4 {
	public static void exercise_1() {
		int denominator, numerator;
		numerator = 4;
		denominator = 0;

		System.out.println("Result: " + numerator / denominator);
		System.out.println("exercise_1(): end.");
	}

	public static void exercise_1_fix() {
		int denominator, numerator;
		numerator = 4;
		denominator = 0;

		try {
			System.out.println("Result: " + numerator / denominator);
		} catch (ArithmeticException e) {
			System.out.println("Error: Division by zero is not allowed. Please ensure the denominator is not zero.");
		} finally {
			System.out.println("exercise_1_fix(): end.");
		}
	}

	// *******************************************************************************

	public static void exercise_2() {
		int num = 0;

		System.out.print("Enter an integer: ");
		Scanner scanner = new Scanner(System.in);

		num = scanner.nextInt();

		// Squaring the number input
		System.out.println("The square of " + num + " is " + num * num);
		System.out.println("exercise_2(): end.");
		scanner.close();
	}

	public static void exercise_2_fix() {
		int num = 0;

		System.out.print("Enter an integer: ");
		Scanner scanner = new Scanner(System.in);

		try {
			num = scanner.nextInt();
			System.out.println("The square of " + num + " is " + num * num);
		} catch (InputMismatchException e) {
			System.out.println("Error: Please enter a valid integer. Non-integer input is not allowed.");
		} finally {
			System.out.println("exercise_2_fix(): end.");
			scanner.close();
		}
	}

	// *******************************************************************************

	public static void exercise_3() {
		int num = 0;
		Scanner scanner = new Scanner(System.in);
		boolean validInput = false;

		while (!validInput) {
			System.out.print("Enter an integer: ");

			try {
				num = scanner.nextInt();
				System.out.println("The square of " + num + " is " + num * num);
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Error: Please enter a valid integer. Non-integer input is not allowed.");
				scanner.next();
			}
		}

		System.out.println("exercise_3(): end.");
		scanner.close();
	}

	// *******************************************************************************

	public static boolean checkFirstTwoLettersAreCharacters(String line) {
		if (line.length() < 2) {
	        return false;
	    }
	    return Character.isLetter(line.charAt(0)) && Character.isLetter(line.charAt(1));
	}
	
	class MissedFlightException extends Exception {
	    String flight;

	    public MissedFlightException(String flight) {
	        super("Missed Flight: " + flight);
	        this.flight = flight;
	    }
	}

	class CanceledFlightException extends Exception {
	    String flight;

	    public CanceledFlightException(String flight) {
	        super("Canceled Flight: " + flight);
	        this.flight = flight;
	    }
	}

	public class FlightStringFormatException extends Exception {
	    private String error;

	    public FlightStringFormatException(String error) {
	        super("Flight String Format Error: " + error);
	        this.error = error;
	    }

	    public String getError() {
	        return error;
	    }
	}
	
	public static void exercise_4(int status, String flight) {
		Lab4 Lab4 = new Lab4();
		
		try {
	        if (!Lab4.checkFirstTwoLettersAreCharacters(flight)) {
	            throw Lab4.new FlightStringFormatException("First Two Letters are not characters!");
	        }

	        switch (status) {
	            case 1:
	                throw Lab4.new MissedFlightException(flight);
	            case 2:
	                throw Lab4.new CanceledFlightException(flight);
	        }
	    } catch (MissedFlightException e) {
	        System.out.println("Missed Flight, initiate rebooking ...");
	    } catch (CanceledFlightException e) {
	        System.out.println("Canceled flight, initiate refunding ...");
	    } catch (FlightStringFormatException e) {
	        System.out.println("Restart process and correct the characters errors ...");
	    } finally {
	        System.out.println("exercise_4(): done\n");
	    }
	}
}