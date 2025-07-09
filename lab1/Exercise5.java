package lab1_2_5;

import java.util.Scanner;

public class Exercise5 {

	// Method to check if a given year is a leap year
    public boolean isItALeapYear(int year) {
    	
    	// If the year is divisible by 400 then it is a leap year
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static void testLeapYears() {
        int[] years = {1716, 1989, 1992, 2000, 2010, 2012};

        Exercise5 exercise = new Exercise5();

        for (int year : years) {
            if (exercise.isItALeapYear(year)) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }
        }
    }

    public static void tester() {
        Scanner scanner = new Scanner(System.in);
        Exercise5 exercise = new Exercise5();

        System.out.println("Enter years to check if they are leap years (enter -1 to stop):");
        while (true) {
            int year = scanner.nextInt();
            if (year == -1) {
                break;
            }
            if (exercise.isItALeapYear(year)) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        testLeapYears();
        tester();
    }
}

