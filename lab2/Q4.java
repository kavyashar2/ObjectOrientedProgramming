package lab2;

public class Q4 {
	public static void q4() {
		Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        // Print the instances to verify that they are the same
        System.out.println("Singleton instance 1: " + s1);
        System.out.println("Singleton instance 2: " + s2);
        System.out.println("Singleton instance 3: " + s3);

        // Check if all references point to the same instance
        if (s1 == s2 && s2 == s3) {
            System.out.println("All references point to the same Singleton instance.");
        } else {
            System.out.println("Error: Different instances exist!");
        }
    }
}