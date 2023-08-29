package me.kktrkkt.demobootweb.handler_method.multipart_file;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class FileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getFiles() throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile(
                "file",
                "file.txt",
                "text/plain",
                "hello file".getBytes());

        this.mockMvc.perform(multipart("/files").file(mockMultipartFile))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/files"))
                .andDo(print());
    }


}