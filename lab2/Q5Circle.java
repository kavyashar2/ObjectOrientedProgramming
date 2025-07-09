package lab2;

public class Q5Circle extends Q5FigureAbstract {
	
	public Q5Circle(double radius) {
		this.dim1=radius;
	}
	
	public double area() {
		return this.dim1*this.dim1*Math.PI;
	}
}