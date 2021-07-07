package co.friend.common;

import java.util.Scanner;

import co.friend.model.Friend;

public class ScannerUtil {

	// 사용자의 입력 메세지 => 숫자, 문자
	static Scanner scn = new Scanner(System.in);
	
	// 구분,이름,전화
	public static Friend readFriend() {
		String input = "";
		String[] inputs = null;
		while(true) {
			System.out.print("구분,이름,전화 > ");
			input = scn.next();
			inputs = input.split(",");
			if( inputs.length == 3 ) {
				break;
			}else {
				System.out.println("※ 해당하는 값 3가지를 정확히 입력해주세요.");
			}
		}
		return new Friend(inputs[0], inputs[1], inputs[2]);
	}
	
	public static String readString(String prompt) {
		System.out.print(prompt);
		return readString();
	}
	
	public static String readString() {
		String msg = null;
		try {
			msg = scn.next();	
		}catch(Exception e) {
			System.out.println("※ 관리자에게 문의하세요.");
		}
		return msg;
	}
	
	public static int readInt(String prompt) {
		System.out.print(prompt);
		return readInt();
	}
	
	public static int readInt() {
		int val = 0;
		while(true) {
			try {
				val = scn.nextInt();
				scn.nextLine();
				break;
			}catch(Exception e) {
				System.out.print("※ 숫자를 입력하세요 ==>");
				scn.nextLine();
			}
		}
		return val;
	}
	
	
}
