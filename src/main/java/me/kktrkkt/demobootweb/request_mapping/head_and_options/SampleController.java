package me.kktrkkt.demobootweb.request_mapping.head_and_options;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        return hello();
    }
}
