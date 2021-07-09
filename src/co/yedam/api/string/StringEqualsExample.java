package co.yedam.api.string;

public class StringEqualsExample {
	public static void main(String[] args) {
		String strVal1 = new String("신민철");
		String strVal2 = "신민철";
		
		if(strVal1 == strVal2) {
			System.out.println("[==] 같은 String 객체를 참조");
		}else {
			System.out.println("[==] 다른 String 객체를 참조");
		}
		
		if(strVal1.equals(strVal2)) {
			System.out.println("[equals] 같은 String 객체를 참조");
		}else {
			System.out.println("[equals] 다른 String 객체를 참조");
		}
	}
}
