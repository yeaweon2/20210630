package co.yedam.Friend;

import java.util.Scanner;

public class FriendListApp {

	static Scanner scn = new Scanner(System.in);
	static Friend[] friends = new Friend[10];

	public static void main(String[] args) {
		// 1.추가 2.리스트 3.종료
		boolean run = true;
		while (run) {
			System.out.println("====================");
			System.out.println("1.추가 2.리스트 3.종료");
			System.out.println("====================");
			System.out.print("선택 >> ");

			String selNo = scn.next();
			scn.nextLine();

			switch (selNo) {
			case "1":
				System.out.println("1.친구 2.학교친구 3.회사친구");
				System.out.print("선택 >> ");
				String menu = scn.nextLine();

				System.out.print("이름 >> ");
				String name = scn.nextLine();
				System.out.print("연락처 >> ");
				String phone = scn.nextLine();

				Friend friend = null;
				if (menu.equals("1")) {
					friend = new Friend(name, phone); // Friend 인스턴스
				} else if (menu.equals("2")) {
					System.out.print("전공 >> ");
					String major = scn.nextLine();
					friend = new UnivFriend(name, phone, major); // univFriend 인스턴스
				} else if (menu.equals("3")) {
					System.out.print("부서 >> ");
					String department = scn.nextLine();
					friend = new CompFriend(name, phone, department); // CompFriend 인스턴스
				} else {
					System.out.println("1 ~ 3번만 선택해주세요.");
					break;
				}

				// 배열에 저장
				for (int i = 0; i < friends.length; i++) {
					if (friends[i] == null) {
						friends[i] = friend;
						break;
					}
				}
				break; // switch구문 : break;
			case "2":
				for (int i = 0; i < friends.length; i++) {
					if (friends[i] != null) {
						System.out.println(friends[i].toString());
					}
				}
				break;
			case "3":
				run = false;
			}
		}
		System.out.println("프로그램 종료.");
	} // end of main()
} // end of class
