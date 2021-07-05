package co.yedam.pilates;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		accountArray[0] = new Account("111-5555"		,"송혜교",5000);
		accountArray[1] = new Account("11-352-7530"		,"강동원",3000);
		accountArray[2] = new Account("22-351-6485"		,"한효주",120000);
		accountArray[3] = new Account("345-951-6202"	,"김혜수",550000);
		accountArray[4] = new Account("352-99-4111"		,"정우성",3200);
		accountArray[5] = new Account("352-6201-52-522"	,"박보검",9500);	
		
		boolean run = true;
		while(run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.계좌생성 2.계좌목록 3.예금 4.출금 5.삭제 6.검색 9.종료 ");
			System.out.println("-------------------------------------------------");
			System.out.print("선택 ==> ");
			
			int selNo = scn.nextInt();
			scn.nextLine();
			if(selNo == 1) {
				createAccount();
			}else if(selNo == 2) {
				accountList();
			}else if(selNo == 3) {
				deposit();
			}else if(selNo == 4) {
				withdraw();
			}else if(selNo == 5) {
				delAno();
			}else if(selNo == 6){
				searchAno();
			}else if(selNo == 9) {
				run = false;
			}else {	
				System.out.println("1 ~ 9번 메뉴만 선택해주세요.");
			}
		}
		System.out.println("프로그램 종료.");
	}
	
	public static String scanString(String arg) {
		System.out.print(arg);
		String val = scn.nextLine();
		return val;
	}
	
	public static int scanInt(String arg) {
		System.out.print(arg);
		int val = 0;
		try{
			val = scn.nextInt();
		}catch(Exception e) {
			System.out.println("숫자만 입력해주세요.");
		}
		return val;
	}
	
	public static void createAccount() {
		String ano = scanString("계좌정보 입력 >> ");
		String owner = scanString("계좌주 입력 >> ");
		int balance = scanInt("최초입금액 입력 >> ");
		
		Account act = new Account(ano,owner,balance);
		
		for(int i = 0 ; i < accountArray.length ; i++ ) {
			if(accountArray[i] == null) {
				accountArray[i] = act;
				break;
			}
		}

		System.out.println();
		System.out.println("계좌정보가 등록되었습니다.");
		System.out.println();
	}
	public static void accountList() {
		int chk = 0;
		System.out.println();
		for(int i = 0 ; i < accountArray.length ; i++ ) {
			if(accountArray[i] != null) {
				System.out.println(accountArray[i].showInfo());
				chk++;
			}
		}
		if(chk < 1) {
			System.out.println("계좌정보가 없습니다.");
		}else {
			System.out.println();
			System.out.println(">>> 총 " + chk + " 건 <<<");
			System.out.println();
		}
		
		System.out.println();
	}
	
	public static void deposit() {
		String ano = scanString("계좌정보 입력 >> ");
		int balance = scanInt("입금액 입력 >> ");

		if(findAccount(ano)) {
			ingAccount("예금",ano,balance);
		}else {
			System.out.println();
			System.out.println("결과 : 해당 계좌정보가 없습니다.");
		}
		System.out.println();
	}	
	
	public static void withdraw() {
		String ano = scanString("계좌정보 입력 >> ");
		int balance = scanInt("출금액 입력 >> ");

		if(findAccount(ano)) {
			ingAccount("출금",ano,balance);
		}else {
			System.out.println();
			System.out.println("결과 : 해당 계좌정보가 없습니다.");
		}
		System.out.println();
	}	
	
	public static boolean chkBalance(String menu, int bal , int amt) {
		boolean chk = false;
		if(menu.equals("예금")) {
			if( (bal + amt) > 1000000 ) {
				chk = false;
			}else {
				chk = true;
			}
		}else {
			if( (bal - amt) < 0  ) {
				chk = false;
			}else {
				chk = true;
			}
		}
		return chk;
	}
	
	public static void ingAccount(String menu , String ano, int balance) {
		boolean chk = false;
		//Account ano1 = new Account();
		
		for(int i = 0 ; i < accountArray.length ; i++ ) {
			if(accountArray[i] != null && accountArray[i].getAno().equals(ano)) {
				chk = true;
				if(menu.equals("예금")) {
					if(chkBalance("예금", accountArray[i].getBalance(), balance) ) {
						accountArray[i].setBalance( (accountArray[i].getBalance()+balance) );
						System.out.println("결과 : 예금이 성공되었습니다.");
						break;	
					}else {
						System.out.println("결과 : 처리이상 ( 100만원 이상의 금액을 입금할 수 없습니다. )");
						break;
					}
				}else {
					if(chkBalance("출금", accountArray[i].getBalance(), balance) ) {
						accountArray[i].setBalance( (accountArray[i].getBalance()-balance) );
						System.out.println("결과 : 출금이 성공되었습니다.");
						break;	
					}else {
						System.out.println("결과 : 처리이상 ( 출금액이 현재 잔고보다 많습니다. )");
						break;
					}					
				}
			}
		}
	}
	
	public static boolean findAccount(String ano) {
		boolean chk = false;
		for(int i = 0 ; i < accountArray.length ; i++ ) {
			if(accountArray[i] != null && accountArray[i].getAno().equals(ano)) {
				chk = true;
				break;
			}
		}
		return chk;
	}
	
	public static void delAno() {
		String ano = scanString("계좌정보 입력 >> ");
		if(findAccount(ano)) {
			for(int i = 0 ; i < accountArray.length ; i++ ) {
				if(accountArray[i] != null && accountArray[i].getAno().equals(ano)) {
					while(true) {
						String answer = scanString("[ " + accountArray[i].getOwner() +" ] 님의 계좌정보를 삭제하시겠습니까? ( Y / N )");
						if(answer.equals("Y") || answer.equals("y")) {
							accountArray[i] = null;
							break;
						}else if(answer.equals("N") || answer.equals("n")) {
							break;
						}else {
							System.out.println("Y 또는 N 으로 입력해주세요.");
						}
					}
					break;
				}
			}			
			System.out.println();
		}else {
			System.out.println("해당 계좌정보는 존재하지 않습니다.");
			System.out.println();
		}
	}
	
	public static void searchAno() {
		String ano = scanString("계좌정보 입력 >> ");
		if(findAccount(ano)) {
			for(int i = 0 ; i < accountArray.length ; i++ ) {
				if(accountArray[i] != null && accountArray[i].getAno().equals(ano)) {
					accountArray[i].showInfoDetail();
					break;
				}
			}
		}else {
			System.out.println("해당 계좌정보는 존재하지 않습니다.");
			System.out.println();
		}
	}	
	
}
