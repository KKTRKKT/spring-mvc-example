package me.kktrkkt.demobootweb.handler_method.redirect_attributes;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.lang.UsesSunMisc;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    static private MockHttpSession session;

    @BeforeAll
    static void beforeAll() {
        session = new MockHttpSession();
    }

    @Test
    @Order(1)
    void getForm() throws Exception {
        this.mockMvc.perform(get("/form"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("/form")))
                .andDo(print());
    }

    @Test
    @Order(2)
    void postForm() throws Exception {
        this.mockMvc.perform(post("/form")
                        .param("name", "test")
                        .param("limit", "10"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/event?name=test&limit=10"))
                .andDo(print());
    }

    @Test
    @Order(3)
    void getEvent() throws Exception {
        this.mockMvc.perform(get("/event")
                        .param("name", "test")
                        .param("limit", "10"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("name", "limit"))
                .andExpect(content().string(containsString("test")))
                .andExpect(content().string(containsString("10")))
                .andDo(print());
    }

    @Test
    @Order(4)
    void getFormFlash() throws Exception {
        this.mockMvc.perform(get("/form/flash"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("/form/flash")))
                .andDo(print());
    }

    @Test
    @Order(5)
    void postFormFlash() throws Exception {
        this.mockMvc.perform(post("/form/flash")
                        .session(session)
                        .param("name", "test")
                        .param("limit", "10"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/event/flash"))
                .andDo(print());
    }

    @Test
    @Order(6)
    void getEventFlash() throws Exception {
        this.mockMvc.perform(get("/event/flash")
                        .session(session))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("name", "limit"))
                .andExpect(content().string(containsString("test")))
                .andExpect(content().string(containsString("10")))
                .andDo(print());
    }
}