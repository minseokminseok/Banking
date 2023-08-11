package banking3;

import banking1.Account;
public class HighCreditAccount extends Account{
	 double normalRate;
	 double extraRate;
	 String creditRating;
	 
	 //생성자
	 //String accountNumber, String name, int balance, double normalRate, double extraRate, char creditRating)
	 public HighCreditAccount(String accountNumber, String name, int balance, double normalRate, String creditRating, double extraRate) { 
		 super(accountNumber,name,balance);
		 this.normalRate = normalRate;
		 this.extraRate = extraRate;
		 this.creditRating = creditRating;
	 }
	 
	 @Override
	public int plusBalance(int money) {
		 
		if(creditRating.charAt(0) == 'a' || creditRating.charAt(0) == 'A') {
			extraRate = 0.07;
		}
		if(creditRating.charAt(0) == 'b' || creditRating.charAt(0) == 'B') {
			extraRate = 0.04;
		}
		if(creditRating.charAt(0) == 'c' || creditRating.charAt(0) == 'C') {
			extraRate = 0.02;
		}
		 
		 
		 //신용계좌 : 잔고 + (잔고 * 기본이자) + (잔고 * 추가이자) + 입금액
		balance += (balance * normalRate *0.01 ) +(balance * extraRate*0.01) + money;
		return balance;
	}
	
	 @Override
	public void showAllData() {
		 System.out.println("신용계좌정보");
		super.showAllData();
	}
	 
}
