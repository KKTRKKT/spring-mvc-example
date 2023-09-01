package me.kktrkkt.demobootweb.handler_method.request_parsing;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Spring에서 본문의 contentType을 참고해 처리할 수 있는 HttpMessageConvert 선택해 변환한다.
// SpringBoot에서 json을 object로 변환해주는 jackson 관련 객체를 자동으로 빈으로 등록해준다. JacksonAutoConfiguration 참고
// 요청 본문을 변환 받는 방법에는 @RequestBody와 HttpEntity 등이 있다
@RestController
@RequestMapping("/api/sample")
public class SampleController {

    @PostMapping(params = "requestBody")
    public Sample createByRb(@RequestBody Sample sample) {
        // save sample
        sample.setId(1L);
        return sample;
    }

    @PostMapping(params = "httpEntity")
    public Sample createByHe(HttpEntity<Sample> httpEntity) {
        // save sample
        Sample body = httpEntity.getBody();
        body.setId(1L);
        return body;
    }
}
