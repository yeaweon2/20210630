package co.yedam.inheritance;

public class ArtistExample {
	public static void main(String[] args) {
		
		// 매개변수의 다형성

		Shape shape = new Shape();
		Triangle tri = new Triangle();
		Circle cir = new Circle();
		Rectangle rect = new Rectangle();
		
		Artist artist = new Artist();
		artist.paint(shape);
		artist.paint(tri);
		artist.paint(cir);
		artist.paint(rect);
		
	}
}
