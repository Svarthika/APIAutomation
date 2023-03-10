package org.example.modules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.payloadPojos.Booking;
import org.example.payloadPojos.Bookingdates;
//Serialise & Deserialise
public class PayloadManager {
    ObjectMapper objectMapper;

    public String createPayload() throws JsonProcessingException {

        //java object - JSON String
        objectMapper = new ObjectMapper();
        Booking booking = new Booking();
        booking.setFirstname("Varthika");
        booking.setLastname("surthy");
        booking.setTotalprice(123);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Breakfast, lunch");
        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2023-10-01");
        bookingdates.setCheckout("2023-10-01");
        booking.setBookingdates(bookingdates);
        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;
    }
}
