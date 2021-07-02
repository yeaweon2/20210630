package co.yedam.exercise;

public class Employee {
	// 사원정보 ( 필드 : 사원번호, 사원명, 사원이메일, 사원급여, 사원부서 )
	private int empNo;
	private String empName;
	private String empEmail;
	private int empPay;
	private String empTeam;
	
	public Employee() {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPay = empPay;
		this.empTeam = empTeam;
	}
	
	public Employee(int empNo, String empName, String empEmail) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empEmail = empEmail;
	}
	
	

	public Employee(int empNo, String empName, String empEmail, int empPay, String empTeam) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPay = empPay;
		this.empTeam = empTeam;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public int getEmpPay() {
		return empPay;
	}

	public void setEmpPay(int empPay) {
		this.empPay = empPay;
	}

	public String getEmpTeam() {
		return empTeam;
	}

	public void setEmpTeam(String empTeam) {
		this.empTeam = empTeam;
	}
	
	public void showInfo() {
		System.out.println("사원번호 : " + this.empNo + " 이름 : " + this.empName + " 이메일 : " + this.empEmail );
	}	
}
