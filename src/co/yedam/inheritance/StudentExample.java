package co.yedam.inheritance;

public class StudentExample {
	public static void main(String[] args) {
		Student std = new Student();
		std.setName("학생1");
		std.setStudNo(100);
		
		HighStudent highStd = new HighStudent();
		highStd.setName("고등학생1");
		highStd.setStudNo(200);
		highStd.setSchoolName("성화여자고등학교");
		
	}
}
