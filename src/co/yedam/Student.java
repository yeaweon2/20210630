package co.yedam;

public class Student {
	private String name;
	private int grade;
	private int engScore;
	private int MathScore;
	
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
	
//	public String maxEng() {
//		int maxEng = 0;
//		String maxEngName = "";
//		if(maxEng < this.engScore) {
//			maxEng 		= this.engScore;
//			maxEngName 	= this.name;
//		}
//		return ;
//	}

}
