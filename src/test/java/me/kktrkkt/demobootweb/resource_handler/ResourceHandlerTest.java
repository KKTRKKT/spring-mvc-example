package me.kktrkkt.demobootweb.resource_handler;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ResourceHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void springBootResourceHandler() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/index.html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsStringIgnoringCase("hello world")))
                .andDo(print());
     }

    @Test
    void myResourceHandler() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/kktrkkt/index.html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsStringIgnoringCase("hello kktrkkt")))
                .andExpect(header().exists(HttpHeaders.CACHE_CONTROL))
                .andDo(print());
    }
}