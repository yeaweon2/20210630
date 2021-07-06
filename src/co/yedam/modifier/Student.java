package co.yedam.modifier;


class Teacher{
	private String name;
	private String major;
	
	Teacher(){
		//default
	}
	
	String getName() {
		return name;
	}
}


public class Student {
	private String name;
	private String major;
	private int grade;
	
	private Student() {
		// private
	}
	
	protected Student(String name){
		// default
		this.name = name;
	}
	
	public Student(String name, String major) {
		// public
		this.name = name;
		this.major = major;
	}
}
