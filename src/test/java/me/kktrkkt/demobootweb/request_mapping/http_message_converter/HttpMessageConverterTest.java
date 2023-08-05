package me.kktrkkt.demobootweb.request_mapping.http_message_converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.web.servlet.MockMvc;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HttpMessageConverterTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Jaxb2Marshaller marshaller;

    @Test
    void stringMessageConverter() throws Exception {
        String hello = "hello";
        this.mockMvc.perform(get("/sample").content(hello))
                .andExpect(status().isOk())
                .andExpect(content().string(hello))
                .andDo(print());
    }

    @Test
    void jsonMessageConverter() throws Exception {
        Sample sample = new Sample();
        sample.setTitle("sample");
        sample.setContents("contents");
        String sampleJson = objectMapper.writeValueAsString(sample);
        this.mockMvc.perform(get("/sample")
                    .param("json", "")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(sampleJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("sample"))
                .andExpect(jsonPath("$.contents").value("contents"))
                .andDo(print());
    }

    @Test
    void xmlMessageConverter() throws Exception {
        Sample sample = new Sample();
        sample.setTitle("sample");
        sample.setContents("contents");

        StringWriter stringWriter = new StringWriter();
        Result result = new StreamResult(stringWriter);
        marshaller.marshal(sample, result);
        String sampleXml = stringWriter.toString();

        this.mockMvc.perform(get("/sample")
                        .param("json", "")
                        .contentType(MediaType.APPLICATION_XML)
                        .accept(MediaType.APPLICATION_XML)
                        .content(sampleXml))
                .andExpect(status().isOk())
                .andExpect(xpath("sample/title").string("sample"))
                .andExpect(xpath("sample/contents").string("contents"))
                .andDo(print());
    }
}