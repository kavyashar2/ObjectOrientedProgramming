package lab1_1_1;

public class Puppy {

	private String name;
	private int age;

	public Puppy(){
		this.name = "Name not given yet";
		this.age = 1;
	}

	public Puppy(String name, int age){ 
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}
	
	// Getter for age (in years)
	public int getAge() {
		return this.age;
	}
	
	// Getter for age (in days)
	public int getAgeInDays() {
		return this.age * 365;
	}

	public static void main(String[] args) {  
		Puppy myPuppy = new Puppy("Fido", 2);  
		System.out.println("Puppy name: " + myPuppy.getName());
		System.out.println("Puppy age (in years): " + myPuppy.getAge());
		System.out.println("Puppy age (in days): " + myPuppy.getAgeInDays());
	}
	
}
