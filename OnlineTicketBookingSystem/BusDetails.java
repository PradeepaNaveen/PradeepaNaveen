package OnlineTicketBookingSystem;
import java.util.*;
public class BusDetails {
    String busType;
    String seatType;
    int totalSeats = 12;
    int numberOfTickets;
    int bookedSeats;
    int[][] seatView = new int[4][3];
    Scanner input = new Scanner(System.in);

    BusDetails(String busType, String seatType) {
        int number = 1;
        this.busType = busType;
        this.seatType = seatType;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                seatView[i][j] = number;
                number++;
            }
        }
    }

    public void viewSeats() {
        System.out.println("*------>Driver\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (seatView[i][j] > 0)
                    System.out.print(" " + seatView[i][j] + " ");
                else if (seatView[i][j] == -1)
                    System.out.print("M");
                else
                    System.out.print("F");
            }
            System.out.println(" ");
            System.out.println("-------------------->");
        }
    }

    public boolean checkAvailability(int seatNumber) {
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (seatView[i][j] == seatNumber)
                    flag = true;
                else
                    flag = false;
            }
        }
        return flag;
    }

    public int[] bookSeat() {
        System.out.println("Enter no of tickets want to book");
        numberOfTickets = input.nextInt();
        int[] seat = new int[numberOfTickets];
        for (int k = 0; k < numberOfTickets; k++) {
            System.out.print("Enter seat number want to be booked:");
            int seatNumber = input.nextInt();
            System.out.print("Enter gender M or F:");
            char gender = input.next().charAt(0);
            if (seatNumber < 1 || seatNumber > 12) {
                System.out.println("Invalid seat number!!!\nPlease choose seat between 1-12");
                seatNumber = 0;
            } else if (checkAvailability(seatNumber)) {
                System.out.println("Sorry entered seat is already booked...\nPlease choose another seat");
                seatNumber = 0;
            } else {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 3; j++) {
                        seatView[i][j] = seatNumber;
                    }
                }
            }
            if (seatNumber != 0)
                seat[k] = seatNumber;
        }
        bookedSeats += seat.length;
        return seat;
    }
    public void deleteSeats(int[] bookedTickets)
    {
        for(int t : bookedTickets)
        {
            int seat = 1,c=0;
            for(int i=0;i<4;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(seat == t)
                    {
                        seatView[i][j] = seat;
                        bookedSeats--;
                        c+=1;
                        break;
                    }
                    seat++;
                }
                if(c>0)
                    break;
            }
        }
    }
}
