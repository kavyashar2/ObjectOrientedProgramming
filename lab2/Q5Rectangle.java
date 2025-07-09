package lab2;

public class Q5Rectangle extends Q5FigureAbstract{
	
	public Q5Rectangle(double dim1, double dim2) {
		this.dim1 = dim1;
        this.dim2 = dim2;
	}	
	
	public double area() {
		return this.dim1 * this.dim2;
	}
}