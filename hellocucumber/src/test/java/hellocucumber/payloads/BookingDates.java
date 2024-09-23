package hellocucumber.payloads;

import java.time.LocalDate;
// import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDates {

    @JsonProperty
    private LocalDate checkin;
    @JsonProperty
    private LocalDate checkout;

    public BookingDates(LocalDate checkin, LocalDate checkout) {
        this.checkin = checkin;
        this.checkout =checkout;

    }
}