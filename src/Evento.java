import java.time.LocalDate;
import java.util.Scanner;

public class Evento {

    private String title;
    private LocalDate data;
    private int totalSeats;
    private int reservedSeats;

    public Evento(String title, LocalDate data, int totalSeats) {
        this.title= title;
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Error: The date is in the past.");
        }
        this.data = data;
        if (totalSeats <= 0) {
            throw new IllegalArgumentException("Error: The number of total seats must be positive.");
        }
        this.totalSeats= totalSeats;
        this.reservedSeats=0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

//    METODO PER PRENOTARE


    public void prenota(){
        System.out.println("Seats available: " + totalSeats);
        int toReserve = 0;
        // Qui inizia lo Scanner
        Scanner scanner = new Scanner(System.in);
//              QUI CHIEDO SE PRENOTA
        System.out.println("Do you want to reserve some seats? (y/n)");
        String reservationQuestion= scanner.nextLine();
        if (reservationQuestion.equalsIgnoreCase("y")){
            System.out.println("How many seats do you want to reserve?");
            toReserve = Integer.parseInt(scanner.nextLine());
            if (toReserve > (totalSeats - reservedSeats)) {
                throw new IllegalArgumentException("No more seats available");
            } else {
                System.out.println("Thank you for having used our services, you've reserved: " + toReserve + " seat(s).");
            }
            System.out.println( "You've reserved: " + (reservedSeats += toReserve) + " Seats");
        }
    }
//              QUI CHIEDO SE DISDICE
          public void disdici () {
              Scanner scan = new Scanner(System.in);
              System.out.println("Do you want to cancel some reservations? (y/n)");
              String cancelReservation = scan.nextLine();
              if (cancelReservation.equalsIgnoreCase("y")) {
                  int seatsCanceled = 0;
                  if (reservedSeats == 0) {
                      throw new IllegalArgumentException("You cannot cancel as you didn't reserve anything");
                  } else {
                      do {
                          System.out.println("How Many reservations do you want to cancel? ");
                          seatsCanceled = Integer.parseInt(scan.nextLine());
                          if (seatsCanceled <= 0 || seatsCanceled > reservedSeats) {
                              System.out.println("Invalid input. Please enter a number between 1 and " + reservedSeats);
                          }
                      } while (seatsCanceled <= 0 || seatsCanceled > reservedSeats);

                      System.out.println("You've canceled: " + seatsCanceled);
                      reservedSeats -= seatsCanceled;  // Updating the reservedSeats
                      System.out.println("Total reserved seats now: " + reservedSeats);
                  }
              }
              System.out.println("There are still: " + (totalSeats - reservedSeats) + " seats left");
          }

    @Override
    public String toString() {
        return "Evento{" +
                "title='" + title + '\'' +
                ", data=" + data +
                ", totalSeats=" + totalSeats +
                ", reservedSeats=" + reservedSeats +
                '}';
    }
}
