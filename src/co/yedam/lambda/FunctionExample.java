package co.yedam.lambda;

@FunctionalInterface
interface Runnable {  // 구현해야할 메소드가 하나만 있는 인터페이스일 경우 람다식 사용가능 
	String run(String name);
//	void swim();
}

class RunClass implements Runnable{

	@Override
	public String run(String name) {
		System.out.println( name + "가 달립니다.");
		return name + " 화이팅!!"; 
	}	
}

public class FunctionExample {
	public static void main(String[] args) {
		Runnable runnable = new RunClass();
		String result = runnable.run("철수");
		System.out.println(result);
		
		runnable = new Runnable() { // 익명 구현객체 : new 인터페이스(){ }
			@Override
			public String run(String name) {
				System.out.println(name + "가 달립니다 222");
				return name + " 힘내!!";
			} 
		};
		result = runnable.run("영희");
		System.out.println(result);
		 
		// 람다표현식
		runnable = (String name) -> { System.out.println( name + "가 달립니다 333"); return name + " 유후!!"; }; 
		
		result = runnable.run("익명이");
		System.out.println(result);
	}
}
