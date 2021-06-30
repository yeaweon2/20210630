package co.yedam;

public class PersonExample {
	public static void main(String[] args) {
		
		Person p1 = new Person();	
		p1.setName("홍길동");
		p1.setAge(20);
		p1.setHeight(-170);
		p1.setBloodType("O");
		
		Person p2 = new Person();
		p2.setName("김길동");
		p2.setAge(30);
		p2.setHeight(180.4);
		p2.setBloodType("A");
		
		Person[] persons = { p1, p2 };
		
		// 새로운 인스턴스(사람)선언 : 여러분의 정보를 담아 추가
		Person p3 = new Person();
		p3.setName("최예원");
		p3.setAge(34);
		p3.setHeight(-160);
		p3.setBloodType("O");
		
		persons = new Person[] { p1, p2, p3 };
		
		for(int i = 0 ; i < persons.length ; i++) {
//			//혈액형이 A인 사람만 조회
//			if(persons[i].getBloodType().equals("A") ) {
//				System.out.println("이름 :" + persons[i].getName() + " / 나이 : " + persons[i].getAge() );
//			}
			
			// 나이가 25이상인 사람만 조회
			if(persons[i].getAge() >= 25) {
				//persons[i].showInfo();
				System.out.println(persons[i].getInfo());
			}
		}
	}
}
