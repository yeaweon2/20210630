package co.yedam;

public class StudentExample {
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		
		s1.setName("한지민");
		s1.setGrade(1);
		s1.setEngScore(85);
		s1.setMathScore(72);
		
		s2.setName("송혜교");
		s2.setGrade(1);
		s2.setEngScore(92);
		s2.setMathScore(33);		
		
		s3.setName("박보검");
		s3.setGrade(2);
		s3.setEngScore(90);
		s3.setMathScore(67);		
		
		Student[] std1 = new Student[] { s1, s2, s3 };
		int maxEng = 0;
		int maxMath = 0;
		
		int engSum = 0;
		int mathSum = 0;
		
		double engAvg = 0.0;
		double mathAvg = 0.0;
		
		Student maxEngStd = null;
		Student maxMathStd = null;
		
		for( int i = 0; i < std1.length ; i++) {
			std1[i].showInfo();
			
			engSum = engSum + std1[i].getEngScore();
			mathSum = mathSum + std1[i].getMathScore();
			
			// 최고 영어점수 구하기
			if(maxEng < std1[i].getEngScore()) {
				maxEng = std1[i].getEngScore();
				maxEngStd = std1[i];
			}
			
			if(maxMath < std1[i].getMathScore()) {
				maxMath = std1[i].getMathScore();
				maxMathStd = std1[i];
			}
		}
		
		engAvg = (double)engSum/(double)std1.length;
		mathAvg = (double)mathSum/(double)std1.length;
		
		System.out.println();
		System.out.println("==> 영어 1등 : " + maxEngStd.getName() + " / " + maxEngStd.getEngScore() + " 점 ");
		System.out.println("==> 수학 1등 : " + maxMathStd.getName() + " / " + maxMathStd.getMathScore() + " 점 ");
		System.out.println();
		System.out.println("==> (전체) 영어 평균 : " + engAvg + " / 수학 평균 : " + mathAvg );
	}
}
