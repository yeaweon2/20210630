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
			String menu = scn.next();
			if( menu.equals("1") || menu.equals("입력")) {
				memberAdd();
			}else if(menu.equals("2") || menu.equals("수정")) {
				memberEdit();
			}else if(menu.equals("3") || menu.equals("삭제")) {
				
			}else if(menu.equals("4") || menu.equals("회원LIST")) {
				memberList();
			}else if(menu.equals("5") || menu.equals("이름조회")) {
				memberFind(); 
			}else if(menu.equals("9") || menu.equals("종료")){
				break;
			}else {
				System.out.println("잘못된 메뉴입니다. 다시 선택해주세요.");
				System.out.println();
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
		int chk = 0 ;
		if( members != null ) {
			System.out.println();
			for(int i = 0 ; i < members.length ; i++) {
				if(members[i] != null) {
					System.out.println(members[i].showInfo());
					chk++;
				}
			}
			System.out.println();
			System.out.println( ">>> 총 " + chk + " 명 <<<");
			System.out.println();
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

	public static void memberEdit() {
		int chk = 0;
		System.out.print("수정할 회원 이름을 입력해주세요. >>");
		String editName = scn.next();
		for(int i = 0 ; i < members.length ; i++) {
			if(members[i] != null) {
				if(editName.endsWith(members[i].getMemberName())) {
					chk++;
					while(true) {
						System.out.println("-------------------------------");
						System.out.println("1.이름 2.연락처 3.생일 4.성별 5.완료");
						System.out.println("-------------------------------");
						System.out.print("수정할 정보를 선택해주세요 ==> ");
						int editMenu = scn.nextInt();
						if( editMenu == 1 ) {
							System.out.print("이름을 입력 > ");
							String editAfName = scn.next();
							members[i].setMemberName(editAfName);
						}else if( editMenu == 2 ) {
							System.out.print("연락처를 입력 > ");
							String editAfPhone = scn.next();
							members[i].setMemberPhone(editAfPhone);
						}else if( editMenu == 3 ) {
							System.out.print("생일을 입력 > ");
							String editAfBirth = scn.next();
							members[i].setMemberBirth(editAfBirth);
						}else if( editMenu == 4 ){
							System.out.print("성별을 입력 (1.남/2.여)> ");
							
							Gender gen = null;
							int editAfGen = scn.nextInt();
							if		(editAfGen == 1){	gen = Gender.MEN; 	}
							else if	(editAfGen == 2){	gen = Gender.WOMEN;	}
							members[i].setMemberGen(gen);
						}else if( editMenu == 5 ){
							System.out.println();
							break;
						}else {
							System.out.println("1~4번의 메뉴만 선택해주세요.");
						}
					}
					
				}
					
				
			}
		}
		if(chk == 0) {
			System.out.println("해당 회원은 존재하지 않습니다.");
		}
			
	}
}
