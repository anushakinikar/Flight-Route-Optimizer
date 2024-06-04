package DSL_MiniProject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Passenger{
	Scanner sc = new Scanner(System.in);
	 private String email;
	 private String password;
	 private String name;
	 private int age;
	 private String gender;
	 private Stack<String> history;
	 
	 Passenger(String email, String password, String name, int age, String gender){
		 this.email = email;
		 this.password = password;
		 this.name = name;
		 this.age = age;
		 this.gender = gender;
		 this.history = history;
	 }
	 Passenger(String name, int age, String gender){
		 this.name = name;
		 this.age = age;
		 this.gender = gender;
	 }
	 
	 Graph_Node src, dst;
	 ArrayList<Edge>  ar;
	 ArrayList<ArrayList<Edge>>  arr;
	 ArrayList<Edge> choice;
	 ArrayList<Flight> flights=new ArrayList<>();
	 int number_seats;
	 int flight_date_pref;
	char seat_pref; 
	 
	public void book_Ticket(Passenger pg, Graph g){
		
		System.out.println("\nDeparting Airports:");
		System.out.println();
		System.out.println("1. Chhatrapati Shivaji Maharaj International Aiport - BOM (Mumbai)");
		System.out.println("2. Chennai International Airport - MAA (Chennai)");
		System.out.println("3. Indira Gandhi International Airport - DEL (Delhi)");
		System.out.println();
		System.out.print("Enter your departing airport: ");
		int dept_choice = sc.nextInt();
		int arrival_choice=0;
		System.out.println("\nEnter your choice\n");
		System.out.println("1. Domestic Travel ");
		System.out.println("2. International Travel");
		int travel_type = sc.nextInt();
		
		
		
		//Domestic trips
		if(travel_type == 1) { 
			
			
			if(dept_choice == 1) { //domestic from mumbai
				
				src = g.getHead(1);
				
			System.out.println("\nDestinations: \n");
			System.out.println("1. Indira Gandhi International Airport - DEL (Delhi)\r\n"
				+ "2. Chennai International Airport - MAA (Chennai)\r\n");
				
			System.out.print("Enter your destination: ");
			arrival_choice = sc.nextInt();
			
			if(arrival_choice==1) {
				dst=g.getHead(0);
			}
			else if(arrival_choice==2) {
				dst=g.getHead(7);
			}
			else {
				System.out.println("Invalid choice");
				dst=null;
			}
			
			ar = g.leastTime(src.get_index(), dst.get_index());
			arr = g.allPaths(src.get_airport(), dst.get_airport());
		
			flight_date_pref = flight_date();
			seat_pref = flight_seat_pref();
			
			System.out.println("Please enter number of seats");
			number_seats = sc.nextInt();
			if(number_seats > 4) {
				System.out.println("You can only book maximum of 4 seats");
			}
			
			int route_choice;
			do {
			System.out.println("Enter your choice");
			System.out.println("1. Minimal time route");
			System.out.println("2. Minimal cost route");
			System.out.println("3. Display all routes possible");
			System.out.println("4. Exit");
			route_choice = sc.nextInt();
			
			
			if(route_choice == 1) {
				ar = g.leastTime(src.get_index(), dst.get_index());
				choice=ar;
				int time=0;
				double price=0;
				System.out.print("Path: "+ar.get(0).get_src().get_airport()+"-->");
				for(int i=0;i<ar.size();i++) {
					Flight f_obj=ar.get(i).get_flight();
					System.out.print(ar.get(i).get_dst().get_airport()+"-->");
					price+=ar.get(i).get_flight().get_price(seat_pref);
					time+=ar.get(i).get_time()+ar.get(i).get_srcLayOver();
					flights.add(f_obj);
				}
				System.out.print("end");
				int q=time/60;
				int r=time%60;
				System.out.println("\nPrice: "+price);
				System.out.println("Time: "+q+"h "+r+"m");
				
                System.out.println("\nDo you wish to book this flight? Enter 1 for YES; 0 for NO");
				
				if(sc.nextInt()==1) {
					choice=ar;
					System.out.println("\nBOOKED SUCCESSFULLY!");
					break;
				}
				
				for(int i=0;i<flights.size();i++) {
					flights.set(i,null);
				}
				}
			else if(route_choice == 2) {
				ar = g.leastPrice(src.get_index(), dst.get_index(),seat_pref);
				choice=ar;
				int time=0;
				double price=0;
				System.out.print("Path: "+ar.get(0).get_src().get_airport()+"-->");
				for(int i=0;i<ar.size();i++) {
					Flight f_obj=ar.get(i).get_flight();
					System.out.print(ar.get(i).get_dst().get_airport()+"-->");
					price+=ar.get(i).get_flight().get_price(seat_pref);
					time+=ar.get(i).get_time()+ar.get(i).get_srcLayOver();
					flights.add(f_obj);
				}
				System.out.print("end");
				int q=time/60;
				int r=time%60;
				System.out.println("\nPrice: "+price);
				System.out.println("Time: "+q+"h "+r+"m");
				System.out.println("\nDo you wish to book this flight? Enter 1 for YES; 0 for NO");
				
				if(sc.nextInt()==1) {
					choice=ar;
					System.out.println("\nBOOKED SUCCESSFULLY!");
					break;
				}
				for(int i=0;i<flights.size();i++) {
					flights.set(i,null);
				}
				
			}
			else if(route_choice==3) {
				arr = g.allPaths(src.get_airport(), dst.get_airport());
			    int count=0;
				
			    for (int i = 0; i < arr.size(); i++) {
			        System.out.println((i + 1) + ". Option " + (i + 1) + ": \n");

			        int time = 0;
			        double price = 0;
			        System.out.print("  Path: ");
			        for (int j = 0; j < arr.get(i).size(); j++) { // Use 'j' as the loop variable here
			            Flight f_obj = arr.get(i).get(j).get_flight();
			            if (j == 0) {
			                System.out.print(arr.get(i).get(0).get_src().get_airport() + "-->");
			            }
			            System.out.print(arr.get(i).get(j).get_dst().get_airport() + "-->");
			            price += arr.get(i).get(j).get_flight().get_price(seat_pref);
			            time += arr.get(i).get(j).get_time() + arr.get(i).get(j).get_srcLayOver();
			            flights.add(f_obj);
			        }
			        System.out.print("end");
			        int q = time / 60;
			        int r = time % 60;
			        System.out.println("\n  Price: " + price);
			        System.out.println("  Time: " + q + "h " + r + "m\n");
			    }

				System.out.println("\nEnter choice: (Enter 0 if you dont want to book any!)");
				int c=sc.nextInt();
				
				if(c!=0 && c<=arr.size()) {
				choice=arr.get(c-1);
				System.out.println("\nBOOKED SUCCESSFULLY!");
				break;
				}
				
				for(int i=0;i<flights.size();i++) {
					flights.set(i,null);
				}
			}
			
			else {
				System.out.println("Invalid choice!");
			}
			}
			while(route_choice!=4);
			
			//String historyy = history_details(travel_type,flight_date_pref,dept_choice,arrival_choice);
			//history.push(historyy);
			
			
			
			}
			if(dept_choice == 2) { 
				src = g.getHead(7);
				
				//domestic from chennai
				System.out.println("\nDestinations: \n");
				System.out.println("1. Chhatrapati Shivaji Maharaj International Aiport - BOM (Mumbai)\r\n"
					+ "2. Indira Gandhi International Airport - DEL (Delhi)\r\n");
					
				System.out.println("Enter your destination");
				arrival_choice = sc.nextInt();
				
				if(arrival_choice==1) {
					dst=g.getHead(1);
				}
				else if(arrival_choice==2) {
					dst=g.getHead(0);
				}
				else {
					System.out.println("Invalid choice!");
					dst=null;
				}
				ar = g.leastTime(src.get_index(), dst.get_index());
				arr = g.allPaths(src.get_airport(), dst.get_airport());
				
				flight_date_pref = flight_date();
				seat_pref = flight_seat_pref();
				
				System.out.println("Please enter number of seats");
				number_seats = sc.nextInt();
				if(number_seats > 4) {
					System.out.println("You can only book maximum of 4 seats");
				}
				
				int route_choice;
				do {
				System.out.println("Enter your choice");
				System.out.println("1. Minimal time route");
				System.out.println("2. Minimal cost route");
				System.out.println("3. Display all routes possible");
				System.out.println("4. Exit");
				route_choice = sc.nextInt();
				
				
				if(route_choice == 1) {
					ar = g.leastTime(src.get_index(), dst.get_index());
					choice=ar;
					int time=0;
					double price=0;
					System.out.print("Path: "+ar.get(0).get_src().get_airport()+"-->");
					for(int i=0;i<ar.size();i++) {
						Flight f_obj=ar.get(i).get_flight();
						System.out.print(ar.get(i).get_dst().get_airport()+"-->");
						price+=ar.get(i).get_flight().get_price(seat_pref);
						time+=ar.get(i).get_time()+ar.get(i).get_srcLayOver();
						flights.add(f_obj);
					}
					System.out.print("end");
					int q=time/60;
					int r=time%60;
					System.out.println("\nPrice: "+price);
					System.out.println("Time: "+q+"h "+r+"m");
					
	                System.out.println("\nDo you wish to book this flight? Enter 1 for YES; 0 for NO");
					
					if(sc.nextInt()==1) {
						choice=ar;
						System.out.println("\nBOOKED SUCCESSFULLY!");
						break;
					}
					for(int i=0;i<flights.size();i++) {
						flights.set(i,null);
					}
					}
				else if(route_choice == 2) {
					ar = g.leastPrice(src.get_index(), dst.get_index(),seat_pref);
					choice=ar;
					int time=0;
					double price=0;
					System.out.print("Path: "+ar.get(0).get_src().get_airport()+"-->");
					for(int i=0;i<ar.size();i++) {
						Flight f_obj=ar.get(i).get_flight();
						System.out.print(ar.get(i).get_dst().get_airport()+"-->");
						price+=ar.get(i).get_flight().get_price(seat_pref);
						time+=ar.get(i).get_time()+ar.get(i).get_srcLayOver();
						flights.add(f_obj);
					}
					System.out.print("end");
					int q=time/60;
					int r=time%60;
					System.out.println("\nPrice: "+price);
					System.out.println("Time: "+q+"h "+r+"m");
					System.out.println("\nDo you wish to book this flight? Enter 1 for YES; 0 for NO");
					
					if(sc.nextInt()==1) {
						choice=ar;
						System.out.println("\nBOOKED SUCCESSFULLY!");
						break;
					}
					for(int i=0;i<flights.size();i++) {
						flights.set(i,null);
					}
					
				}
				else if(route_choice==3) {

					arr = g.allPaths(src.get_airport(), dst.get_airport());
				    int count=0;
					
				    for (int i = 0; i < arr.size(); i++) {
				        System.out.println((i + 1) + ". Option " + (i + 1) + ": \n");

				        int time = 0;
				        double price = 0;
				        System.out.print("  Path: ");
				        for (int j = 0; j < arr.get(i).size(); j++) { // Use 'j' as the loop variable here
				            Flight f_obj = arr.get(i).get(j).get_flight();
				            if (j == 0) {
				                System.out.print(arr.get(i).get(0).get_src().get_airport() + "-->");
				            }
				            System.out.print(arr.get(i).get(j).get_dst().get_airport() + "-->");
				            price += arr.get(i).get(j).get_flight().get_price(seat_pref);
				            time += arr.get(i).get(j).get_time() + arr.get(i).get(j).get_srcLayOver();
				            flights.add(f_obj);
				        }
				        System.out.print("end");
				        int q = time / 60;
				        int r = time % 60;
				        System.out.println("\n  Price: " + price);
				        System.out.println("  Time: " + q + "h " + r + "m\n");
				    }

					System.out.println("\nEnter choice: (Enter 0 if you dont want to book any!)");
					int c=sc.nextInt();
					
					if(c!=0 && c<=arr.size()) {
					choice=arr.get(c-1);
					System.out.println("\nBOOKED SUCCESSFULLY!");
					break;
					}
					for(int i=0;i<flights.size();i++) {
						flights.set(i,null);
					}
				}
				
				else {
					System.out.println("Invalid choice!");
				}
				}
				while(route_choice!=4);
				
				//String historyy = history_details(travel_type,flight_date_pref,dept_choice,arrival_choice);
				//history.push(historyy);
			}			
			
			if(dept_choice == 3) {   //domestic from delhi
				src = g.getHead(0);
				
				System.out.println("\nDestinations: \n");
				System.out.println("1. Chhatrapati Shivaji Maharaj International Aiport- BOM (Mumbai)\r\n"
					+ "2. Chennai International Airport -MAA (Chennai)\r\n");
					
				System.out.print("Enter your destination: ");
				arrival_choice = sc.nextInt();
				
				if(arrival_choice==1) {
					dst=g.getHead(1);
				}
				else if(arrival_choice==2) {
					dst=g.getHead(7);
				}
				else {
					System.out.println("Invalid choice!");
					dst=null;
				}
				ar = g.leastTime(src.get_index(), dst.get_index());
				arr = g.allPaths(src.get_airport(), dst.get_airport());
				
				flight_date_pref = flight_date();
			    seat_pref = flight_seat_pref();
				
				System.out.println("Please enter number of seats");
				number_seats = sc.nextInt();
				
				int route_choice;
				do {
				System.out.println("Enter your choice");
				System.out.println("1. Minimal time route");
				System.out.println("2. Minimal cost route");
				System.out.println("3. Display all routes possible");
				System.out.println("4. Exit");
				route_choice = sc.nextInt();
				
				
				if(route_choice == 1) {
					ar = g.leastTime(src.get_index(), dst.get_index());
					choice=ar;
					int time=0;
					double price=0;
					System.out.print("Path: "+ar.get(0).get_src().get_airport()+"-->");
					for(int i=0;i<ar.size();i++) {
						Flight f_obj=ar.get(i).get_flight();
						System.out.print(ar.get(i).get_dst().get_airport()+"-->");
						price+=ar.get(i).get_flight().get_price(seat_pref);
						time+=ar.get(i).get_time()+ar.get(i).get_srcLayOver();
						flights.add(f_obj);
					}
					System.out.print("end");
					int q=time/60;
					int r=time%60;
					System.out.println("\nPrice: "+price);
					System.out.println("Time: "+q+"h "+r+"m");
					
	                System.out.println("\nDo you wish to book this flight? Enter 1 for YES; 0 for NO");
					
					if(sc.nextInt()==1) {
						choice=ar;
						System.out.println("\nBOOKED SUCCESSFULLY!");
						break;
					}
					for(int i=0;i<flights.size();i++) {
						flights.set(i,null);
					}
					}
				else if(route_choice == 2) {
					ar = g.leastPrice(src.get_index(), dst.get_index(),seat_pref);
					choice=ar;
					int time=0;
					double price=0;
					System.out.print("Path: "+ar.get(0).get_src().get_airport()+"-->");
					for(int i=0;i<ar.size();i++) {
						Flight f_obj=ar.get(i).get_flight();
						System.out.print(ar.get(i).get_dst().get_airport()+"-->");
						price+=ar.get(i).get_flight().get_price(seat_pref);
						time+=ar.get(i).get_time()+ar.get(i).get_srcLayOver();
						flights.add(f_obj);
					}
					System.out.print("end");
					int q=time/60;
					int r=time%60;
					System.out.println("\nPrice: "+price);
					System.out.println("Time: "+q+"h "+r+"m");
					System.out.println("\nDo you wish to book this flight? Enter 1 for YES; 0 for NO");
					
					if(sc.nextInt()==1) {
						choice=ar;
						System.out.println("\nBOOKED SUCCESSFULLY!");
						break;
					}
					for(int i=0;i<flights.size();i++) {
						flights.set(i,null);
					}
					
				}
				else if(route_choice==3) { //main

					arr = g.allPaths(src.get_airport(), dst.get_airport());
				    int count=0;
					
				    for (int i = 0; i < arr.size(); i++) {
				        System.out.println((i + 1) + ". Option " + (i + 1) + ": \n");

				        int time = 0;
				        double price = 0;
				        System.out.print("  Path: ");
				        for (int j = 0; j < arr.get(i).size(); j++) { // Use 'j' as the loop variable here
				            Flight f_obj = arr.get(i).get(j).get_flight();
				            if (j == 0) {
				                System.out.print(arr.get(i).get(0).get_src().get_airport() + "-->");
				            }
				            System.out.print(arr.get(i).get(j).get_dst().get_airport() + "-->");
				            price += arr.get(i).get(j).get_flight().get_price(seat_pref);
				            time += arr.get(i).get(j).get_time() + arr.get(i).get(j).get_srcLayOver();
				            flights.add(f_obj);
				        }
				        System.out.print("end");
				        int q = time / 60;
				        int r = time % 60;
				        System.out.println("\n  Price: " + price);
				        System.out.println("  Time: " + q + "h " + r + "m\n");
				    }

					System.out.println("\nEnter choice: (Enter 0 if you dont want to book any!)");
					int c=sc.nextInt();
					
					if(c!=0 && c<=arr.size()) {
					choice=arr.get(c-1);
					System.out.println("\nBOOKED SUCCESSFULLY!");
					break;
					}
					for(int i=0;i<flights.size();i++) {
						flights.set(i,null);
					}
				}
				
				else {
					System.out.println("Invalid choice!");
				}
				}
				while(route_choice!=4);
				//String historyy = history_details(travel_type,flight_date_pref,dept_choice,arrival_choice);
				//history.push(historyy);
			}
		}
		
		
		
	
		//International trips
		else if(travel_type == 2) {
			System.out.println("\nDestinations: \n");
			System.out.println("1. John F Kennedy- JFK (New York)\r\n"
								+ "2. Zurich International Airport- ZRH (Zurich)\r\n"
								+ "3. Abu Dhabi Airport- AUH(Dubai)  \r\n"
								+ "4. Frankfurt International Airport- FRA (Frankfurt) \r\n"
								+ "5. Doha International Airport- DOH (Doha)\r\n"
								+ "6. Heathrow International Airport- LHR (London)\r\n");
								
			
			if(dept_choice==1) {
				src=g.getHead(1);
			}
			else if(dept_choice==2) {
				src=g.getHead(7);
			}
			else if(dept_choice==3) {
				src=g.getHead(0);
			}
			else {
				System.out.println("Invalid choice!");
				src=null;
			}
			
			System.out.print("Enter your destination: ");
			arrival_choice = sc.nextInt();
			
			switch(arrival_choice) {
			case 1: dst=g.getHead(4);
				break;
			case 2: dst=g.getHead(14);
				break;
			case 3: dst=g.getHead(5);
				break;
			case 4: dst=g.getHead(6);
				break;
			case 5: dst=g.getHead(2);
				break;
			case 6: dst=g.getHead(17);
				break;
			default: System.out.println("Invalid choice!");
			         dst=null;
			}
			
			ar = g.leastTime(src.get_index(), dst.get_index());
			arr = g.allPaths(src.get_airport(), dst.get_airport());
			
			flight_date_pref = flight_date();
			seat_pref = flight_seat_pref();
			
			int flag=0;
			while(flag==0) {
			System.out.println("\nPlease enter number of seats: ");
			number_seats = sc.nextInt();
			
				if(number_seats > 4) {
					System.out.println("You can only book maximum of 4 seats");
				}
				else {
					flag=1;
				}
			}
			
			
			int route_choice;
			do {
			System.out.println("Enter your choice");
			System.out.println("1. Minimal time route");
			System.out.println("2. Minimal cost route");
			System.out.println("3. Display all routes possible");
			System.out.println("4. Exit");
			route_choice = sc.nextInt();
			
			
			if(route_choice == 1) {
				ar = g.leastTime(src.get_index(), dst.get_index());
				choice=ar;
				int time=0;
				double price=0;
				System.out.print("Path: "+ar.get(0).get_src().get_airport()+"-->");
				for(int i=0;i<ar.size();i++) {
					Flight f_obj=ar.get(i).get_flight();
					System.out.print(ar.get(i).get_dst().get_airport()+"-->");
					price+=ar.get(i).get_flight().get_price(seat_pref);
					time+=ar.get(i).get_time()+ar.get(i).get_srcLayOver();
					flights.add(f_obj);
				}
				System.out.print("end");
				int q=time/60;
				int r=time%60;
				System.out.println("\nPrice: "+price);
				System.out.println("Time: "+q+"h "+r+"m");
				
                System.out.println("\nDo you wish to book this flight? Enter 1 for YES; 0 for NO");
				
				if(sc.nextInt()==1) {
					choice=ar;
					System.out.println("\nBOOKED SUCCESSFULLY!");
					break;
				}
				for(int i=0;i<flights.size();i++) {
					flights.set(i,null);
				}
				}
			else if(route_choice == 2) {
				ar = g.leastPrice(src.get_index(), dst.get_index(),seat_pref);
				choice=ar;
				int time=0;
				double price=0;
				System.out.print("Path: "+ar.get(0).get_src().get_airport()+"-->");
				for(int i=0;i<ar.size();i++) {
					Flight f_obj=ar.get(i).get_flight();
					System.out.print(ar.get(i).get_dst().get_airport()+"-->");
					price+=ar.get(i).get_flight().get_price(seat_pref);
					time+=ar.get(i).get_time()+ar.get(i).get_srcLayOver();
					flights.add(f_obj);
				}
				System.out.print("end");
				int q=time/60;
				int r=time%60;
				System.out.println("\nPrice: "+price);
				System.out.println("Time: "+q+"h "+r+"m");
				System.out.println("\nDo you wish to book this flight? Enter 1 for YES; 0 for NO");
				
				if(sc.nextInt()==1) {
					choice=ar;
					System.out.println("\nBOOKED SUCCESSFULLY!");
					break;
				}
				for(int i=0;i<flights.size();i++) {
					flights.set(i,null);
				}
				
			}
			else if(route_choice==3) {

				arr = g.allPaths(src.get_airport(), dst.get_airport());
			    int count=0;
				
			    for (int i = 0; i < arr.size(); i++) {
			        System.out.println((i + 1) + ". Option " + (i + 1) + ": \n");

			        int time = 0;
			        double price = 0;
			        System.out.print("  Path: ");
			        for (int j = 0; j < arr.get(i).size(); j++) { // Use 'j' as the loop variable here
			            Flight f_obj = arr.get(i).get(j).get_flight();
			            if (j == 0) {
			                System.out.print(arr.get(i).get(0).get_src().get_airport() + "-->");
			            }
			            System.out.print(arr.get(i).get(j).get_dst().get_airport() + "-->");
			            price += arr.get(i).get(j).get_flight().get_price(seat_pref);
			            time += arr.get(i).get(j).get_time() + arr.get(i).get(j).get_srcLayOver();
			            flights.add(f_obj);
			        }
			        System.out.print("end");
			        int q = time / 60;
			        int r = time % 60;
			        System.out.println("\n  Price: " + price);
			        System.out.println("  Time: " + q + "h " + r + "m\n");
			    }

				System.out.println("\nEnter choice: (Enter 0 if you dont want to book any!)");
				int c=sc.nextInt();
				
				if(c!=0 && c<=arr.size()) {
				choice=arr.get(c-1);
				System.out.println("\nBOOKED SUCCESSFULLY!");
				break;
				}
				for(int i=0;i<flights.size();i++) {
					flights.set(i,null);
				}
			}
			
			else {
				System.out.println("Invalid choice!");
			}
			}
			while(route_choice!=4);
			//String historyy = history_details(travel_type,flight_date_pref,dept_choice,arrival_choice);
			//history.push(historyy);
		}  
		
		
	
	 }
	
	public String history_details(int travel_type, int flight_date_pref,int dept_choice,int arrival_choice ) {
		if(travel_type == 1) {
			if(dept_choice == 1 && arrival_choice == 1) {
				return "Date: " + flight_date_pref + "\nFrom Chhatrapati Shivaji Maharaj International Aiport- BOM (Mumbai) to Indira Gandhi International Airport- DEL (Delhi)";
			}
			else if(dept_choice == 1 && arrival_choice == 2) {
				return "Date: " + flight_date_pref + "\nFrom Chhatrapati Shivaji Maharaj International Aiport- BOM (Mumbai) to Chennai International Airport -MAA (Chennai)";
			}
			else if(dept_choice == 2 && arrival_choice == 1) {
				return "Date: " + flight_date_pref + "\nFrom Chennai International Airport -MAA (Chennai) to Chhatrapati Shivaji Maharaj International Aiport- BOM (Mumbai) ";
			}
			else if(dept_choice == 2 && arrival_choice == 2) {
				return "Date: " + flight_date_pref + "\nFrom Chennai International Airport -MAA (Chennai) to Indira Gandhi International Airport- DEL (Delhi)";
			}
			else if(dept_choice == 3 && arrival_choice == 1) {
				return "Date: " + flight_date_pref + "\nFrom Indira Gandhi International Airport- DEL (Delhi) to Chhatrapati Shivaji Maharaj International Aiport- BOM (Mumbai)";
			}
			else if(dept_choice == 3 && arrival_choice == 2) {
				return "Date: " + flight_date_pref + "\nFrom Indira Gandhi International Airport- DEL (Delhi) to Chennai International Airport -MAA (Chennai)";
			}
		}
		else if(travel_type == 2) {
			
			//International from Mumbai
			if(dept_choice == 1 && arrival_choice == 1) {
				return "Date: " + flight_date_pref + "\nFrom Chhatrapati Shivaji Maharaj International Aiport- BOM (Mumbai) to  John F Kennedy- JFK (New York)";
			}
			else if(dept_choice == 1 && arrival_choice == 2) {
				return "Date: " + flight_date_pref + "\nFrom Chhatrapati Shivaji Maharaj International Aiport- BOM (Mumbai) to Zurich International Airport- ZRH (Zurich)";
			}
			else if(dept_choice == 1 && arrival_choice == 3) {
				return "Date: " + flight_date_pref + "\nFrom Chhatrapati Shivaji Maharaj International Aiport- BOM (Mumbai) to Abu Dhabi Airport- AUH(Dubai)";
			}
			else if(dept_choice == 1 && arrival_choice == 4) {
				return "Date: " + flight_date_pref + "\nFrom Chhatrapati Shivaji Maharaj International Aiport- BOM (Mumbai) to Frankfurt International Airport- FRA (Frankfurt)";
			}
			else if(dept_choice == 1 && arrival_choice == 5) {
				return "Date: " + flight_date_pref + "\nFrom Chhatrapati Shivaji Maharaj International Aiport- BOM (Mumbai) to Doha International Airport- DOH (Doha)";
			}
			else if(dept_choice == 1 && arrival_choice == 6) {
				return "Date: " + flight_date_pref + "\nFrom Chhatrapati Shivaji Maharaj International Aiport- BOM (Mumbai) to Heathrow International Airport- LHR (London)";
			}
			
			
			
			
			//International from Chennai
			if(dept_choice == 1 && arrival_choice == 1) {
				return "Date: " + flight_date_pref + "\nFrom Chennai International Airport -MAA (Chennai) to  John F Kennedy- JFK (New York)";
			}
			else if(dept_choice == 1 && arrival_choice == 2) {
				return "Date: " + flight_date_pref + "\nFrom Chennai International Airport -MAA (Chennai) to Zurich International Airport- ZRH (Zurich)";
			}
			else if(dept_choice == 1 && arrival_choice == 3) {
				return "Date: " + flight_date_pref + "\nFrom Chennai International Airport -MAA (Chennai) to Abu Dhabi Airport- AUH(Dubai)";
			}
			else if(dept_choice == 1 && arrival_choice == 4) {
				return "Date: " + flight_date_pref + "\nFrom Chennai International Airport -MAA (Chennai) to Frankfurt International Airport- FRA (Frankfurt)";
			}
			else if(dept_choice == 1 && arrival_choice == 5) {
				return "Date: " + flight_date_pref + "\nFrom Chennai International Airport -MAA (Chennai) to Doha International Airport- DOH (Doha)";
			}
			else if(dept_choice == 1 && arrival_choice == 6) {
				return "Date: " + flight_date_pref + "\nFrom Chennai International Airport -MAA (Chennai) to Heathrow International Airport- LHR (London)";
			}
			
			
			
			
			//International from Delhi
			
			if(dept_choice == 1 && arrival_choice == 1) {
				return "Date: " + flight_date_pref + "\nIndira Gandhi International Airport- DEL (Delhi) to  John F Kennedy- JFK (New York)";
			}
			else if(dept_choice == 1 && arrival_choice == 2) {
				return "Date: " + flight_date_pref + "\nFrom Indira Gandhi International Airport- DEL (Delhi) to Zurich International Airport- ZRH (Zurich)";
			}
			else if(dept_choice == 1 && arrival_choice == 3) {
				return "Date: " + flight_date_pref + "\nFrom Indira Gandhi International Airport- DEL (Delhi) to Abu Dhabi Airport- AUH(Dubai)";
			}
			else if(dept_choice == 1 && arrival_choice == 4) {
				return "Date: " + flight_date_pref + "\nFrom Indira Gandhi International Airport- DEL (Delhi) to Frankfurt International Airport- FRA (Frankfurt)";
			}
			else if(dept_choice == 1 && arrival_choice == 5) {
				return "Date: " + flight_date_pref + "\nFrom Indira Gandhi International Airport- DEL (Delhi) to Doha International Airport- DOH (Doha)";
			}
			else if(dept_choice == 1 && arrival_choice == 6) {
				return "Date: " + flight_date_pref + "\nFrom Indira Gandhi International Airport- DEL (Delhi) to Heathrow International Airport- LHR (London)";
			}
			
			
			
			}
	
		
		return null;
	}
	public int flight_date() {
		
		System.out.println("             NOVEMBER 2023            ");
		System.out.println("SUN    MON   TUE   WED   THURS   FRI   SAT");
		System.out.println(" 12    13    14    15     16     17     18");
		System.out.println(" 19    20    21    22     23     24     25");
		System.out.println(" 26    27    28    29     30");
		System.out.print("\nEnter your preferred departure date: ");
		int dept_date_choice = sc.nextInt();
		return dept_date_choice;
	}
		//timing access from flight class
		
	
	public char flight_seat_pref() {
		System.out.println("\nSeat Preference\n");
		System.out.println("Enter your choice");
		System.out.println("1. Economy Class");
		System.out.println("2. Business Class");
		System.out.println("3. First Class");
		int seat_pref = sc.nextInt();
		if(seat_pref == 1) {
			return 'e';
		}
		else if(seat_pref == 2) {
			return 'b';
		}
		else if(seat_pref == 3) {
			return 'f';
		}
		return 0;
		
	}
	
	

	public void display_Ticket(Passenger pg){
		if(flights==null) {
			System.out.println("\nNO TICKETS TO BE DISPLAYED!");
			return;
		}
		
		for(int i=0;i<flights.size();i++) {
			Flight f_obj=flights.get(i);
			System.out.println(i);
			if(f_obj!=null) {
				f_obj.addPassenger(pg,seat_pref,number_seats);
			}
			
		}
		
		int flight_date_pref = flight_date();
		int total_time=0;
		double total_price=0;
		System.out.println("Your booked tickets are as follows: \n");
		System.out.println("**************************************************Ticket Information **************************************************");
        System.out.println("                                                     GTA Airlines");
        System.out.println("\nPassenger Name: " + name);
        System.out.println("Passenger age: "+age);
        //System.out.println("Destination: " + );
        
        System.out.println("\nDeparture Date: " + flight_date_pref+"th Nov 2023");
        System.out.println("\nNumber of Seats: "+number_seats);
        String seatType="";
        if (seat_pref=='e') {
        	seatType="Economy";
        }
        else if (seat_pref=='b') {
        	seatType="Business";
        }
        else if (seat_pref=='f') {
        	seatType="FirstClass";
        }
        System.out.println("Seat Type: "+seatType);
        
        System.out.println("\nFlights data: \n");
        for(int i=0;i<choice.size();i++){
        	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        	System.out.println("Flight "+(i+1));
        	System.out.println("  Flight number: "+choice.get(i).get_flight().get_flightNo());
        	System.out.println("  "+choice.get(i).get_src().get_airport()+" --> "+choice.get(i).get_dst().get_airport());
        	System.out.println("  Departure Time: "+choice.get(i).get_flight().get_dtime());
        	System.out.println("  Arrival Time: "+choice.get(i).get_flight().get_atime());
        	int t=choice.get(i).get_time();
        	total_time+=t;
        	int q=t/60;
        	int r=t%60;
        	System.out.println("  Time: "+q+"h "+r+"m");
        	int lt=choice.get(i).get_srcLayOver();
        	if(lt>0) {
        		int lq=lt/60;
        		int lr=lt%60;
        		System.out.println("  Layover: "+lq+"h "+lr+"m");
        	}
        	
        	System.out.println("  Price: "+(choice.get(i).get_flight().get_price(seat_pref))*number_seats);
        	total_price+=choice.get(i).get_flight().get_price(seat_pref);
        	
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        int q=total_time/60;
        int r=total_time%60;
        System.out.println("\nTotal time: "+q+"h "+r+"m");
        System.out.println("Total Price: "+total_price);
        
        System.out.println("*************************************************************************************************************************");
        //System.out.println("Ticket Price: Rs. " + ticketPrice);
	}

	public void cancel_Ticket(Passenger pg){
		for(int i=0;i<flights.size();i++) {
			Flight f_obj=flights.get(i);
					if(f_obj!=null) {
						f_obj.deletePassenger(pg, seat_pref, number_seats);
					}
			
		}
		System.out.println("DELETED SUCCESSFULLY!");
		flights=null;
	}

	public void view_history(){
		System.out.println("Your travel history is as follows");
		System.out.println(history);
		
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
}
