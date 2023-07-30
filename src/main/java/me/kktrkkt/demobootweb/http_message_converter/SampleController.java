package me.kktrkkt.demobootweb.http_message_converter;

import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @GetMapping("/sample")
    public String getSample(@RequestBody String message) {
        return message;
    }

    @GetMapping(value = "/sample", params = "json")
    public Sample getSample(@RequestBody Sample sample) {
        return sample;
    }
}
