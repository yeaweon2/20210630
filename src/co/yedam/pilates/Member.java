package co.yedam.pilates;

public class Member {
	private int memberId;
	private String memberName;
	private String memberPhone;
	private String memberBirth;
	private Gender memberGen; // enum
	
	public Member() {}
	
	public Member(int memberId, String memberName, String memberPhone) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
	}

	public Member(int memberId, String memberName, String memberPhone, String memberBirth, Gender memberGen) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberBirth = memberBirth;
		this.memberGen = memberGen;
	}
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}
	public Gender getMemberGen() {
		return memberGen;
	}
	public void setMemberGen(Gender memberGen) {
		this.memberGen = memberGen;
	}
	
	public String showInfo() {
		String info = "회원번호:" + this.memberId +" / 회원명:"+this.memberName + " / 연락처:"+this.memberPhone+" / 생년월일:"+this.memberBirth+" / 성별:"+this.memberGen ;
		return info;
	}
	
	public void findShowInfo() {
		System.out.println("==========================================");
		System.out.println("1. 회원ID 	: " + this.memberId );
		System.out.println("2. 회원명  	: " + this.memberName );
		System.out.println("3. 연락처  	: " + this.memberPhone );
		System.out.println("4. 생년월일 	: " + this.memberBirth );
		System.out.println("5. 성   별  	: " + this.memberGen );
		System.out.println("==========================================");
		System.out.println();
	}	
	

	
}
