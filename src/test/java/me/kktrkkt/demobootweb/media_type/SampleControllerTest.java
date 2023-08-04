package me.kktrkkt.demobootweb.media_type;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getSample() throws Exception {
        // 요청 본문의 타입이 application/json이 아니기 때문에 실패한다
        this.mockMvc.perform(get("/sample"))
                .andExpect(status().isUnsupportedMediaType())
                .andDo(print());

        // 응답 본문의 타입을 json으로 설정하지 않았기 때문에 실패한다
        this.mockMvc.perform(get("/sample")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isNotAcceptable())
                .andDo(print());

        this.mockMvc.perform(get("/sample")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString("kktrkkt")))
                .andExpect(status().isOk())
                .andExpect(content().json("\"kktrkkt\""))
                .andDo(print());
    }
}