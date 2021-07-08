package co.friend.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.friend.model.Friend;

// FriendAccess(인터페이스)를 구현하는 객체.
// 파일에 저장
public class FriendList implements FriendAccess {

	String path = "c:/tmp/friendList.txt";
	List<Friend> friends;
	
	public FriendList() {
		friends = new ArrayList<Friend>();
		open();
	}	
	
	public void open() {
		File file = new File(path);
		if(!file.exists()) {	// path에 해당파일이 없으면 디렉토리생성 및 파일생성
			File dir = new File("c:/tmp/");
			dir.mkdirs();  // c:/tmp 디텍토리 생성
			try {
				file.createNewFile(); // 파일을 생성	
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Scanner scn = new Scanner(file);
			while(true) {
				if(!scn.hasNext()) {
					break;
				}
				String readStr = scn.next();
				String[] arr = readStr.split(",");
				Friend friend = new Friend(arr[0], arr[1], arr[2]);
				
				// 배열의 빈공간에 한건씩 저장.
//				for(int i = 0; i < friends.length ; i++) {
//					if( friends[i] == null ) {
//						friends[i] = friend;
//						break;
//					}
//				}
				
				friends.add(friend);
			}
			scn.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		BufferedWriter br = null;
		try {
			br= new BufferedWriter(new FileWriter(path));
//			for(int i = 0; i<friends.length ; i++) {
//				if(friends[i] != null) {
//					br.write(String.format("%s,%s,%s\n", friends[i].getGubun(),friends[i].getName(),friends[i].getTel()));
//				}
//			}
			
			for(int i = 0; i<friends.size() ; i++) {	
				br.write(String.format("%s,%s,%s\n", friends.get(i).getGubun(),friends.get(i).getName(),friends.get(i).getTel()));
			}			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean duplNameChk(String name) {
		boolean duplChk = false;
		for(int i = 0; i < friends.size() ; i++) {
			if( friends.get(i).getName().equals(name) ) { 
				duplChk = true;
				break;
			}
		}
		return duplChk;
	}

	@Override
	public void insert(Friend friend) {
		if(!duplNameChk(friend.getName())) {
			friends.add(friend);
			System.out.println("※ [" + friend.getName() + "] 님의 정보가 입력되었습니다.");			
		}else {
			System.out.println("※ 동일한 이름이 존재합니다.");
		}
		save();
	}

	@Override
	public void update(Friend friend) {
		boolean chk = false;
		for(int i = 0; i < friends.size() ; i++) {
			if( friends.get(i).getName().equals(friend.getName()) ) { // 이름 비교
				friends.get(i).setTel(friend.getTel());
				chk = true;
				break;
			}
		}
		if(!chk) {
			System.out.println("※ 수정하실 이름의 정보가 존재하지 않습니다.");
		}else {
			System.out.println("※ 수정이 완료되었습니다.");
		}
		save();
	}

	@Override
	public void delete(String name) {
		boolean chk = false;
		for(int i = 0; i < friends.size() ; i++) { 
			if( friends.get(i).getName().equals(name) ) { // 이름 비교
				friends.remove(i);
				chk = true;
				break;
			}
		}
		if(!chk) {
			System.out.println("※ 삭제하실 이름의 정보가 존재하지 않습니다.");
		}else {
			System.out.println("※ 삭제가 완료되었습니다.");
		}
		save();
	}

	@Override
	public List<Friend> selectAll() {
		return friends;
	}

	@Override
	public Friend selectOne(String name) {
		Friend friend = null;
		for(int i = 0; i < friends.size() ; i++) {
			if( friends.get(i).getName().equals(name) ) {  
				friend = friends.get(i);
				break;
			}
		}
		return friend;
	}

	@Override
	public Friend findTel(String tel) {
		Friend friend = null;
		for(int i = 0; i < friends.size() ; i++) {
			if( friends.get(i) != null ) {  
				if( friends.get(i).getTel().equals(tel) ) { 
					friend = friends.get(i);
					break;
				}
			}
		}		
		return friend;
	}
}
