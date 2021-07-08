package co.yedam.generic;

class Orange{
	int price;
}

public class BoxExample {
	public static void main(String[] args) {
		// 제네릭 : 모든 유형의 데이터타입을 사용하는 시점에 지정해서
		// Casting(X), 타입오류를 일으키지 않도록 도입됨 
		Box<Integer> box = new Box<Integer>();
		box.setObj(10);
		Integer val = box.getObj();
		
		Box<String> boxx = new Box<String>();
		boxx.setObj("10");
		String val2 = boxx.getObj();
//		
//		// box.setObj(new Integer(10));
//		// int => Integer
//		// byte => Byte
//		// double => Double
	
		Box<Orange> box1 = new Box<Orange>();
		box1.setObj(new Orange());
		Orange ora= box1.getObj();
	}
}
