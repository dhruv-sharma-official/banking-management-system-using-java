import java.util.ArrayList;
import java.util.Scanner;




public class main{ 

	public static void transferMoney(Scanner scanner, ArrayList<customer> customers){
		System.out.println("Transfer from Account no: ");
		long tfrom = scanner.nextLong();
		System.out.println("Transfer to Account no: ");
		long tto = scanner.nextLong();
////////////////////////////////////////////////////////////////////
		for (customer per : customers) {
			boolean fromfound = false;
			if (per.getAccno() == tfrom){
				fromfound = true;
			}
			if (fromfound){
				System.out.println("\nAccount balance: " + per.getAccbal()+"\n");
				System.out.println("Enter Amount: ");
				long amount = scanner.nextLong();
				if (amount <= per.accountbal) {
					per.accountbal = per.accountbal - amount;

					for (customer per2 : customers) {
						boolean tofound = false;
						if (per2.getAccno() == tto){
							tofound = true;
						}
						if (tofound){
							per2.accountbal = per2.accountbal + amount;
						} else {
							System.out.println("reciever's account not found");
						}
					}



				} else {
					System.out.println("Insufficient funds");
				}
				
			} else {
				System.out.println("sender's account not found");
			}
		}


			
	}

	public static void withdrawMoney(Scanner scanner, ArrayList<customer> customers) {
		System.out.println("Enter the Account Number: ");
		long ano = scanner.nextLong();
		for (customer per : customers) {
			boolean found = false;
			if (per.getAccno() == ano){
				found = true;
			}
			if (found){
				System.out.println("\nAccount balance: " + per.getAccbal()+"\n");
				System.out.println("Enter Amount: ");
				long amount = scanner.nextLong();
				if (amount <= per.accountbal) {
					per.accountbal = per.accountbal - amount;
				} else {
					System.out.println("Insufficient funds");
				}
				
			} else {
				System.out.println("no account found");
			}
		}
	}



	public static void addMoney(Scanner scanner, ArrayList<customer> customers) {
		System.out.println("Enter the Account Number: ");
		long ano = scanner.nextLong();
		boolean found;
		for (customer per : customers) {
			found = false;
			if (per.getAccno() == ano){
				found = true;
			}
			if (found){
				System.out.println("\nAccount balance: " + per.getAccbal()+"\n");
				System.out.println("Enter Amount: ");
				long amount = scanner.nextLong();
				per.accountbal = per.accountbal + amount;
				continue;
			} else {
				System.out.println("no account found");
			}
		}


	}

	public static void addAccount(Scanner scanner, ArrayList<customer> customers) {
		System.out.print("Adding New Account\n");
		System.out.print("Enter Account Holder Name:\n");
		String nam = scanner.next();
		
		
		System.out.println("\nEnter Contact Number:");
		long number = scanner.nextLong();
		scanner.nextLine();
		
		System.out.println("\nEnter age:");
		int age = scanner.nextInt();
		
		System.out.println("\nEnter Gender:");
		String gender = scanner.next();
		
		System.out.println("\nEnter Pan card no:");
		String pan = scanner.next();
		long accountno = number * 2;
		
		customer cust = new customer(nam, number, age, gender, accountno, pan, 0);
		customers.add(cust);
		System.out.println("\n#### customer added with following details ####\n\n" + 
				"Name: "+ cust.getName() + 
				"\nAge: "+ cust.getAge() + 
				"\nContact no: "+ cust.getcont() + 
				"\nGender: "+ cust.getGen() + 
				"\nPan card no: "+ cust.getpan() + 
				"\nAccount no: " + cust.getAccno() +
				"\nAccount balance: " + cust.getAccbal()+"\n");

	}
	public static void disdetailsAcc(Scanner scanner, ArrayList<customer> customers){
		System.out.println("Enter the Account Number: ");
			long ano = scanner.nextInt();
			for (customer per : customers) {
				boolean found = false;
				if (per.getAccno() == ano){
					found = true;
				}
				if (found){
					System.out.println("\nhere are the account details\n"+
					"Name: "+ per.getName() + 
					"\nAge: "+ per.getAge() + 
					"\nContact no: "+ per.getcont() + 
					"\nGender: "+ per.getGen() + 
					"\nPan card no: "+ per.getpan() + 
					"\nAccount no: " + per.getAccno() +
					"\nAccount balance: " + per.getAccbal()+"\n");
					continue;
				} else {
					System.out.println("no account found");
				}
			}
	}

