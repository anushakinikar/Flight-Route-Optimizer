package DSL_MiniProject;

import java.util.Stack;

class Flight{
	
	private int seats;
	private int economy;
	private int business;
	private int firstClass;
	private double economy_price;
	private double business_price;
	private double first_price;
	private String src;
	private String dst;
	private String  d_time;
	private String a_time;
	private String flightNo;
	
	private FlightPassenger root;
	FlightPassenger parent;

	Flight(){
		this.seats=0;
		this.economy=0;
		this.business=0;
        this.firstClass=0;
		this.economy_price=0;
		this.business_price=0;
		this.first_price=0;
		this.src="";
		this.dst="";
		this.flightNo="";
		this.root=null;
	}

	

	Flight(int seats, int economy,int business, int firstClass, int economy_price, int business_price, int first_price, String src, String dst,String d_time, String a_time, String flightNo){

		this.seats=seats;
		this.economy=economy;
		this.business=business;
     	this.firstClass=firstClass;
		this.economy_price=economy_price;
		this.business_price=business_price;
		this.first_price=first_price;
		this.src="";
		this.dst="";
		this.d_time=d_time;
		this.a_time=a_time;
		this.flightNo=flightNo;
		this.root=null;
	}
	
	double get_economyPrice() {
		return economy_price;
	}
	
	double get_businessPrice() {
		return business_price;
	}
	
	double get_firstPrice() {
		return first_price;
	}
	
	double get_price(char seatType) {
	    if(seatType=='e') {
	    	return economy_price;
	    }
	    else if(seatType=='b') {
	    	return business_price;
	    }
	    else if(seatType=='f') {
	    	return first_price;
	    }
		return 0;
	}
	
	String get_flightNo() {
		return flightNo;
	}
	
	String get_atime() {
		return a_time;
	}
	
	String get_dtime() {
		return d_time;
	}

	boolean addPassenger(Passenger P,char seatType, int seatNos) {

		int flag=1;
		
		switch(seatType) {
		case 'e': 
			if(economy>=seatNos) {
				economy-=seatNos;
			}
			else {
				flag=0;
			}
		break;

		case 'b': 
			if(business>=seatNos) {
				business-=seatNos;
			}
			else {
				flag=0;
			}
		break;

		case 'f':
			if(firstClass>=seatNos) {
				firstClass-=seatNos;
			}
			else {
				flag=0;
			}
   	    break;
   	
		default: seats-=seatNos; 
		}

		if(flag==0) {
			return false;
		}

		FlightPassenger temp=new FlightPassenger(P,seatType,seatNos);

		if(root==null) {
			root=temp;  
		}
		else {
			FlightPassenger ptr=root;
			if(ptr!=null) {
				while(true) {
					if(ptr.get_flightPassenger().getEmail().compareTo(temp.get_flightPassenger().getEmail())==0){
 						 
 						 break;
 					 }
 					 else {
 						 if(ptr.get_flightPassenger().getEmail().compareTo(temp.get_flightPassenger().getEmail())>0) {

 							 if(ptr.get_lc()==null) {
 								 ptr.set_lc(temp);
 								 break;
 							 }
 							 else {
 								 ptr=ptr.get_lc();
 							 }
 					 }
 					 if(ptr.get_flightPassenger().getEmail().compareTo(temp.get_flightPassenger().getEmail())<0) { 

 							 if(ptr.get_rc()==null) {
 								 ptr.set_rc(temp);
 								 break;
 							 }
 							 else {
 								 ptr=ptr.get_rc();
 							 }
 					 	}
 					 }
				}
			}
		}
     return true;
	}

	
	void displayFlightPassengers(){

		if(root==null) {
			System.out.println("No flight bookings yet!");
			return;
		}
		
		Stack<FlightPassenger> stack=new Stack<>();
		FlightPassenger ptr=root;
		while(ptr!=null || !stack.isEmpty()) {
			while(ptr!=null) {
				stack.push(ptr);
				ptr=ptr.get_lc();
			}
			if(!stack.isEmpty()) {
				ptr=stack.pop();
				//System.out.print(ptr.get_flightPassenger().display_Tickets()+"\n"+ptr.get_seatType()+" "+ptr.getSeatNos());
			}
		}
	}
	

	FlightPassenger searchPassenger(Passenger P) {

		FlightPassenger ptr=root;
		parent=root;

	   	 while(ptr!=null) {
	   		 if(P.getEmail().compareTo(ptr.get_flightPassenger().getEmail())>0) {
	   			 parent=ptr;
	   			 ptr=ptr.get_rc();
	   		 }
	   		 else if(P.getEmail().compareTo(ptr.get_flightPassenger().getEmail())<0) {
	   			 parent=ptr;
	   			 ptr=ptr.get_lc();
	   		 }

	   		 else if(P.getEmail().compareTo(ptr.get_flightPassenger().getEmail())==0) {
	   			 return ptr;
	   		 }
	   	 }
	   	 return null;
	}

	

	void deletePassenger(Passenger P,char seatType, int seatNos) {

	    FlightPassenger ptr=searchPassenger(P);

		if(ptr==null) {
			System.out.println("User has no booked seats in this flight!");
			return;
		}
		
		if(ptr.get_lc()!=null && ptr.get_rc()!=null) {            //node deletion with both children present
 
			parent=ptr;
			FlightPassenger p=ptr.get_lc();                       //root node as well as non-root node
			while(p.get_rc()!=null) {
				parent=p;
 				p=p.get_rc();
			}
			
			ptr.set_flightPassenger(p.get_flightPassenger());
			ptr.set_seatType(p.get_seatType());
			ptr.setSeatNos(p.getSeatNos());

			if(parent!=ptr) {
				parent.set_rc(p.get_lc());
			}
			else {
				parent.set_lc(p.get_lc());
			}
		}

		if(parent!=null) {                                      //non root node deletion

			if(ptr.get_lc()==null && ptr.get_rc()==null) {
				if(ptr==parent.get_lc()) {
					parent.set_lc(null);
				}
				if(ptr==parent.get_rc()) {
					parent.set_rc(null);
				}
			}
			else if(ptr.get_lc()!=null && ptr.get_rc()==null) {

				if(ptr==parent.get_lc()) {
					parent.set_lc(ptr.get_lc());
				}
				if(ptr==parent.get_rc()) {
					parent.set_rc(ptr.get_lc());
				}
			}

			else if(ptr.get_lc()==null && ptr.get_rc()!=null) {
				
				if(ptr==parent.get_lc()) {
					if(ptr==parent.get_lc()) {
						parent.set_lc(ptr.get_rc());
					}
					if(ptr==parent.get_rc()) {
						parent.set_rc(ptr.get_rc());
					}
				}
			}
		}

		if(parent==null) {                                          //root node deletion

			if(ptr.get_lc()==null && ptr.get_rc()==null) {
	   			 root=null;
	   		 }

	   		 else if(ptr.get_lc()!=null && ptr.get_rc()==null) {
	   			 root=root.get_lc();
	   		 }

	   		 else if(ptr.get_lc()==null && ptr.get_rc()!=null){
	   			 root=root.get_rc();
	   		 }
		}

		switch(seatType) {
		
		case 'e': economy+=seatNos;
		break;
		case 'b': business+=seatNos;
		break;
		case 'f':firstClass+=seatNos;
     	break;
		default: seats+=seatNos; 
        break;
		
		}
	}
}
