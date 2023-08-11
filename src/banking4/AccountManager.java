package banking4;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import banking1.Account;
import banking2.NormalAccount;

import banking2.HighCreditAccount;
public class AccountManager {
public static void showMenu() {
	System.out.println("1.계좌계설");
	System.out.println("2.입금");
	System.out.println("3.출금");
	System.out.println("4.전체계좌정보출력");
	System.out.println("5.계좌정보삭제");
	System.out.println("6.프로그램종료");
}
public static void main(String[] args) {//메인시작
	Scanner scan = new Scanner(System.in);
	//크기 필요없음 list는
	AccountInfoHandler handler =
			new AccountInfoHandler();
	while(true) {//while시작
	try {
		showMenu();
		int choice = scan.nextInt();
		switch(choice) {
		case 1: 
			handler.addAccount(choice);
			break;
		case 2:  
			handler.depositMoney();
			break;
		case 3: 
			handler.withdrawMoney();
			break;
		case 4: handler.showAllData();
			break;
		case 5: handler.deleteAccount();
			break;
		case 6:
			System.out.println("프로그램 종료되었습니다.");
			return;
		default: System.out.println("범위에 맞지 않는숫자");
		}
	}//try 끝
	catch(InputMismatchException e) {
			scan.nextLine();
			System.out.println("타입안맞음");
	}
	}//while 끝
}//메인끝

}//AccountManager클래스  끝
//핸들러시작
class AccountInfoHandler{
	//멤버변수	
	/* 상속관계에서 부모클래스로 인스턴스 배열을 생성한다. 부모로
	자식을 참조할 수 있으므로, 부모타입의 배열에는 자식타입의 인스
	턴스를 저장할 수 있다. */
	/*인스턴스에 저장한거 컬렉션으로 변경*/
	//private Account[] myAccounts;
	HashSet<Account> myAccounts = new HashSet<Account>();
	
	/* 배열에 저장된 연락처 정보를 카운트하기 위한 멤버변수.
	추가할때마다 ++연산자로 1씩 증가한다. */
	
	/*자동인덱싱이 되므로 크기 필요없다 매개변수도 필요없다.*/
	//private int numOfAccounts;
	//생성자 : 인스턴스 배열의 크기를 인수로 받은 후 초기화한다.
	//public AccountInfoHandler(int num)
	public AccountInfoHandler () {
		//System.out.println("생성자 호출됨");
		//정보를 저장할 인스턴스 배열을 생성한다.
		//myAccounts = new Account[num];	
		//배열의 인덱스는 0부터 시작이므로 이와같이 초기화한다.
		//numOfAccounts = 0;
		//myAccounts = new ArrayList<Account>();
	}
	//여기서 부터 함수 만들기
	// 계좌추가
	//여기서 입금 예외처리 한번 해보자~
	public void addAccount(int choice)  {
		
		//여기서 2개로 나눠야 된다.
		Scanner scan = new Scanner(System.in);
		String accountNumber; String name; int balance; double normalRate;
		double extraRate; String creditRating;
		System.out.println("##신규계좌계설 계좌선택하세요##");
		System.out.println("1.보통계좌");
		System.out.println("2.신용계좌");
		 choice = scan.nextInt();
		//일반계좌
		if(choice == 1) {
		scan.nextLine();
		System.out.println("##일반신규계좌계설 ##");
		System.out.print("계좌번호:");accountNumber = scan.nextLine();
		System.out.print("이름:");name = scan.nextLine();
		System.out.print("잔고:");balance = scan.nextInt();
		System.out.println("기본이자율(정수)"); normalRate = scan.nextDouble();
		Account account = new NormalAccount( accountNumber, name, balance,  normalRate);
		//계좌번호가 똑같을때
		if(account.getAccountNumber().equals(accountNumber)) {
			System.out.println("계좌번호가 중복됩니다.");
			myAccounts.remove(account);
			myAccounts.add(account);
		}
		
		//계좌번호가 다를때
		else{
			myAccounts.add(account);
		}
		
		System.out.println("계좌계설이 완료되었습니다.");
		
		
	
		} // 일반계좌끝
		if(choice ==2) {
			System.out.println("##신용신규계좌계설 ##");
			scan.nextLine();
			System.out.print("계좌번호:");accountNumber = scan.nextLine();
		
			System.out.print("이름:");name = scan.nextLine();
			System.out.print("잔고:");balance = scan.nextInt();
			System.out.println("기본이자율(정수)"); normalRate = scan.nextDouble();
			scan.nextLine();
			System.out.println("신용등급");   creditRating=scan.nextLine();
			// 이자율 계산
			System.out.println("신용등급에 따른 이자율");
			extraRate = scan.nextDouble();
			System.out.println("계좌개설 완료");
			
			//Account account = new HighCreditAccount(accountNumber,name,balance,normalRate,creditRating,extraRate);
			
			myAccounts.add( new HighCreditAccount(accountNumber,name,balance,normalRate,creditRating,extraRate));
		}// if 끝
		
		
		
		
	}//addAcount 함수 끝
	
