package co.yedam.pilates;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("------------------------------------");
			System.out.println("1.계좌생성 2.계좌목록 3.예금 4.출금 5.종료 ");
			System.out.println("------------------------------------");
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
				run = false;
			}else {	
				System.out.println("1 ~ 5번 메뉴만 선택해주세요.");
			}
		}
	}
	
	public static String scanString(String arg) {
		System.out.println(arg);
		String val = scn.nextLine();
		return val;
	}
	
	public static int scanInt(String arg) {
		System.out.println(arg);
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
			}
		}

		System.out.println();
		System.out.println("계좌정보가 등록되었습니다.");
		System.out.println();
	}
	public static void accountList() {
		int chk = 0;
		for(int i = 0 ; i < accountArray.length ; i++ ) {
			if(accountArray[i] != null) {
				accountArray[i].showInfo();
				chk++;
			}
		}
		if(chk < 1) {
			System.out.println("계좌정보가 없습니다.");
		}
	}
	public static void deposit() {
		
	}
	public static void withdraw() {
		
	}
}
