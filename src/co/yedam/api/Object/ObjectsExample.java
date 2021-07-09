package co.yedam.api.Object;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

class Student implements Comparable<Student>  {
	String sno;
	String name;
	int grade;
	
	Student(String sno, int grade){
		this.sno = sno;
		this.grade = grade;
	}
	
	@Override
	public int compareTo(Student o) {
//		return this.sno.compareTo(o.sno);
		return this.grade - o.grade;
	}
}

class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.grade - o2.grade;
	}
}

public class ObjectsExample {
	public static void main(String[] args) {
		Integer i1 = 10;
		Integer i2 = 20;
		
		Student s1 = new Student("C001", 2);
		Student s2 = new Student("B001", 1);
		Student s3 = new Student("A001", 3);
		
		int result = Objects.compare(s1, s2, new StudentComparator());
		System.out.println(result);
		
		TreeSet<Student> ts = new TreeSet<>();
		ts.add(s1);
		ts.add(s2);
		ts.add(s3);
		
		System.out.println(ts.first().sno);
	}
}


