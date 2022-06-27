package OnlineTicketBookingSystem;
import java.util.*;
public class Main {
    static Scanner input = new Scanner(System.in);
    ArrayList<CustomerDetails> customerObject = new ArrayList<CustomerDetails>();
    ArrayList<Ticket> ticketObject = new ArrayList<Ticket>();
    ArrayList<BusDetails> busObject = new ArrayList<BusDetails>();
    public void customerSignUp()
    {
        System.out.println("Enter id,name,password,age,gender to sign-up for the page");
        int id = input.nextInt();
        String name= input.next();
        String password = input.next();
        int age = input.nextInt();
        char gender = input.next().charAt(0);
        int t=0;
        for(CustomerDetails c:customerObject)
        {
            if(c.id ==id)
                t++;
            else if (t == 0)
            {
                customerObject.add(new CustomerDetails(id,name,password,age,gender));
                System.out.println("Back to home page");
                //break;
            }
            else
                System.out.println("User id already exists");
        }
    }
    public void createDetails()
    {
        customerObject.add(new CustomerDetails(1,"Poojitha","111",21,'F'));
        customerObject.add(new CustomerDetails(2,"Naveen","222",30,'M'));
        customerObject.add(new CustomerDetails(3,"Adithya","333",15,'M'));
        busObject.add(new BusDetails("AC","Seater"));
        busObject.add(new BusDetails("AC","Sleeper"));
        busObject.add(new BusDetails("Non-AC","Seater"));
        busObject.add(new BusDetails("Non-AC","Sleeper"));
    }
    public void customerLogin()
    {
        System.out.println("Enter Id and Password for Login:");
        int id = input.nextInt();
        String pword = input.next();
        int f=0;
        CustomerDetails currentCustomer = null;
        for(CustomerDetails c: customerObject)
        {
            if(c.id == id && c.password.equals(pword))
            {
                currentCustomer = c;
                f++;
                break;
            }
        }
        if(f == 0)
            System.out.println("Invalid Login or Password:");
        else
        {
            int t = 0;
            System.out.println("Login Successfully..........\n Welcome!!!!!!!!!!!!"+currentCustomer.name);
            while(t == 0)
            {
                System.out.println("1).Book Ticket 2).View Ticket 3).Cancel Ticket 4).Logout");
                int choiceAfterLogin = input.nextInt();
                switch (choiceAfterLogin)
                {
                    case 1:
                        System.out.println("Choose bus type,seat type:");
                        String bType = input.next();
                        String sType = input.next();
                        for(BusDetails b :busObject)
                        {
                            if(b.busType.equals(bType) && b.seatType.equals(sType))
                            {
                                int[] bookedSeat = b.bookSeat();
                                int noOfTick=b.numberOfTickets;
                                int ticketId=ticketObject.size();
                                System.out.println("-------------------------------");
                                ticketObject.add(new Ticket(ticketId,bookedSeat,b, b.numberOfTickets,currentCustomer.id));
                                System.out.println("Your Ticket is id:"+ticketId+ "\n" +"Your Tickets were booked\n!!!!Happy Journey!!!!");
                                System.out.println("-------------------------------");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Enter bustype,seattype");
                        bType=input.next();
                        sType=input.next();
                        for(BusDetails b:busObject)
                        {
                            if(b.busType.equals(bType) && b.seatType.equals(sType))
                            {
                                b.viewSeats();
                            }
                        }
                        break;
                    case 3:System.out.println("Enter booking id");
                        int bid=input.nextInt();
                        for(Ticket ti:ticketObject)
                        {
                            if(ti.id==bid && ti.customerId!=currentCustomer.id)
                            {
                                System.out.println("Ticket does not belongs to you!!!!\nTicket cancellation cannot be possible");
                                break;
                            }
                            else if(ti.id==bid)
                            {
                                BusDetails busDetails=ti.ticketDetails();
                                int[] bookedSeats=ti.bookedTickets;
                                busDetails.deleteSeats(bookedSeats);
                                ticketObject.remove(ti);
                                System.out.println("Your ticket has been deleted successfully!!!\nThank you");
                                break;
                            }
                        }
                        break;
                    case 4:
                        System.out.println("You have successfully logged out...come back again!!!");
                        t++;
                        break;
                }
            }
        }
    }
    public static void main(String[] args)
    {
        int choice;
        Main object = new Main();
        object.createDetails();
        while(true)
        {
            System.out.println("1).Customer Sign-Up \n 2).Customer Login \n 3).Exit");
            choice = input.nextInt();
            switch (choice)
            {
                case 1:object.customerSignUp();
                       break;
                case 2:object.customerLogin();
                       break;
                case 3:System.exit(0);
            }
        }
    }
}
