package banking1;

public class Account {
	//멤버변수 : 이름, 전화번호, 주소 기본정보 3가지를 저장.
		private String accountNumber;
		private String name;
		public int balance;
		//생성자 : 멤버변수 초기화.
		public Account(String accountNumber, String name, int balance) {
			this.accountNumber = accountNumber;
			this.name = name;
			this.balance = balance;
		}
		
		
		
		
		
		public String getAccountNumber() {
			return accountNumber;
		}


	/*	public void addAccount() {
			
		} */


		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public String getName() {
			return name;
		}





		public void setName(String name) {
			this.name = name;
		}





		public int getBalance() {
			return balance;
		}





		public void setBalance(int balance) {
			this.balance = balance;
		}





		//멤버변수 전체를 출력하기 위한 멤버메서드
		public void showAllData() {
			System.out.println("계좌번호:"+ accountNumber);
			System.out.println("계좌이름:"+ name);
			System.out.println("잔고:"+ balance);
		}
		
		public int plusBalance (int money) {
			balance += money;
			return balance;
		}
		
		public int minusBalance (int money) {
			balance -= money;
			return balance;
		}
		
		//함수 오버라이딩용
		
		
		
		
	

}
