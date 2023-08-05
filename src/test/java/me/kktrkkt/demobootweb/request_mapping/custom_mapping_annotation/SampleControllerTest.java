package me.kktrkkt.demobootweb.request_mapping.custom_mapping_annotation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void hello() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/sample/hello"))
                .andExpect(status().isOk())
                .andDo(print());

        this.mockMvc.perform(MockMvcRequestBuilders.options("/sample/hello"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}