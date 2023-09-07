package me.kktrkkt.demobootweb.data_binder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void postSample() throws Exception {
        this.mockMvc.perform(post("/api/samples")
                        // 핸들러에서 id는 null로 받는다
                        .param("id", "1")
                        .param("name", "sample")
                        // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 부착하면 formatter에 의해서 자동으로 LocalDate 타입으로 변환된다
                        .param("date",  "2023-09-07"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("10"))
                .andExpect(jsonPath("$.name").value("sample"))
                .andExpect(jsonPath("$.date").value("2023-09-07"))
                .andDo(print());
    }

    @Test
    void postSampleAdmin() throws Exception {
        // Validator에 의해 admin이라는 이름은 사용할 수 없다
        this.mockMvc.perform(post("/api/samples").param("name", "admin"))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }
}