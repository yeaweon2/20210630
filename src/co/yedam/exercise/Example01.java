package co.yedam.exercise;

public class Example01 {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.setEmpNo(1234);
		e1.setEmpName("박주현");
		e1.setEmpEmail("pjh@email.com");
		e1.setEmpPay(450);
		e1.setEmpTeam("개발부");
		
		e1.showInfo();
		
		System.out.println("-------------------------------------------------");
		
		Employee e2 = new Employee(1235, "홍미림", "hmr@email.com");
		e2.showInfo();
		
		System.out.println("-------------------------------------------------");
		
		// 배열
		Employee[] emps = new Employee[5];
		
		emps[0] = e1;
		emps[1] = e2;
		emps[2] = new Employee(1236, "임효인", "lhi@email.com", 5000000, "총무부");
		
		// 배열의 각각 요소의 값을 출력
		for(int i = 0; i < emps.length ; i++) {
			if( emps[i] != null ) {
				emps[i].showInfo();
			}
		}
		
		
	}
}
