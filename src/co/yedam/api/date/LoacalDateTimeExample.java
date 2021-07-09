package co.yedam.api.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoacalDateTimeExample {
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println(now);	
		
		// LocalDateTime => String
		System.out.println(now.format(dtf));
		
		// String => LocalDateTime
		LocalDateTime anytime = LocalDateTime.parse("2021-06-13 15:00:00",dtf);
		
		dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd HH");
		anytime = LocalDateTime.parse("2021/05/01 14", dtf);
		System.out.println(anytime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		
		
		// 시간 비교시 LocalDateTime형식으로 비교
		System.out.println(now.isAfter(anytime));
		
		System.out.println(anytime.getMonth());
		System.out.println(anytime.getMonthValue() + "월");
		
		LocalDateTime ti = LocalDateTime.now()
				.withYear(1990).withMonth(6).withDayOfMonth(5)
				.withHour(15).withMinute(31).withSecond(26);
		
		System.out.println(ti.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
		
		
		LocalDateTime yourBirth = LocalDateTime.now()
				.withYear(1988).withMonth(6).withDayOfMonth(20);
		
		System.out.println(yourBirth.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 생일입니다.")));
		
				
		
		
		
	}
}
