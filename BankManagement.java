import java.util.ArrayList;
import java.util.Scanner;

class customer {
	String name;
	long number;
	int age;
	String gender;
	long accountno;
	String pan;
	long accountbal;

	ArrayList<customer> customers = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);

	customer(String name, long number, int age, String gender, long accountno, String pan, long accountbal) {
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

class Employee {
	int id;
	String name;
	String postName;
	int age;
	static int idCounter = 1;

	// ArrayList Emp_data;

	Employee(String name, String postName, int age) {
		this.name = name;
		this.postName = postName;
		this.age = age;
		this.id = idCounter++;

	}

	// void display(){
	// System.out.println(name);
	// System.out.println(postName);
	// System.out.println(age);
	// }

}

public class BankManagement {

	public static void transferMoney(Scanner scanner, ArrayList<customer> customers) {
		System.out.println("Transfer from Account no: ");
		long tfrom = scanner.nextLong();
		System.out.println("Transfer to Account no: ");
		long tto = scanner.nextLong();
		////////////////////////////////////////////////////////////////////
		for (customer per : customers) {
			boolean fromfound = false;
			if (per.getAccno() == tfrom) {
				fromfound = true;
			}
			if (fromfound) {
				System.out.println("\nAccount balance: " + per.getAccbal() + "\n");
				System.out.println("Enter Amount: ");
				long amount = scanner.nextLong();
				if (amount <= per.accountbal) {
					per.accountbal = per.accountbal - amount;

					for (customer per2 : customers) {
						boolean tofound = false;
						if (per2.getAccno() == tto) {
							tofound = true;
						}
						if (tofound) {
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
			if (per.getAccno() == ano) {
				found = true;
			}
			if (found) {
				System.out.println("\nAccount balance: " + per.getAccbal() + "\n");
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
			if (per.getAccno() == ano) {
				found = true;
			}
			if (found) {
				System.out.println("\nAccount balance: " + per.getAccbal() + "\n");
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
				"Name: " + cust.getName() +
				"\nAge: " + cust.getAge() +
				"\nContact no: " + cust.getcont() +
				"\nGender: " + cust.getGen() +
				"\nPan card no: " + cust.getpan() +
				"\nAccount no: " + cust.getAccno() +
				"\nAccount balance: " + cust.getAccbal() + "\n");

	}

	public static void disdetailsAcc(Scanner scanner, ArrayList<customer> customers) {
		System.out.println("Enter the Account Number: ");
		long ano = scanner.nextLong();
		for (customer per : customers) {
			boolean found = false;
			if (per.getAccno() == ano) {
				found = true;
			}
			if (found) {
				System.out.println("\nhere are the account details\n" +
						"Name: " + per.getName() +
						"\nAge: " + per.getAge() +
						"\nContact no: " + per.getcont() +
						"\nGender: " + per.getGen() +
						"\nPan card no: " + per.getpan() +
						"\nAccount no: " + per.getAccno() +
						"\nAccount balance: " + per.getAccbal() + "\n");
				continue;
			} else {
				System.out.println("no account found");
			}
		}
	}

	public static void disdetailsCont(Scanner scanner, ArrayList<customer> customers) {
		System.out.println("Enter the Contact Number: ");
		long cno = scanner.nextLong();
		for (customer per : customers) {
			boolean found = false;
			if (per.number == cno) {
				found = true;
			}
			if (found) {
				System.out.println("\nhere are the account details\n" +
						"Name: " + per.getName() +
						"\nAge: " + per.getAge() +
						"\nContact no: " + per.getcont() +
						"\nGender: " + per.getGen() +
						"\nPan card no: " + per.getpan() +
						"\nAccount no: " + per.getAccno() +
						"\nAccount balance: " + per.getAccbal() + "\n");
				continue;
			} else {
				System.out.println("no account found");
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<customer> customers = new ArrayList<>();
		ArrayList<Employee> Emp = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int inp;

		while (true) {

			System.out.println("1 -> Add Employee");
			System.out.println("2 -> See All Employee Data");
			System.out.println("3 -> See Employee Data using ID ");
			System.out.println("4 -> Account ");
			System.out.println("5 -> Transaction ");
			System.out.println("0 -> Exit");
			inp = scanner.nextInt();
			switch (inp) {
				case 1:
					System.out.println("How many Employee you want to add ");
					int empCount = scanner.nextInt();
					for (int i = 0; i < empCount; i++) {
						System.out.println("Enter User " + (i + 1) + " Name :-");
						String name = scanner.next();
						System.out.println("Enter User " + (i + 1) + " Post :-");
						String post = scanner.next();
						System.out.println("Enter User " + (i + 1) + " Age :-");
						int age = scanner.nextInt();
						Employee obj = new Employee(name, post, age);
						Emp.add(obj);

					}
					break;
				case 2:
					for (Employee employee : Emp) {
						System.out.println("======================= ||  Name: " + employee.name + ", Post: "
								+ employee.postName + ", Age: "
								+ employee.age + ", ID: " + employee.id + " || ====================");

					}
					break;

				case 3:
					System.out.println("enter your id ");
					int idd = scanner.nextInt();
					for (Employee employee : Emp) {
						if (employee.id == idd) {
							System.out.println("======================= ||  Name: " + employee.name + ", Post: "
									+ employee.postName + ", Age: "
									+ employee.age + ", ID: " + employee.id + " || ====================");
						}

					}
					// System.out.println("You Enter Wrong Id !");
					break;

				case 4:
					System.out.println("1 -> view account details \n2 -> add account \n3 -> delete account\n");
					int inInput = scanner.nextInt();
					switch (inInput) {
						case 1:
							System.out.println("1 -> search by contact no \n2 -> search by account no \n0 -> exit\n");
							inp = scanner.nextInt();
							switch (inp) {
								case 1:
									disdetailsCont(scanner, customers);
									break;
								case 2:
									disdetailsAcc(scanner, customers);
								default:
									System.out.println("invalid input");
							}
							break;
						case 2:
							addAccount(scanner, customers);
							break;
						case 3:
							System.out.println("this feature will be introduced soon");
							break;
						default:
							System.out.println("invalid input");
					}
					break;

				case 5:
					System.out.println("1 -> add money \n2 -> withdraw money \n3 -> transfer money \n0 -> exit");
					inp = scanner.nextInt();
					switch (inp) {
						case 1:
							addMoney(scanner, customers);
							break;
						case 2:
							withdrawMoney(scanner, customers);
							break;

						case 3:
							transferMoney(scanner, customers);
							break;
						case 0:
							continue;
						default:
							System.out.println("Invalid input");
							break;
					}
				case 0:
					break;

				default:
					System.out.println("Choose Wrong number !!");
			}

			if (inp == 0) {
				break;
			}
		}

	}
}

// extra functions here ###################################################

/*
 * ############ welcome to bank ##############
 * 1 Accounts
 * 1 view account details
 * 1 search by account no
 * 2 search by contact no
 * 0 exit
 * 2 add account
 * 3 delete account
 * 0 exit
 * 
 * 2 transaction
 * 1 transfer money
 * 2 add money
 * 3 withdraw money
 * 0 exit
 * 0 exit
 */