	public void showAllData() {
		for(Account account : myAccounts) {
			account.showAllData();
		}
		System.out.println("==전체정보가 출력되었습니다==");
	} // showAllData 함수 끝
	//입금
	//여기서 예외처리 해보자
	public void depositMoney()  {
		Scanner scan = new Scanner(System.in);
		String accountNumber; String name; int money;
		System.out.println("계좌번호와 입금할 금액 입력하세요");
		try {
		accountNumber = scan.nextLine();
		money = scan.nextInt();
		if(money<0 || money%500!=0) {
			System.out.println("음수는 입력안됩니다. 500원 단위로 입력하세요");
		}
		else {
			//boolean isFind = false;
			//String searchAccount = scan.nextLine();//여기를 수정해야겠다.
			
			for(Account account : myAccounts) {
				
				if(account.getAccountNumber().equals(accountNumber)) {
					//System.out.println("계좌번호일치");
					account.plusBalance(money);
					
				}
				/*if(myAccounts.getAccountNumber().equals(accountNumber)) {
					myAccounts.plusBalance(money);
				}*/
			}//for 끝
		}
		
		}//try 끝
		catch(InputMismatchException e) {
			e.getStackTrace();
		}
	} //deposit 함수 끝
	//출금
	
	//출금 예외처리 if해보자
	public void withdrawMoney() {
		Scanner scan = new Scanner(System.in);
		String accountNumber; String name; int money;
		System.out.println("계좌번호와 출금할 금액 입력하세요");
		//출금에서 balance를 money로 바꾸자 햇갈리니까
		
		//입력 받는 곳에서 부터 try 써보자
		try {
		accountNumber = scan.nextLine();
		money = scan.nextInt();
		scan.nextLine();
		//여기서 if로 계좌잔고 보다 많은 금액 출금 못하게 해보자
		
		
		for(Account account : myAccounts) {
			//출금액이 더 많다면
			if(account.balance < money) {
				System.out.println("잔고가 부족해요 전액 출금?");
				System.out.println("Y:전액출금, N:이전으로돌아가기");
				//myAccounts[i].setBalance(0); //여기는 괜찮은데 String이 배열이 아니라 아웃오브 바운더리 에러남
				//String [] yesOrNo = new String[100];
				//yesOrNo = scan.nextLine();
				//String [] yesOrNo = new yesOrNo[1];
				String yesOrNo;
				yesOrNo = scan.nextLine();
				if(yesOrNo.charAt(0) == 'y' || yesOrNo.charAt(0) == 'Y') {
					account.setBalance(0);
					System.out.println("전액 출금되었습니다.");
				}
				else {
					continue;
				}
			}
			
			if(money %1000 !=0) {
				System.out.println("1000원단위로만 출금가능");
				continue;
			}
			
			else if(account.getAccountNumber().equals(accountNumber)) {
				account.minusBalance(money);
				}
			}//for문 끝
		
			}//try 끝
			catch(InputMismatchException e) {
				e.printStackTrace();
			}
			
		} //withdrawl 함수끝
	
		//삭제 함수
		public void deleteAccount() {
			System.out.println("삭제할 계좌번호을 입력하세요");
			Scanner scan = new Scanner(System.in);
			String deleteNum = scan.nextLine();
			Iterator<Account> itr = myAccounts.iterator(); //이터레이터 쓸수있게만듬
			Account account = itr.next();
			if(account.getAccountNumber().equals(deleteNum)) {
				myAccounts.remove(account);
				System.out.println("삭제되었습니다.");
			}
			
			
		}//삭제 함수 끝
	}//handler클래스 끝
	


/////////////////////////////////////////////////////////////////////////////
	//동일 계좌 찾기
	/* private static Account findAccount(String accountNumber) {
	        for (int i = 0 ; i <numOfAccounts; i++) {
	            if (myAccounts[i].accountNumber().equals(accountNumber)) {
	                return myAccounts[i];
	            }
	        }
	        System.out.println("해당 계좌번호를 찾을 수 없습니다.");
	        return null;
	    }*/
