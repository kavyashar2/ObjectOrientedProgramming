package lab2;

// Uncomment the lines as you compile each of the exercises.
public class Main {
	public static void main(String[] args) {
		Q1.q1();
		Q2.q2();
		Q3.q3();
		Q4.q4();

		Q5Circle circ=new Q5Circle(10.0);
		Q5Rectangle rect=new Q5Rectangle(10.0, 20.0);
		System.out.println("Circle area="+circ.area());
		System.out.println("Rectangle area="+rect.area());
	}
}