package me.kktrkkt.demobootweb.request_mapping.http_header;

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
                .andExpect(status().isNotFound())
                .andDo(print());

        this.mockMvc.perform(get("/exists").header("key", "key"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void notExists() throws Exception {
        this.mockMvc.perform(get("/not-exists"))
                .andExpect(status().isOk())
                .andDo(print());

        this.mockMvc.perform(get("/not-exists").header("key", "key"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void match() throws Exception {
        this.mockMvc.perform(get("/match"))
                .andExpect(status().isNotFound())
                .andDo(print());

        this.mockMvc.perform(get("/match").header("key", "11"))
                .andExpect(status().isNotFound())
                .andDo(print());

        this.mockMvc.perform(get("/match").header("key", "10"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}