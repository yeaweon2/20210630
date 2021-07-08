package co.yedam.generic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		// 순서없음, 중복안됨, get없음=>iterator 생성해야함
		
		Set<String> names = new HashSet<String>();
		names.add("박지현");
		names.add("박현진");
		
		System.out.println("크기 => " + names.size()); 
		
		Iterator<String> iter = names.iterator(); // 반복자를 생성해주는 메소드
		while(iter.hasNext()) {
			String val = iter.next();
			System.out.println(val);
		}
		
		names.add("안의정");
		iter = names.iterator(); 
		while(iter.hasNext()) {
			String val = iter.next();
			System.out.println(val);
		}
	}
}
