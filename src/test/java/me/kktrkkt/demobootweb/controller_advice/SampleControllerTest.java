package me.kktrkkt.demobootweb.controller_advice;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getSampleForm() throws Exception {
        this.mockMvc.perform(get("/samples/form"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(Matchers.containsString("<h2>sample error</h2>")))
                .andDo(print());
    }

    @Test
    void getSample() throws Exception {
        this.mockMvc.perform(get("/api/samples"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("sample error"))
                .andDo(print());
    }
}