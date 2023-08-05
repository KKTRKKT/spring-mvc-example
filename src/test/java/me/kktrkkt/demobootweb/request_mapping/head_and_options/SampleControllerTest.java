package me.kktrkkt.demobootweb.request_mapping.head_and_options;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void hello() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.options("/hello"))
                .andExpect(status().isOk())
                .andExpect(header().stringValues(HttpHeaders.ALLOW, hasItems(containsString("GET"))))
                .andDo(print());
    }
}