package me.kktrkkt.demobootweb.request_mapping.media_type;

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
            produces = {
                MediaType.APPLICATION_JSON_VALUE,
//                MediaType.APPLICATION_XML_VALUE // produces가 한개일때는 요청 헤더에 accept가 없어도 되지만 2개 이상이면 요청 헤더에 반드시 추가해야한다.
            })
    public String getSample(@RequestBody String json){
        return json;
    }
}
