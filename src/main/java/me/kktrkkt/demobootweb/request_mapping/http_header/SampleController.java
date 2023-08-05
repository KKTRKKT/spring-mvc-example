package me.kktrkkt.demobootweb.request_mapping.http_header;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    // key라는 헤더가 존재하면 매핑한다
    @GetMapping(value = "/exists", headers = "key")
    public String exists() {
        return "exists";
    }

    // key라는 헤더가 존재하지 않으면 매핑한다
    @GetMapping(value = "/not-exists", headers = "!key")
    public String notExists() {
        return "notExists";
    }

    // key라는 헤더의 값이 10이면 매핑한다
    @GetMapping(value = "/match", headers = "key=10")
    public String match() {
        return "match";
    }

}
