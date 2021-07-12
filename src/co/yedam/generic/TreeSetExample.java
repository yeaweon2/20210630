package co.yedam.generic;

import java.util.TreeSet;

class Member implements Comparable<Member> {
	int memberNo;
	String memberNm;
	
	public Member(int memberNo, String memberNm) {
		super();
		this.memberNo = memberNo;
		this.memberNm = memberNm;
	}

	@Override
	public int compareTo(Member o) {
		// a < b < c
		// 내림차순 o.memberNo - this.memberNo;
		// 오름차순 this.memberNo - o.memberNo		
		if( (this.memberNm.compareTo(o.memberNm)) == 0 ) {
			return this.memberNo - o.memberNo;
		}
		return this.memberNm.compareTo(o.memberNm) ;	

//		if(this.memberNo < o.memberNo) 
//			return -1;  // 음의값 오름차순
//		else if(this.memberNo == o.memberNo)
//			return 0;
//		else 
//			return 1;	// 양의값 내림차순		
	}
}

public class TreeSetExample {
	public static void main(String[] args) {
		TreeSet<Member> members = new TreeSet<Member>();
		members.add(new Member(1001,"Hong"));
		members.add(new Member(1002,"Choi"));
		members.add(new Member(1003,"Kim"));
		members.add(new Member(1004,"Hong"));
		
		int a = 0;
		while(!members.isEmpty()) {
			Member mb = members.pollFirst();
			
			if( a == members.size() ) {
				
			}
			System.out.println(mb.memberNo + " / " + mb.memberNm);
			a++;
		}
		
		System.out.println();
		System.out.println("String.compareTo : " + "Hark".compareTo("Hong"));
		System.out.println();
		
		TreeSet<Integer> set = new TreeSet<>();
		set.add(10); // Integer, new Integer(10)
		set.add(5);
		set.add(13);

		set.first();
		set.last();

		while(!set.isEmpty()) {
			Integer v = set.pollFirst(); 
			System.out.println(v);
		}		
		System.out.println("End..");
	}
}
