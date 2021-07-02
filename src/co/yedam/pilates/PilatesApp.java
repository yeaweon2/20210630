package co.yedam.pilates;

import java.util.Scanner;

public class PilatesApp {
	
	private static PilatesApp singleton = new PilatesApp();
	
	private PilatesApp() {
		
	}
	
	public static PilatesApp getInstance() {
		return singleton;
		
	}
	
	Member[] members = new Member[10];
	Scanner scn = new Scanner(System.in);
	
	public void main() {
		// 회원관리 프로그램 
		// 1.입력, 2.수정, 3.삭제, 4.회원리스트, 5.이름조회, 9.종료
		
		members = new Member[] {
			new Member(1, "송혜교", "01012345679" , "790501" , Gender.WOMEN), 
			new Member(2, "강동원", "01066665679" , "870620" , Gender.MEN),
			new Member(3, "정우성", "01033335679" , "760312" , Gender.MEN),
			new Member(4, "한효주", "01055555679" , "850910" , Gender.WOMEN),
			new Member(5, "김철수", "01055555679" , "850910" , Gender.WOMEN),
			new Member(6, "한효주", "95120" , "2222" , Gender.MEN),
			new Member(7, "한효주", "01055555679" , "850910" , Gender.MEN),
			new Member(8, "김태희", "01035865679" , "821225" , Gender.WOMEN)
			, null
			, null
			, null
			, null
			, null
			, null
			, null
		};
		
		while(true) {
			showMenu();
			String menu = scn.nextLine();
			if( menu.equals("1") || menu.equals("입력")) {
				memberAdd();
			}else if(menu.equals("2") || menu.equals("수정")) {
				memberUpdate();
			}else if(menu.equals("3") || menu.equals("삭제")) {
				memberDelete();
			}else if(menu.equals("4") || menu.equals("회원LIST")) {
				memberList();
			}else if(menu.equals("5") || menu.equals("이름조회")) {
				searchByName();
			}else if(menu.equals("6") || menu.equals("상세조회")) {
				memberDetail();
			}else if(menu.equals("9") || menu.equals("종료")){
				break;
			}else {
				System.out.println("잘못된 메뉴입니다. 다시 선택해주세요.");
				System.out.println();
			}
		}
		System.out.println("프로그램 종료되었습니다.");
	}
	
	public void searchByName() {
		String name = scanString("조회할 이름을 입력하세요 >> " );
		System.out.println();
		Boolean exist = false;
		for(int i = 0 ; i < members.length ; i++) {
			if(members[i] != null && members[i].getMemberName().equals(name) ) {
				System.out.println(members[i].showInfo());
				exist = true;
			}
		}
		if(!exist) {
			System.out.println("해당 이름이 없습니다.");
		}
		System.out.println();
	}
	
	public void showMenu() {
		System.out.println("----------------------------------------------------");
		System.out.println("1.입력 2.수정 3.삭제 4.회원리스트 5.이름조회 6.상세조회 9.종료");
		System.out.println("----------------------------------------------------");
		System.out.print("선택==> ");
	}
	
