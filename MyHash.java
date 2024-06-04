package DSL_MiniProject;

class MyHash {

    LinkedList hashTable[];   //NOTE : Change this size later

    MyHash() {

        hashTable = new LinkedList[10];    //array(of 10 indexes) of LinkedList
//        for (int i = 0; i < 10; i++) {
//            hashTable[i] = new LinkedList();
//        }
    }
    public int hash(Passenger pg) {
        int hashCode = 0;
        int prime = 31;
        String pg_Eml = pg.getEmail();

        for (char c : pg_Eml.toCharArray()) {
            hashCode = (hashCode * prime + c) % 10;  // Later , REMEMBER to use a larger modulus
        }

        return hashCode;
    }

    public void create(Passenger pg) {
        int hashCode = hash(pg);


        if (hashTable[hashCode] == null) {
            hashTable[hashCode] = new LinkedList();
        }
        hashTable[hashCode].insert(pg);
    }

    public void display(Passenger pg) {   //Displaying passenger email and its hashcode
        String passengerEmail = pg.getEmail();
        System.out.println("passengerEmail = " + passengerEmail + " : " + hash(pg));
    }

    public Passenger search(String email) {
        Passenger pgToBeSearched = new Passenger(email, "", "", 0, "");
        int hashCode = hash(pgToBeSearched);

        LinkedList bucketToSearchIn = hashTable[hashCode];

        if (bucketToSearchIn != null) {
            Passenger foundPassenger = bucketToSearchIn.search(email);
            if (foundPassenger != null) {
                System.out.println("Passenger with email Id " + foundPassenger.getEmail() + " is " + foundPassenger.getName());
                return foundPassenger;
            } else
                System.out.println("Passenger with email Id " + email + " NOT FOUND");


        } else
            System.out.println("Passenger with email Id " + email + " NOT FOUND");


        return null; // Passenger NOT found
    }


    public void update_Email(String currentEmail, String newEmail) {

        Passenger pgToUpdateEml = search(currentEmail);

        if (pgToUpdateEml != null) {
            pgToUpdateEml.setEmail(newEmail);    //Updating the email in Passenger object
//            System.out.println("Email updated for " + pgToUpdate.getName() + " to " + newEmail);
            System.out.println("Email updated for " + pgToUpdateEml.getName() + " to " + pgToUpdateEml.getEmail());

        } else {
            System.out.println("Passenger with email " + currentEmail + " not found.");
        }
    }


    public void deletePassenger(String email) {
        Passenger pgToDelete = search(email);

        if (pgToDelete != null) {
            int hashCode = hash(pgToDelete);
            LinkedList bucketToDeleteFrom = hashTable[hashCode];
            bucketToDeleteFrom.deleteEmail(pgToDelete.getEmail());

            if (bucketToDeleteFrom.head == null) {
                hashTable[hashCode] = null; // Setting the bucket to null if its found empty
            }

            System.out.println("Passenger with email " + email + " has been DELETED.");
        }

//        else {
//            System.out.println("Passenger with email " + email + " NOT found .");
//        }
    }


}
