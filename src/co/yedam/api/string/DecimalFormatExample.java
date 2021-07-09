package co.yedam.api.string;

import java.text.DecimalFormat;

public class DecimalFormatExample {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("￦ #,###.###");
		df = new DecimalFormat("00000000000000.00000000");
		df = new DecimalFormat("#######.###");
		double num = 12345737234.7234589;
		System.out.println(df.format(num));
		
	}
}
