package me.kktrkkt.demobootweb.handler_method.form_submit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getEventsForm() throws Exception {
        this.mockMvc.perform(get("/events/form"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("<title>Create New Form</title>")))
                .andExpect(model().attributeExists("event"))
                .andDo(print());
    }

    @Test
    void postEvents() throws Exception {
        this.mockMvc.perform(post("/events")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "new event")
                        .param("limit", "100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("new event"))
                .andExpect(jsonPath("$.limit").value(100))
                .andDo(print());
    }

    @Test
    void postEventsModel() throws Exception {
        this.mockMvc.perform(post("/events/model")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "new event")
                        .param("limit", "100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("new event"))
                .andExpect(jsonPath("$.limit").value(100))
                .andDo(print());
    }

    @Test
    void postEventsModelBadRequest() throws Exception {
        this.mockMvc.perform(post("/events/model")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "new event")
                        .param("limit", "string")) // number를 주지 않을경우 실패
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    void postEventsBR() throws Exception {
        this.mockMvc.perform(post("/events/br")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "new event")
                        .param("limit", "string")) // number를 주지 않을경우 실패
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("new event"))
                .andExpect(jsonPath("$.limit").value("0"))
                .andDo(print());
    }

    @Test
    void postEventsValid() throws Exception {
        this.mockMvc.perform(post("/events/valid")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "new event")
                        .param("limit", "-10")) // 검증
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    void postEventsValidated() throws Exception {
        this.mockMvc.perform(post("/events/validated")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "new event")
                        .param("limit", "-10")) // name만 검증하기 때문에 성공
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("new event"))
                .andExpect(jsonPath("$.limit").value("-10"))
                .andDo(print());
    }
}