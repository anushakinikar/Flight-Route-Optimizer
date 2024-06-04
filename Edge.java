package DSL_MiniProject;

class Edge extends Graph_Node{
	private Graph_Node src;                                              //source airport
	private Graph_Node dst;                                          //destination airport
	Flight f;
	private int src_layOver;
	private int time;                                             //cost of flight
	Edge next;
	
	Edge(){                                                          //default constructor
		this.src=null;
		this.dst=null;
		this.f=null;
		this.src_layOver=0;
		this.time=0;
		this.next=null;
	}
	
	Edge(Graph_Node src, Graph_Node dst,int layOver, int time, Flight f){            //parameterized constructor
		this.src=src;
		this.dst=dst;
		this.f=f;
		this.src_layOver=layOver;
		this.time=time;
		this.next=null;
	}
	
	Edge get_next() {
		return next;
	}
	
	Graph_Node get_src() {
		return src;
	}
	
	Graph_Node get_dst() {
		return dst;
	}
	
	int get_srcLayOver() {
		return src_layOver;
	}
	
	int get_time() {
		return time;
	}
	
	
	Flight get_flight() {
		return f;
	}
	
}
