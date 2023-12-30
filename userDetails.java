package InfoBankDetails;

import java.util.Scanner;

public class userDetails {
	 private String userId;
	 private String userPin;
	 private static int transaction=0;
	 private static long balance=8000000L;
	 
	 public String getuserId() {
		 return userId;
	 }
	 public void setuserId(String userId) {
		 this.userId=userId;
	 }
	 public String getuserPin() {
		 return userPin;
	 }
	 public void setuserPin(String userPin) {
		 this.userId=userPin;
	 }

	public userDetails(String userId, String userPin) 
	{
		this.userId = userId;
		this.userPin = userPin;
	}

	public static void login()
	{
		System.out.println("Hey!Welcome to InfoBank.\nLogin to proceed!");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter userId");
		String userId = sc.nextLine();

		if (!userId.isEmpty()) 
		{ 
			System.out.println("Enter userPin");
			String userPin = sc.nextLine();

			if (!userPin.isEmpty()) 
			{ 
				System.out.println("Login done successfully!\n************************");
				choices();
				
			}
			else 
			{
				System.out.println("Enter valid details");
			}
		}
		else 
		{
			System.out.println("Enter valid details");
		}

	}
	private static void choices()
	{
		System.out.println("1.Transactions History\n2.Withdraw\n3.Deposit\n4.Transfer\n5.Quit");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:transDetails();
		break;
		case 2:withdraw();
		transDetails();
		break;
		case 3:deposit();
		transDetails();
		break;
		case 4:transfer();
		transDetails();
		break;
		case 5:quit();
		break;
		default:System.out.println("Invalid choice entered");
		}
	}
	private static void transDetails() 
	{
		if(transaction==0) 
		{
			System.out.println("No transaction done");
		}
		else
		{
			System.out.println(transaction+" time you have transfered");
		}
	}
	private static void withdraw()
	{
		System.out.println("Enter withdraw amount");
		Scanner sc=new Scanner(System.in);
		long amount=sc.nextLong();
		try {
			if(amount<=balance) {
				transaction++;
				balance=balance-amount;
				System.out.println("Withdraw Successfull");
				System.out.println("Your balance is "+balance);
			}
			else {
				System.out.println("Insufficient Balance");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void deposit() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your userId");
		String userId=sc.nextLine();
		System.out.println("Enter deposit amount");
		long amount=sc.nextLong();
		try 
		{
			if(amount<=balance) 
			{
				transaction++;
				balance=balance-amount;
				System.out.println("Amount deposited successfully");
				System.out.println("Your balance is "+balance);	
			}
			else 
			{
				System.out.println("Insufficient balance");
			}
		}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
	private static void transfer()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Receipent name");
		String recName=sc.nextLine();
		System.out.println("Enter amount to be trasnfered to "+recName);
		long amount=sc.nextLong();
		
			if(amount<=balance)
			{
				transaction++;
				balance=balance-amount;
				System.out.println(amount+" transfered successfully");
				System.out.println("Your balance is "+balance);
			}
			else {
				System.out.println("Insufficient balance");
			}	
	}
	private static void quit() {
		System.out.println("ThankYou!! Visit again:)");
	}
	}
	


