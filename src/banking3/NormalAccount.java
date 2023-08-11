package banking3;

import java.util.Scanner;

import banking1.Account;

public class NormalAccount extends Account{

	
	 //Scanner scan = new Scanner(System.in);
	 //String AccountNumber =  scan.nextLine();
	 double normalRate;
	 //생성자
	 public NormalAccount(String AccountNumber, String name, int balance,  double normalRate) {
		 
		 super(AccountNumber,name,balance);
		
		 this.normalRate = normalRate;
	 }
	 
	
	
	@Override
	public int plusBalance(int money) {
		balance += (balance*normalRate*0.01) + money;
				return balance;
	}
	
	
	@Override
	public void showAllData() {
		System.out.println("normal계좌 기본정보");
		super.showAllData();
		System.out.println("기본이자:"+normalRate);
	}
	/*public void showAllData() {
		System.out.println("==대딩친구(전체정보)==");
		super.showAllData();
		System.out.println("전공:"+ major);
	}*/
	
	 
	 
	 
	 
	 
	 // balance = balance +(balance+0.02) + depositMoney();
	 
	
	 
	 
	
	
	
	
	

}
