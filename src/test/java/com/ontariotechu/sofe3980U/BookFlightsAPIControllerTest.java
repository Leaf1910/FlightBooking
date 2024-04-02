package com.ontariotechu.sofe3980U;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;

@RunWith(SpringRunner.class)
@WebMvcTest(BookFlightsAPIController.class)
public class BookFlightsAPIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookFlightsAPIController controller;

    @Test
    public void testBookDirectApi() throws Exception {
        when(controller.Bookdirectapi(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                .thenReturn("Direct flight booked successfully.\n" +
                        "Booking ID: f28a4f97-e760-45da-9ff5-16c0f289b69a\n" +
                        "From Airport: LAX\n" +
                        "Destination Airport: TorontoPearson\n");

        mockMvc.perform(MockMvcRequestBuilders.post("/Bookdirect-api")
                .param("FromAirport", "LAX")
                .param("DestinationAirport", "TorontoPearson"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Direct flight booked successfully.\n" +
                        "Booking ID: f28a4f97-e760-45da-9ff5-16c0f289b69a\n" +
                        "From Airport: LAX\n" +
                        "Destination Airport: TorontoPearson\n"));
    }
    
    @Test
    public void testBookDirectApi_MissingParameters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/Bookdirect-api"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

  
    
}