	public static void disdetailsCont(Scanner scanner, ArrayList<customer> customers){
		System.out.println("Enter the Contact Number: ");
		long cno = scanner.nextLong();
		for (customer per : customers) {
			boolean found = false;
			if (per.number == cno){
				found = true;
			}
			if (found){
				System.out.println("\nhere are the account details\n"+
				"Name: "+ per.getName() + 
				"\nAge: "+ per.getAge() + 
				"\nContact no: "+ per.getcont() + 
				"\nGender: "+ per.getGen() + 
				"\nPan card no: "+ per.getpan() + 
				"\nAccount no: " + per.getAccno() +
				"\nAccount balance: " + per.getAccbal()+"\n");
				continue;
			} else {
				System.out.println("no account found");
			}
		}
	}
	



	public static void main(String[] args){
	ArrayList<customer> customers = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	int inp;
	int i = 0;
	boolean a = true;
	while (a){
		System.out.println("<============= Welcome to LK bank ==============>");
		System.out.println("1 -> Accounts \n2 -> Transactions \n0 -> Exit");
		inp = scanner.nextInt();
		
		if (inp == 0) {
			System.out.println("thank you for using LK bank");
			a = false;

		
		} else if (inp == 1) {
			System.out.println("1 -> view account details \n2 -> add account \n3 -> delete account\n");
			inp = scanner.nextInt();
				if (inp == 0){
					continue;
				} else if (inp == 1){
					System.out.println("1 -> search by contact no \n2 -> search by account no \n0 -> exit\n");
					inp = scanner.nextInt();
					if (inp == 0){
						continue;
					} else if (inp == 1){
						disdetailsCont(scanner, customers);
					} else if (inp == 2) {
						disdetailsAcc(scanner, customers);
					} else {
						System.out.println("invalid input");
					}
				} else if (inp == 2) {
					addAccount(scanner, customers);
				} else if (inp == 3) {
					System.out.println("this feature will be introduced soon");
				}


			

		} else if (inp == 2) {
			System.out.println("1 -> add money \n2 -> withdraw money \n3 -> transfer money \n0 -> exit");
			inp = scanner.nextInt();
			if (inp == 0){
				continue;
			} else if (inp == 1) {
				addMoney(scanner, customers);	
			} else if (inp == 2) {
				withdrawMoney(scanner, customers);
			} else if (inp == 3) {
				transferMoney(scanner, customers);
			}

		} else {
			System.out.println("invalid input");
		}
		

	
	}

	
	}
}



// extra functions here ###################################################
class customer{
	String name;
	long number;
	int age;
	String gender;
	long accountno;
	String pan;
	long accountbal;
	
	ArrayList<customer> customers = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	
	customer(String name, long number, int age, String gender, long accountno, String pan, long accountbal){
		this.name = name;
		this.number = number;
		this.age = age;
		this.gender = gender;
		this.accountno = accountno;
		this.pan = pan;
		this.accountbal = accountbal;
	}
	
	/////////// getting methods ///////
	public String getName() {
        return name;
	}
	public int getAge() {
        return age;
	}
	public long getcont() {
	return number;
	}
	public String getGen() {
	return gender;
	}
	public long getAccno() {
	return accountno;
	}
	public String getpan() {
	return pan;
	}
	public long getAccbal() {
	return accountbal;
	}
	
}


/*
 ############ welcome to bank ##############
 1 Accounts
 	1 view account details
		1 search by account no
		2 search by contact no
		0 exit
	2 add account
	3 delete account
	0 exit

2 transaction
	1 transfer money
	2 add money
	3 withdraw money
	0 exit
 0 exit
 */