package OnlineTicketBookingSystem;

import java.util.Arrays;

public class Ticket {
    int id;
    int[] bookedTickets;
    BusDetails busObject;
    int numberOfTickets;
    int customerId;
    Ticket(int id,int[] bookedTickets,BusDetails busObject,int numberOfTickets,int customerId)
    {
        this.id  = id;
        this.bookedTickets = bookedTickets;
        this.busObject = busObject;
        this.numberOfTickets = numberOfTickets;
        this.customerId  = customerId;
    }
    BusDetails ticketDetails()
    {
        System.out.println("----------------------------------");
        System.out.println("Ticket Details are: \n");
        System.out.println("Bus Type:" +busObject.busType);
        System.out.println("Seat Type:" +busObject.seatType);
        System.out.println("Booked by customer_Id:" +customerId);
        System.out.println("Number Of Tickets:" +numberOfTickets);
        System.out.println("Booked Seats" + Arrays.toString(bookedTickets));
        System.out.println("------------------------------------");
        return busObject;
    }
}
