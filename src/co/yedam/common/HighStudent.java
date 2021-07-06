package co.yedam.common;

import co.yedam.modifier.Student;

public class HighStudent extends Student {
	
	HighStudent(String name){	// 상속의 관계에서 패키지가 다르더라도 접근가능 ==> protected
		super(name);
	}
}
