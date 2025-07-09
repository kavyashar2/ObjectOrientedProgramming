package lab1_2_7;

public class Exercise7 {

	// Method to generate random numbers
    public static void genRandNum(int range, int count) {

        for (int i = 0; i < count; i++) {

            int rand = (int) (range * Math.random());

            System.out.println("Random number " + (i + 1) + ": " + rand);
        }
    }

    public static void main(String[] args) {
        Exercise7.genRandNum(10, 10);
    }
}
