package me.kktrkkt.demobootweb.request_mapping.http_param;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void exists() throws Exception {
        this.mockMvc.perform(get("/exists"))
                .andExpect(status().isBadRequest())
                .andDo(print());

        this.mockMvc.perform(get("/exists").param("name", "name"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void notExists() throws Exception {
        this.mockMvc.perform(get("/not-exists"))
                .andExpect(status().isOk())
                .andDo(print());

        this.mockMvc.perform(get("/not-exists").param("name", "name"))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    void match() throws Exception {
        this.mockMvc.perform(get("/match"))
                .andExpect(status().isBadRequest())
                .andDo(print());

        this.mockMvc.perform(get("/match").param("name", "11"))
                .andExpect(status().isBadRequest())
                .andDo(print());

        this.mockMvc.perform(get("/match").param("name", "kktrkkt"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}