package me.kktrkkt.demobootweb.request_mapping.custom_mapping_annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@GetSampleMapping
public class SampleController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
