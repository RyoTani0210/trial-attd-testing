package hellocucumber.payloads;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingResponse {
    @JsonProperty
    private int bookingid;
    @JsonProperty
    private Booking booking;

    public int getBookingid(){
        return bookingid;
    }
    public Booking getBooking(){
        return booking;
    }

    // パラメータ付きコンストラクタを追加
    public BookingResponse(int bookingid, Booking booking){
        this.bookingid = bookingid;
        this.booking = booking;
    }
}
