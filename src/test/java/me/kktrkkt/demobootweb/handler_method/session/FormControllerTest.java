package me.kktrkkt.demobootweb.handler_method.session;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FormControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    void getForm1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/form1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Create New Form1")))
                .andDo(print());
    }

    @Test
    @Order(2)
    void postForm1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/form1")
                        .param("name", "event"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Create New Form2")))
                .andDo(print());
    }

    @Test
    @Order(3)
    void getForm2() {
    }

    @Test
    @Order(4)
    void postForm2() {
    }

    @Test
    @Order(5)
    void getLast() {

    }
}