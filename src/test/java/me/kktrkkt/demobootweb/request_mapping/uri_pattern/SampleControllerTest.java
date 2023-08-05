package me.kktrkkt.demobootweb.request_mapping.uri_pattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void uriPatternTest() throws Exception {
        this.mockMvc.perform(get("/sample/name"))
                .andExpect(status().isOk())
                .andExpect(content().string("sample name"))
                .andDo(print());

        this.mockMvc.perform(get("/sample/1234"))
                .andExpect(status().isNotFound())
                .andDo(print());

        // 더 명확한 패턴의 uri에 맵핑된다
        this.mockMvc.perform(get("/sample/kktrkkt"))
                .andExpect(status().isOk())
                .andExpect(content().string("kktrkkt"))
                .andExpect(handler().handlerType(SampleController.class))
                .andExpect(handler().methodName("getKktrkkt"))
                .andDo(print());
    }


}