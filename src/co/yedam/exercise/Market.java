package co.yedam.exercise;

import co.yedam.pilates.Gender;

public class Market {
	
	private int selNo;
	private String selName;
	private String selPhone;
	private Gender gen;
	private String itemNm;
	private int Amt;

	public Market() {
		super();
	}

	public Market(int selNo, String selName, String selPhone, Gender gen) {
		super();
		this.selNo = selNo;
		this.selName = selName;
		this.selPhone = selPhone;
		this.gen = gen;
	}

	public Market(int selNo, String selName, String selPhone, Gender gen, String itemNm, int amt) {
		super();
		this.selNo = selNo;
		this.selName = selName;
		this.selPhone = selPhone;
		this.gen = gen;
		this.itemNm = itemNm;
		Amt = amt;
	}
	
	public int getSelNo() {
		return selNo;
	}
	public void setSelNo(int selNo) {
		this.selNo = selNo;
	}
	public String getSelName() {
		return selName;
	}
	public void setSelName(String selName) {
		this.selName = selName;
	}
	public String getSelPhone() {
		return selPhone;
	}
	public void setSelPhone(String selPhone) {
		this.selPhone = selPhone;
	}
	public Gender getGen() {
		return gen;
	}
	public void setGen(Gender gen) {
		this.gen = gen;
	}
	public String getItemNm() {
		return itemNm;
	}
	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}
	public int getAmt() {
		return Amt;
	}
	public void setAmt(int amt) {
		Amt = amt;
	}
	
}
