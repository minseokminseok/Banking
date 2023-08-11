package banking1;

import java.util.Scanner;


import banking1.Account;


public class BankingSystemMain {

	public static void showMenu() {
		System.out.println("1.계좌계설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램종료");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		AccountInfoHandler handler =
				new AccountInfoHandler(100);
		
		while(true) {
			showMenu();
		
		int choice = scan.nextInt();
		
		
		switch(choice) {
		
		
		case 1: 
			handler.addAccount();
			break;
		case 2:  
			handler.depositMoney();
			break;
		case 3: 
			handler.withdrawMoney();
			break;
		case 4: handler.showAllData();
			break;
		case 5:
			System.out.println("프로그램 종료되었습니다.");
			return;
		default: System.out.println("범위에 맞지 않는숫자");
		
		}
		
		
		
		
		}
		
		
		
	}

}


class AccountInfoHandler{
	
	//멤버변수	
		/* 상속관계에서 부모클래스로 인스턴스 배열을 생성한다. 부모로
		자식을 참조할 수 있으므로, 부모타입의 배열에는 자식타입의 인스
		턴스를 저장할 수 있다. */
		private Account[] myAccounts;
		/* 배열에 저장된 연락처 정보를 카운트하기 위한 멤버변수.
		추가할때마다 ++연산자로 1씩 증가한다. */
		private int numOfAccounts;
		
		//생성자 : 인스턴스 배열의 크기를 인수로 받은 후 초기화한다.
		public AccountInfoHandler(int num) {
			//System.out.println("생성자 호출됨");
			//정보를 저장할 인스턴스 배열을 생성한다.
			myAccounts = new Account[num];	
			//배열의 인덱스는 0부터 시작이므로 이와같이 초기화한다.
			numOfAccounts = 0;
		}
		
		//여기서 부터 함수 만들기
		// 계좌추가
		public void addAccount() {
			//여기서 2개로 나눠야 된다.
			
			Scanner scan = new Scanner(System.in);
			String accountNumber; String name; int balance; double normalRate;
			double extraRate; String creditRating;
			System.out.println("##신규계좌계설 계좌선택하세요##");
			System.out.println("1.보통계좌");
			System.out.println("2.신용계좌");
			int choice = scan.nextInt();
			
			if(choice == 1) {
			System.out.println("##일반신규계좌계설 ##");
			
			System.out.print("계좌번호:");accountNumber = scan.nextLine();
			scan.next();
			System.out.print("이름:");name = scan.nextLine();
			scan.next();
			System.out.print("잔고:");balance = scan.nextInt();
			System.out.println("기본이자율(정수)"); normalRate = scan.nextInt();
			System.out.println("계좌계설이 완료되었습니다.");
			
			Account account = new Account(accountNumber, name, balance);
			/* 참조변수를 인스턴스 배열에 추가한다. 인덱스로 사용
			된 변수의 초기값이 0이므로, 0번 인덱스에 추가한 뒤
			1증가시킨다. 이를 위해 '후위증가' 하고있다. */
			myAccounts[numOfAccounts++] = account;
			}
			if(choice ==2) {
				System.out.println("##신용신규계좌계설 ##");
				scan.next();
				System.out.print("계좌번호:");accountNumber = scan.nextLine();
				scan.next();
				System.out.print("이름:");name = scan.nextLine();
				System.out.print("잔고:");balance = scan.nextInt();
				System.out.println("기본이자율(정수)"); normalRate = scan.nextInt();
				System.out.println("신용등급");   creditRating=scan.nextLine();
				System.out.println("계좌개설 완료");
			}
		}
		public void showAllData() {
			
			for(int i=0 ; i<numOfAccounts ; i++) {
				myAccounts[i].showAllData();
			}
			System.out.println("==전체정보가 출력되었습니다==");
		}
		//입금
		public void depositMoney() {
			Scanner scan = new Scanner(System.in);
			String accountNumber; String name; int balance;
			System.out.println("계좌번호와 입금할 금액 입력하세요");
			
			accountNumber = scan.nextLine();
			balance = scan.nextInt();
			for(int i=0 ; i<numOfAccounts ; i++) {
				if(myAccounts[i].getAccountNumber().equals(accountNumber)) {
					myAccounts[i].plusBalance(balance);
				}
			}
		}
		
		//출금
		public void withdrawMoney() {
			Scanner scan = new Scanner(System.in);
			String accountNumber; String name; int balance;
			System.out.println("계좌번호와 입금할 금액 입력하세요");
			
			accountNumber = scan.nextLine();
			balance = scan.nextInt();
			for(int i=0 ; i<numOfAccounts ; i++) {
				if(myAccounts[i].getAccountNumber().equals(accountNumber)) {
					myAccounts[i].minusBalance(balance);
				}
			}
		}
		
		
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
		
}
