package co.yedam.modifier;

public class Example {
	public static void main(String[] args) {
		Teacher t1 = new Teacher();
		t1.getName(); // 동일한 패키지내에서는 호출가능.
		
		Student std1 = new Student("");
	}
}
