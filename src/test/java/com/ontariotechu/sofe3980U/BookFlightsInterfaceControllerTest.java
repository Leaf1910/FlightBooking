package com.ontariotechu.sofe3980U;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.ontariotechu.sofe3980U.Classes.Airport;
import com.ontariotechu.sofe3980U.Classes.Flight;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookFlightsInterfaceController.class)
public class BookFlightsInterfaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookFlightsInterfaceController controller;

    @Test
    public void testGetBookingView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("BookingInterface"))
                .andExpect(model().attributeExists("FullName"))
                .andExpect(model().attributeExists("airports"));
    }

    @Test
    public void testFindAvailableFlights() throws Exception {
        mockMvc.perform(post("/Bookdirect")
                .param("FromAirport", "YYZ")
                .param("DepartureAirport", "LAX")
                .param("DepartureDate", "2024-04-01")
                .param("ArriveDate", "2024-04-02")
                .param("timeFormat", "24"))
                .andExpect(status().isOk())
                .andExpect(view().name("AvailableFlights"))
                .andExpect(model().attributeExists("availableFlights"))
                .andExpect(model().attributeExists("timeFormat"));
    }


    @Test
    public void testBookRoundTrip() throws Exception {
        mockMvc.perform(post("/Bookroundtrip")
                .param("FromAirport", "YYZ")
                .param("ToAirport", "LAX")
                .param("ReturnAirport", "YYZ"))
                .andExpect(status().isOk())
                .andExpect(view().name("RoundTripFlights"))
                .andExpect(model().attributeExists("outboundFlights"))
                .andExpect(model().attributeExists("returnFlights"));
    }
}
