package hellocucumber.payloads;
// import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Booking {
    //予約情報
    @JsonProperty
    private int roomid;
    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private String email;
    @JsonProperty
    private String phonenumber;
    @JsonProperty
    private boolean depositpaid;
    @JsonProperty
    private BookingDates bookingdates;
    @JsonProperty
    private String additionalneeds;

    //申し込みPosting用
    public Booking(
        int roomid,
        String firstname,
        String lastname,
        String email,
        String phonenumber,
        boolean depositpaid,
        BookingDates bookingdates,
        String additionalneeds
        ) {
            this.roomid = roomid;
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.phonenumber = phonenumber;
            this.depositpaid = depositpaid;
            this.bookingdates = bookingdates;
            this.additionalneeds = additionalneeds;
        }
}
