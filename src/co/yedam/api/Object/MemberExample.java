package co.yedam.api.Object;

public class MemberExample {
	public static void main(String[] args) {
		Member original = new Member("blue", "홍길동","12345",25,  true, new Car("소나타"));
		
		
		Member cloned = original.getMember();
		
		original.car.model = "모닝";
		original.age = 5;
		
		System.out.println("[복제 객체의 필드값]");
		System.out.println("id : " 			+ cloned.id);
		System.out.println("name : " 		+ cloned.name);
		System.out.println("password : " 	+ cloned.password);
		System.out.println("age : " 		+ cloned.age);
		System.out.println("adult : " 		+ cloned.adult);
		System.out.println("Car model : " 	+ cloned.car.model );
		
		System.out.println();
		
		System.out.println("[원본 객체의 필드값]");
		System.out.println("id : " 			+ original.id);
		System.out.println("name : " 		+ original.name);
		System.out.println("password : " 	+ original.password);
		System.out.println("age : " 		+ original.age);
		System.out.println("adult : " 		+ original.adult);		
		System.out.println("Car model : " 	+ original.car.model );
		
		
	}
}
