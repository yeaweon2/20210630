package co.yedam.pilates;

public class Account {
	private String ano;
	private String owner;
	private int balance;
	
	public Account() {
		super();
	}
	
	public Account(String ano, String owner, int balance) {
		super();
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String showInfo() {
		String info = this.ano + "\t" + this.owner + "\t" + this.balance;
		return info;
	}
	public void showInfoDetail() {
		System.out.println();
		System.out.println("=========================================");
		System.out.println("1. 계좌정보 	:  " + this.ano		);
		System.out.println("2. 예금주   	:  " + this.owner	);
		System.out.println("3. 잔 액		:  " + this.balance	);
		System.out.println("=========================================");
		System.out.println();
	}	
}
