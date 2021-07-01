package co.yedam.pilates;

import java.util.Scanner;

public class PilatesApp {
	
	static Member[] members = new Member[10];
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 회원관리 프로그램 
		// 1.입력, 2.수정, 3.삭제, 4.회원리스트, 5.이름조회, 9.종료
		
		while(true) {
			showMenu();
			int menu = scn.nextInt();
			if( menu == 1 ) {
				memberAdd();
			}else if(menu == 2) {
				
			}else if(menu == 3) {
				
			}else if(menu == 4) {
				memberList();
			}else if(menu == 5) {
				memberFind(); 
			}else if(menu == 9){
				break;
			}
		}
		System.out.println("프로그램 종료되었습니다.");
	}
	
	public static void showMenu() {
		System.out.println("--------------------------------------------");
		System.out.println("1.입력 2.수정 3.삭제 4.회원리스트 5.이름조회 9.종료");
		System.out.println("--------------------------------------------");
		System.out.print("선택==> ");
	}
	
	public static void memberAdd() {
		System.out.print("이름을 입력 >>");
		String name = scn.next();
		System.out.print("연락처을 입력 >>");
		String phone = scn.next();
		System.out.print("생일을 입력 >>");
		String birth = scn.next();
		System.out.print("성별을 입력 (1.남/2.여) >>");
		
		int gen = scn.nextInt();
		Gender gender = null;
		
		Member member = new Member();
		member.setMemberName(name);
		member.setMemberBirth(birth);
		member.setMemberPhone(phone);
		if		(gen == 1){	gender = Gender.MEN; 	}
		else if	(gen == 2){	gender = Gender.WOMEN;	}
		member.setMemberGen(gender);
		member.setMemberId(getNextId());
		
		for(int i = 0 ; i < members.length ; i++) {
			if(members[i] == null) { // 입력시 비워져 있는 곳에 입력.
				members[i] = member;
				break;	// 비워있는 위치에 한건 입력 후 종료.
			}
		}
		System.out.println();
		System.out.println(" [ " + name + " ] 회원님, 등록되었습니다.");
		System.out.println();
	}
	
	public static void memberList() {
		if( members != null ) {
			System.out.println( ">>> 총 " + members.length + " 명 <<<");
			for(int i = 0 ; i < members.length ; i++) {
				if(members[i] != null) {
					System.out.println(members[i].showInfo());
					System.out.println();
				}
			}
		}else {
			System.out.println("회원정보가 없습니다.");
		}
	}

	public static void memberFind() {
		if( members != null ) {
			System.out.print("검색하실 회원 이름을 입력 >>");
			String findName = scn.next();
			
			for(int i = 0 ; i < members.length ; i++) {
				if(members[i] != null) {
					if(findName.equals(members[i].getMemberName())) {
						members[i].findShowInfo();
					}
				}
			}
		}else {
			System.out.println("회원정보가 없습니다.");
		}
	}
	
	public static int getNextId() {
		//회원번호 가입순번 => 1,2,3,4 ...
		int memberId = 0;
		// 현재 멤버 아이디 중에서 최고번호 가져오기
		for(int i = 0; i < members.length ; i++) {
			if(members[i] != null) {
				if( members[i].getMemberId() > memberId ) {
					memberId = members[i].getMemberId();
				}
			}
		}
		
		memberId++;
		return memberId;
	}

	
}
