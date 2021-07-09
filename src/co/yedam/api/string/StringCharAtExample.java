package co.yedam.api.string;

public class StringCharAtExample {
	public static void main(String[] args) {
		String ssn = "010624-1230123";
		
		char sex = ssn.charAt(7);
		switch(sex) {
			case'1': System.out.println("남자입니다."); break;
			case'2': System.out.println("여자입니다."); break;
			case'3': System.out.println("남성입니다."); break;
			case'4': System.out.println("여성입니다."); break;
		}
	}
}
