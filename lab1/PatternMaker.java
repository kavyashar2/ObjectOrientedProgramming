package lab1_1_3;

class PatternMaker {
	
	// Method to draw one line of the pattern
    public static void drawOneLine(char symbol, int noOfTimes, int offset) {
       
        for (int i = 0; i < offset; i++) {
            System.out.print(" ");  
        }

        for (int i = 0; i < noOfTimes; i++) {
            System.out.print(symbol);  
        }

        System.out.println(); 
    }

    // Method to draw the entire pattern
    public static void drawPattern() {

        drawOneLine('*', 4, 4);

        drawOneLine('*', 8, 8);

        drawOneLine('*', 12, 12);
    }

    public static void main(String[] args) {
        drawPattern();
    }
    
}

