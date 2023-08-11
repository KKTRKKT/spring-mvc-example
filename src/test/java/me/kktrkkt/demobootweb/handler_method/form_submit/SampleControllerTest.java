package me.kktrkkt.demobootweb.handler_method.form_submit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getEventsForm() throws Exception {
        this.mockMvc.perform(get("/events/form"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("<title>Create New Form</title>")))
                .andExpect(model().attributeExists("event"))
                .andDo(print());
    }

    @Test
    void postEvents() throws Exception {
        this.mockMvc.perform(post("/events")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "new event")
                        .param("limit", "100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("new event"))
                .andExpect(jsonPath("$.limit").value(100))
                .andDo(print());
    }
}