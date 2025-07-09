package lab2;

public abstract class Q5FigureAbstract {
	protected double dim1;
	protected double dim2;

	public abstract double area();
	
	public void showDimensions() {
		System.out.println("Dim1="+this.dim1);
		System.out.println("Dim2="+this.dim2);
	}
}