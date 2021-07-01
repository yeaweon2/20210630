package co.yedam;

import java.util.Calendar;

public class CalExample {
	public static void main(String[] args) {
		int year = 2021;
		int month = 6;
		
		printCal(year, month);
		
		System.out.println();
		System.out.println();	
		System.out.println("프로그램 종료.");
	}
	
	public static void printCal(int year, int month) {
		
		System.out.println(" <<< " + year + "년 " + month +"월 달력 >>>" );
		System.out.println();
		
		Calendar cal = Calendar.getInstance(); // new Calender();
		
		cal.set(year, (month-1), 1);

		int fristDay = cal.get(Calendar.DAY_OF_WEEK);
		int lastDate = cal.getActualMaximum(Calendar.DATE);

		printDays();
				
		// 공란 만들기
		for(int i = 1; i < fristDay ; i++) {
			System.out.printf("%4s", "" );
		}
		
		for(int i = 1 ; i <= lastDate ; i++) {
			System.out.printf("%4d", i );
			if( (i+(fristDay-1))%7 == 0 ) {
				System.out.println();	
			}
		}	
		
//		System.out.println("년도 : " + cal.get(Calendar.YEAR));
//		System.out.println("월 : " + (cal.get(Calendar.MONTH)+1)); // 0부터 시작함
//		System.out.println("일 : " + cal.get(Calendar.DAY_OF_MONTH));
//		System.out.println("요일 : " + cal.get(Calendar.DAY_OF_WEEK));
//		System.out.println("마지막날 : " + cal.getActualMaximum(Calendar.DATE));
	}
	
	public static void printDays() {
		String[] days = {"Sun","Mon","Tue","Wed","Thr","Fri","Sat"};
		
		// 요일정보 : 확장for
		for(String day : days) {
			System.out.print(" " + day );
		}
		System.out.println();
	}
}
