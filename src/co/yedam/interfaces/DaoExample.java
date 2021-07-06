package co.yedam.interfaces;

public class DaoExample {
	public static void main(String[] args) {
		Dao dao = new OracleDao();
		
		dao.insert();
		dao.update();
		dao.delete();

		// 익명의 구현객체 , 이름없는 클래스 , 1회성
		// sqlite, postgreSQL		
		Dao dao2 = new Dao() {
			@Override
			public void insert() {
				System.out.println("sqlite 입력처리");
			}

			@Override
			public void update() {
				System.out.println("sqlite 수정처리");
			}

			@Override
			public void delete() {
				System.out.println("sqlite 삭제처리");
			}
		};
		
		dao2 = new Dao() {
			@Override
			public void insert() {
				System.out.println("postgreSQL 입력처리");
			}

			@Override
			public void update() {
				System.out.println("postgreSQL 수정처리");
			}

			@Override
			public void delete() {
				System.out.println("postgreSQL 삭제처리");
			}
		};		
		
		dao2.insert();
		dao2.update();
		dao2.delete();
		

		
	}
}
