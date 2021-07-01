package co.yedam;

public class MethodExample2 {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("홍길동");
		
		String name = p1.getName();
		
		int n1 		= p1.getSum(10, 20);
		int n2 		= p1.getSum(5, 5);
		int result 	= p1.getSum(n1, n2);
		
		System.out.println("결과 : " + result);
		
		// 10 ~ 20 사이의 임의의 값 추출
		n1 = p1.getFrom10To20();
		System.out.println("10 ~ 20 ==> " + n1);
		
		n2 = p1.getFromTo(10,30);
		System.out.println("10 ~ 30 ==> " + n2);
		
		System.out.println();
		
		// 문자열
		String msg = p1.getNameAndAge("홍길동", 20);
		System.out.println(msg);
		
		System.out.println();
		
		Person newPerson = p1.createNewPerson("송혜교", 25);
		newPerson.setHeight(167.8);
		newPerson.setBloodType("AB");
		System.out.println(newPerson.getInfo());
		
		
		Person anotherPerson = p1.createNewPerson("한효주", 27, 165.3);
		anotherPerson.setBloodType("O");
		System.out.println(anotherPerson.getInfo());
		
		Person theOtherPerson = p1.createNewPerson("송승헌", 30, 185, "B");
		System.out.println(theOtherPerson.getInfo());
		
	}
}

 