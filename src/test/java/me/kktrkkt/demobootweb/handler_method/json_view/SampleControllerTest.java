package me.kktrkkt.demobootweb.handler_method.json_view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getSampleList() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/samples"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("sample1"))
                .andExpect(jsonPath("$[0].details").doesNotExist())
                .andDo(print());
    }

    @Test
    void getSample() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/samples/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("sample1"))
                .andExpect(jsonPath("$.details").value("details1"))
                .andDo(print());
    }
}