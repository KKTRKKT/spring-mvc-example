package me.kktrkkt.demobootweb.uri_pattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 클래스에 붙인 @RequestMapping + 메소드 @RequestMapping 설정을 합쳐서 맵핑한다
@RequestMapping("/sample")
public class SampleController {

    /*
        요청 식별자로 맵핑하기
        @RequestMapping에서 지원하는 패턴
        - ?는 한글자
        - *는 여러 글자
        - **는 여러 패스
     */
    @GetMapping("/?/*/**")
    public String getSample() {
        return "sample";
    }

}
