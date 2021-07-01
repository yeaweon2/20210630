package co.yedam;

public class Student {
	private String name;
	private int grade;
	private int engScore;
	private int MathScore;
	
	public Student() {	// 매개값이 없는 생성자 ==> 기본생성자. new Student()
		
	}
	
	public Student(String name) { // 매개값을 가지는 생성자.
		this.name = name;
	}

	public Student(String name, int grade) { // 매개값을 가지는 생성자.
		this.name = name;
		this.grade = grade;
	}	

	public Student(String name, int grade, int engScore, int mathScore) {
//		super();	// 상속관련
		this.name = name;
		this.grade = grade;
		this.engScore = engScore;
		MathScore = mathScore;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getMathScore() {
		return MathScore;
	}
	public void setMathScore(int mathScore) {
		MathScore = mathScore;
	}
	
	public void showInfo() {
		System.out.println("[ 학생이름 : "+ this.name + " 학년 : "+ this.grade + " 영어점수 : " + this.engScore + " 수학점수 : " + this.MathScore + " ] ");
	}
	

}
