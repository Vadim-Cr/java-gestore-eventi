import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento{
    private LocalTime myTime;
    private BigDecimal ticketPrice;

    public Concerto(String title, LocalDate data, int totalSeats, LocalTime myTime, BigDecimal ticketPrice) {
        super(title, data, totalSeats);
        this.myTime = myTime;
        this.ticketPrice = ticketPrice;
    }

    public String getMyTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return getData().format(formatter);
    }

    public void setMyTime(LocalTime myTime) {
        this.myTime = myTime;
    }

    public BigDecimal getTicketPrice() {
        DecimalFormat df = new DecimalFormat("##,##" + "€");
        df.setGroupingUsed(true);  // Abilita la raggruppamento (ad es., la virgola nei migliaia)
        String formattedPrice = df.format(ticketPrice);
        return ticketPrice;
    }


    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public static double withDecimalFormatLocal(double value) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.getDefault());
        return new Double(df.format(value));
    }


    @Override
    public String toString() {
        return "Concerto{" +
                "myTime=" + myTime +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
