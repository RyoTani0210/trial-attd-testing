package hellocucumber.payloads;
// import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Booking {
    //予約情報
    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private int totalprice;
    @JsonProperty
    private boolean depositpaid;
    @JsonProperty
    private BookingDates bookingdates;
    @JsonProperty
    private String additionalneeds;

    //デフォルトコンストラクタ作成
    // public Booking() {}

    public Booking(
        String firstname,
        String lastname,
        int totalprice,
        boolean depositpaid,
        BookingDates bookingdates,
        String additionalneeds
        ) {
            // this.roomid = roomid;
            this.firstname = firstname;
            this.lastname = lastname;
            this.totalprice = totalprice;
            this.depositpaid = depositpaid;
            this.bookingdates = bookingdates;
            this.additionalneeds = additionalneeds;
        }
}
