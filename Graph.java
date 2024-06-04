package DSL_MiniProject;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Graph {
	
	private int n;                                           //number of Graph_Nodes in the graph
	private int e;                                           //number of edges in the graph  
	private Graph_Node[] head;                               //array of Graph_Nodes to store all vertices
	
	public Graph_Node[] getHead() {
		return head;
	}

	public Graph_Node getHead(int i) {
		
		return head[i];
	}
	
	public Edge getEdgeTop(int i) {
		return top[i];
	}

	private Edge[] top;
	private int[] visited;  //to keep track of visited nodes
	
	
	
	Graph(){                                                 //constructor to initialise n, e, head, visited
		this.n=19;
		this.e=40;
		head=new Graph_Node[this.n];
		top=new Edge[this.n];
		visited=new int[n];
	}
	
	
	
	void create_graph() {
	       Graph_Node G0 = new Graph_Node("DEL", 0);
	       Graph_Node G1 = new Graph_Node("BOM", 1);
	       Graph_Node G2 = new Graph_Node("DOH", 2);
	       Graph_Node G3 = new Graph_Node("IST", 3);
	       Graph_Node G4 = new Graph_Node("JFK", 4);
	       Graph_Node G5 = new Graph_Node("AUH", 5);
	       Graph_Node G6 = new Graph_Node("FRA", 6);
	       Graph_Node G7 = new Graph_Node("MAA", 7);
	       Graph_Node G8 = new Graph_Node("LIN", 8);
	       Graph_Node G9 = new Graph_Node("BLR", 9);
	       Graph_Node G10 = new Graph_Node("CDG", 10);
	       Graph_Node G11 = new Graph_Node("AMS", 11);
	       Graph_Node G12 = new Graph_Node("SFO", 12);
	       Graph_Node G13 = new Graph_Node("MUC", 13);
	       Graph_Node G14 = new Graph_Node("ZRH", 14);
	       Graph_Node G15 = new Graph_Node("MCT", 15);
	       Graph_Node G16 = new Graph_Node("DXB", 16);
	       Graph_Node G17 = new Graph_Node("LHR", 17);
	       Graph_Node G18 = new Graph_Node("FCO", 18);


	       head[0] = G0;
	       head[1] = G1;
	       head[2] = G2;
	       head[3] = G3;
	       head[4] = G4;
	       head[5] = G5;
	       head[6] = G6;
	       head[7] = G7;
	       head[8] = G8;
	       head[9] = G9;
	       head[10] = G10;
	       head[11] = G11;
	       head[12] = G12;
	       head[13] = G13;
	       head[14] = G14;
	       head[15] = G15;
	       head[16] = G16;
	       head[17] = G17;
	       head[18] = G18;
		
		Flight F1=new Flight(450,15,35,400,5580,7580,10580,"DEL","BOM","18:20","20:45","GTA101");
		Flight F2=new Flight(850,50,250,550,12416,17416,28416,"DEL","DOH","21:55","02:05(+1)","GTA102");
		Flight F3=new Flight(850,50,250,550,9416,12416,16416,"BOM","IST","10:20","14:35","GTA103");
		Flight F4=new Flight(850,50,250,550,37416,42566,50435,"IST","JFK","16:45","18:55(+1)","GTA104");
		Flight F5=new Flight(850,50,250,550,12416,17416,28416,"DOH","JFK","8:45","15:20","GTA105");
		Flight F6=new Flight(850,50,250,550,9366,14986,20416,"BOM","AUH","16.30","06:50","GTA106");
		Flight F7=new Flight(850,50,250,550,13416,17865,26658,"AUH","FRA","11:20","06:50","GTA107");
		Flight F8=new Flight(850,50,250,550,51416,57746,68437,"DEL","JFK","02:20","07:35","GTA108");
		Flight F9=new Flight(450,15,35,400,5580,7580,10580,"DEL","MAA","17:30","20:15","GTA109");
		Flight F10=new Flight(850,50,250,550,18416,23658,30258,"DEL","FCO","03:15","12:45","GTA110");
		Flight F11=new Flight(850,50,250,550,5320,8230,15980,"FCO","LIN","17:45","16:40","GTA111");
		Flight F12=new Flight(850,50,250,550,12416,17416,28416,"LIN","FRA","19:45","18:40","GTA112");
		Flight F13=new Flight(450,15,35,400,5580,7580,10580,"DEL","BLR","14:10","16:45","GTA113");
		Flight F14=new Flight(850,50,250,550,17416,21416,29760,"BLR","FRA","23:55","14:10","GTA114");
		Flight F15=new Flight(850,50,250,550,4850,6530,12870,"FRA","ZRH","21:10","17:20","GTA115");
		Flight F16=new Flight(850,50,250,550,35416,42870,53416,"DEL","AMS","03:55","10:10","GTA116");
		Flight F17=new Flight(850,50,250,550,4516,6765,14416,"AMS","CDG","16:50","17:55","GTA117");
		Flight F18=new Flight(850,50,250,550,10764,14876,20764,"CDG","ZRH","18:35","18:00","GTA118");
		Flight F19=new Flight(850,50,250,550,11661,17416,28716,"DEL","AUH","05:45","07:10","GTA119");
		Flight F20=new Flight(850,50,250,550,12416,17416,28416,"MAA","MCT","07:20","10:45","GTA120");
		Flight F21=new Flight(850,50,250,550,23765,30875,40420,"MCT","FRA","17:45","18:50","GTA121");
		Flight F22=new Flight(450,15,35,400,5580,7580,10580,"MAA","BOM","21:15","23:20","GTA122");
		Flight F23=new Flight(850,50,250,550,45860,50860,63416,"BOM","FRA","00:20(+1)","07:55","GTA123");
		Flight F24=new Flight(450,15,35,400,5580,7580,10580,"MAA","DEL","12:30","14:55","GTA124");
		Flight F25=new Flight(850,50,250,550,12416,17416,28416,"DEL","ZRH","16:15","06:20(+1)","GTA125");
		Flight F26=new Flight(850,50,250,550,23680,30416,53870,"MCT","ZRH","14:45","19:05","GTA126");
		Flight F27=new Flight(850,50,250,550,20416,29816,46872,"MAA","AUH","22:35","01:35(+1)","GTA127");
		Flight F28=new Flight(850,50,250,550,20430,32416,46980,"MAA","DXB","04:50","07:50","GTA128");
		Flight F29=new Flight(850,50,250,550,12416,17416,28416,"DXB","AUH","07:55","09:05","GTA129");
		Flight F30=new Flight(850,50,250,550,80470,98456,123416,"BOM","LHR","23:35","09:20(+1)","GTA130");
		Flight F31=new Flight(850,50,250,550,80470,98456,123416,"MAA","FRA","01:50","10:30","GTA131");
		Flight F32=new Flight(850,50,250,550,12416,17416,28416,"FRA","LHR","12:30","13:00","GTA132");
		Flight F33=new Flight(850,50,250,550,60500,90500,110300,"MAA","LHR","15:25","9:20(+1)","GTA133");
		Flight F34=new Flight(850,50,250,550,65780,91416,110416,"MAA","CDG","7:00","14:00","GTA134");
		Flight F35=new Flight(850,50,250,550,12416,17416,28416,"CDG","BOM","8:00","15:00","GTA135");
		Flight F36=new Flight(850,50,250,550,90416,155416,230416,"BOM","SFO","11:05","6:20(+1)","GTA136");
		Flight F37=new Flight(850,50,250,550,90416,120416,210416,"BOM","JFK","1:45","6:50","GTA137");
		Flight F38=new Flight(450,15,35,400,4416,8416,15416,"BOM","DEL","7:20","9:30","GTA138");
		Flight F39=new Flight(450,15,35,400,3416,7416,14416,"BOM","MAA","14:00","16:05","GTA139");
		Flight F40=new Flight(850,50,250,550,28416,60416,96416,"DEL","FRA","12:50","18:20","GTA140");
		
		Edge E1=new Edge(G0,G1,0,145,F1);                              //del to bom
		Edge E2=new Edge(G0,G2,0,205,F2);                              //del to doh
		Edge E3=new Edge(G1,G3,485,420,F3);                              //boom to ist
		Edge E4=new Edge(G3,G4,175,12045,F4);                              //ist to jfk
		Edge E5=new Edge(G2,G4,140,855,F5);                              //doh to jfk
		Edge E6=new Edge(G1,G5,325,175,F6);                              //bom to auh
		Edge E7=new Edge(G5,G6,175,395,F7);                              //auh to fra
		Edge E8=new Edge(G0,G4,0,1425,F8);                             //del to jfk
		Edge E9 = new Edge(G0, G7, 0, 195, F9);
		Edge E10 = new Edge(G0, G18, 0, 520, F10);
		Edge E11 = new Edge(G18, G8, 220, 90, F11);
		Edge E12 = new Edge(G8, G6, 125, 255, F12);
		Edge E13 = new Edge(G0, G9, 0, 150, F13);
		Edge E14 = new Edge(G9, G6, 0, 1425, F14);
		Edge E15 = new Edge(G6, G14, 450, 50, F15);
		Edge E16 = new Edge(G0, G11, 280, 570, F16);
		Edge E17 = new Edge(G11, G10, 600, 725, F17);
		Edge E18 = new Edge(G10, G14, 250, 325, F18);
		Edge E19 = new Edge(G0, G5, 0, 765, F19);
		Edge E20 = new Edge(G7, G15, 0, 575, F20);
		Edge E21 = new Edge(G15, G6, 400, 325, F21);
		Edge E22 = new Edge(G7, G1, 0, 185, F22);
		Edge E23 = new Edge(G1, G6, 0, 225, F23);
		Edge E24 = new Edge(G7, G0, 0, 185, F24);
		Edge E25 = new Edge(G0, G14, 0, 605, F25);
		Edge E26 = new Edge(G15, G14, 240, 360, F26 );
        Edge E27 = new Edge(G7, G5, 0, 240, F27 );
        Edge E28 = new Edge(G7, G16, 250, 240, F28); 
        Edge E29 = new Edge(G16, G5, 0, 60, F29); //
        Edge E30 = new Edge(G1, G17, 0, 570, F30);
        Edge E31 = new Edge(G7, G6, 0, 540, F31);
        Edge E32 = new Edge(G6, G17, 150, 120, F32);
        Edge E33 = new Edge(G7, G17, 0, 600, F33);
        Edge E34 = new Edge(G7, G10, 0, 600, F34);
        Edge E35 = new Edge(G10, G12, 230, 540, F35);
        Edge E36 = new Edge(G1, G12, 0, 960, F36);
        Edge E37 = new Edge(G1, G4, 0, 840, F37);
        Edge E38 = new Edge(G1, G0, 0, 120, F38);
        Edge E39 = new Edge(G1, G7, 0, 150, F39);
        Edge E40 = new Edge(G0, G6, 0, 480, F40);
		
		insert(E1);
		insert(E2);
		insert(E3);
		insert(E4);
		insert(E5);
		insert(E6);
		insert(E7);
		insert(E8);
		insert(E9);
		insert(E10);
		insert(E11);
		insert(E12);
		insert(E13);
		insert(E14);
		insert(E15);
		insert(E16);
		insert(E17);
		insert(E18);
		insert(E19);
		insert(E20);
		insert(E21);
		insert(E22);
		insert(E23);
		insert(E24);
		insert(E25);
		insert(E26);
		insert(E27);
		insert(E28);
		insert(E29);
		insert(E30);
		insert(E31);
		insert(E32);
		insert(E33);
		insert(E34);
		insert(E35);
		insert(E36);
		insert(E37);
		insert(E38);
		insert(E39);
		insert(E40);
		
		//System.out.println(E1.get_flight().get_price());
		
		
	}
	
	void insert(Edge E) {
		for(int i=0;i<n;i++) {
		    if(E.get_src()==head[i]) {
		        if(head[i].next==null) {
		            head[i].next=E;
		            top[i]=E;
		        }
		        else {
		            E.next=top[i];
		            head[i].next=E;
		            top[i]=E;
		        }
		        break; 
		    }
		}

	}
	
	void display() {
		for(int i=0;i<n;i++) {
			System.out.println("Airport: "+head[i].get_airport());
			if(head[i].next!=null) {
				Edge ptr=top[i];
				while(ptr!=null) {
					System.out.println(ptr.get_src().get_airport()+ " "+ptr.get_dst().get_airport()+" "+ptr.get_srcLayOver()+" "+ptr.get_time()+" ");
					ptr=ptr.next;
				}
			}
			else {
				System.out.println("No flights available!");
			}
		}
	}
	
	void clear() {
		for(int i=0;i<n;i++) {
			visited[i]=0;
		}
	}
	
	ArrayList<ArrayList<Edge>> allPaths(String src, String dst) {
	    ArrayList<ArrayList<Edge>> allPathsList = new ArrayList<>();	
	    clear();
	    displayAllPaths(src, dst, new ArrayList<Edge>(), visited, allPathsList);
	    return allPathsList;
	}

	void displayAllPaths(String src, String dst, ArrayList<Edge> path, int[] visited, ArrayList<ArrayList<Edge>> allPathsList) {
	    if (src.equals(dst)) {
	        allPathsList.add(new ArrayList<>(path)); // Append the path to the list of all paths
	        return;
	    }

	    int k = -1;
	    for (int i = 0; i < n; i++) {
	        if (src.equals(head[i].get_airport())) {
	            k = i;
	            break;
	        }
	    }

	    visited[head[k].get_index()] = 1;
	    Edge ptr = top[k];

	    while (ptr != null) {
	        if (visited[ptr.get_dst().get_index()] == 0) {
	            path.add(ptr);
	            displayAllPaths(ptr.get_dst().get_airport(), dst, path, visited, allPathsList);
	            path.remove(path.size() - 1);
	        }
	        ptr = ptr.next;
	    }

	    visited[head[k].get_index()] = 0;
	}

	
	int[] dist=new int[n];
	
	void clear_dist() {
		for(int i=0;i<n;i++) {
			dist[i]=0;
		}
	}
	
	
	
	
	static class Pair implements Comparable<Pair>{
		int n;
		int path;
		
		public Pair(int n, int path) {
			this.n=n;
			this.path=path;
		}

		@Override
		public int compareTo(Pair p2) {
			return this.path-p2.path;
		}
		
	}
	
	public ArrayList<Edge> leastTime(int src, int dst) {
	    PriorityQueue<Pair> pq = new PriorityQueue<>();
	    int[] time = new int[n];
	    int[] parent = new int[n]; // Store the parent node for each node in the shortest path

	    for (int i = 0; i < n; i++) {
	        visited[i] = 0;
	        time[i] = Integer.MAX_VALUE;
	        parent[i] = -1; // Initialize parent to -1 for each node
	    }

	    time[src] = 0;
	    pq.add(new Pair(src, 0));

	    while (!pq.isEmpty()) {
	        Pair curr = pq.remove();

	        if (visited[curr.n] == 0) {
	            visited[curr.n] = 1;

	            Edge ptr = top[curr.n];
	            while (ptr != null) {
	                int u = ptr.get_src().get_index();
	                int v = ptr.get_dst().get_index();

	                if (visited[v] == 0 && (time[u] + ptr.get_time() + ptr.get_srcLayOver()) < time[v]) {
	                    time[v] = time[u] + ptr.get_time() + ptr.get_srcLayOver();
	                    parent[v] = u; // Update parent for node v
	                    pq.add(new Pair(v, time[v]));
	                }

	                ptr = ptr.get_next();
	            }
	        }

	        if (curr.n == dst) {
	            // Destination reached, stop the algorithm
	            break;
	        }
	    }

	    ArrayList<Edge> leastTimePathEdges = constructLeastTimePathEdges(src, dst, parent);

	    /*for (int i = 0; i < n; i++) {
	        System.out.print(time[i] + " ");
	    }
	    System.out.println();*/

	    return leastTimePathEdges;
	}

	public ArrayList<Edge> constructLeastTimePathEdges(int src, int dst, int[] parent) {
	    ArrayList<Edge> pathEdges = new ArrayList<>();
	    int current = dst;

	    while (parent[current] != -1) {
	        Edge edge = findEdge(parent[current], current);
	        if (edge != null) {
	            pathEdges.add(0, edge);
	        }
	        current = parent[current];
	    }

	    return pathEdges;
	}

	public Edge findEdge(int src, int dst) {
	    Edge ptr = top[src];
	    while (ptr != null) {
	        if (ptr.get_dst().get_index() == dst) {
	            return ptr;
	        }
	        ptr = ptr.get_next();
	    }
	    return null;
	}
	
	public ArrayList<Edge> leastPrice(int src, int dst, char seatType) {
	    PriorityQueue<Pair> pq = new PriorityQueue<>();
	    int[] price = new int[n];
	    int[] parent = new int[n]; // Store the parent node for each node in the shortest path
	    
	    
	    

	    for (int i = 0; i < n; i++) {
	        visited[i] = 0;
	        price[i] = Integer.MAX_VALUE;
	        parent[i] = -1; // Initialize parent to -1 for each node
	    }

	    price[src] = 0;
	    pq.add(new Pair(src, 0));

	    while (!pq.isEmpty()) {
	        Pair curr = pq.remove();

	        if (visited[curr.n] == 0) {
	            visited[curr.n] = 1;

	            Edge ptr = top[curr.n];
	            while (ptr != null) {
	                int u = ptr.get_src().get_index();
	                int v = ptr.get_dst().get_index();

	                if (visited[v] == 0 && (price[u] + ptr.get_flight().get_price(seatType)) < price[v]) {
	                    price[v] = (int) (price[u] + ptr.get_flight().get_price(seatType));
	                    parent[v] = u; // Update parent for node v
	                    pq.add(new Pair(v, price[v]));
	                }

	                ptr = ptr.get_next();
	            }
	        }

	        if (curr.n == dst) {
	            // Destination reached, stop the algorithm
	            break;
	        }
	    }

	    ArrayList<Edge> leastPricePathEdges = constructLeastPricePathEdges(src, dst, parent);

	    /*for (int i = 0; i < n; i++) {
	        System.out.print(price[i] + " ");
	    }*/
	    System.out.println();
	    

	    return leastPricePathEdges;
	}

	public ArrayList<Edge> constructLeastPricePathEdges(int src, int dst, int[] parent) {
	    ArrayList<Edge> pathEdges = new ArrayList<>();
	    int current = dst;

	    while (parent[current] != -1) {
	        Edge edge = findEdge(parent[current], current);
	        if (edge != null) {
	            pathEdges.add(0, edge);
	        }
	        current = parent[current];
	    }

	    return pathEdges;
	}	
	
	
}