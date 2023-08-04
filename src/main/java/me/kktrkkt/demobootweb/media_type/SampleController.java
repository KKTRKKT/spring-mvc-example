package me.kktrkkt.demobootweb.media_type;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 클래스의 consumes의 값은 기본값으로, 메소드에서 선언할경우 덮어씌어짐
@RequestMapping(consumes = MediaType.APPLICATION_XML_VALUE)
public class SampleController {

    // consumes를 이용해 요청 본문의 미디어타입을 지정할 수 있다.
    // produces를 이용해 응답 본문의 미디어타입을 지정할 수 있다.
    @GetMapping(value = "/sample",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSample(@RequestBody String json){
        return json;
    }
}
