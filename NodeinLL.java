package DSL_MiniProject;

class NodeinLL {
    Passenger passenger;
    NodeinLL next;

    public NodeinLL(Passenger passenger) {
        this.passenger = passenger;
        this.next = null;
    }
}