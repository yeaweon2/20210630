package co.yedam;

public class MethodExample {
	public static void main(String[] args) {
		String str1 = new String("홍길동 19900101 01012345678");
		String str2 = new String("김태희 19790516 01085207410");
		String str3 = new String("박보검 19890923 01098765432");
		
		System.out.println(makeUsefulInfo(str1));
		System.out.println(makeUsefulInfo(str2));
		System.out.println(makeUsefulInfo(str3));
		
	}
	
	public static String makeUsefulInfo(String str) {
		String[] info = str.split(" ");
		String name = info[0];
		String birth = info[1];
		String phone = info[2];
		
		name  = "\n이름 : " + name ;
		birth = "\n생일 : " + birth.substring(0, 4) + "년 " + birth.substring(4, 6) + "월 " + birth.substring(6, 8) + "일";
		phone = "\n전화 : " + phone.substring(0, 3) + "-" + phone.substring(3, 7) + "-" + phone.substring(7,11);
		
		String result = name + birth + phone;
		
		return result;
	} 
}
