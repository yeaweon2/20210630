package co.yedam.generic.board;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ListExample {
	public static void main(String[] args) {
		Board b1 = new Board("이것이 자바다", "컬렉션:List/Set/Map");
		Board b2 = new Board("초콜렛", "가나 초콜렛을 먹었다.");
		Board b3 = new Board("여름날씨", "계속 비가 오락가락합니다.");
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(b1);
		dao.insertBoard(b2);
		dao.insertBoard(b3);
		
		System.out.println("==== Map형식으로 리스트를 출력 ====> ");
		
		// Map형식으로 리스트를 출력
		Map<String,String> map = dao.getBoards();
		Set<String> set = map.keySet();
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println("제목:" + key + " / " + map.get(key));
		}
		
		System.out.println();
		System.out.println("==== List 형식으로 리스트를 출력 ====> ");
		ArrayList<Board> list = dao.getBoardList();
		
		for(Board board : list) {
			System.out.println(board.toString());
		}
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println();
		System.out.print("수정할 글 제목을 입력 : ");
		String search = scn.nextLine();
		
		System.out.print("변경할 내용을 입력하세요.");
		String changeContent = scn.nextLine();
		
		Board arg = new Board(search, changeContent);
		
//		dao.updateBoard(search, changeContent);
		dao.updateBoard(arg);
		for(Board board : list) {
			System.out.println(board.toString());
		}
		scn.close();
	}
}
