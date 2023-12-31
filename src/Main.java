import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
    LocalDate dataEvento = LocalDate.of(2023, 11, 15);
    Evento eventoTeatro = new Evento ("Pinocchio",dataEvento, 300);

    int reservedSeats=0;
//    Chiedo quante volte vuole prenotare
    Scanner scan=new Scanner(System.in);
        System.out.println("How many reservations?");
        int numberOfReservations= Integer.parseInt(scan.nextLine());


        for (int i = 0; i < (numberOfReservations); i++) {
            eventoTeatro.prenota();
            reservedSeats += eventoTeatro.getReservedSeats();
        }

//    Chiedo se vuole cancellare delle prenotazioni
            eventoTeatro.disdici();
        System.out.println("Total reserved seats: " + eventoTeatro.getReservedSeats());
        System.out.println("Available seats: " + (eventoTeatro.getTotalSeats() - eventoTeatro.getReservedSeats()));
        scan.close();

        LocalDate dataConcerto = LocalDate.of(2023, 11, 15);  // 15 novembre 2023
        LocalTime oraConcerto = LocalTime.of(20, 0);  // 20:00
        BigDecimal prezzoBiglietto = new BigDecimal("59.99");

        Concerto concerto = new Concerto(
                "Concerto di Eminem",
                dataConcerto,
                300,
                oraConcerto,
                prezzoBiglietto
        );
        System.out.println(concerto);
        }
}