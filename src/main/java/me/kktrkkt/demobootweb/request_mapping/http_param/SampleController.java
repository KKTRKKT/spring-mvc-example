package me.kktrkkt.demobootweb.request_mapping.http_param;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    // name이라는 파라미터가 존재하면 매핑한다
    @GetMapping(value = "/exists", params = "name")
    public String exists() {
        return "exists";
    }

    // name이라는 파라미터가 존재하지 않으면 매핑한다
    @GetMapping(value = "/not-exists", params = "!name")
    public String notExists() {
        return "notExists";
    }

    // name이라는 파라미터의 값이 10이면 매핑한다
    @GetMapping(value = "/match", params = "name=kktrkkt")
    public String match() {
        return "match";
    }

}
