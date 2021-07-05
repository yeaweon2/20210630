package co.yedam.account;

// 실행 클랙스(main)
public class Main {
	public static void main(String[] args) {
		// Singleton 싱글톤
		// i)
		//AccountApp.getInstance().exe();
		
		// ii)
		AccountApp app = AccountApp.getInstance();
		app.exe();
	}
}