	public void memberAdd() {
		String name = scanString("이름을 입력 >> ");
		String phone = scanString("연락처을 입력 >> ");
		String birth = scanString("생일을 입력 >> "); 
		Gender gender = scanGender("성별을 입력 (1.남/2.여) >> ");
		Member member = new Member(getNextId(), name, birth, phone, gender);
		
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
	
	// 입력메세지 출력 후 문자 입력값으로 반환.
	public String scanString(String arg) {
		System.out.print(arg);
		String val = scn.nextLine();
		return val;
	}
	
	public String scanLineString(String arg) {
		System.out.print(arg);
		String val = scn.nextLine();
		return val;
	}	
	
	public int scanInt(String arg) {
		int val = 0;
		while(true) {
			try {
				System.out.print(arg);
				val = scn.nextInt();
				break;
			}catch(Exception e) {
				System.out.println("숫자만 입력 가능합니다.");
				scn.nextLine();
			}
		}
		return val;
	}	
	
	// 입력메세지 출력 후 Gender 반환.
	public Gender scanGender(String arg) {
		Gender gender = null;
		while(true) {
			try {
				System.out.print(arg);
				String gen = scn.nextLine(); //예외가 발생하며 에러메세지 출력 후 다시 처리
				if(gen.equals("1") || gen.equals("MEN") || gen.equals("남자") || gen.equals("남")){	
					gender = Gender.MEN; 	
				}else if(gen.equals("2") || gen.equals("WOMEN") || gen.equals("여자") || gen.equals("여")){	
					gender = Gender.WOMEN;
				}else if(gen.equals("")) {
					gender = null;
				}else{
					
					System.out.println("1 또는 2를 입력해주세요.");
					continue;	// 반복문 탈출 못하도록 
				}
				break;
			}catch(Exception e) {
				System.out.println("숫자를 입력하세요.");
				scn.nextLine();
			}
		}
		return gender;
	}	
	
	public void memberList() {
		int chk = 0 ;
		if( members != null ) {
			System.out.println();
			for(int i = 0 ; i < members.length ; i++) {
				if(members[i] != null) {
					System.out.println(members[i].showInfo());
					chk++;
				}
			}
			
			if(chk > 0) {
				System.out.println();
				System.out.println( ">>> 총 " + chk + " 명 <<<");
				System.out.println();
			}else {
				System.out.println("회원정보가 없습니다.");
			}
		}else {
			System.out.println("회원정보가 없습니다.");
		}
	}

	public void memberDetail() {
		int chk = 0;
		if( members != null ) {
			int findId = scanInt("검색하실 회원ID를 입력 >> ");
			scn.nextLine();
			for(int i = 0 ; i < members.length ; i++) {
				if(members[i] != null) {
					if( findId == members[i].getMemberId() ) {
						members[i].findShowInfo();
						chk++;
					}
				}
			}
			if(chk == 0 ) {
				System.out.println("해당 회원정보가 없습니다.");
				System.out.println();
			}
		}else {
			System.out.println("회원정보가 없습니다.");
		}
	}
	
	public int getNextId() {
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
	
	public void memberUpdate() {
		int editId = scanInt("수정할 회원 ID를 입력해주세요. >> "); 
		scn.nextLine();
		Boolean exist = false;
		
		for(int i = 0 ; i < members.length ; i++) {
			if(members[i] != null && editId == members[i].getMemberId()) {
				exist = true;
								
				String name = scanLineString("이름을 입력 >> ");
				
				String phone = scanLineString("연락처를 입력 >> ");
				
				String birth = scanLineString("생일을 입력 >> ");
				
				Gender gen = scanGender("성별을 입력(1.남/2.여) >> ");
				
				if(!name.equals("")) { 
					members[i].setMemberName(name);
				}
				
				if(!phone.equals("")) { 
					members[i].setMemberPhone(phone);
				}
				
				if(!birth.equals("")) { 
					members[i].setMemberBirth(birth);
				}
				
				if( gen != null ) { 
					members[i].setMemberGen(gen);
				}
				System.out.println();
				System.out.println("수정이 완료되었습니다.");
				break;
			}
		}
		
		if(!exist) {
			System.out.println("해당 회원ID가 존재하지않습니다.");
		}
	}
	
	public void memberDelete() {
		int delId = scanInt("삭제할 회원번호를 입력하세요 >> ");
		scn.nextLine();
		Boolean exist = false;
		for(int i = 0 ; i < members.length ; i++) {
			if(members[i] != null && members[i].getMemberId() == delId ) {
				members[i] = null;
				exist = true;
				System.out.println("1건 삭제가 완료되었습니다.");
				break;
			}
		}
		if(!exist) {
			System.out.println("해당 회원ID가 존재하지 않습니다.");
		}
		System.out.println();
	}
}
