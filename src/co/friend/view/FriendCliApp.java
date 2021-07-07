package co.friend.view;

import co.friend.access.FriendAccess;
import co.friend.access.FriendList;
import co.friend.common.ScannerUtil;
import co.friend.model.Friend;

// 화면에 정보를 보여주고 사용자의 입력에 따라 처리
public class FriendCliApp {
	
	FriendAccess service = new FriendList();
	
	public void start() {
		// 1.입력 2.수정 3.삭제 4.리스트 5.이름조회 6.전화번호조회 9.종료
		
		int menu = 0;
		do {
			menuTitle();
			menu = ScannerUtil.readInt("선택 > ");
			
			switch(menu) {
				case 1: // 입력
					insert(); break;
				case 2:	// 수정
					update(); break;
				case 3: // 삭제
					delete(); break;
				case 4:	// 리스트
					list(); break;
				case 5:	// 이름조회
					searchName(); break;
				case 6:	// 전화번호 조회
					searchTel(); break;
			}
		}while(menu != 9);
		System.out.println("프로그램 종료.");
	}
	
	public void insert() {
		Friend friend = ScannerUtil.readFriend();
		service.insert(friend);
	}
	
	public void update() {
		String name = ScannerUtil.readString("이름 입력 > ");
		String tel =  ScannerUtil.readString("연락처 입력 > ");
		Friend friend = new Friend("", name, tel);
		service.update(friend);
	}
	
	public void delete() {
		String name = ScannerUtil.readString("이름 입력 > ");
		service.delete(name);
	}
	
	public void list() {
		
		System.out.println();
		System.out.println("----------------------------------------------");
		Friend[] friendList = service.selectAll();
		for( Friend friend : friendList ) {
			if( friend != null ) {
				System.out.println(friend.toString());
			}
		}
		System.out.println("----------------------------------------------");
	}
	
	public void searchName() {
		String name = ScannerUtil.readString("이름 입력 > ");
		Friend friend = service.selectOne(name);
		if(friend != null) {
			detailInfo(friend.getGubun(), friend.getName(), friend.getTel());
		}else {
			System.out.println("※ 입력하신 이름과 일치하는 정보가 없습니다.");
		}
	}
	
	public void searchTel() {
		String name = ScannerUtil.readString("전화번호 입력 > ");
		Friend friend = service.findTel(name);
		if(friend != null) {
			detailInfo(friend.getGubun(), friend.getName(), friend.getTel());
		}else {
			System.out.println("※ 입력하신 전화번호와 일치하는 정보가 없습니다.");
		}
	}
	
	public void menuTitle() {
		System.out.println();
		System.out.println("======== [ 친구관리 ] ===========");
		System.out.println("| 1. 친구 추가   2. 친구 수정     |");
		System.out.println("| 3. 친구 삭제   4. 전체 조회     |");
		System.out.println("| 5. 이름 조회   6. 전화번호 조회  |");
		System.out.println("| 9. 종    료                  |");
		System.out.println("===============================");
	}
	
	public void detailInfo(String gubun, String name, String tel) {
		System.out.println("----------------------------");
		System.out.println(" 1. 구 분 : " + gubun );
		System.out.println(" 2. 이 름 : " + name );
		System.out.println(" 3. 전화번호 : " + tel );
		System.out.println("----------------------------");
		System.out.println();		
	}
}
