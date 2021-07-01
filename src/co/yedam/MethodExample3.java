package co.yedam;

public class MethodExample3 {
	public static void main(String[] args) {
		Student s1 = new Student("최예원", 1, 80, 90);
		Student s2 = new Student("김지연", 2, 70, 77);
		
		Student[] javaClass = { s1, s2, new Student("최유리", 2, 72, 75) };
		
//		s1.setName("최예원");
//		s1.setGrade(1);
//		s1.setEngScore(80);
//		s1.setMathScore(85);
		
		System.out.println("< 2학년 LIST > ");
		for(int i = 0 ; i < javaClass.length ; i++){
			if( javaClass[i].getGrade() == 2 ) {
				System.out.println(javaClass[i].getName() + " , " + javaClass[i].getGrade()+ " , " + javaClass[i].getEngScore() + " , " + s1.getMathScore() );		
			}
		}
		
		
		
	}
}
