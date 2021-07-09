package co.yedam.api.string;

public class GenderCheckExample {
	public static void main(String[] args) {
		String birth1 = "9703041234567";
		String birth2 = "970304 1234567";
		String birth3 = "970304-2234567";
		String birth4 = "970304-3234567";
		String birth5 = "970304 4234567";
		
		checkGender(birth1);
		checkGender(birth2);
		checkGender(birth3);
		checkGender(birth4);
		checkGender(birth5);
	}
	
	public static String checkGender(String orginId) {

		String id = orginId;
		char genIdx = 0;
		String gen = "";

		// 앞뒤공백제거
		id = id.trim();
		
		if(id.indexOf("-") != -1) {  // '-' 이 들어갈 경우
			int idx = id.indexOf("-");
			id = id.replace("-", "");
		}else if(id.indexOf(" ") != -1){  // 공백이 들어갈 경우
			id = id.replace(" ", "");
		}
		
		genIdx = id.charAt(6);
		
//		switch(genIdx) {
//			case '1':
//			case '3':
//				gen = "남자";
//				break;
//			case '2':
//			case '4':
//				gen = "여자";
//				break;
//		}
		
		if( String.valueOf(genIdx).equals("1") ||  String.valueOf(genIdx).equals("3") ) {
			gen = "남자";
		}else if( String.valueOf(genIdx).equals("2") ||  String.valueOf(genIdx).equals("4") ) {
			gen = "여자";
		}
		
		System.out.println( "[ " + orginId + " ] 성별 ==> " + gen );
		
		return gen;
				
	}
}
