import java.util.Scanner;
import java.util.ArrayList;




public class main{

	public void addaccount(){
		System.out.print("Adding New Account\n");
			System.out.print("Enter Account Holder Name:\n");
			String nam = "Druc";
			
			
			System.out.println("\nEnter Contact Number:");
			int number = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("\nEnter age:");
			int age = scanner.nextInt();

			
			System.out.println("\nEnter Gender:");
			String gender = scanner.nextLine();

			
			System.out.println("\nEnter Pan card no:");
			String pan = scanner.nextLine();
			int accountno = number * 2;
			
			customer cust = new customer(nam, number, age, gender, accountno, pan, 0);
			customers.add(cust);
			for (customer person : customers) {
				System.out.println(person.getName() + " "+ person.getAge());

			}
			System.out.println("\n#### customer added with following details ####\n\n" + 
					"Name: "+ cust.getName() + 
					"\nAge: "+ cust.getAge() + 
					"\nContact no: "+ cust.getcont() + 
					"\nGender: "+ cust.getGen() + 
					"\nPan card no: "+ cust.getpan() + 
					"\nAccount no: " + cust.getAccno() +
					"\nAccount balance: " + cust.getAccbal()+"\n");
			

	
	}

	public static void main(String[] args){
	ArrayList<customer> customers = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	int inp;
	int i = 0;
	boolean a = true;
	while (a){
		System.out.println("<============= Welcome to LK bank ==============>");
		System.out.println("1 ->Add Account \n2 -> View Account details \n0 -> Exit");
		inp = scanner.nextInt();
		
		if (inp == 0) {
			System.out.println("thank you for using Bank mgmt system");
			a = false;
		} else if (inp == 1) {
			addaccount();
		} else if (inp == 2) {
			System.out.println("Enter the Account Number: ");
			int ano = scanner.nextInt();
			boolean found = false;
			for (customer per : customers) {
				if (per.getAccno() == ano){
					found = true;
				}
				if (found){
					System.out.println("\nhere are the account details\n" + 
					"Name: "+ per.getName() + 
					"\nAge: "+ per.getAge() + 
					"\nContact no: "+ per.getcont() + 
					"\nGender: "+ per.getGen() + 
					"\nPan card no: "+ per.getpan() + 
					"\nAccount no: " + per.getAccno() +
					"\nAccount balance: " + per.getAccbal()+"\n");
				} else {
					System.out.println("no account found");
				}
					

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
	int number;
	int age;
	String gender;
	int accountno;
	String pan;
	int accountbal;
	
	ArrayList<customer> customers = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	
	customer(String name, int number, int age, String gender, int accountno, String pan, int accountbal){
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
	public int getcont() {
	return number;
	}
	public String getGen() {
	return gender;
	}
	public int getAccno() {
	return accountno;
	}
	public String getpan() {
	return pan;
	}
	public int getAccbal() {
	return accountbal;
	}
	
}