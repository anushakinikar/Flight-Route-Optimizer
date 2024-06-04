package DSL_MiniProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Graph g = new Graph();
		g.create_graph();
		int exit=0;
		
		outerloop:
		
		do {
		
		System.out.println("\t\t\t\t\t\tWELCOME TO GTA AIRWAYS");
		System.out.println("\t\t\t\t\tOne stop place to book your flights!");
		System.out.println("\t\t\t\t\tPlease enter your details to signup");
		
		int flag=0;
		String email="";
		while(flag==0) {
			System.out.print("\nEnter your email: ");
			 email = sc.next();
			 	if((email.contains("@") && email.contains(".") )== false) {
			 		System.out.println("INVALID EMAIL ADDRESS! \nEmail Address should have '.' and '@' \nEnter valid email address");
			 	}
			 	else {
			 		flag=1;;
			 	}
			 	
		}
		
		sc.nextLine();
		flag=0;
		String password="";
		while(flag==0) {
			System.out.print("Enter your password: ");
			 password = sc.nextLine();
			 	if(password.length() < 8) {
			 		System.out.println("INVALID PASSWORD! Password should have minimum 8 characters\n");
			 	}
			 	else {
			 		flag=1;
			 	}
		}
			 


			 System.out.print("Enter your name: ");
			 String name = sc.nextLine();
			 
			 System.out.print("Enter your age: ");
			 int age = sc.nextInt();
			 
			 System.out.print("Enter your gender: ");
			 String gender = sc.next();
			 
			 
			 System.out.println("\n!!!!LOGIN SUCCESSFUL!!!!");
			 Passenger pg = new Passenger(email, password, name, age,  gender);
			 MyHash mh = new MyHash();
			 mh.create(pg);
			 
			
			 int w = 1;
			 while(w == 1) {
			 
			 System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^MENU^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			 //System.out.println("\t\t\t\t\t\t\tMENU");
			 System.out.print("1. Book Tickets\n2. Display Tickets\n3. Cancel Tickets\n4. Delete Account\n5. Exit\nPlease enter your choice: ");
			 int choice = sc.nextInt();
			 System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			 switch(choice) {
			 case 1: //book
				 pg.book_Ticket(pg,g);
				 break;
			 case 2: 
				 //display
				 pg.display_Ticket(pg);
				 break;
			 case 3: //cancel
				 pg.cancel_Ticket(pg);
				 break;
			 case 4:
				 sc.nextLine();
				 //System.out.println("Enter email id of the account to be deleted");
				 //String e = sc.nextLine();
				 System.out.println("Are you sure you want to delete? Enter 1 for YES; 0 for NO");
				 int d=sc.nextInt();
				 if(d==1) {
					 mh.deletePassenger(email);
					 continue outerloop;
				 }
				 else {
					 System.out.println("Account NOT deleted!");
				 }
				 break;
			 case 5:
				 exit=1;
				 System.exit(0);
				 break;
			 default: System.out.println("Invalid choice!");
			 break;
			 }
			  
			 }	
		}
		while(exit!=1);
	}
}

