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

    public void prenotaODisdici(){
        System.out.println("Seats available: " + totalSeats);
        int toReserve = 0;
        // Qui inizia lo Scanner
        Scanner scanner = new Scanner(System.in);
//todo    *********************************************************************************
//              QUI CHIEDO SE PRENOTA
        System.out.println("Do you want to reserve some seats? (y/n)");
       String reservationQuestion= scanner.nextLine();
      if (reservationQuestion.equalsIgnoreCase("y")){
               System.out.println("How many seats do you want to reserve?");
               toReserve += scanner.nextInt();
               if (toReserve > (totalSeats - reservedSeats)) {
                   throw new IllegalArgumentException("No more seats available");
               } else {
                   System.out.println("Thank you for having used our services, you've reserved: " + toReserve + " seat(s).");
               }
          System.out.println(reservedSeats += toReserve);
//todo    *********************************************************************************
//              QUI CHIEDO SE DISDICE
      } else if (reservationQuestion.equalsIgnoreCase("n")){
               System.out.println("Do you want to cancel your reservation?  (y/n)");
               String cancelReservation = scanner.nextLine();
          if (cancelReservation.equalsIgnoreCase("y")){
              int seatsCanceled = 0;
              do {
                  System.out.println("How Many reservations do you want to cancel? ");
                  seatsCanceled = scanner.nextInt();
                  if (seatsCanceled <= 0 || seatsCanceled > reservedSeats) {
                      System.out.println("Invalid input. Please enter a number between 1 and " + reservedSeats);
                  }
              } while (seatsCanceled <= 0 || seatsCanceled > reservedSeats);

              System.out.println("You've canceled: " + seatsCanceled);
              reservedSeats -= seatsCanceled;  // Updating the reservedSeats
              System.out.println("Total reserved seats now: " + reservedSeats);
          }
       }


        scanner.close();
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
