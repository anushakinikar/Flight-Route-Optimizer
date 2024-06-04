package DSL_MiniProject;

class Graph_Node {
	private String airport;                                   //airport name
	private int index;                                        //index number associated with each airport
	Graph_Node next;                                  //linking variable
	
	Graph_Node(){                                             //default constructor
		this.airport="";
		this.index=0;
		this.next=null;
	}
	
	Graph_Node(String airport, int index){                    //parameterized constructor to initialize airports
		this.airport=airport;
		this.index=index;
		this.next=null;
	}
	
	String get_airport() {
		return airport;
	}
	
	int get_index() {
		return index;
	}
}