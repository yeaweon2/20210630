package co.yedam.inheritance;

public class StudentExample {
	public static void main(String[] args) {
		Student std = new Student();
		std.setName("학생1");
		std.setStudNo(100);
//		System.out.println("Student : " + std.getName() + " , " + std.getStudNo());
//		System.out.println();
		
		HighStudent highStd = new HighStudent();
		highStd.setName("고등학생1");
		highStd.setStudNo(200);
		highStd.setSchoolName("성화여자고등학교");
//		System.out.println("HighStudent : " + highStd.getName() + " , " + highStd.getStudNo() + " , " + highStd.getSchoolName());
		
		Student[] students = new Student[3];
		students[0] = std;
		students[1] = highStd;
		
		students[0].getName();
		students[0].getStudNo();
		
		// students[0]의 인스턴스가 HighStudent의 것이 맞는지 체크
		if(students[0] instanceof HighStudent) {
			HighStudent hsx = (HighStudent) students[0];			
			//System.out.println("1. " + hsx.getSchoolName());
		}
		students[0].showInfo();
		System.out.println(students[0]);
		
		
		students[1].getName();
		students[1].getStudNo();
//		students[1].getSchoolName();
		
		if(students[1] instanceof HighStudent) {
			HighStudent hs = (HighStudent) students[1];	// 형변환 필요			
			//System.out.println("2. " + hs.getSchoolName());
			
		}
		students[1].showInfo();
		System.out.println(students[1]);
		
		
	}
}
