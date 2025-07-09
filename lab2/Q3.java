package lab2;

/**
 * Lockable Items
 */
interface Lockable {
	public void lock(String key);
	public void unlock(String key);
}

class Box implements Lockable {
	private String password = null;
	boolean locked = false;	
	
	public Box(String password) {
		this.password = password;
        this.locked = false;
	}

	public void lock(String password) {
		if (this.password.equals(password)) {
            this.locked = true; // Lock the box (set to true)
            System.out.println("Box: Locked successfully!");
        } else {
            System.out.println("Box: Incorrect password, cannot lock!");
        }
	}

	public void unlock(String password) {
		if (!locked) {
            System.out.println("Box: Already unlocked.");
        } else if (this.password.equals(password)) { // Check if the entered password matches
            this.locked = false; // Unlock the box (set to false)
            System.out.println("Box: Unlocked successfully!");
        } else {
            System.out.println("Box: Incorrect password, cannot unlock!");
        }
	}

	public void show() {
		if (!this.locked) {
			System.out.println("Box: Showing Contents ... :)");
		} else
			System.out.println("Box: LOCKED!");
	}
}

class Computer implements Lockable {
	private String password = null;
	private boolean locked = false;
	
	public Computer(String password) {
		 this.password = password;
	        this.locked = false;
	}

	public void lock(String password) {
		if (this.password.equals(password)) { // Check if the entered password is correct
            this.locked = true; // Lock the computer (set to true)
            System.out.println("Computer: Locked successfully!");
        } else {
            System.out.println("Computer: Incorrect password, cannot lock!");
        }
	}

	public void unlock(String pword) {
		if (!locked) {
            System.out.println("Computer: Already unlocked.");
        } else if (this.password.equals(pword)) { // Check if the entered password matches
            this.locked = false; // Unlock the computer (set to false)
            System.out.println("Computer: Unlocked successfully!");
        } else {
            System.out.println("Computer: Incorrect password, cannot unlock!");
        }	
	}

	public void show() {
		if (!locked) {
			System.out.println("Computer: ready to work ... :)");
		} else
			System.out.println("Computer: LOCKED!");
	}
}

public class Q3 {
	public static void q3() {
		Box box1 = new Box("1234");

		box1.lock("1234");
		box1.unlock("1234");
		box1.show();

		Computer c1 = new Computer("6862");
		c1.lock("6862");
		c1.show();

		c1.unlock("6862");
		c1.show();
	}
}