package co.yedam.exercise;

import co.yedam.pilates.Gender;

public class MarketExample {
	public static void main(String[] args) {
		Market m1 = new Market();
		m1.setSelNo(1);
		m1.setSelName("Park");
		m1.setSelPhone("01092193427");
		m1.setGen(Gender.MEN);
		m1.setItemNm("cookie");
		m1.setAmt(8000);
		
		Market m2 = new Market(2,"Choi","01025826541", Gender.WOMEN ,"shampoo", 15000);
	
		Market m3 = new Market(3,"Lee","01066668888", Gender.MEN );
		
		Market[] markets = new Market[5]; // { m1, m2, m3 };
		markets[0] = m1;
		markets[1] = m2;
		markets[2] = m3;
		
		for(int i = 0 ; i < markets.length ; i++) {
			if(markets[i] != null) {
				System.out.println(markets[i].getSelName()+ " / " + markets[i].getItemNm());
			}
		}
		
	}
}
