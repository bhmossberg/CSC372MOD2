package textbook;

public class SeatInfo {
	   private String firstName; // First name
	   private String lastName;  // Last name
	   private int amtPaid;      // Amount paid

	   // Method to initialize Seat fields
	   public void reserveSeat(String inFirstName, String inLastName, int ticketCost) {
	      firstName = inFirstName;
	      lastName = inLastName;
	      amtPaid = ticketCost;
	   }

	   // Method to empty a Seat
	   public void makeEmpty() {
	      firstName = "empty";
	      lastName = "empty";
	      amtPaid = 0;
	   }

	   // Method to check if Seat is empty
	   public boolean isEmpty() {
	      return firstName.equals("empty");
	   }

	   // Method to print Seat fields
	   public void printSeatInfo() {
	      System.out.print(firstName + " ");
	      System.out.print(lastName + " ");
	      System.out.println("Paid: " + amtPaid);
	   }

	   public String getFirstName() {
	      return firstName;
	   }

	   public String getLastName() {
	      return lastName;
	   }

	   public int getAmountPaid() {
	      return amtPaid;
	   }
	}
