package DSL_MiniProject;


class LinkedList {
    NodeinLL head;

    public void insert(Passenger passenger) {
        NodeinLL newNode = new NodeinLL(passenger);
        newNode.next = head;
        head = newNode;
    }

    public Passenger search(String email) {
        NodeinLL current = head;
        while (current != null) {
            if (current.passenger.getEmail().equals(email)) {
                return current.passenger;
            }
            current = current.next;
        }
        return null; // Passenger NOT found
    }

    /*public void updateEmail(String currentEmail, String newEmail) {
        NodeinLL current = head;
        while (current != null) {
            if (current.passenger.getEmail().equals(currentEmail)) {
                current.passenger.setEmail(newEmail);
                return;
            }
            current = current.next;
        }
    }*/

    public void deleteEmail(String email) {
        if (head == null) {
            return; // List is empty
        }
        if (head.passenger.getEmail().equals(email)) {
            head = head.next;
            return;
        }

        NodeinLL current = head;
        while (current.next != null) {
            if (current.next.passenger.getEmail().equals(email)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}

