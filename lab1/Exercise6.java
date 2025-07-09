package lab1_2_6;

public class Exercise6 {

    public static String fullName(String firstName, String middleName, String lastName) {

        String formattedFirstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        String formattedMiddleInitial = middleName.substring(0, 1).toUpperCase() + ".";
        String formattedLastName = lastName.toUpperCase();

        return formattedLastName + ", " + formattedFirstName + " " + formattedMiddleInitial;
    }

    // Method to check if the text is a palindrome
    public static boolean palindrome(String text) {

        String tempStr = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Removed non-alphanumeric characters and convert to lower case
        return tempStr.equals(new StringBuilder(tempStr).reverse().toString());
    }

    public static void main(String[] args) {

        String firstName = "robert";
        String middleName = "james";
        String lastName = "CLARK";
        System.out.println(fullName(firstName, middleName, lastName));

        System.out.println(fullName("alice", "may", "johnson")); 

        String[] testPhrases = {
            "A man, a plan, a canal, Panama",
            "desserts",
            "radar",
            "Madam"
        };

        for (String phrase : testPhrases) {
            System.out.println(phrase + " is a palindrome: " + palindrome(phrase));
        }
    }
}
