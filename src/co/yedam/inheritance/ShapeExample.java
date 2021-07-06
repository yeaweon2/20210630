package co.yedam.inheritance;

public class ShapeExample {
	public static void main(String[] args) {
		// 다형성
		Shape shape = new Shape();
		shape.draw();
		
		shape = new Triangle();
		shape.draw();
		
		shape = new Rectangle();
		shape.draw();
		
		shape = new Circle();
		shape.draw();
		
	}
}
