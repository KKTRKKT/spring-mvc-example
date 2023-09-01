package me.kktrkkt.demobootweb.handler_method.response_converting;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/sample")
public class SampleController {

    @GetMapping(params = "responseBody")
    @ResponseBody
    public List<Sample> getSampleByRb(){
        Sample sample = new Sample();
        sample.setId(1L);
        sample.setName("hello");

        return Arrays.asList(sample);
    }

    // responseEntity는 응답의 상태, 본문, 헤더 등 설정이 필요할때 유용하다
    @GetMapping(params = "responseEntity")
    public ResponseEntity<List<Sample>> getSampleByRe(){
        Sample sample = new Sample();
        sample.setId(1L);
        sample.setName("hello");

        return ResponseEntity.ok(Arrays.asList(sample));
    }
}
