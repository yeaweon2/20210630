package co.yedam.account;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Scanner;

// 데이터를 담아놓기위한 Account
// 컨트롤 입금, 출금,  => 사용자의 입력으로 메뉴를 실행.
public class AccountApp {

	private static AccountApp app = new AccountApp();
	
	private AccountApp() {
		
	}
	
	public static AccountApp getInstance() {
		return app;
	}
	
	Account[] accounts = new Account[10];
	Scanner scn = new Scanner(System.in);
	File file = new	File("accountList.txt");

	public void exe() {
//		accounts[0] = new Account("111-5555","박보검", 12000);
//		accounts[1] = new Account("22-15-3520","홍길동", 350000);
//		accounts[2] = new Account("33-84-777","송혜교", 7800);
//		accounts[3] = new Account("55-223-44-2","강동원", 1500);
//		accounts[4] = new Account("44-33-656-88","김태희", 800);
//		
		boolean run = true;
		// 1.계좌생성 2.계좌목록 3.예금 4.출금 5.종료
		while(run) {
			
			printMenu();
			
			int selectNo = scn.nextInt();
			scn.nextLine();
			
			if(selectNo == 1) {
				createAccount();
			}else if(selectNo == 2) {
				accountList();
			}else if(selectNo == 3) {
				deposit();
			}else if(selectNo == 4) {
				withdraw();
			}else if(selectNo == 5) {
				fileSave();
			}else if(selectNo == 6) {
				fileOpen();
			}else if(selectNo == 7) {
				run = false;
			}else {
				System.out.println();
				System.out.println("1 ~ 5 번의 메뉴만 선택해주세요.");
				System.out.println();
			}
			
		}
		System.out.println();
		System.out.println(">> 프로그램 종료.");
	}	
	
	private void printMenu() {
		System.out.println("------------------------------------------------------");
		System.out.println("1.계좌생성 2.계좌목록 3.예금 4.출금 5.파일저장 6. 파일열기 7.종료");
		System.out.println("------------------------------------------------------");
		System.out.print("선택 >> ");
	}
	
	// 계좌생성
	private void createAccount() {	
		String ano = Utils.scanString("계좌번호 입력 >> ");
		String owner = Utils.scanString("예금주 입력 >> ");
		String amount = Utils.scanNumberString("금액 입력 >> "); 
		
		Account acnt = new Account(ano, owner, Integer.parseInt(amount));
//		acnt.setAno(ano);
//		acnt.setOwner(owner);
//		acnt.setBalance(Integer.parseInt(amount)); // 문자열숫자 => int형으로 변환
		
		for(int i = 0 ; i < accounts.length ; i++) {
			if(accounts[i] == null) {
				accounts[i] = acnt;
				System.out.println(">> 1건 입력되었습니다.");
				break;	// 비어있는 위치에 1건 입력후 종료.
			}
		}
		
	}
	
	// 계좌정보(ano)를 입력 해당계좌를 반환해주는 메소드.
	private Account findAccount(String ano) {
		for(int i = 0 ; i < accounts.length ; i++) {
			if(accounts[i] != null && accounts[i].getAno().equals(ano)){
				return accounts[i];
			}
		}
		return null;
	}
	
	private void accountList() {
		System.out.println();
		for(int i = 0; i < accounts.length ; i++) {
			if( accounts[i] != null ) {
				System.out.println( accounts[i].getAno() + " / " + accounts[i].getOwner() + " / " + accounts[i].getBalance());
			}
		}
		System.out.println();
	}
	
	// 예 금
	private void deposit() {
		String ano = Utils.scanString("계좌번호 입력 >> ");
		Account acnt = findAccount(ano); 
		if(acnt != null) {
			System.out.println(">>" + acnt.getOwner() + "님의 현재 잔액는 " + acnt.getBalance() + "원 입니다.");
			String amt = Utils.scanNumberString("예금액을 입력 >> ");
			int balance = acnt.getBalance();
			acnt.setBalance( balance + Integer.parseInt(amt));
			System.out.println(">> 현재 잔액 : " + acnt.getBalance() + "원");
		}else {
			System.out.println(">> 해당 계좌번호는 없습니다.");
		}	
		System.out.println();
	}
	
	// 출 금
	private void withdraw() {
		String ano = Utils.scanString("계좌번호 입력 >> ");
		Account acnt = findAccount(ano); 
		if(acnt != null) {
			System.out.println(">>" + acnt.getOwner() + "님의 현재 잔액는 " + acnt.getBalance() + "원 입니다.");
			while(true) {
				String amt = Utils.scanNumberString("출금액을 입력 >> ");
				int balance = acnt.getBalance();
				if(balance - Integer.parseInt(amt) < 0 ) {
					System.out.println(">> 출금액이 현재 잔액보다 많습니다.");
				}else {
					acnt.setBalance( balance - Integer.parseInt(amt));
					System.out.println(">> 잔액 : " + acnt.getBalance() + "원");
					break;
				}
			}
		}else {
			System.out.println(">> 해당 계좌번호는 없습니다.");
		}	
		System.out.println();
	}	
	
	// 파일저장
	private void fileSave() {
		OutputStream os = null; 
		try {
			os = new FileOutputStream(file);
			for(int i = 0 ; i < accounts.length ; i++) {
				if(accounts[i] != null) {
					Account account = accounts[i];
					String val = account.getAno() + "," + account.getOwner() + "," + account.getBalance()+"\n";
					os.write(val.getBytes());
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				os.flush();	
				os.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("파일저장이 완료되었습니다.");
	}
	
	// 파일열기
	private void fileOpen() {
		//InputStream is = null;
		Reader is = null;
		try {
//			is = new FileInputStream(file);
			is = new FileReader(file);
			int readByte = 0;
			StringBuffer sb = new StringBuffer();
			while((readByte = is.read()) != -1) {
				sb.append((char) readByte);
			}
			String[] acnts = sb.toString().split("\n");
			for(int i = 0 ; i < acnts.length ; i++) {
				String[] acnt = acnts[i].split(",");
				accounts[i]= new Account(acnt[0], acnt[1],Integer.parseInt(acnt[2]));
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("파일열기완료.");
	}
		
	
}
