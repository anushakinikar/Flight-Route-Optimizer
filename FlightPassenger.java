package DSL_MiniProject;

class FlightPassenger {

	private Passenger p;
	private char seatType;
	private FlightPassenger left;
	private FlightPassenger right;
	private int seatNos;

	FlightPassenger(){
		this.p=null;
		this.seatType='\0';
		this.left=null;
		this.right=null;
		this.seatNos = 0;
	}

	FlightPassenger(Passenger p, char seatType, int seatNos){
		this.p=p;
		this.seatType=seatType;
		this.left=null;
		this.right=null;
		this.seatNos = seatNos;
	}


	public int getSeatNos() {
		return seatNos;
	}

	public void setSeatNos(int seatNos) {
		this.seatNos = seatNos;
	}
	
	Passenger get_flightPassenger() {
		return p;
	}

	void set_flightPassenger(Passenger P) {
		this.p=P;
	}

	void set_seatType(char seat) {
		this.seatType=seat;
	}

	char get_seatType() {
		return seatType;
	}

	FlightPassenger get_lc() {
		return left;
	}

	FlightPassenger get_rc() {
		return right;
	}

	void set_lc(FlightPassenger left) {
		this.left=left;
	}
	
	void set_rc(FlightPassenger right) {
		this.right=right;
	}

}