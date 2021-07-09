package co.yedam.api.Object;

class Apple implements Cloneable {
	int price;
	Apple(int price){
		this.price = price;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		Apple ap = (Apple)obj;
		return this.price == ap.price; 
	}
}

public class ObjectExample {
	public static void main(String[] args) {
		Object obj = new Object();
		Object obj2 = new Object();
		System.out.println(obj.equals(new Object()));
		
		boolean result1 = obj.equals(obj2);
		boolean result2 = (obj == obj2);
		System.out.println( result1 + " / " + result2 );
		
		Apple ap1 = new Apple(1000);
		Apple ap2 = new Apple(1000);
		
		try {
		Apple ap3 = (Apple) ap1.clone();
		System.out.println("ap3 : " + ap3.price);
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println(ap1.equals(ap2));
		
	}
}
