package me.kktrkkt.demobootweb.handler_method.session;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getSession() throws Exception {
        this.mockMvc.perform(get("/session"))
                .andExpect(status().isOk())
                .andExpect(request().sessionAttribute("hello", "world"))
                .andDo(print());
    }

    @Test
    void getSessionAttributes() throws Exception {
        this.mockMvc.perform(get("/session-attributes"))
                .andExpect(status().isOk())
                .andExpect(request().sessionAttribute("hi", "bye"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("hi"))
                .andDo(print());
    }
}