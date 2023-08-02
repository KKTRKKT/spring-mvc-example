package me.kktrkkt.demobootweb.uri_pattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getSample() throws Exception {
        this.mockMvc.perform(get("/sample/12/many/many/path"))
                .andExpect(status().isNotFound());

        this.mockMvc.perform(get("/sample/1/many/many/path"))
                .andExpect(status().isOk());
    }


}