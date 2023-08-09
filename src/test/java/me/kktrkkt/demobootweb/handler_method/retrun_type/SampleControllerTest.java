package me.kktrkkt.demobootweb.handler_method.retrun_type;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getSampleResponseBody() throws Exception {
        this.mockMvc.perform(get("/response-body/sample"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello sample"))
                .andDo(print());
    }

    @Test
    void getSampleString() throws Exception {
        this.mockMvc.perform(get("/view/sample/string"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsStringIgnoringCase("<h1>Hello Sample</h1>")))
                .andDo(print());
    }

    @Test
    void getSampleView() throws Exception {
        this.mockMvc.perform(get("/view/sample/view"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsStringIgnoringCase("<h1>Hello Sample</h1>")))
                .andDo(print());
    }

    @Test
    void getSampleModel() throws Exception {
        this.mockMvc.perform(get("/view/sample"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsStringIgnoringCase("<h1>Hello Sample</h1>")))
                .andExpect(model().attribute("attribute", "attribute"))
                .andDo(print());
    }
}