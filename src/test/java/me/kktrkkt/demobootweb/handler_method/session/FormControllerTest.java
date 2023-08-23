package me.kktrkkt.demobootweb.handler_method.session;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FormControllerTest {

    @Autowired
    private MockMvc mockMvc;

    static private MockHttpSession session;

    @BeforeAll
    static void beforeAll() {
        session = new MockHttpSession();
    }

    @Test
    @Order(1)
    void getForm1() throws Exception {
        this.mockMvc.perform(get("/form1").session(session))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Create New Form1")))
                .andDo(print());
    }

    @Test
    @Order(2)
    void postForm1() throws Exception {
        this.mockMvc.perform(post("/form1")
                        .param("name", "event")
                        .session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/form2"))
                .andDo(print());
    }

    @Test
    @Order(3)
    void getForm2() throws Exception {
        this.mockMvc.perform(get("/form2").session(session))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Create New Form2")))
                .andExpect(request().sessionAttribute("name", "event"))
                .andDo(print());
    }

    @Test
    @Order(4)
    void postForm2() throws Exception {
        this.mockMvc.perform(post("/form2")
                        .param("limit", "10")
                        .session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/last"))
                .andExpect(request().sessionAttribute("name", "event"))
                .andExpect(request().sessionAttribute("limit", 10))
                .andDo(print());
    }

    @Test
    @Order(5)
    void getLast() throws Exception {
        this.mockMvc.perform(get("/last").session(session))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("last")))
                .andExpect(model().attributeExists("event"))
                .andDo(print());
    }
}